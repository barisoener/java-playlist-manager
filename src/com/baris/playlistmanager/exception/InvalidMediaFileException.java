package com.baris.playlistmanager.exception;

public class InvalidMediaFileException extends RuntimeException {
  public InvalidMediaFileException(String message){
    super(message);
  }
}