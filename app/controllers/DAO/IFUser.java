package controllers.DAO;

import models.User;
import models.Vehiculo;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrador on 22/06/2015.
 */
public interface IFUser {

    Connection getConnection();
    User validarBD(String user, String password);
    List<Vehiculo> listaVehiculos(User usuario);

}
