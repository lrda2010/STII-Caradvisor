package controllers;

//import play.*; //esto se usa para el lenguaje Scala
import controllers.DAO.DAOUser;
import models.User;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    static DAOUser db = new DAOUser();

    public static Result principal() {
        return ok(login.render(0));
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
            return redirect("http://www.google.com.pe");
        }else{
            return ok(login.render(1));
        }
    }



    public static Result LogOut(){
        session().clear();
        return ok(login.render(0));
    }


    }


