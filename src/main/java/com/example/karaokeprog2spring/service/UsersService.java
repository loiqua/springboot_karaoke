package com.example.karaokeprog2spring.service;

import com.example.karaokeprog2spring.model.users;
import com.example.karaokeprog2spring.repository.DAO.UsersDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsersService {
    private UsersDAO usersDAO;

    public UsersService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public users insert(users toUsers) {
        try {
            this.usersDAO.insertUsers(toUsers);
            return toUsers;
        } catch (SQLException e) {
            throw new RuntimeException("Error during user insertion");
        }
    }

    public users updateUser(users toUpdate) {
        try {
            this.usersDAO.updateUserById(toUpdate); // Assurez-vous que le nom de la méthode correspond ici
            return toUpdate;
        } catch (SQLException e) {
            throw new RuntimeException("Error during user update");
        }
    }


    public void deleteUser(int userId) {
        try {
            this.usersDAO.deleteUserById(userId);
        } catch (SQLException e) {
            throw new RuntimeException("Error during user deletion");
        }
    }

    public List<users> getAllUsers() {
        try {
            return usersDAO.findAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all users");
        }
    }
}
