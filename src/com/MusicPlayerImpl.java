package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicPlayerImpl implements MusicPlayer {

	List<PlayList> playlist;
	List<Song> songs;
	Song currentSong;

	MusicPlayerImpl() {
		this.playlist = new ArrayList<>();
		this.songs = new ArrayList<>();
	}

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
	}

	@Override
	public void updateSong(int songId, String title, String artistName, double duration) {
		Iterator<Song> itSong = songs.listIterator();
		boolean isFound = false;

		while (itSong.hasNext()) {
			Song nextSong = itSong.next();
			if (nextSong.getSongId() == songId) {
				isFound = true;
				nextSong.setSongTitle(title);
				nextSong.setArtistName(artistName);
				nextSong.setDuration(duration);
				return;
			}
		}
		if (!isFound) {
			System.out.println("The song was not found");
		}
	}

	@Override
	public void deleteSong(int songId) {
		Iterator<Song> itSong = songs.listIterator();

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

	@Override
	public void playSong(int songId) {
		Iterator<Song> itSong = songs.listIterator();

		while (itSong.hasNext()) {
			Song nextSong = itSong.next();
			if (nextSong.getSongId() == songId) {
				System.out.println(nextSong.getSongTitle() + " is playing");
				currentSong = nextSong;
				return;
			}
		}
		System.out.println("No Song found");
	}

	@Override
	public void pauseSong() {
		if (currentSong == null) {
			System.out.println("No song is playing");
		} else {
			System.out.println("Paused " + currentSong.getSongTitle());
		}
	}

	@Override
	public void stop() {
		if (currentSong == null) {
			System.out.println("No song is playing");
		} else {
			System.out.println(currentSong.getSongTitle() + " has been stopped");
			currentSong = null;
		}
	}

	@Override
	public void displayAllSongs() {
		Iterator<Song> itSong = songs.listIterator();

		while (itSong.hasNext()) {
			System.out.println(itSong.next());
		}

		System.out.println("== End of the list ==");
	}

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
				System.out.println("Playlist with this name already exist");
				return;
			}
		}

		playList.setPlaylistName(playListName);
		playlist.add(playList);
	}

	@Override
	public void addSongToPlaylist(String playListName, List<Song> song) {
		if (song == null || song.isEmpty()) {
			System.out.println("No songs provided");
			return;
		}

		Iterator<PlayList> itPlayList = playlist.iterator();

		while (itPlayList.hasNext()) {
			PlayList nextList = itPlayList.next();
			if (nextList.getPlaylistName().equalsIgnoreCase(playListName)) {
				List<Song> existing = nextList.getSong();

				for (int i = 0; i < song.size(); i++) {

					if (existing.contains(song.get(i))) {
						System.out.println("The song was already exist in the playlist");
					} else {

						existing.add(song.get(i));
					}
				}
				return;
			}
		}

		System.out.println("Playlist not found"); // This will print when it didn't find the given playlist
	}

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
