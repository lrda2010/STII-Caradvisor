package models;

/**
 * Created by Administrador on 04/11/2015.
 */
public class Vehiculo {

    private String ID_vehiculo;
    private String marca;
    private String modelo;
    private int year;
    private String color;
    private String caracteristicas;
    private String FK_ID_usuario;

    public Vehiculo(String ID_vehiculo, String marca, String modelo, int year, String color, String caracteristicas, String FK_ID_usuario) {

        this.ID_vehiculo = ID_vehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.color = color;
        this.caracteristicas = caracteristicas;
        this.FK_ID_usuario = FK_ID_usuario;
    }


    public String getID_vehiculo() {
        return ID_vehiculo;
    }

    public void setID_vehiculo(String ID_vehiculo) {
        this.ID_vehiculo = ID_vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getFK_ID_usuario() {
        return FK_ID_usuario;
    }

    public void setFK_ID_usuario(String FK_ID_usuario) {
        this.FK_ID_usuario = FK_ID_usuario;
    }
}
