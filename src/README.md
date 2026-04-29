# Java Playlist Manager

A command-line playlist manager built in Java.
This project demonstrates object-oriented programming, design patterns, and basic file system integration.

## Features

* Add songs manually via CLI (MP3 or WAV)
* Automatically scan and load media files from a local `media/` folder
* Support for multiple file types (MP3, WAV)
* Search songs by title or artist
* Sort songs by title or duration
* Custom iterator implementation for playlist traversal
* Input validation with custom exception handling

## Technologies and Concepts

* Java
* Object-Oriented Programming (OOP)
* Inheritance and Abstraction
* Factory Design Pattern
* Iterator Pattern
* Exception Handling
* File System (java.io.File)
* Command Line Interface (CLI)

## Project Structure

```
src/
 └── com.baris.playlistmanager
     ├── app
     ├── model
     ├── factory
     ├── iterator
     ├── exception
```

## How to Run

1. Clone the repository:

```
git clone https://github.com/barisoener/java-playlist-manager.git
```

2. Open in an IDE (VS Code or IntelliJ)

3. Create a `media/` folder and add `.mp3` or `.wav` files

4. Run `Main.java`

## Example Usage

```
=== Playlist Manager ===
1 - Add song
2 - List songs
3 - Search
4 - Sort songs
5 - Exit
```

## Notes

* Auto-loaded files use default metadata (filename, "Unknown Artist", fixed duration)
* Manual entries are not linked to real files (use placeholder path)
* Manual entries are treated as virtual songs within the playlist
* Unsupported file types are skipped with a console message

## Future Improvements

* Add JavaFX GUI
* Extract real MP3 metadata
* Add audio playback
* Save/load playlists from file

## Author

Baris Oener

