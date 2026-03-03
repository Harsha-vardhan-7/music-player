package com;

import java.util.List;

public class PlayList {

	private String playlistName;
	private List<Song> song;

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
