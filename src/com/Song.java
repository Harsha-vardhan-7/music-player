package com;

import java.util.Objects;

/**
 * Represents a song in the music player. Each song contains basic metadata such
 * as ID, title, artist, and duration.
 */

public class Song {

	private int songId; // Unique identifier for the song
	private String songTitle; // Title of the song
	private String artistName; // Artist who performed the song
	private double duration; // Duration of the song in minutes

	Song(int songId, String songTitle, String artistName, double duration) {

		this.songId = songId;
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.duration = duration;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songTitle=" + songTitle + ", artistName=" + artistName + ", duration="
				+ duration + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(songId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		return songId == other.songId;
	}

}
