package controllers.DAO;

import models.User;

import java.sql.Connection;

/**
 * Created by Administrador on 22/06/2015.
 */
public interface IFUser {

    Connection getConnection();
    User validarBD(String user, String password);

}
