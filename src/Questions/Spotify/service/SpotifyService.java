package Questions.Spotify.service;

import Questions.Spotify.dao.SongsRepository;
import Questions.Spotify.model.Playlist;
import Questions.Spotify.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SpotifyService {
    private static SpotifyService instance;
    private SongsRepository songsRepository;
    private Map<Integer, User> users;
    private MusicPlayerService musicPlayerService;

    SpotifyService() {
        users = new ConcurrentHashMap<>();
        songsRepository = new SongsRepository();
        musicPlayerService = new MusicPlayerService();
    }

    public static synchronized SpotifyService getInstance() {
        if (instance == null) {
            instance = new SpotifyService();
        }
        return instance;
    }

    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Playlist createPlayList(int userId, String playListName) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("Invalid User ID");
            return null;
        }
        Playlist playlist = new Playlist(playListName);
        user.getPlaylists().add(playlist);
        return playlist;
    }




}
