package io.github.balram02.musify.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.github.balram02.musify.models.SongsModel;
import io.github.balram02.musify.repositories.SongsRepository;

public class SharedViewModel extends AndroidViewModel {

    private SongsRepository repository;
    private LiveData<List<SongsModel>> songs;
    private List<SongsModel> songsQueue;
    private List<SongsModel> allSongsQueue;
    private LiveData<List<SongsModel>> recentSongs;
    private LiveData<List<SongsModel>> songsByAlbums;
    private LiveData<List<SongsModel>> songsByArtist;

    public SharedViewModel(@NonNull Application application) {
        super(application);
        repository = new SongsRepository(application);
        songs = repository.getAllSongs();
        songsQueue = repository.getShuffleSongsQueue();
        allSongsQueue = repository.getAllSongsQueue();
        recentSongs = repository.getRecentlyPlayedSongs();
        songsByAlbums = repository.getAlbums();
        songsByArtist = repository.getArtist();
    }

    public void update(SongsModel songsModel) {
        repository.update(songsModel);
    }

    public void delete(SongsModel songsModel) {
        repository.delete(songsModel);
    }

    public LiveData<List<SongsModel>> getAllSongs() {
        return songs;
    }

    public List<SongsModel> getAllSongsQueue() {
        return allSongsQueue;
    }

    public List<SongsModel> getShuffleSongsQueue() {
        return songsQueue;
    }

    public LiveData<Boolean> isFavorite(int id) {
        return repository.isFavorite(id);
    }

    public LiveData<List<SongsModel>> getFavoriteSong() {
        return repository.getFavoriteSong();
    }

    public LiveData<List<SongsModel>> getRecentlyPlayedSongs() {
        return recentSongs;
    }

    public LiveData<List<SongsModel>> getAlbums() {
        return songsByAlbums;
    }

    public LiveData<List<SongsModel>> getArtist() {
        return songsByArtist;
    }

}