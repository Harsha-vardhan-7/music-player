package com;

import java.util.List;

public interface MusicPlayer {

	void addSong(Song song);

	void updateSong(int songId, String title, String artistName, double duration);

	void deleteSong(int songId);

	void playSong(int songId);

	void pauseSong();

	void stop();

	void displayAllSongs();

	void createPlayList(String playListName);

	void addSongToPlaylist(String playListName, List<Song> song);

	void playPlaylist(String playListName);
}
