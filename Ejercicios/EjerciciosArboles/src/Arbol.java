public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(int clave) {
        raiz = new NodoArbol(clave);
    }

    // Escribe las claves del arbol binario de raiz a en preorden.
    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print (nodo.getClave() + " "); // Nodo
            preOrden(nodo.getIz()); // Izquierda
            preOrden(nodo.getDe()); // Derecha
        }
    }
    public void preOrden() {
        System.out.print ("Preorden: ");
        preOrden(raiz);
        System.out.println();
    }

    // Escribe las claves del arbol binario de raiz a en postorden.
    private void postOrden(NodoArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.getIz()); // Izquierda
            postOrden(nodo.getDe()); // Derecha
            System.out.print(nodo.getClave() + " "); // Nodo
        }
    }
    public void postOrden() {
        System.out.print ("Post orden: ");
        postOrden(raiz);
        System.out.println();
    }

    // Escribe las claves del arbol binario de raiz a en orden central.
    private void ordenCentral(NodoArbol nodo) {
        if (nodo != null) {
            ordenCentral(nodo.getIz()); // Izquierda
            System.out.print(nodo.getClave() + " "); // Nodo
            ordenCentral(nodo.getDe()); // Derecha
        }
    }
    public void ordenCentral() {
        System.out.print ("Orden central: ");
        ordenCentral(raiz);
        System.out.println();
    }

    public void listarAmplitud() {
        NodoArbol p = raiz;
        Cola c = new Cola();

        System.out.print ("Amplitud: ");
        if (p != null)
            c.encolar(p);
        while (!c.colaVacia()) {
            p = c.desencolar();
            System.out.print(p.getClave() + " ");
            if (p.getIz() != null)
                c.encolar(p.getIz());
            if (p.getDe() != null)
                c.encolar(p.getDe());
        }
        System.out.println();
    }

    private boolean busqueda(NodoArbol nodo, int dato) {
        boolean resul = false;

        if (nodo != null)
            if (nodo.getClave() == dato)
                resul = true;
            else {
                resul = busqueda(nodo.getIz(), dato);
                if (!resul)
                    resul = busqueda(nodo.getDe(), dato);
            }
        return resul;
    }

    public boolean busqueda(int dato) {
        return busqueda(raiz, dato);
    }

    /**
     * Obtener un �rbol nuevo a partir de un dato, un �rbol a1 (que ser� el
     * sub�rbol izquierdo) y otro a2 (sub�rbol derecho) que deben ser distintos.
     */
    public void juntar(int clave, Arbol a1, Arbol a2) {
        if (a1.raiz == a2.raiz && a1.raiz != null)
            System.out.println("no se pueden mezclar, a1 y a2 son iguales");
        else {
            // Crear el nodo nuevo
            raiz = new NodoArbol(clave, a1.raiz, a2.raiz);
            // Borrar los �rboles a1 y a2
            if (this != a1)
                a1.raiz = null;
            if (this != a2)
                a2.raiz = null;
        }
    }

    public void listarAmplitudNiveles() {
        NodoArbol p;
        int n;
        ColaN c = new ColaN();

        System.out.println ("Amplitud niveles: ");
        p = raiz;
        if (p != null) {
            TElemento elem = new TElemento(p, 1);
            c.encolar(elem);
            while (!c.colaVacia()) {
                elem = c.desencolar();
                p = elem.getNodoArbol();
                n = elem.getNivel();
                System.out.println("nivel: " + n + " " + p.getClave() + " ");
                if (p.getIz() != null) {
                    elem = new TElemento(p.getIz(), n + 1);
                    c.encolar(elem);
                }
                if (p.getDe() != null) {
                    elem = new TElemento(p.getDe(), n + 1);
                    c.encolar(elem);
                }
            }
        }
        System.out.println();
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol nodo) {
        raiz = nodo;
    }


    public void mostrarHojas() {
        System.out.print ("Claves en hojas: ");
        mostrarHojas(raiz);
        System.out.println ("Fin");
    }
    private void mostrarHojas(NodoArbol nodo) {
        if (nodo != null)
            if (nodo.getIz() == null && nodo.getDe() == null) {
                System.out.print(nodo.getClave() + ", ");
        }
            else {
                mostrarHojas(nodo.getIz());
                mostrarHojas(nodo.getDe());
            }
    }
}
