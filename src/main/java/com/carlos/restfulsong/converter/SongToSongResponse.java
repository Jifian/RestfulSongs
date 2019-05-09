package com.carlos.restfulsong.converter;

import com.carlos.restfulsong.entity.Song;
import com.carlos.restfulsong.model.response.SongResponse;
import org.springframework.core.convert.converter.Converter;

public class SongToSongResponse implements Converter<Song, SongResponse> {
	@Override
	public SongResponse convert(Song source) {
		return null;
	}
}
