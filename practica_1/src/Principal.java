import java.io.*;
import java.util.Scanner;

public class Principal {

    public static void main(String args[])throws IOException {
        Scanner reader = new Scanner(System.in);

        //init base calsess
        Menu mainMenu = new Menu();
        GrupoAlumnos grupo1 = new GrupoAlumnos(10, "GM14" );

        System.out.println("=====================================");
        System.out.println("|| Bienvenido al registro de grupos||");
        System.out.println("=====================================");
        mainMenu.showMenu();

        boolean boolMenu = false;
        while(boolMenu==false){
            System.out.print("\nPorfavor seleccione una opcion: ");
            int opcion = reader.nextInt();
            System.out.print("\n");
            boolMenu = mainMenu.menuSub(grupo1, opcion);
        }

/*
        Alumno al1 = new Alumno("Felipe", "Arias Gonzalez", "aa1253", 3.50);
        Alumno al2 = new Alumno("Manuel", "Garcia Sacedon", "ax0074", 8.35);


        grupo1.insertarAlumno(al1);
        grupo1.insertarAlumno(al2);
        grupo1.mostrarGrupo();
        */
        reader.close();

    }


}
