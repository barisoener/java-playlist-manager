package com.baris.playlistmanager.iterator;

import com.baris.playlistmanager.model.MediaFile;
import com.baris.playlistmanager.model.Playlist;

public class PlaylistIterator{

  private Playlist playlist;
  private int currentPosition;

  public PlaylistIterator(Playlist playlist)
  {
    this.playlist=playlist;
    this.currentPosition=0;
  }

  public boolean hasNext(){
    return currentPosition<playlist.size();
  }

  public MediaFile next(){
    if(!hasNext()){
      return null;
    }
    return playlist.getAllSongs().get(currentPosition++);
  }

  public boolean hasPrevious(){
    return currentPosition>0;
  }

  public MediaFile previous()
  {
    if(!hasPrevious()){
      return null;
    }
    return playlist.getAllSongs().get(--currentPosition);
  }

  public MediaFile current()
  {
    if(playlist.isEmpty() || currentPosition >= playlist.size()) {
      return null;
    }
    return playlist.getAllSongs().get(currentPosition);
  }


  public void reset()
  {
    currentPosition=0;
  }
}