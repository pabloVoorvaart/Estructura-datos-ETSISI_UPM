public class PilaCaracteres {
    private NodoCaracteres cimaPila;
    private int numElementos;

    public PilaCaracteres() {
        cimaPila = null;
        numElementos = 0;
    }


    public boolean pilaVacia() {

        return cimaPila == null;
    }

    public void apilar(char dato) {
        if (this.pilaVacia())
            cimaPila = new NodoCaracteres(dato, null);
        else {
            cimaPila = new NodoCaracteres(dato, cimaPila);
        }
        numElementos++;
    }

    public char desapilar() {
        char valor;
        if (this.pilaVacia()) {
            System.out.println("Error, la pila está vacía");
            valor = '9';
        } else {
            valor = cimaPila.getDato();
            cimaPila = cimaPila.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public char cima() {
        char valor;
        if (this.pilaVacia()) {
            System.out.println("Error, la pila está vacía");
            valor = '9';
        } else {
            valor = cimaPila.getDato();
        }
        return valor;
    }

    public NodoCaracteres NodoCima() {
        NodoCaracteres valor;
        if (this.pilaVacia()) {
            System.out.println("Error, la pila está vacía");
            valor = null;
        } else {
            valor = cimaPila;
        }
        return valor;
    }


    public int numElemPila() {
        return numElementos;
    }

    public void escribirPila() {
        NodoCaracteres aux = cimaPila;
        System.out.println("contenido de la pila:");

        while (aux != null) {
            System.out.print(aux.getDato() + "  ");
            aux = aux.getSiguiente();
        }
        System.out.print("\n\n");
    }

    public void unirPila(PilaCaracteres obj) {
        char paraApilar;
        if(obj.cima() != '9') {
            paraApilar = obj.desapilar();
            this.unirPila(obj);
            this.apilar(paraApilar);
        }
    }

}
