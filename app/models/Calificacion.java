package models;

/**
 * Created by Administrador on 26/11/2015.
 */
public class Calificacion {


    private int id;
    private String comentario;
    private int calificacionG;
    private int calidad;
    private int ubicacion;
    private int precio;
    private int equipoL;
    private int NivelR;
    private String fk_proveedor;
    private String fk_usuario;

    public Calificacion(String comentario, int calificacionG, int calidad, int ubicacion, int precio, int equipoL, int nivelR, String fk_proveedor, String fk_usuario) {
        this.comentario = comentario;
        this.calificacionG = calificacionG;
        this.calidad = calidad;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.equipoL = equipoL;
        NivelR = nivelR;
        this.fk_proveedor = fk_proveedor;
        this.fk_usuario = fk_usuario;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacionG() {
        return calificacionG;
    }

    public void setCalificacionG(int calificacionG) {
        this.calificacionG = calificacionG;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getEquipoL() {
        return equipoL;
    }

    public void setEquipoL(int equipoL) {
        this.equipoL = equipoL;
    }

    public int getNivelR() {
        return NivelR;
    }

    public void setNivelR(int nivelR) {
        NivelR = nivelR;
    }

    public String getFk_proveedor() {
        return fk_proveedor;
    }

    public void setFk_proveedor(String fk_proveedor) {
        this.fk_proveedor = fk_proveedor;
    }

    public String getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(String fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
}
