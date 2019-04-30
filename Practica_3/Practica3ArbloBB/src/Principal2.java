public class Principal2 {
    public static void main (String [] args){
Arbol a = new Arbol();
Alumno a1 = new Alumno("Juan","Lopez",8);
Alumno a2 = new Alumno("Victor","Lopez",3);
Alumno a3 = new Alumno("Maria","Lopez",7);
Alumno a4 = new Alumno("Irene","Lopez",10);
Alumno a5 = new Alumno("Mario","Lopez",1);
Alumno a6 = new Alumno("Franny","Lopez",9);
Alumno a7 = new Alumno("Jose","Lopez",7);
Alumno a8 = new Alumno("Miguel","Lopez",2);
a.insertar(123,a1);
a.insertar(192,a2);
a.insertar(199,a3);
a.insertar(271,a4);
a.insertar(391,a5);
a.insertar(197,a6);
a.insertar(179,a7);
a.insertar(193,a8);
a.maxCalif();

    }
}
