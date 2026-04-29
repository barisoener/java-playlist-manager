package com.baris.playlistmanager.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Playlist{
    private String name;
    private List<MediaFile> songs;
    private int currentIndex;

    public Playlist(String name){
      this.name=name;
      this.songs=new ArrayList<>();
      this.currentIndex=0;
    }

    public String getName() {
        return name;
    }
      public void addSong(MediaFile mediaFile) {
        songs.add(mediaFile);
    }

    public boolean removeSongById(String id) {
    for (int i = 0; i < songs.size(); i++) {
        if (songs.get(i).getId().equals(id)) {
            songs.remove(i);
            if (currentIndex >= songs.size() && !songs.isEmpty()) {
                currentIndex = songs.size() - 1;
            }
            return true;
        }
    }
    return false;
}

    public boolean isEmpty() {
        return songs.isEmpty();
    }

     public int size() {
        return songs.size();
    }

    public MediaFile getCurrentSong() {
        if (songs.isEmpty()) {
            return null;
        }
        return songs.get(currentIndex);
    }

    
    public List<MediaFile> getAllSongs() {
    return songs;
}

     public List<MediaFile> searchByTitle(String keyword) {
        List<MediaFile> results = new ArrayList<>();

        for (MediaFile song : songs) {
            if (song.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(song);
            }
        }

        return results;
    }

     public List<MediaFile> searchByArtist(String keyword) {
        List<MediaFile> results = new ArrayList<>();

        for (MediaFile song : songs) {
            if (song.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(song);
            }
        }
           return results;
    }

    public void sortByTitle() {
        songs.sort(Comparator.comparing(MediaFile::getTitle));
    }

    public void sortByDuration() {
        songs.sort(Comparator.comparingInt(MediaFile::getDurationInSeconds));
    }
}