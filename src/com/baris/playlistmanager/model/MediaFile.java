package com.baris.playlistmanager.model;

import com.baris.playlistmanager.exception.InvalidMediaFileException;

public abstract class MediaFile{
    private String id;
    private String title;
    private String artist;
    private int durationInSeconds;
    private String filePath;

    public MediaFile(String id, String title, String artist, int durationInSeconds, String filePath) {
        validate(id, title, artist, durationInSeconds, filePath);

        this.id = id;
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
        this.filePath = filePath;
    }

       private void validate(String id, String title, String artist, int durationInSeconds, String filePath) {
        if (isBlank(id)) {
            throw new InvalidMediaFileException("ID cannot be empty");
        }

        if (isBlank(title)) {
            throw new InvalidMediaFileException("Title cannot be empty");
        }

        if (isBlank(artist)) {
            throw new InvalidMediaFileException("Artist cannot be empty");
        }

        if (durationInSeconds <= 0) {
            throw new InvalidMediaFileException("Duration must be positive");
        }

        if (isBlank(filePath)) {
            throw new InvalidMediaFileException("File path cannot be empty");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public String getId() {
    return id;
}
      public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getFilePath() {
        return filePath;
    }
    
    public String getFormattedDuration(){
      int minutes=durationInSeconds/60;
      int seconds= durationInSeconds%60;
       return minutes + ":" + String.format("%02d", seconds);
    }

    public abstract String getFileType();

     @Override
    public String toString() {
        return "[" + getFileType() + "] " + title + " - " + artist + " (" + getFormattedDuration() + ")";
    }
}