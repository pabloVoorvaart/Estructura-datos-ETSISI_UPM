import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {
    private String filename = "Grupos.txt";
    private File file = new File(filename);

    public FileHandler(){
        if(file.exists()){
            if(file.length()!=0){
                this.processFile(filename);
            }
        }
        else{
            System.out.print("Grupos.txt does not exist, creating....\n");
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processFile(String file) {
        try {

            List<String> allLines = Files.readAllLines(Paths.get(filename));
            for (String line : allLines){
                System.out.print(line + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



