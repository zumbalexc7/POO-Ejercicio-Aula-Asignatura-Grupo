/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Asignatura;
import modelo.Aula;
import modelo.Grupo;

/**
 *
 * @author Alex Zumba
 */
public class ControladorGrupo {

    private List<Grupo> listaGrupos;
    private Grupo seleccionado;

    public ControladorGrupo() {
        listaGrupos = new ArrayList<>();
        seleccionado = null;
    }

    public long generarId() {
        return (listaGrupos.size() > 0) ? listaGrupos.get(listaGrupos.size() - 1).getId() + 1 : 1;
    }

    // CRUD
    public boolean crear(String nombre) {
        return listaGrupos.add(new Grupo(generarId(), nombre));
    }

    public Grupo buscar(String nombre) {
        for (Grupo grupo : listaGrupos) {
            if (grupo.getNombre().equals(nombre)) {
                return grupo;
            }
        }
        return null;
    }

    public boolean actualizar(String nombreAnterior, String nombre) {
        Grupo grupo = buscar(nombreAnterior);
        if (grupo != null) {
            int posicion = listaGrupos.indexOf(grupo);
            grupo.setNombre(nombre);
            listaGrupos.set(posicion, grupo);
            return true;
        }
        return false;
    }

    public boolean eliminar(String nombre) {
        return listaGrupos.remove(buscar(nombre));
    }

    public boolean agregarAsignatura(Asignatura asignatura) {
        return seleccionado.getListaAsignaturas().add(asignatura);
    }

    public boolean agregarAula(Aula aula) {
        return seleccionado.getListaAulas().add(aula);
    }

    public List<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(List<Grupo> listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    public Grupo getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Grupo seleccionado) {
        this.seleccionado = seleccionado;
    }

}
