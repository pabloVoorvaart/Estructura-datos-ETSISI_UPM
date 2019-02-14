import jdk.nashorn.internal.runtime.ListAdapter;

public class GrupoAlumnos {
    private Alumno[] ListaAlumnos;
    private int numAlumnos;
    private int maximo;
    public String Nombre;

    public GrupoAlumnos(){
        this.Nombre = "grupoDesconocido";
        this.maximo = 10;
    }

    public GrupoAlumnos(int max, String nombre){
        this.Nombre = nombre;
        this.maximo = max;
    }

    //getters
    public String getNombre(){
        return Nombre;
    }

    public int getNumAlumnos(){
        return numAlumnos;
    }

    public int getMaximo(){
        return maximo;
    }

    public void setNombre(String nombre){
        Nombre = nombre;
    }

    public Alumno alumnoPos(int i){
        if (ListaAlumnos[i] != null){
            return ListaAlumnos[i];
        }
        else{
            return null;
        }
    }

    public boolean insertarAlumno(Alumno a){
        if(ListaAlumnos.length==maximo){
            return false;
        }
        else{
            ListaAlumnos[numAlumnos] = a;
            numAlumnos++;
            return true;
        }
    }

    public void mostrarGrupo(){
        for(int i = 0; i < numAlumnos; i++){
            this.alumnoPos(i).mostarAlumno();
        }
    }

    public double mediaCalif(){
        double totalCalif = 0;
        for(int i = 0; i < numAlumnos; i++){
            totalCalif += this.alumnoPos(i).getCalificacion();
        }
        return totalCalif/numAlumnos;
    }

    /*
    public void maxCalif(){
        double max = 0;
        Alumno display;

        for(int i = 0; i < numAlumnos; i++){
            if(this.alumnoPos(i).getCalificacion() > max){
                max = this.alumnoPos(i).getCalificacion();
            }
            if(this)
        }
    }*/
}
