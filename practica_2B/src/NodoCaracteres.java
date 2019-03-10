public class NodoCaracteres {
    private char dato;
    private NodoCaracteres siguiente;

    public NodoCaracteres(char dato, NodoCaracteres siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoCaracteres getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCaracteres siguiente) {
        this.siguiente = siguiente;
    }


}
