/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorGrupo;
import java.util.Scanner;
import modelo.Grupo;

/**
 *
 * @author Alex Zumba
 */
public class VistaGrupo {

    private ControladorGrupo controladorGrupo;
    private VistaAula vistaAula;
    private VistaAsignatura vistaAsignatura;
    private Scanner entrada;

    public VistaGrupo(VistaAula vistaAula, VistaAsignatura vistaAsignatura) {
        controladorGrupo = new ControladorGrupo();
        this.vistaAula = vistaAula;
        this.vistaAsignatura = vistaAsignatura;
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("1. Crear");
            System.out.println("2. Actualizar");
            System.out.println("3. Buscar");
            System.out.println("4. Eliminar");
            System.out.println("5. Listar");
            System.out.println("6. Gestionar Asignaturas");
            System.out.println("7. Gestionar Aula");
            System.out.println("8. Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    actualizar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    listar();
                    break;
                case 6:
                    asignatura();
                    break;
                case 7:
                    aula();
                    break;
                case 8:
                    System.out.println("A salido del menu Grupo");
                    break;
            }
        } while (opcion < 8);
    }

    public void crear() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.println("Resultado: " + controladorGrupo.crear(nombre));
    }

    public Grupo buscar() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.next();
        Grupo grupo = controladorGrupo.buscar(nombre);
        controladorGrupo.setSeleccionado(grupo);
        System.out.println(grupo);
        return grupo;
    }

    public void actualizar() {
        Grupo grupo = buscar();
        System.out.print("Ingrese nombre nuevo: ");
        String nombreNuevo = entrada.next();
        System.out.println("Resultado: " + controladorGrupo.actualizar(grupo.getNombre(), nombreNuevo));
    }

    public void eliminar() {
        Grupo grupo = buscar();
        System.out.println("Resultado: " + controladorGrupo.eliminar(grupo.getNombre()));
    }

    public void listar() {
        for (Grupo grupo : controladorGrupo.getListaGrupos()) {
            System.out.println(grupo);
        }
    }

    public void asignatura() {
        Grupo grupo = buscar();
        if (grupo != null) {
            vistaAsignatura.getControladorAsignatura().setListaAsignatura(grupo.getListaAsignaturas());
            vistaAsignatura.menu();
        }
    }

    public void aula() {
        Grupo grupo = buscar();
        if (grupo != null) {
            vistaAula.getControladorAula().setListaAula(grupo.getListaAulas());
            vistaAula.menu();
        }
    }

}
