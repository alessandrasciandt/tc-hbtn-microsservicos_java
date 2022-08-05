package com.song.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Welcome!";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs() {
        List<Song> songs = songRepository.getAllSongs();
        return songs;
    }

    @GetMapping(path = "/findSong/{id}")
    public Song findSongById(@PathVariable Integer id) {
        Song song = songRepository.getSongById(id);
        return song;
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public Song addSong(@RequestBody Song song) {
        songRepository.addSong(song);
        Song songResultado = songRepository.getSongById(song.getId());
        return songResultado;
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public Song updadeSong(@RequestBody Song song) {
        songRepository.updateSong(song);
        Song songresultado = songRepository.getSongById(song.getId());
        return songresultado;
    }

    @DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
    public void deleteSongById(@RequestBody Song song) {
        songRepository.removeSong(song);
    }
}
