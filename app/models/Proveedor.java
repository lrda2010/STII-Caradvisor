package models;

/**
 * Created by Administrador on 08/11/2015.
 */
public class Proveedor {

    private String id;
    private String tipo;
    private String nombre;
    private String servicio;
    private String direccion;
    private String telefono;
    private String web;
    private int puntaje;

    public Proveedor(String id, String tipo, String nombre, String servicio, String direccion, String telefono, String web, int puntaje) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.servicio = servicio;
        this.direccion = direccion;
        this.telefono = telefono;
        this.web = web;
        this.puntaje = puntaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
