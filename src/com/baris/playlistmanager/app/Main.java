package com.baris.playlistmanager.app;

import com.baris.playlistmanager.iterator.PlaylistIterator;
import com.baris.playlistmanager.model.MediaFile;
import com.baris.playlistmanager.model.Playlist;
import com.baris.playlistmanager.factory.MediaFileFactory;

public class Main{
  public static void main(String[] args){
    System.out.println("Playlist Manager Started");

      MediaFile song1 = MediaFileFactory.createFromPath(
        "1",
        "Test Song",
        "Test Artist",
        200,
        "media/test-song.mp3"
);

MediaFile song2 = MediaFileFactory.createFromPath(
        "2",
        "Another Song",
        "Another Artist",
        240,
        "media/sample-audio.wav"
);
//for testing factory class

 MediaFile badSong = MediaFileFactory.createFromPath(
    "3",
    "Bad Song",
    "Unknown",
    100,
    "media/test.txt"
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