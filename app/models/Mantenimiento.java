package models;

/**
 * Created by Administrador on 09/11/2015.
 */
public class Mantenimiento {

    private int id;
    private String linea;
    private int id_veh_gen;
    private int km_min;
    private int km_max;


    public Mantenimiento(int id, String linea, int id_veh_gen, int km_min, int km_max) {
        this.id = id;
        this.linea = linea;
        this.id_veh_gen = id_veh_gen;
        this.km_min = km_min;
        this.km_max = km_max;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public int getId_veh_gen() {
        return id_veh_gen;
    }

    public void setId_veh_gen(int id_veh_gen) {
        this.id_veh_gen = id_veh_gen;
    }

    public int getKm_min() {
        return km_min;
    }

    public void setKm_min(int km_min) {
        this.km_min = km_min;
    }

    public int getKm_max() {
        return km_max;
    }

    public void setKm_max(int km_max) {
        this.km_max = km_max;
    }
}

