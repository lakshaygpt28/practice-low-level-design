package Questions.Spotify.service;

import Questions.Spotify.model.Song;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MusicPlayerService {
    List<Song> songQueue;
    Boolean isPlaying;
    int currentSongIdx;

    public MusicPlayerService() {
        songQueue = new CopyOnWriteArrayList<>();
    }

    public void addSong(Song song) {
        songQueue.add(song);
    }

    public void play(Song song) {
        songQueue.clear();
        songQueue.add(song);
        currentSongIdx = 0;
        isPlaying = true;
    }

    public void pause() {
        isPlaying = false;
        // stopPlaying
    }

    public void resume() {
        isPlaying = true;
        // startPlaying
    }

    public void next() {
        currentSongIdx = (currentSongIdx + 1) % songQueue.size();
    }

    public void previous() {
        currentSongIdx = (currentSongIdx - 1) % songQueue.size();
    }

    public Song getCurrentSong() {
        return songQueue.get(currentSongIdx);
    }

    public Boolean getPlaying() {
        return isPlaying;
    }

    public List<Song> getSongQueue() {
        return songQueue;
    }
}
