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
        int cont = 0, cont2 = 0;

        for(int i = 0; i<frase.length(); i++){
            if(frase.charAt(i)!= ' '){
                pila1.apilar(frase.charAt(i));
                cola1.encolar(frase.charAt(i));
                cont2 ++;
            }
        }

        while(pila1.cima()!='9' && cola1.primero() != '9'){
            if(pila1.cima()==cola1.primero()){
                cont ++;
            }
            pila1.desapilar();
            cola1.desencolar();
        }
        if(cont==cont2){
            System.out.println("Es palindromo");
        }
        else{
            System.out.println("No es palindromo");
        }

    }
}
