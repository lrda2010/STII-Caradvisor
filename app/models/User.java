package models;

import play.data.validation.Constraints;

/**
 * Created by Administrador on 22/06/2015.
 */
public class User {

    @Constraints.Required
    String username;
    String password;

    public User() {
    }

    public User(String username,
                String password
                 ) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
