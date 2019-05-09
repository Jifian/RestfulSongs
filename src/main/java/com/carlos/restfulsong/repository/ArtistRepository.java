package com.carlos.restfulsong.repository;

import com.carlos.restfulsong.entity.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	Artist findByName(String name);
}
