package Questions.Spotify;

import Questions.Spotify.model.*;
import Questions.Spotify.service.MusicPlayerService;
import Questions.Spotify.service.SpotifyService;

public class SpotifyDemo {
    public static void main(String[] args) {
        SpotifyService spotifyService = SpotifyService.getInstance();
        MusicPlayerService musicPlayerService = new MusicPlayerService();

        User user1 = spotifyService.createUser("Alice");
        User user2 = spotifyService.createUser("Bob");

        Artist artist1 = new Artist("Mitraz");
        Artist artist2 = new Artist("Arijit Singh");

        Album album1 = new Album("Album 1", artist1);
        Album album2 = new Album("Album 2", artist2);

        Song song1 = new Song("Gulaab", album1, artist1, new SongMetadata());
        Song song2 = new Song("Tum hi ho", album2, artist2, new SongMetadata());
        Song song3 = new Song("Dheeme Dheeme", album1, artist1, new SongMetadata());

        album1.getSongs().add(song1);
        album1.getSongs().add(song3);
        album2.getSongs().add(song2);

        Playlist playlist1 = spotifyService.createPlayList(user1.getId(), "My Playlist");
        playlist1.addSong(song1);
        playlist1.addSong(song3);
        playlist1.addSong(song2);

        musicPlayerService.play(song1);
        musicPlayerService.addSong(song2);
        musicPlayerService.addSong(song3);

        musicPlayerService.getCurrentSong();

        musicPlayerService.next();
        musicPlayerService.getCurrentSong();

        musicPlayerService.pause();
        musicPlayerService.resume();


    }
}
