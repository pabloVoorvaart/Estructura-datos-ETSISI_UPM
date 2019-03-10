import java.util.Scanner;

public class Comprobador2 {
    private String frase;
    private PilaCaracteres pila1;
    private ColaCaracteres cola1;

    public Comprobador2(){
        this.frase = "";
        pila1 = new PilaCaracteres();
        cola1 = new ColaCaracteres();
    }

    public Comprobador2(String frase){
        this.frase = frase;
        pila1 = new PilaCaracteres();
        cola1 = new ColaCaracteres();
    }

    public void leerFrase(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe una frase: ");
        this.frase = sc.nextLine();
    }

    public void esPalindromo(){
        //esto deberia ser bool!!!
        int posMid, cont = 0;

        for(int i = 0; i<frase.length(); i++){
            if(frase.charAt(i)!= ' '){
                pila1.apilar(frase.charAt(i));
                cola1.encolar(frase.charAt(i));
            }
        }


        NodoCaracteres aux1 = pila1.NodoCima();
        NodoCaracteres aux2 = cola1.NodoCima();

        while(aux1!=null && aux2 != null){
            if(aux1.getDato()==aux2.getDato()){
                cont ++;
            }
            aux1 = aux1.getSiguiente();
            aux2 = aux2.getSiguiente();
        }
        if(cont==pila1.numElemPila()&&cont==cola1.numElemCola()){
            System.out.println("Es palindromo");
        }
        else{
            System.out.println("No es palindromo");
        }

    }
}
