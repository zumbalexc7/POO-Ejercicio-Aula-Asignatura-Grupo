/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Alex Zumba
 */
public class Grupo {

    private long id;
    private String nombre;
    private List<Aula> listaAulas;
    private List<Asignatura> listaAsignaturas;

    public Grupo() {

    }

    public Grupo(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Grupo(long id, String nombre, List<Aula> listaAulas, List<Asignatura> listaAsignaturas) {
        this.id = id;
        this.nombre = nombre;
        this.listaAulas = listaAulas;
        this.listaAsignaturas = listaAsignaturas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Aula> getListaAulas() {
        return listaAulas;
    }

    public void setListaAulas(List<Aula> listaAulas) {
        this.listaAulas = listaAulas;
    }

    public List<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(List<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Grupo: " + "id: " + id + ", nombre: " + nombre;
    }

}
