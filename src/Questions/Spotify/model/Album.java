package Questions.Spotify.model;

import Questions.Amazon.util.IdGenerator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Album {
    private int id;
    private String name;
    private List<Song> songs;
    private Artist artist;

    public Album(String name, Artist artist) {
        this.id = IdGenerator.getNextId(Album.class);
        this.name = name;
        this.songs = new CopyOnWriteArrayList<>();
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Artist getArtist() {
        return artist;
    }
}
