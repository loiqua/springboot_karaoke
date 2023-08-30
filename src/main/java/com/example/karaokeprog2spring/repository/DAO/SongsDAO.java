package com.example.karaokeprog2spring.repository.DAO;

import com.example.karaokeprog2spring.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongsDAO {
    private final DataSource dataSource;

    @Autowired
    public SongsDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public boolean deleteSongByIdWithId(int id) throws SQLException {
        String sql = "DELETE FROM songs WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0; // Retourne true si au moins une ligne a été supprimée
        }
    }


    public void insertSong(Song song) throws SQLException {
        String sql = "INSERT INTO songs (title, artist, genre_id, year, lyrics) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, song.getTitle());
            preparedStatement.setString(2, song.getArtist());
            preparedStatement.setInt(3, song.getGenreId());
            preparedStatement.setInt(4, song.getYear());
            preparedStatement.setString(5, song.getLyrics());

            preparedStatement.executeUpdate();
        }
    }

    public List<Song> findAllSongs() throws SQLException {
        List<Song> allSongs = new ArrayList<>();
        String sql = "SELECT * FROM songs";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                allSongs.add(mapResultSetToSong(resultSet));
            }
        }

        return allSongs;
    }
    public Song findSongById(int id) throws SQLException {
        String sql = "SELECT * FROM songs WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToSong(resultSet);
                }
            }
        }

        return null; // Ajustez cette logique selon vos besoins
    }

    public boolean updateSongById(int id, Song song) throws SQLException {
        String sql = "UPDATE songs SET title = ?, artist = ?, genre_id = ?, year = ?, lyrics = ? WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, song.getTitle());
            preparedStatement.setString(2, song.getArtist());
            preparedStatement.setInt(3, song.getGenreId());
            preparedStatement.setInt(4, song.getYear());
            preparedStatement.setString(5, song.getLyrics());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        }
        return false;
    }

    public boolean deleteSongById(int id) throws SQLException {
        String sql = "DELETE FROM songs WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }
        return false;
    }

    // Méthode utilitaire pour mapper le résultat de la requête à un objet Song
    private Song mapResultSetToSong(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String artist = resultSet.getString("artist");
        int genreId = resultSet.getInt("genre_id");
        int year = resultSet.getInt("year");
        String lyrics = resultSet.getString("lyrics");

        return new Song(id, title, artist, genreId, year, lyrics);
    }

}
