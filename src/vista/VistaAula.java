/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorAula;
import java.util.Scanner;
import modelo.Aula;

/**
 *
 * @author Alex Zumba
 */
public class VistaAula {

    private ControladorAula controladorAula;
    private Scanner entrada;

    public VistaAula() {
        controladorAula = new ControladorAula();
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
                    System.out.println("A salido del menu Aula");
                    break;
            }
        } while (opcion < 6);
    }

    public void crear() {
        System.out.print("Ingrese la descripcion: ");
        String descripcion = entrada.next();
        System.out.println("Resultado: " + controladorAula.crear(descripcion));
    }

    public Aula buscar() {
        System.out.print("Ingrese la descripcion");
        String descripcion = entrada.next();
        Aula aula = controladorAula.buscar(descripcion);
        controladorAula.setSeleccionado(aula);
        System.out.println(aula);
        return aula;
    }

    public void actualizar() {
        Aula aula = buscar();
        if (aula != null) {
            System.out.println("Ingrese la nueva descripcion");
            String descripcionNueva = entrada.next();

            System.out.println("Resultado: " + controladorAula.actualizar(aula.getDescripcion(), descripcionNueva));
        }
    }

    public void eliminar() {
        Aula aula = buscar();
        if (aula != null) {
            System.out.println("Resultado: " + controladorAula.eliminar(aula.getDescripcion()));
        }
    }

    public void listar() {
        for (Aula aula : controladorAula.getListaAula()) {
            System.out.println(aula);
        }
    }

    public ControladorAula getControladorAula() {
        return controladorAula;
    }

    public void setControladorAula(ControladorAula controladorAula) {
        this.controladorAula = controladorAula;
    }

}
