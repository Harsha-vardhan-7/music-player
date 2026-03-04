package com;

import java.util.List;

/**
 * Represents a music playlist. A playlist has a name and a collection of songs.
 */
public class PlayList {

	private String playlistName; // Name of the playlist

	private List<Song> song; // Songs contained inside the playlist

	PlayList(List<Song> song) {
		this.song = song;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public List<Song> getSong() {
		return song;
	}

	public void setSong(List<Song> song) {
		this.song = song;
	}

}
