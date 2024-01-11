package Clases;

import java.sql.Timestamp;
import java.util.Date;

public class Puntajes {

    private int idPuntajes;
    private String name;
    private int puntaje;
    private Timestamp fecha;

    // Constructor que toma el nombre, puntaje y establece la fecha actual
    public Puntajes(String name, int puntaje) {
        this.name = name;
        this.puntaje = puntaje;
        this.fecha = new Timestamp(new Date().getTime());
    }
    
    public Puntajes(String name, int puntaje, Timestamp time) {
        this.name = name;
        this.puntaje = puntaje;
        this.fecha = time;
    }

    // Getters y Setters

    public int getIdPuntajes() {
        return idPuntajes;
    }

    public void setIdPuntajes(int idPuntajes) {
        this.idPuntajes = idPuntajes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    // Método toString para facilitar la visualización de los objetos
    @Override
    public String toString() {
        return "Puntajes{" +
                "idPuntajes=" + idPuntajes +
                ", name='" + name + '\'' +
                ", puntaje=" + puntaje +
                ", fecha=" + fecha +
                '}';
    }
}

