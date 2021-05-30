/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorAsignatura;
import java.util.Scanner;
import modelo.Asignatura;

/**
 *
 * @author Alex Zumba
 */
public class VistaAsignatura {

    private ControladorAsignatura controladorAsignatura;
    private Scanner entrada;

    public VistaAsignatura() {
        controladorAsignatura = new ControladorAsignatura();
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
            System.out.println("6. Salir");
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
                    System.out.println("A salido del menu Asignatura");
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese el nombre: ");
        String nombre = entrada.next();
        System.out.println("Resultado: " + controladorAsignatura.crear(nombre));
    }

    public Asignatura buscar() {
        System.out.print("Ingrese el nombre");
        String nombre = entrada.next();
        Asignatura asignatura = controladorAsignatura.buscar(nombre);
        controladorAsignatura.setSeleccionado(asignatura);
        System.out.println(asignatura);
        return asignatura;
    }

    public void actualizar() {
        Asignatura asignatura = buscar();
        if (asignatura != null) {
            System.out.print("Ingrese el nombre nuevo");
            String nombre = entrada.next();

            System.out.println("Resultado: " + controladorAsignatura.actualizar(asignatura.getNombre(), nombre));
        }
    }

    public void eliminar() {
        Asignatura asignatura = buscar();
        if (asignatura != null) {
            System.out.println("Resultado: " + controladorAsignatura.eliminar(asignatura.getNombre()));
        }
    }

    public void listar() {
        for (Asignatura asignatura : controladorAsignatura.getListaAsignatura()) {
            System.out.println(asignatura);
        }
    }

    public ControladorAsignatura getControladorAsignatura() {
        return controladorAsignatura;
    }

    public void setControladorAsignatura(ControladorAsignatura controladorAsignatura) {
        this.controladorAsignatura = controladorAsignatura;
    }

}
