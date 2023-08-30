package com.example.karaokeprog2spring.controller;

import com.example.karaokeprog2spring.model.Song;
import com.example.karaokeprog2spring.service.SongsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongsController {
    private final SongsService songsService;

    @Autowired
    public SongsController(SongsService songsService) {
        this.songsService = songsService;
    }

    @PostMapping("/")
    public ResponseEntity<String> addSong(@RequestBody Song song) {
        songsService.insertSong(song);
        return ResponseEntity.status(HttpStatus.CREATED).body("Song added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable int id) {
        Song song = songsService.getSongById(id);
        if (song != null) {
            return ResponseEntity.ok(song);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSong(@PathVariable int id, @RequestBody Song song) {
        boolean updated = songsService.updateSong(id, song);
        if (updated) {
            return ResponseEntity.ok("Song updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSong(@PathVariable int id) {
        boolean deleted = songsService.deleteSong(id);
        if (deleted) {
            return ResponseEntity.ok("Song deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}