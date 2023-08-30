package com.example.karaokeprog2spring.repository.Interface;

import java.sql.SQLException;

public interface ChooseInterface {
    void insertChoose(int userId, int songId) throws SQLException;

    // Déclarez d'autres méthodes si nécessaires
}
