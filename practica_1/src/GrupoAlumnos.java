import jdk.nashorn.internal.runtime.ListAdapter;

public class GrupoAlumnos {
    private Alumno[] ListaAlumnos;
    private int numAlumnos;
    private int maximo;
    private FileHandler fileHandler;
    public String Nombre;
    public boolean loaded;

    public GrupoAlumnos(){
        this.Nombre = "grupoDesconocido";
        this.maximo = 10;
        this.ListaAlumnos = new Alumno[maximo];
        this.fileHandler = new FileHandler(this);
    }

    public GrupoAlumnos(int max, String nombre){
        this.Nombre = nombre;
        this.maximo = max;
        this.ListaAlumnos = new Alumno[maximo];
        this.fileHandler = new FileHandler(this);
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

    //setters
    public void setNombre(String nombre){
        Nombre = nombre;
    }

    //other
    public Alumno alumnoPos(int i){
        if (ListaAlumnos[i] != null){
            return ListaAlumnos[i];
        }
        else{
            return null;
        }
    }

 /*   public boolean borrarAlumno(int pos){

    }*/

    public boolean insertarAlumno(Alumno a){
        if(numAlumnos==maximo){
            return false;
        }
        else{
            ListaAlumnos[numAlumnos] = a;
            numAlumnos++;
            if(this.loaded==true){
                fileHandler.writteFile(a);
            }

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
        System.out.print(totalCalif/numAlumnos);
        return totalCalif/numAlumnos;
    }


    public void maxCalif(){
        double max = 0;

        for(int i = 0; i < numAlumnos; i++){
            if(this.alumnoPos(i).getCalificacion() > max){
                max = this.alumnoPos(i).getCalificacion();
            }
        }
        System.out.print(max);

    }
}
