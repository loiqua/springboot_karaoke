package com.example.karaokeprog2spring.repository.DAO;

import com.example.karaokeprog2spring.model.users;
import com.example.karaokeprog2spring.repository.Interface.UsersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersDAO implements UsersInterface {
    private databaseconfig databaseconfig;
    @Autowired
    public UsersDAO(databaseconfig databaseconfig){
        this.databaseconfig = databaseconfig;
    }
    private void convertToList(List<users> allUsers, ResultSet result) throws SQLException {
        allUsers.add(new users(
                result.getInt("id"),
                result.getString("name"),
                result.getString("email"),
                result.getString("password")
        ));
    }
    @Override
    public void insertUsers(users toInsert) throws SQLException {
        String sql = "INSERT INTO users(id,name,email,password)"+
                "values(?,?,?,?)";
        try(PreparedStatement statement = databaseconfig.datakaraokesource().getConnection().prepareStatement(sql)){
            statement.setInt(1,toInsert.getId_users());
            statement.setString(2,toInsert.getName());
            statement.setString(3,toInsert.getEmail());
            statement.setString(4,toInsert.getPassword());

            statement.executeUpdate();
        }

    }

    @Override
    public List<users> findAllUsers() throws SQLException {
        List<users> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (PreparedStatement preparedStatement = databaseconfig.datakaraokesource().getConnection().prepareStatement(sql)) {
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                convertToList(allUsers, result);
            }
        }

        return allUsers;
    }


    public void updateUserById(users toUpdate) throws SQLException {
        String sql = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";
        try (PreparedStatement statement = databaseconfig.datakaraokesource().getConnection().prepareStatement(sql)) {
            statement.setString(1, toUpdate.getName());
            statement.setString(2, toUpdate.getEmail());
            statement.setString(3, toUpdate.getPassword());
            statement.setInt(4, toUpdate.getId_users());

            statement.executeUpdate();
        }
    }

    public void deleteUserById(int userId) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = databaseconfig.datakaraokesource().getConnection().prepareStatement(sql)) {
            statement.setInt(1, userId);

            statement.executeUpdate();
        }
    }


}

