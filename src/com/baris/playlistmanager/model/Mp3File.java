package com.baris.playlistmanager.model;

public class Mp3File extends MediaFile{
  private String album;

    public Mp3File(String id, String title, String artist, int durationInSeconds, String filePath, String album) {
        super(id, title, artist, durationInSeconds, filePath);
        this.album = album;
    }
    public String getAlbum() {
        return album;
    }

    @Override
    public String getFileType() {
        return "MP3";
    }

    @Override
    public String toString() {
        return super.toString() + " | Album: " + album;
    }

}