package com.baris.playlistmanager.app;

import com.baris.playlistmanager.factory.MediaFileFactory;
import com.baris.playlistmanager.iterator.PlaylistIterator;
import com.baris.playlistmanager.model.MediaFile;
import com.baris.playlistmanager.model.Mp3File;
import com.baris.playlistmanager.model.Playlist;
import com.baris.playlistmanager.model.WavFile;

import java.io.File;
import java.util.Scanner;

public class Main{
 public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Playlist playlist = new Playlist("My Playlist");

    //to add existing songs from media
    loadMediaFolder(playlist);

    boolean running = true;

    while (running) {
        System.out.println("\n=== Playlist Manager ===");
        System.out.println("1 - Add song");
        System.out.println("2 - List songs");
        System.out.println("3 - Search");
        System.out.println("4- Sort songs");
        System.out.println("5 - Exit");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addSong(scanner, playlist);
                break;
            case 2:
                listSongs(playlist);
                break;
            case 3:
                searchSongs(scanner,playlist);
                break;
            case 4:
                sortSongs(scanner,playlist);
                break;
            case 5:
                running=false;
                break;
            default:
                System.out.println("Invalid choice");
        }
        if (running) {
                System.out.println("\nPress ENTER to return to menu...");
                //pause until ENTER
                scanner.nextLine();
        }
    }

    scanner.close();
    System.out.println("Program closed.");
}




private static void addSong(Scanner scanner, Playlist playlist) {
    try {
        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Artist: ");
        String artist = scanner.nextLine();

        System.out.print("Duration in seconds: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("File type:");
        System.out.println("1 - MP3");
        System.out.println("2 - WAV");
        System.out.print("Choice: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        MediaFile song;

        // Manual creation: choose type without using factory
        if (type == 1) {
            song = new Mp3File(
                    id,
                    title,
                    artist,
                    duration,
                    "manual-entry",
                    "User input"
            );
        } else if (type == 2) {
            song = new WavFile(
                    id,
                    title,
                    artist,
                    duration,
                    "manual-entry",
                    44100
            );
        } else {
            System.out.println("Invalid file type.");
            return;
        }

        playlist.addSong(song);
        System.out.println("Song added successfully.");

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

private static void listSongs(Playlist playlist) {
    if (playlist.isEmpty()) {
        System.out.println("Playlist is empty.");
        return;
    }

    PlaylistIterator iterator = new PlaylistIterator(playlist);

    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
}



private static void sortSongs(Scanner scanner, Playlist playlist) {

    System.out.println("1 - Sort by title");
    System.out.println("2 - Sort by duration");
    System.out.print("Choice: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    if (choice == 1) {
        playlist.sortByTitle();
        System.out.println("Songs sorted by title.");
    } else if (choice == 2) {
        playlist.sortByDuration();
        System.out.println("Songs sorted by duration.");
    } else {
        System.out.println("Invalid choice.");
    }
}
private static void searchSongs(Scanner scanner, Playlist playlist) {

    System.out.println("1 - Search by title");
    System.out.println("2 - Search by artist");
    System.out.print("Choice: ");

    int choice = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Keyword: ");
    String keyword = scanner.nextLine();

    if (choice == 1) {
        for (MediaFile song : playlist.searchByTitle(keyword)) {
            System.out.println(song);
        }
    } else if (choice == 2) {
        for (MediaFile song : playlist.searchByArtist(keyword)) {
            System.out.println(song);
        }
    } else {
        System.out.println("Invalid choice.");
    }
}

private static void loadMediaFolder(Playlist playlist) {

    File folder = new File("media/");
    File[] files = folder.listFiles();

    if (files == null) {
        System.out.println("Media folder not found or empty.");
        return;
    }

    for (File file : files) {

        if (!file.isFile()) {
            continue;
        }

        try {
            MediaFile song = MediaFileFactory.createFromPath(
                    "auto-" + file.getName(),
                    file.getName(),
                    "Unknown Artist",
                    180,
                    file.getPath()
            );

            playlist.addSong(song);

        } catch (Exception e) {
            System.out.println("Skipping file: " + file.getName());
        }
    }
}

}