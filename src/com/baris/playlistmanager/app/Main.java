package com.baris.playlistmanager.app;

import com.baris.playlistmanager.iterator.PlaylistIterator;
import com.baris.playlistmanager.model.MediaFile;
import com.baris.playlistmanager.model.Mp3File;
import com.baris.playlistmanager.model.Playlist;
import com.baris.playlistmanager.model.WavFile;

public class Main{
  public static void main(String[] args){
    System.out.println("Playlist Manager Started");

       MediaFile song1 = new Mp3File(
                "1",
                "Blinding Lights",
                "The Weeknd",
                200,
                "songs/blindinglights.mp3",
                "After Hours"
        );

        MediaFile song2 = new WavFile(
                "2",
                "Interstellar Theme",
                "Hans Zimmer",
                240,
                "songs/interstellar.wav",
                44100
        );

        Playlist playlist= new Playlist("first playlist");
        playlist.addSong(song1);
        playlist.addSong(song2);

        System.out.println("Iterator test");

        PlaylistIterator iterator= new PlaylistIterator(playlist);

        while(iterator.hasNext()) {
          System.out.println(iterator.next());
        }
    
        
  }
}