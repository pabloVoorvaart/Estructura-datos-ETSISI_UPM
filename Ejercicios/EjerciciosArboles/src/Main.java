public class Main {
    public static void main(String[] args){
        Arbol a = new Arbol();
        Arbol a1 = new Arbol();
        Arbol a2 = new Arbol();
        Arbol a3 = new Arbol();
        Arbol a4 = new Arbol(10);
        Arbol a5 = new Arbol(25);
        Arbol a6 = new Arbol(3);
        Arbol a7 = new Arbol(80);
        Arbol a8 = new Arbol(80);
        Arbol a9 = new Arbol(80);


        a2.juntar(15, a4, a5);
        a3.juntar(60, a6, a6);
        a.juntar(40, a2, a3);
    }
}
