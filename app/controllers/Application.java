package controllers;

//import play.*; //esto se usa para el lenguaje Scala

import controllers.DAO.DAOUser;
import models.Mantenimiento;
import models.Proveedor;
import models.User;
import models.Vehiculo_Usuario;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;

public class Application extends Controller {

    static DAOUser db = new DAOUser();

    public static Result principal() {
        return ok(login.render(0));
    }

    public static Result pie() {
        return ok(footer.render());
    }

    public static Result cabecera() {
        return ok(header.render());
    }


    //Generando el metodo de validacion de usuario
    public static Result ValidaciondeUsuario()
    {

        //PARA POST --> ES SEGURO
        DynamicForm requestData = Form.form().bindFromRequest();
        String username = requestData.get("username");
        String password = requestData.get("password");

        User result = db.validarBD(username,password);

        if (result!= null) {

            List<Vehiculo_Usuario> veh = db.listaVehiculos(result);
            List<Proveedor> disTop = db.listaDistribuidoresTop();
            List<Proveedor> talTop = db.listaTalleresTop();
            List<Proveedor> mecTop = db.listaMecanicosTop();

            if(veh.isEmpty()){
                return ok(intro.render(0, null,disTop,talTop,mecTop));}
            else{
                return ok(intro.render(1, veh,disTop,talTop,mecTop));
            }

        }else{
            return ok(login.render(1));
        }

    }

    public static Result LogOut(){
        session().clear();
        return ok(login.render(0));
    }


    public static Result BusquedaRapida(){


        DynamicForm requestData = Form.form().bindFromRequest();
        int km = Integer.parseInt(requestData.get("kilometraje"));
        String marca = requestData.get("marca");
        String modelo = requestData.get("modelo");

        Integer id = db.devolverIdMantenimiento(marca,modelo);
        System.out.println("El id devuelto es: " + id);
        List<Mantenimiento> mantenimientos = db.devolverMantenimiento(id,km);

        if(mantenimientos.isEmpty()) {
            return ok(busquedarapida.render(0,marca,modelo,km,null));
        }
        else{
            return ok(busquedarapida.render(1,marca,modelo,km,mantenimientos));
        }
    }

    public static Result AgregarVehiculo(){

        db.AgregarVehiculo(new Vehiculo_Usuario("03","Toyota",
                "Corolla", 2003, "Rojo", 201010, "ocolfer"));

        return ok();
    }

    }


