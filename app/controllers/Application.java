package controllers;

//import play.*; //esto se usa para el lenguaje Scala

import controllers.DAO.DAOUser;
import models.*;
import play.cache.Cache;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import java.util.List;

public class Application extends Controller {

    static DAOUser db = new DAOUser();

    public static Result principal() {
        return ok(login.render(0,1));
    }

    public static Result pie() {
        return ok(footer.render());
    }

    public static Result cabecera() {
        return ok(cabecera.render());
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

            session().put("user",result.getUsername());
            Cache.set("user",result);
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
            return ok(login.render(1,1));
        }

    }

    public static Result LogOut(){
        session().clear();
        Cache.remove("user");
        return ok(login.render(0,1));
    }

    public static Result BusquedaRapida(){


        DynamicForm requestData = Form.form().bindFromRequest();

        int km = Integer.parseInt(requestData.get("kilometraje"));
        String marca = requestData.get("marca");
        String modelo = requestData.get("modelo");

        Integer id = db.devolverIdMantenimiento(marca,modelo);
        List<Mantenimiento> mantenimientos = db.devolverMantenimiento(id,km);

        if(mantenimientos.isEmpty()) {
            return ok(busquedarapida.render(0,marca,modelo,km,null));
        }
        else{
            return ok(busquedarapida.render(1,marca,modelo,km,mantenimientos));
        }
    }

    public static Result BusquedaRepuesto(){

        DynamicForm requestData = Form.form().bindFromRequest();
        String marca = requestData.get("marcabr");
        String repuesto = requestData.get("repuesto");
        Integer id = db.devolverIdRepuesto(marca);
        List<Repuesto> repuestos = db.devolverRepuestos(id, repuesto);

        return ok(busquedarepuesto.render(marca, repuestos));
    }


    public static Result AgregarVehiculo(){

        DynamicForm requestData = Form.form().bindFromRequest();
        int km = Integer.parseInt(requestData.get("km"));
        String marca = requestData.get("marcaM");
        String modelo = requestData.get("modeloM");
        String color = requestData.get("color");
        int year = Integer.parseInt(requestData.get("year"));

        db.AgregarVehiculo(new Vehiculo_Usuario(marca,
                modelo, year, color, km, session().get("user")));

        List<Vehiculo_Usuario> veh = db.listaVehiculos((User) Cache.get("user"));
        List<Proveedor> disTop = db.listaDistribuidoresTop();
        List<Proveedor> talTop = db.listaTalleresTop();
        List<Proveedor> mecTop = db.listaMecanicosTop();

        return ok(intro.render(1, veh,disTop,talTop,mecTop));

    }

    public static Result RegistrarUsuario(){

        DynamicForm requestData = Form.form().bindFromRequest();
        String valor_perfil = null;
        String username = requestData.get("inputuser");
        String password = requestData.get("password");
        String nombre = requestData.get("inputNombre");
        String apellido = requestData.get("inputApellido");
        String DNI = requestData.get("inputDNI");
        String direccion = requestData.get("inputDireccion");
        int telefono = Integer.parseInt(requestData.get("number"));
        String email = requestData.get("email");
        String perfil = requestData.get("perfil");

        switch (perfil) {
            case "Usuario":
                valor_perfil = "USR";
                break;
            case "Taller":
                valor_perfil = "TAL";
                break;
            case "Mecanico":
                valor_perfil = "MEC";
                break;
            case "Distribuidor":
                valor_perfil = "DIS";
                break;
        }


        db.RegistrarUsuario(new User_Prop(username,nombre,apellido,DNI,direccion,telefono),new User(username,username,password,
                DNI,email,valor_perfil,username));

        return ok(login.render(0,0));
    }

    public static Result RetrocederMenu(){

        List<Vehiculo_Usuario> veh = db.listaVehiculos((User) Cache.get("user"));
        List<Proveedor> disTop = db.listaDistribuidoresTop();
        List<Proveedor> talTop = db.listaTalleresTop();
        List<Proveedor> mecTop = db.listaMecanicosTop();

        if(veh.isEmpty()){
            return ok(intro.render(0, null,disTop,talTop,mecTop));}
        else{
            return ok(intro.render(1, veh,disTop,talTop,mecTop));
        }

    }

    public static Result Proveedor(String id){

        Proveedor pro = db.devolverProveedor(id);
        String cad = "../assets/proveedores/" + pro.getId() + ".jpg";
        return ok(proveedor.render(pro, cad));
    }

    }


