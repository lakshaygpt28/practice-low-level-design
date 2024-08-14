package Questions.Spotify.model;

import Questions.Amazon.util.IdGenerator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Playlist {
    private int id;
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.id = IdGenerator.getNextId(Playlist.class);
        this.name = name;
        this.songs = new CopyOnWriteArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
