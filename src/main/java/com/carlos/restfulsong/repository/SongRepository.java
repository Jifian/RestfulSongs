package com.carlos.restfulsong.repository;

import com.carlos.restfulsong.entity.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findByGenre(String genre);
}
