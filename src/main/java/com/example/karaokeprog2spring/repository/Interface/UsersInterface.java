package com.example.karaokeprog2spring.repository.Interface;

import com.example.karaokeprog2spring.model.users;

import java.sql.SQLException;
import java.util.List;

public interface UsersInterface {
    void insertUsers(users toInsert) throws SQLException;
    List<users> findAllUsers() throws SQLException;
    void updateUserById(users toUpdate) throws SQLException;
    void deleteUserById(int userId) throws SQLException;
}
