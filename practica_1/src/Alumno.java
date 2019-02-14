import sun.nio.cs.ext.MacArabic;

import java.io.*;

public class Alumno {
    private String Nombre;
    private String Apellidos;
    private String Matricula;
    private double Calificacion;
    private int NumAsigs;
    private String[] Asignaturas;

    public Alumno(){
        this.Nombre = "";
        this.Apellidos = "";
        this.Matricula = "";
        this.Calificacion = 0;
        this.NumAsigs = 0;
        this.Asignaturas = new String[4];
    }

    public Alumno(String Nombre, String Apellidos, String Matricula, double Calificacion){
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Matricula = Matricula;
        this.Calificacion = Calificacion;
        this.NumAsigs = 0;
        this.Asignaturas = new String[4];
    }

    //getters
    public String getNombre(){
        String NombreApellido = Apellidos + ", " + Nombre +".";
        return NombreApellido;
    }

    public String getMatricula(){
        return Matricula;
    }

    public double getCalificacion(){
        return Calificacion;
    }

    public String[] getAsignaturas(){
        String[] ReArray = new String[NumAsigs];
        for(int i=0; i<NumAsigs; i++){
            ReArray[i] = Asignaturas[i];
        }
        return ReArray;
    }

    //setters
    public void setNombre(String InNombre, String InApellidos){
        Nombre = InNombre;
        Apellidos = InApellidos;
    }

    public void setMatricula(String InMatricula){
        Matricula = InMatricula;
    }

    public void setCalificacion(int InCalificacion){
        Calificacion = InCalificacion;
    }

    //other
    public void anadirAsignatura(String asig){
        if(NumAsigs==4){
            System.out.print("No se pueden añadir mas asignaturas \n");
        }
        else{
            Asignaturas[NumAsigs] = asig;
            NumAsigs++;
        }
    }

    public void mostrarAsignaturas(){
       String array[] = this.getAsignaturas();
       if(array.length==0){
           System.out.print("\t -El alumno no esta registrado en ninguna asignatura \n\n");
       }
       else{
           for(int i=0;i<array.length;i++){
               System.out.print("\t -" + array[i] + ".");
           }
       }
    }

    public void mostarAlumno(){
        System.out.print("Nombre: " + this.getNombre() + " Matricula: " + this.getMatricula() + " ("+this.getCalificacion()+")\n");
        this.mostrarAsignaturas();
    }
}