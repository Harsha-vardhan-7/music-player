package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implementation of the MusicPlayer interface.
 * This class manages: - A main song library - Playlists that group songs -
 * Current playing song state
 * All operations such as adding songs, updating songs, playlist management, and
 * playback control are handled here.
 */

public class MusicPlayerImpl implements MusicPlayer {
	// List that stores all created playlists
	List<PlayList> playlist;

	// Main music library containing all songs
	List<Song> songs;

	// Keeps track of the currently playing song
	Song currentSong;

	/**
	 * Initializes the music player with empty song library and playlist collection.
	 */
	MusicPlayerImpl() {
		this.playlist = new ArrayList<>();
		this.songs = new ArrayList<>();
	}

	/**
	 * Adds a new song to the main music library.
	 * 
	 * Validations performed: - Song should not be null - Duplicate songId should
	 * not exist
	 */
	@Override
	public void addSong(Song song) {
		if (song == null) {
			System.out.println("No song is given");
			return;
		}

		for (Song s : songs) {
			if (s.getSongId() == song.getSongId()) {
				System.out.println("Song with this ID already exists");
				return;
			}
		}
		songs.add(song);
		System.out.println(song.getSongTitle() + " has been added to the library");
	}

	/**
	 * Updates the details of a song using songId. If the song is not found, an
	 * error message is printed.
	 */
	@Override
	public void updateSong(int songId, String title, String artistName, double duration) {
		Iterator<Song> itSong = songs.listIterator();

		while (itSong.hasNext()) {
			Song nextSong = itSong.next();
			if (nextSong.getSongId() == songId) {
				nextSong.setSongTitle(title);
				nextSong.setArtistName(artistName);
				nextSong.setDuration(duration);
				System.out.println("Song with ID " + songId + " has been updated successfully. New title: "
						+ nextSong.getSongTitle());
				return;
			}
		}

		System.out.println("Song with this ID is not found");
	}

	/**
	 * Deletes a song from the main music library using the given songId.
	 */
	@Override
	public void deleteSong(int songId) {
		Iterator<Song> itSong = songs.listIterator(); // Iterator is used to safely remove elements while iterating

		while (itSong.hasNext()) {
			Song nextSong = itSong.next();
			if (nextSong.getSongId() == songId) {
				itSong.remove();
				System.out.println("The " + nextSong.getSongTitle() + " has been removed successfully");
				return;
			}
		}
		System.out.println("The song was not found");
	}

	/**
	 * Plays a song from the main library based on songId. The currentSong variable
	 * is updated to track playback state.
	 */
	@Override
	public void playSong(int songId) {
		Iterator<Song> itSong = songs.listIterator();

		while (itSong.hasNext()) {
			Song nextSong = itSong.next();
			if (nextSong.getSongId() == songId) {
				System.out.println(nextSong.getSongTitle() + " is playing 🎶 🎶");
				currentSong = nextSong;
				return;
			}
		}
		System.out.println("No Song found");
	}

	/**
	 * Pauses the currently playing song. If no song is playing, a message is
	 * displayed.
	 */
	@Override
	public void pauseSong() {
		if (currentSong == null) {
			System.out.println("No song is playing");
		} else {
			System.out.println("Paused " + currentSong.getSongTitle());
		}
	}

	/**
	 * Stops the currently playing song and resets the currentSong reference.
	 */
	@Override
	public void stop() {
		if (currentSong == null) {
			System.out.println("No song is playing");
		} else {
			System.out.println(currentSong.getSongTitle() + " has been stopped");
			currentSong = null;
		}
	}

	/**
	 * Displays all songs available in the main music library.
	 */
	@Override
	public void displayAllSongs() {
		Iterator<Song> itSong = songs.listIterator();

		while (itSong.hasNext()) {
			System.out.println(itSong.next());
		}

		System.out.println("== End of the list ==");
	}

	/**
	 * Creates a new playlist with the given name. Validations: - Playlist name
	 * should not be null or empty - Duplicate playlist names are not allowed
	 */
	@Override
	public void createPlayList(String playListName) {
		if (playListName == null || playListName.trim().isEmpty()) {
			System.out.println("Invalid playlist name");
			return;
		}

		List<Song> newSongs = new ArrayList<>();
		PlayList playList = new PlayList(newSongs);

		Iterator<PlayList> itPlayList = playlist.iterator();

		while (itPlayList.hasNext()) {
			PlayList nextList = itPlayList.next();
			if (nextList.getPlaylistName().equalsIgnoreCase(playListName)) {
				System.out.println("Playlist with this name already exists");
				return;
			}
		}

		playList.setPlaylistName(playListName);
		playlist.add(playList);
		System.out.println("Playlist created successfully: " + playListName);
	}

	/**
	 * Adds a list of songs to an existing playlist.
	 *
	 * Validations performed:
	 * - Playlist must exist
	 * - Song list must not be null or empty
	 * - Duplicate songs in the playlist are avoided
	 */
	@Override
	public void addSongToPlaylist(String playListName, List<Song> songsToAdd) {
		if (songsToAdd == null || songsToAdd.isEmpty()) {
			System.out.println("No songs provided");
			return;
		}

		for (PlayList pl : playlist) {
			if (pl.getPlaylistName().equalsIgnoreCase(playListName)) {
				List<Song> existing = pl.getSong();
				for (Song s : songsToAdd) {
					if (!existing.contains(s)) {
						existing.add(s);
					} else {
						System.out.println("Song already exists in the playlist: " + s.getSongTitle());
					}
				}
				System.out.println("Songs added to playlist: " + playListName);
				return;
			}
		}
		System.out.println("Playlist not found"); // This will print when it didn't find the given playlist
	}

	/**
	 * Plays all songs inside a playlist sequentially. If playlist is empty or not
	 * found, appropriate message is shown.
	 */
	@Override
	public void playPlaylist(String playListName) {
		Iterator<PlayList> itPlayList = playlist.iterator();

		while (itPlayList.hasNext()) {
			PlayList nextList = itPlayList.next();

			if (nextList.getPlaylistName().equalsIgnoreCase(playListName)) {
				if (nextList.getSong().isEmpty()) {
					System.out.println("Playlist is empty");
					return;
				}
				Iterator<Song> itSong = nextList.getSong().iterator();

				while (itSong.hasNext()) {
					Song current = itSong.next();
					System.out.println("Playing " + current.getSongTitle());
					currentSong = current;
				}
				return;
			}

		}
		System.out.println("Playlist not found");
	}

}
