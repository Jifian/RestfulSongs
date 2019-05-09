package com.carlos.restfulsong;


import com.carlos.restfulsong.entity.Artist;
import com.carlos.restfulsong.entity.Song;
import com.carlos.restfulsong.repository.ArtistRepository;
import com.carlos.restfulsong.repository.SongRepository;
import com.carlos.restfulsong.rest.ResourceConstants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class H2Initialisation implements CommandLineRunner {
	private static H2Initialisation h2Initialisation;

	@Autowired
	ArtistRepository artistRepository;

	@Autowired
	SongRepository songRepository;

	Map<String, Artist> artistMap = new HashMap();

	private H2Initialisation() {

	}

	/**
	 * Get the singleton
	 * @return
	 */
	public static H2Initialisation getInstance() {
		return h2Initialisation;
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 */
	@Override
	public void run(String... args) {
		h2Initialisation = this;
		readArtists();
		readSongs();
	}

	public void readArtists() {
		JSONParser parser = new JSONParser();
		try {
			Object jsonArrayObj = parser.parse(new FileReader(ResourceConstants.ARTISTS_FILE));
			JSONArray jsonArray = (JSONArray) jsonArrayObj;

			for (Object jsonObjectObj : jsonArray) {
				Artist artist = new Artist((JSONObject) jsonObjectObj);

				System.out.println("Read the following " + artist.getId() + ". Starting save");
				artistRepository.save(artist);
				artistMap.put(artist.getName(), artist);
			}
		} catch (IOException ioe) {

		} catch (ParseException pe) {

		}
	}

	public void readSongs() {
		JSONParser parser = new JSONParser();
		try {
			Object jsonArrayObj = parser.parse(new FileReader(ResourceConstants.SONGS_FILE));
			JSONArray jsonArray = (JSONArray) jsonArrayObj;

			for (Object jsonObjectObj : jsonArray) {
				Song song = new Song();
				JSONObject jsonObject = (JSONObject) jsonObjectObj;

				Artist artist = artistMap.get(getJsonString(jsonObject.get("Name")));



				System.out.println("Read the following " + song.getId() + ". Starting save");
				if(song.getGenre().equals("Metal") && song.getYear() < 2016) {
					songRepository.save(song);

					if (artist != null) {
						song.setArtist(artist);
						songRepository.save(song);

						artist.addSong(song);
						artistRepository.save(artist);
					}
				}
			}
		} catch (IOException ioe) {

		} catch (ParseException pe) {

		}
	}

}
