package Questions.Spotify.model;

import Questions.Amazon.util.IdGenerator;

public class Song {
    private final int id;
    private final String name;
    private final Album album;
    private final Artist artist;
    private final SongMetadata songMetadata;

    public Song(String name, Album album, Artist artist, SongMetadata songMetadata) {
        this.id = IdGenerator.getNextId(Song.class);
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.songMetadata = songMetadata;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Album getAlbum() {
        return album;
    }

    public Artist getArtist() {
        return artist;
    }

    public SongMetadata getSongMetadata() {
        return songMetadata;
    }
}
