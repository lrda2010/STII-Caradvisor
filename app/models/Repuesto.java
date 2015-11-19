package models;

/**
 * Created by Administrador on 19/11/2015.
 */
public class Repuesto {

    private int idrepuesto;
    private String marca;
    private String tipo;
    private String origen;
    private int id_veh_gen;
    private String tipo_repuesto;

    public Repuesto(int idrepuesto, String marca, String tipo, String origen, int id_veh_gen, String tipo_repuesto) {
        this.idrepuesto = idrepuesto;
        this.marca = marca;
        this.tipo = tipo;
        this.origen = origen;
        this.id_veh_gen = id_veh_gen;
        this.tipo_repuesto = tipo_repuesto;
    }

    public int getIdrepuesto() {
        return idrepuesto;
    }

    public void setIdrepuesto(int idrepuesto) {
        this.idrepuesto = idrepuesto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getId_veh_gen() {
        return id_veh_gen;
    }

    public void setId_veh_gen(int id_veh_gen) {
        this.id_veh_gen = id_veh_gen;
    }

    public String getTipo_repuesto() {
        return tipo_repuesto;
    }

    public void setTipo_repuesto(String tipo_repuesto) {
        this.tipo_repuesto = tipo_repuesto;
    }
}
