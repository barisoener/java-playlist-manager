package com.baris.playlistmanager.app;

import com.baris.playlistmanager.factory.MediaFileFactory;
import com.baris.playlistmanager.model.MediaFile;
import com.baris.playlistmanager.model.Playlist;

import java.util.Scanner;

public class Main{
 public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Playlist playlist = new Playlist("My Playlist");

    boolean running = true;

    while (running) {
        System.out.println("\n=== Playlist Manager ===");
        System.out.println("1 - Add song");
        System.out.println("2 - List songs");
        System.out.println("3 - Search by title");
        System.out.println("4 - Exit");
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
                searchByTitle(scanner, playlist);
                break;
            case 4:
                running = false;
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

        System.out.print("File name inside media folder, e.g. test-song.mp3: ");
        String fileName = scanner.nextLine();

        String path = "media/" + fileName;

        MediaFile song = MediaFileFactory.createFromPath(
                id,
                title,
                artist,
                duration,
                path
        );

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

    for (MediaFile song : playlist.getAllSongs()) {
        System.out.println(song);
    }
}

private static void searchByTitle(Scanner scanner, Playlist playlist) {
    System.out.print("Search keyword: ");
    String keyword = scanner.nextLine();

    for (MediaFile song : playlist.searchByTitle(keyword)) {
        System.out.println(song);
    }
}


}