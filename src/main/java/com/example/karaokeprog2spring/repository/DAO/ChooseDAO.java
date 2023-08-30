package com.example.karaokeprog2spring.repository.DAO;

import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class ChooseDAO {
    private DataSource dataSource;

    public ChooseDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertChoose(int userId, int songId) throws SQLException {
        String sql = "INSERT INTO choose (user_id, song_id) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, songId);

            statement.executeUpdate();
        }
    }

    // Implémentez d'autres méthodes si nécessaires
}
