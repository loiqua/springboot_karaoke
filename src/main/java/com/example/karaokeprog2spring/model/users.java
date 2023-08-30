package com.example.karaokeprog2spring.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class users {
    private Integer Id_users;
    private String name;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "============users===========" + "\n" +
                " idUsers = " + Id_users + "\n" +
                " name = " + name + "\n" +
                " email = " + email + "\n" +
                " password = " + password + "\n";
    }
}
