package com;

import java.util.Objects;

public class Song {

	@Override
	public int hashCode() {
		return Objects.hash(artistName, duration, songId, songTitle);
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
		return Objects.equals(artistName, other.artistName)
				&& Double.doubleToLongBits(duration) == Double.doubleToLongBits(other.duration)
				&& songId == other.songId && Objects.equals(songTitle, other.songTitle);
	}

	private int songId;
	private String songTitle;
	private String artistName;
	private double duration;

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

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songTitle=" + songTitle + ", artistName=" + artistName + ", duration="
				+ duration + "]";
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
}
