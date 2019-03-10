import java.util.Scanner;

public class Comprobador1 {
    private String frase;
    private PilaCaracteres pila1, pila2;

    public Comprobador1(){
        this.frase = "";
        pila1 = new PilaCaracteres();
        pila2 = new PilaCaracteres();
    }

    public Comprobador1(String frase){
        this.frase = frase;
        pila1 = new PilaCaracteres();
        pila2 = new PilaCaracteres();
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
        }
    }

    if(pila1.numElemPila()%2!=0){
        posMid = ((pila1.numElemPila()-1)/2+1);
        for(int i = 0; i<posMid-1; i++){
            pila2.apilar(pila1.cima());
            pila1.desapilar();
        }
        pila1.desapilar();
    }
    else{
        posMid = ((pila1.numElemPila())/2);

        for(int i = 0; i<posMid; i++){
            pila2.apilar(pila1.cima());
            pila1.desapilar();
        }
    }


    while(pila1.cima()!='9' && pila2.cima() != '9'){
        if(pila1.cima()==pila2.cima()){
            cont ++;
        }
        pila1.desapilar();
        pila2.desapilar();
    }
    if(cont==posMid){
        System.out.println("Es palindromo");
    }
    else{
        System.out.println("No es palindromo");
    }

    }
}
