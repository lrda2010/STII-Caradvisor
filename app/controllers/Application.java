package controllers;

//import play.*; //esto se usa para el lenguaje Scala

import controllers.DAO.DAOUser;
import models.User;
import models.Vehiculo;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.footer;
import views.html.header;
import views.html.intro;
import views.html.login;

public class Application extends Controller {

    static DAOUser db = new DAOUser();

    public static Result principal() {
        return ok(login.render(0));
    }

    public static Result footer() {
        return ok(footer.render());
    }

    public static Result header() {
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

            Vehiculo veh = db.existeVehiculos(result);

            if(veh == null){
                return ok(intro.render(0));}
            else{
                return ok(intro.render(1));
            }

        }else{
            return ok(login.render(1));
        }

    }


    public static Result LogOut(){
        session().clear();
        return ok(login.render(0));
    }


    }


