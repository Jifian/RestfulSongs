package com.carlos.restfulsong.entity;

import org.json.simple.JSONObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "songs")
public class Song {
	@Id
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private int year;

	@NotNull
	private String shortName;

	@NotNull
	private int bpm;

	@NotNull
	private long duration;

	@NotNull
	private String genre;

	private String spotifyId;

	private String album;

	@ManyToOne
	@JoinColumn
	private Artist artist;

	public Song(){

	}

	public Song(JSONObject jsonObject) {
		String id = getJsonString(jsonObject.get("Id"));
		String name = getJsonString(jsonObject.get("Name"));
		String year = getJsonString(jsonObject.get("Year"));
		String shortName = getJsonString(jsonObject.get("Shortname"));
		String bpm = getJsonString(jsonObject.get("Bpm"));
		String duration = getJsonString(jsonObject.get("Duration"));
		String genre = getJsonString(jsonObject.get("Genre"));
		String spotifyId = getJsonString(jsonObject.get("SpotifyId"));
		String album = getJsonString(jsonObject.get("Album"));


		this.setId(Long.parseLong(id));
		this.setName(name);
		this.setYear(Integer.parseInt(year));
		this.setShortName(shortName);
		this.setBpm(bpm != null ? Integer.parseInt(bpm) : 0);
		this.setDuration(Long.parseLong(duration));
		this.setGenre(genre);
		this.setSpotifyId(spotifyId);
		this.setAlbum(album);
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getBpm() {
		return bpm;
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSpotifyId() {
		return spotifyId;
	}

	public void setSpotifyId(String spotifyId) {
		this.spotifyId = spotifyId;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	public String getJsonString(Object object)
	{
		return object != null ? object.toString() : null;
	}

//	@Override
//	public String toString() {
//		return "Song{" + "id=" + id + ", name='" + name + '\'' + ", year=" + year + ", shortName='" + shortName + '\'' + ", bpm=" + bpm + ", duration=" + duration + ", genre='" + genre + '\'' + ", spotifyId='" + spotifyId + '\'' + ", album='" + album + '\'' + ", artist=" + artist + '}';
//	}
}
