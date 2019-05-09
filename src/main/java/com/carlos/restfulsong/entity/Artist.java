package com.carlos.restfulsong.entity;


import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist {
	@Id
	private Long id;

	@Column(unique = true)
	@NotNull
	private String name;

	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Song> songs = new ArrayList<>();

	public Artist()
	{

	}

	public Artist(JSONObject jsonObject)
	{
		id = Long.parseLong(jsonObject.get("Id").toString());
		name = jsonObject.get("Name").toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

//	@Override
//	public String toString() {
//		return "Artist{" + "id=" + id + ", name='" + name + '\'' + ", songs=" + songs + '}';
//	}

	public void addSong(Song song)
	{
		songs.add(song);
	}
}
