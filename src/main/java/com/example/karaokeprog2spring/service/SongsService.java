package com.example.karaokeprog2spring.service;

import com.example.karaokeprog2spring.model.Song;
import com.example.karaokeprog2spring.repository.DAO.SongsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class SongsService {
    private final SongsDAO songsDAO;

    @Autowired
    public SongsService(SongsDAO songsDAO) {
        this.songsDAO = songsDAO;
    }

    public void insertSong(Song song) {
        try {
            songsDAO.insertSong(song);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert song");
        }
    }

    public Song getSongById(int id) {
        try {
            return songsDAO.findSongById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve song by ID");
        }
    }

    public boolean updateSong(int id, Song song) {
        try {
            return songsDAO.updateSongById(id, song); // Retourne true si la mise à jour réussit
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update song");
        }
    }

    public boolean deleteSong(int id) {
        try {
            return songsDAO.deleteSongById(id); // Retourne true si la suppression réussit
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete song");
        }
    }



}

