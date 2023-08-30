package com.example.karaokeprog2spring.service;

import com.example.karaokeprog2spring.repository.DAO.ChooseDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ChooseService {
    private ChooseDAO chooseDAO;

    public ChooseService(ChooseDAO chooseDAO) {
        this.chooseDAO = chooseDAO;
    }

    public void insertChoose(int userId, int songId) {
        try {
            chooseDAO.insertChoose(userId, songId);
        } catch (SQLException e) {
            throw new RuntimeException("Choose insertion error");
        }
    }

    // Implémentez d'autres méthodes si nécessaires
}
