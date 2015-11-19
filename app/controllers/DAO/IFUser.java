package controllers.DAO;

import models.*;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrador on 22/06/2015.
 */
public interface IFUser {

    Connection getConnection();
    User validarBD(String user, String password);
    List<Vehiculo_Usuario> listaVehiculos(User usuario);
    List<Proveedor> listaDistribuidoresTop();
    List<Proveedor> listaTalleresTop();
    List<Proveedor> listaMecanicosTop();
    Integer devolverIdMantenimiento(String marca, String modelo);
    List<Mantenimiento> devolverMantenimiento(Integer id, Integer kilometraje);
    void AgregarVehiculo(Vehiculo_Usuario veh);
    Integer devolverIdRepuesto(String marca);
    List<Repuesto> devolverRepuestos(Integer id, String trepuesto);

}


