package com.baris.playlistmanager.factory;

import java.io.File;

import com.baris.playlistmanager.exception.InvalidMediaFileException;
import com.baris.playlistmanager.model.MediaFile;
import com.baris.playlistmanager.model.Mp3File;
import com.baris.playlistmanager.model.WavFile;

public class MediaFileFactory {
    
     public static MediaFile createFromPath(String id, String title,String artist,int durationInSeconds,String filePath)
     {
       validateFilePath(filePath);

        String extension = getExtension(filePath);

        if (extension.equals("mp3")) {
            return new Mp3File(id, title, artist, durationInSeconds, filePath, "Unknown Album");
        }

        if (extension.equals("wav")) {
            return new WavFile(id, title, artist, durationInSeconds, filePath, 44100);
        }

        throw new InvalidMediaFileException("Unsupported file type: " + extension);
     }



      private static void validateFilePath(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new InvalidMediaFileException("File path cannot be empty");
        }

        File file = new File(filePath);

        if (!file.exists()) {
            throw new InvalidMediaFileException("File does not exist: " + filePath);
        }

        if (!file.isFile()) {
            throw new InvalidMediaFileException("Path is not a file: " + filePath);
        }
    }

     private static String getExtension(String filePath) {
        int lastDotIndex = filePath.lastIndexOf(".");

        if (lastDotIndex == -1 || lastDotIndex == filePath.length() - 1) {
            throw new InvalidMediaFileException("File has no valid extension: " + filePath);
        }

        return filePath.substring(lastDotIndex + 1).toLowerCase();
    }

}
