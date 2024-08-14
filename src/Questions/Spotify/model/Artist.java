package Questions.Spotify.model;

import Questions.Amazon.util.IdGenerator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Artist {
    private int id;
    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.id = IdGenerator.getNextId(Artist.class);
        this.name = name;
        this.albums = new CopyOnWriteArrayList<>();
    }
}
