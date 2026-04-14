package com.baris.playlistmanager.model;

public abstract class MediaFile{
    private String id;
    private String title;
    private String artist;
    private int durationInSeconds;
    private String filePath;

    public MediaFile(String id, String title, String artist, int durationInSeconds, String filePath) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
        this.filePath = filePath;
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