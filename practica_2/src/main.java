public class main {
    public static void main(String args[]) {
        Pila obj = new Pila();
        Pila obj2 = new Pila();

        for(int i = 0; i<10; i++) {
            obj.apilar(i);
            obj2.apilar(i);
        }
        obj.juntarPila(obj2);
        obj.escribirPila();
        obj2.escribirPila();

    }
}
