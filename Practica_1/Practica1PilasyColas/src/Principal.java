
public class Principal {

    public static void main(String[] args) {

        // Para usar funciones que tenemos en nuestra clase principal necesitatamos un obejto principal
        // De manera que le podamos pasar como parametros otros objetos
        Principal ejem = new Principal();

        // Objetos pila que pasaremos como parametros
        Pila p1 = new Pila();
        Pila p2 = new Pila();

        // Rellenamos las pilas
        p1.apilar(1);
        p1.apilar(2);
        p1.apilar(3);

        System.out.println("Esto viene de la principal sumarElementos: " + p1.sumarElementos());

        p2.apilar(10);
        p2.apilar(20);
        p2.apilar(30);
        p2.apilar(40);

        System.out.println("La suma de los elementos es: " + ejem.sumarElementos(p1));
        //ejem.unirPilas(p1,p2);
        //p1.escribirPila();

        p1.unirPila(p2);
        //p1.escribirPila();

        Cola c = new Cola();

        c.encolar(20);
        c.encolar(40);
        c.encolar(10);
        c.encolar(50);
        //c.escribirCola();

        /*c.dejarN(9);
        System.out.println(" ");
        c.escribirCola();
        c.dejarN(4);
        System.out.println(" ");
        c.escribirCola();
        c.dejarN(2);
        System.out.println(" ");
        c.escribirCola();
        c.dejarN(0);
        System.out.println(" ");
        c.escribirCola();*/

        ejem.dejarN(0,c);
        c.escribirCola();

    }

    int sumarElementos(Pila p) {
        int sum = 0;
        if (!p.pilaVacia()) {

            int elem = p.desapilar();
            //System.out.println(elem);
            sum = elem + sumarElementos(p);

            // Llamada recursiva
            sumarElementos(p);
            p.apilar(elem);

        }
        return sum;
    }

    void unirPilas(Pila p1, Pila p2) {
        if(!p2.pilaVacia()){

            int elem = p2.desapilar();
            // Primero hacemos la llamada recursiva y al acabar lo apilamos para que salga en el orden correcto
            unirPilas(p1, p2);
            p1.apilar(elem);

        }
    }

    void dejarN(int n, Cola c){
        if (!c.colaVacia()) {

            int num = c.numElemCola();
            int elem = 0;
            for (int i = 1; i <= num ; i++) {

                elem = c.desencolar();

                if (i <= n) {
                    c.encolar(elem);
                }
            }
        }
    }

}