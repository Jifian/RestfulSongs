package com.carlos.restfulsong.model.response;

public class SongResponse {

	private String name;

	private int year;

	private String shortName;

	private int bpm;

	private long duration;

	private String genre;

	private String spotifyId;

	private String album;

	private String artist;

	public SongResponse()
	{

	}

	public SongResponse(String name, int year, String shortName, int bpm, long duration, String genre, String spotifyId, String album, String artist) {
		this.name = name;
		this.year = year;
		this.shortName = shortName;
		this.bpm = bpm;
		this.duration = duration;
		this.genre = genre;
		this.spotifyId = spotifyId;
		this.album = album;
		this.artist = artist;
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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
}
