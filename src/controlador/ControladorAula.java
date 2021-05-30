/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Aula;

/**
 *
 * @author Alex Zumba
 */
public class ControladorAula {

    private List<Aula> listaAula;
    private Aula seleccionado;

    public ControladorAula() {
        listaAula = new ArrayList<>();
        seleccionado = null;
    }

    public long generarId() {

        return (listaAula.size() > 0) ? listaAula.get(listaAula.size() - 1).getId() + 1 : 1;
    }

    public boolean crear(String descripcion) {
        return listaAula.add(new Aula(generarId(), descripcion));
    }

    public Aula buscar(String descripcion) {
        for (Aula aula : listaAula) {
            if (aula.getDescripcion().equals(descripcion)) {
                return aula;
            }
        }
        return null;

    }

    public boolean actualizar(String descripcionAnterior, String descripcion) {
        Aula aula = buscar(descripcionAnterior);
        if (aula != null) {
            int posicion = listaAula.indexOf(aula);
            aula.setDescripcion(descripcion);
            listaAula.set(posicion, aula);
            return true;
        }
        return false;
    }

    public boolean eliminar(String descripcion) {
        return listaAula.remove(buscar(descripcion));
    }

    public List<Aula> getListaAula() {
        return listaAula;
    }

    public void setListaAula(List<Aula> listaAula) {
        this.listaAula = listaAula;
    }

    public Aula getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Aula seleccionado) {
        this.seleccionado = seleccionado;
    }

}
