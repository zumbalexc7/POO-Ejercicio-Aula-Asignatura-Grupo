/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Alex Zumba
 */
public class Asignatura {

    private long id;
    private String nombre;
    private List<Grupo> listaGrupo;

    public Asignatura(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Asignatura(long id, String nombre, List<Grupo> listaGrupo) {
        this.id = id;
        this.nombre = nombre;
        this.listaGrupo = listaGrupo;
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

    public List<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(List<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }

    @Override
    public String toString() {
        return "Asignatura: " + "id: " + id + ", nombre: " + nombre;
    }

}
