package com.carlos.restfulsong.model.response;

import java.util.List;

public class ArtistResponse {

	public String name;
	public List<String> songs;

	public ArtistResponse()
	{

	}

	public ArtistResponse(String name, List<String> songs) {
		this.name = name;
		this.songs = songs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSongs() {
		return songs;
	}

	public void setSongs(List<String> songs) {
		this.songs = songs;
	}
}
