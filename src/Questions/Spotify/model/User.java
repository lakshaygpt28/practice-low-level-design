package Questions.Spotify.model;

import Questions.Amazon.util.IdGenerator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private int id;
    private String name;
    private List<Playlist> playlists;

    public User(String name) {
        this.id = IdGenerator.getNextId(User.class);
        this.name = name;
        this.playlists = new CopyOnWriteArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }
}
