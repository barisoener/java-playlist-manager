package com.baris.playlistmanager.model;

public class WavFile extends MediaFile{
  private int sampleRate;

  public WavFile(String id, String title, String artist, int durationInSeconds, String filePath, int sampleRate) {
        super(id, title, artist, durationInSeconds, filePath);
        this.sampleRate = sampleRate;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    @Override
    public String getFileType() {
        return "WAV";
    }

    @Override
    public String toString() {
        return super.toString() + " | Sample Rate: " + sampleRate + " Hz";
    }
}