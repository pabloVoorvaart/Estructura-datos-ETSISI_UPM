import java.util.Scanner;
import java.util.Stack;

public class Comprobador3 {
    private String frase;
    private Stack pila1, pila2;

    public Comprobador3(){
        this.frase = "";
        pila1 = new Stack();
        pila2 = new Stack();
    }

    public Comprobador3(String frase){
        this.frase = frase;
        pila1 = new Stack();
        pila2 = new Stack();
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
                pila1.push(frase.charAt(i));
            }
        }

        if(pila1.size()%2!=0){
            posMid = ((pila1.size()-1)/2+1);
            for(int i = 0; i<posMid-1; i++){
                pila2.push(pila1.peek());
                pila1.pop();
            }
            pila1.pop();
            posMid = posMid-1;
        }
        else{
            posMid = ((pila1.size())/2);

            for(int i = 0; i<posMid; i++){
                pila2.push(pila1.peek());
                pila1.pop();
            }
        }


        while(pila1.empty()==false && pila2.empty()==false){
            if(pila1.peek()==pila2.peek()){
                cont ++;
            }
            pila1.pop();
            pila2.pop();
        }
        if(cont==posMid){
            System.out.println("Es palindromo");
        }
        else{
            System.out.println("No es palindromo");
        }

    }
}
