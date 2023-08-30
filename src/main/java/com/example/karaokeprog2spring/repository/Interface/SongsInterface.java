package com.example.karaokeprog2spring.repository.Interface;

import com.example.karaokeprog2spring.model.Song;

import java.sql.SQLException;
import java.util.List;

public interface SongsInterface {
    void insertSong(Song song) throws SQLException;
    void updateSong(Song song) throws SQLException;
    void deleteSongById(int songId) throws SQLException;
    Song findSongById(int songId) throws SQLException;
    List<Song> findAllSongs() throws SQLException;
}
