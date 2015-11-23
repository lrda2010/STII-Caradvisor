package models;

import play.data.validation.Constraints;

public class User {

    String ID_Usuario_foro;

    @Constraints.Required
    String username;
    String password;

    String DNI;
    String email;
    String perfil;
    String FK_ID_propietario;

    public User(String ID_Usuario_foro, String username, String password, String DNI, String email, String perfil, String FK_ID_propietario) {
        this.ID_Usuario_foro = ID_Usuario_foro;
        this.username = username;
        this.password = password;
        this.DNI = DNI;
        this.email = email;
        this.perfil = perfil;
        this.FK_ID_propietario = FK_ID_propietario;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    public String getID_Usuario_foro() {
        return ID_Usuario_foro;
    }

    public void setID_Usuario_foro(String ID_Usuario_foro) {
        this.ID_Usuario_foro = ID_Usuario_foro;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getFK_ID_propietario() {
        return FK_ID_propietario;
    }

    public void setFK_ID_propietario(String FK_ID_propietario) {
        this.FK_ID_propietario = FK_ID_propietario;
    }
}
