package com.carlos.restfulsong.rest;

import com.carlos.restfulsong.converter.ListSongtoListSongResponse;
import com.carlos.restfulsong.entity.Artist;
import com.carlos.restfulsong.entity.Song;
import com.carlos.restfulsong.model.response.ArtistResponse;
import com.carlos.restfulsong.model.response.SongResponse;
import com.carlos.restfulsong.repository.ArtistRepository;
import com.carlos.restfulsong.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(ResourceConstants.RESOURCE_URL)
public class RestfulSongResource {

	@Autowired
	ArtistRepository artistRepository;

	@Autowired
	SongRepository songRepository;

	/**
	 * gets the artist based on the name
	 * @param name The name of the artist that has been in the path variable
	 * @return returns the artist in JSON format
	 */
	@RequestMapping(path = "/artist/{artist}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Artist> getArtist(@PathVariable(value = "artist") String name) {
		System.out.println("/artist/" + name + " received");
		Artist artist = artistRepository.findByName(name);

		System.out.println(artist);
		return new ResponseEntity<>(artist, HttpStatus.OK);
	}

	/**
	 * gets the song based on the name
	 * @param genre The genre of the song that has been in the path variable
	 * @return returns songs in JSON format
	 */
	@RequestMapping(path = "/song/{genre}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<SongResponse>> getSong(@PathVariable(value = "genre") String genre) {
		System.out.println("/song/" + genre + " received");
		List<Song> songs = songRepository.findByGenre(genre);

		return new ResponseEntity<>(new ListSongtoListSongResponse().convert(songs), HttpStatus.OK);
	}

	/**
	 * creates the artist based on a JSON format that has been consumed
	 * @param artist The artist that has been sent via JSON format
	 * @return returns the artist in JSON format
	 */
	@RequestMapping(path = "/artist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Artist> createArtist(
			@RequestBody
					Artist artist) {

		System.out.println(artist.getName() + ": " + artist.getId());
		artistRepository.save(artist);

		return new ResponseEntity<>(artist, HttpStatus.CREATED);
	}

	/**
	 * update the artist based on the id in the JSON format that has been consumed
	 * @param artist The artist that has been sent via JSON format
	 * @return returns the artist in JSON format
	 */
	@RequestMapping(path = "/artist", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Artist> updateArtist(
			@RequestBody
					Artist artist) {
		System.out.println(artist.getName() + ": " + artist.getId());
		artistRepository.save(artist);

		return new ResponseEntity<>(artist, HttpStatus.OK);
	}

	/**
	 * deletes the artist based on a JSON format that has been consumed
	 * @param artistId The artist that has been sent via JSON format
	 * @return returns the artist in JSON format
	 */
	@RequestMapping(path = "/artist/{artistId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteArtist(
			@PathVariable
					long artistId) {
		Artist artist = artistRepository.findById(artistId).orElse(null);

		if(artist != null)
			artistRepository.delete(artist);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
