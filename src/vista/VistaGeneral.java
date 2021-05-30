/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author Alex Zumba
 */
public class VistaGeneral {

    private Scanner entrada;
    private VistaAsignatura vistaAsignatura;
    private VistaAula vistaAula;
    private VistaGrupo vistaGrupo;

    public VistaGeneral() {
        vistaAsignatura = new VistaAsignatura();
        vistaAula = new VistaAula();
        vistaGrupo = new VistaGrupo(vistaAula, vistaAsignatura);
        entrada = new Scanner(System.in);
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("1.- Grupos");
            System.out.println("2.- Asignaturas");
            System.out.println("3.- Aulas");
            System.out.println("4.- Salir");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    vistaGrupo.menu();
                    break;
                case 2:
                    vistaAsignatura.menu();
                    break;
                case 3:
                    vistaAula.menu();
                    break;
                case 4:
                    System.out.println("Ha finalizado el programa");
                    break;
            }
        } while (opcion < 4);
    }

}
