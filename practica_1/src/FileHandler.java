import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {
    private String filename;
    private File file;
    private GrupoAlumnos _grupo;

    public FileHandler(GrupoAlumnos _grupoParam){
        this._grupo = _grupoParam;
        this.file = new File(this._grupo.Nombre + ".txt");

       if(file.exists()){
            if(file.length()!=0){
                this.processFile();
            }
            else{
                System.out.print("File is empty... \n");
            }
        }
        else{
            System.out.print( filename + " does not exist, creating....\n");
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processFile() {
        try {

            List<String> allLines = Files.readAllLines(Paths.get(this._grupo.Nombre + ".txt"));
            for (String line : allLines){
                String[] words = line.split(" ");
                Alumno x = new Alumno(words[2], words[0] + " " + words[1], words[3], Double.parseDouble(words[4]));
                _grupo.insertarAlumno(x);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



