# Java Playlist Manager

A lightweight command-line playlist manager built in Java, demonstrating object-oriented design principles and design patterns such as Factory and Iterator.

## Features

* Add songs manually via CLI (virtual entries)
* Automatically scan and load MP3/WAV files from a local `media/` folder
* Search songs by title or artist
* Sort songs by title or duration
* Custom iterator implementation for playlist traversal
* Input validation with custom exception handling

## Demo

```
=== Playlist Manager ===
1 - Add song
2 - List songs
3 - Search
4 - Sort songs
5 - Exit
```

## Architecture

* Factory Pattern: Used to create song objects based on file type (MP3, WAV)
* Iterator Pattern: Custom implementation for traversing the playlist

## Concepts Demonstrated

* Object-Oriented Programming (OOP)
* Inheritance and Abstraction
* Design Patterns (Factory, Iterator)
* Exception Handling
* File System interaction (`java.io.File`)
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

2. Navigate into the project folder:

```
cd java-playlist-manager
```

3. Open in an IDE (IntelliJ or VS Code)

4. Create a `media/` folder and add `.mp3` or `.wav` files

5. Run `Main.java`

## Why This Project?

This project was built to practice object-oriented programming and apply design patterns in a simple real-world scenario.

## Limitations

* No real audio playback
* Metadata is not extracted from files
* Manually added songs are not linked to actual files

## Future Improvements

* Add JavaFX GUI
* Extract real MP3 metadata
* Add audio playback support
* Save/load playlists from file

## Author

Baris Oener
