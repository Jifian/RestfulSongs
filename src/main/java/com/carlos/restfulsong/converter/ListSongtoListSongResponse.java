package com.carlos.restfulsong.converter;

import com.carlos.restfulsong.entity.Artist;
import com.carlos.restfulsong.entity.Song;
import com.carlos.restfulsong.model.response.SongResponse;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class ListSongtoListSongResponse implements Converter<List<Song>, List<SongResponse>> {
	@Override
	public List<SongResponse> convert(List<Song> source) {
		List<SongResponse> songs = new ArrayList<>();
		for(Song song: source)
		{
			SongResponse songResponse = new SongResponse();
			songResponse.setName(song.getName());

			Artist artist = song.getArtist();
			if(artist != null) {
				songResponse.setArtist(song.getArtist().getName());
			}
			songResponse.setAlbum(song.getAlbum());
			songResponse.setBpm(song.getBpm());
			songResponse.setDuration(song.getDuration());
			songResponse.setGenre(song.getGenre());
			songResponse.setShortName(song.getShortName());
			songResponse.setSpotifyId(song.getSpotifyId());
			songResponse.setYear(song.getYear());

			songs.add(songResponse);
		}
		return songs;
	}
}
