package com;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayerTest {

	public static void main(String[] args) {

		MusicPlayerImpl mpImpl = new MusicPlayerImpl();

		// Adding Songs
		System.out.println("\n=== Adding Songs ===");
		Song shapeOfYou = new Song(1, "Shape Of You", "Edsheren", 3.00);
		// Song believer= new Song(1, "Believer", "Imagine Dragons", 4.00);
		Song believer = new Song(2, "Believer", "Imagine Dragons", 4.00);
		Song neeliMeghamulalo = new Song(3, "Neeli Meghamulalo", "Prithvi Harish", 3.00);

		mpImpl.addSong(shapeOfYou);
		mpImpl.addSong(believer);
		mpImpl.addSong(neeliMeghamulalo);
		mpImpl.addSong(shapeOfYou); // duplicate

		mpImpl.displayAllSongs();

		// Update Song
		System.out.println("\n=== Updating Song ===");
		mpImpl.updateSong(2, "Blue Eyes", "Honey Singh", 2.45);

		mpImpl.displayAllSongs();

		// Delete Song
		System.out.println("\n=== Deleting Song ===");
		mpImpl.deleteSong(1);

		mpImpl.displayAllSongs();

		mpImpl.deleteSong(5); // The song was not found

		// Play Song
		System.out.println("\n=== Playing Song ===");
		mpImpl.playSong(3);

		// Pause Song
		System.out.println("\n=== Pause ===");
		mpImpl.pauseSong();

		// Stop
		System.out.println("\n=== Stop ===");
		mpImpl.stop();

		// Create playlist
		System.out.println("\n=== Playlist creation ===");
		mpImpl.createPlayList("Harsha");
		mpImpl.createPlayList("Harsha"); // Playlist with this name already exist
		mpImpl.createPlayList("EmptyList");

		// Add Song to playlist
		System.out.println("\n=== Adding songs to the playlist ===");
		List<Song> playlistSongs = new ArrayList<>();
		playlistSongs.add(neeliMeghamulalo);
		playlistSongs.add(believer);

		mpImpl.addSongToPlaylist("Harsha", playlistSongs);

		// Play playlist
		System.out.println("\n=== playing Playlist ===");
		mpImpl.playPlaylist("Harsha");
		mpImpl.playPlaylist("Melodies"); // mpImpl.playPlaylist("Melodies");
		mpImpl.playPlaylist("EmptyList");

	}

}
