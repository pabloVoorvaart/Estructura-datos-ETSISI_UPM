public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }


    // Escribe las claves del �rbol binario de raiz a en preorden.
    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print (nodo.getClave() + " "); // Nodo
            preOrden(nodo.getIz()); // Izquierda
            preOrden(nodo.getDe()); // Derecha
            nodo.getDato().mostrarAlumno();
            System.out.println(nodo.getClave());
        }
    }
    public void preOrden() {
        preOrden(raiz);
    }

    // Escribe las claves del �rbol binario de raiz a en postorden.
    private void postOrden(NodoArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.getIz()); // Izquierda
            postOrden(nodo.getDe()); // Derecha
            System.out.print(nodo.getClave() + " "); // Nodo
            nodo.getDato().mostrarAlumno();
            System.out.println(nodo.getClave());
        }
    }
    public void postOrden() {
        postOrden(raiz);
    }

    // Escribe las claves del �rbol binario de raiz a en orden central.
    private void ordenCentral(NodoArbol nodo) {
        if (nodo != null) {
            ordenCentral(nodo.getIz()); // Izquierda
            System.out.print(nodo.getClave() + " "); // Nodo
            ordenCentral(nodo.getDe()); // Derecha
            nodo.getDato().mostrarAlumno();
            System.out.println(nodo.getClave());
        }
    }
    public void ordenCentral() {
        ordenCentral(raiz);
    }

    public void listarAmplitud() {
        NodoArbol p = raiz;
        Cola c = new Cola();

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
        p.getDato().mostrarAlumno();
        System.out.println(p.getClave());
    }
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol nodo) {
        raiz = nodo;
    }

    private NodoArbol busqueda(NodoArbol nodo, int dato) {
        NodoArbol resul = null;

        if (nodo != null)
            if (nodo.getClave() == dato)
                resul = nodo;
            else if (nodo.getClave() > dato)
                resul = busqueda(nodo.getIz(), dato);
            else
                resul = busqueda(nodo.getDe(), dato);
        return resul;
    }
    public NodoArbol busqueda(int dato) {
        return busqueda(raiz, dato);
    }

    private Alumno get (NodoArbol nodo, int clave) {
        Alumno resul = null;

        if (nodo != null)
            if (nodo.getClave() == clave)
                resul = nodo.getDato();
            else if (nodo.getClave() > clave)
                resul = get (nodo.getIz(), clave);
            else resul = get (nodo.getDe(), clave);
        return resul;
    }
    public Alumno get (int clave) {
        return get(raiz, clave);
    }

    public boolean contieneClave (int clave) {
        return (get (clave) != null);
    }

    private NodoArbol insertar(NodoArbol nodo, int clave, Alumno dato) {
        if (nodo != null)
            if (nodo.getClave() < clave)
                nodo.setDe(insertar(nodo.getDe(), clave, dato));
            else if (nodo.getClave() > clave)
                nodo.setIz(insertar(nodo.getIz(), clave, dato));
            else
                System.out.println("la clave ya existe");
        else nodo = new NodoArbol(clave, dato);
        return nodo;
    }

    public void insertar(int clave, Alumno dato) {
        raiz = insertar(raiz, clave, dato);
    }

    private NodoArbol eliminar2Hijos(NodoArbol nodo, NodoArbol p) {
        NodoArbol resul;
        if (nodo.getDe() != null) {
            resul = nodo;
            nodo.setDe(eliminar2Hijos(nodo.getDe(), p));
        } else {
            p.setClave(nodo.getClave());
            resul = nodo.getIz();
        }
        return resul;
    }
    private NodoArbol eliminarElemento(NodoArbol nodo, int elem) {
        NodoArbol p;
        if (nodo != null)
            if (nodo.getClave() > elem)
                nodo.setIz(eliminarElemento(nodo.getIz(), elem));
            else if (nodo.getClave() < elem)
                nodo.setDe(eliminarElemento(nodo.getDe(), elem));
            else {
                p = nodo;
                if (nodo.getIz() == null)
                    nodo = nodo.getDe();
                else if (nodo.getDe() == null)
                    nodo = nodo.getIz();
                else
                    nodo.setIz(eliminar2Hijos(nodo.getIz(), p));
            }
        else
            System.out.println("la clave buscada no existe");
        return nodo;
    }
    public void eliminar(int elem) {
        raiz = eliminarElemento(raiz, elem);
    }
    public void mostrarHojas() {
        System.out.println ("Contenido de las hojas: ");
        mostrarHojas(raiz);
        System.out.println ("Fin");
    }
    private void mostrarHojas(NodoArbol nodo) {
        if (nodo != null)
            if (nodo.getIz() == null && nodo.getDe() == null) {
                System.out.print(nodo.getClave() + ": ");
                nodo.getDato().mostrarAlumno();
            }
            else {
                mostrarHojas(nodo.getIz());
                mostrarHojas(nodo.getDe());
            }
    }
    private double calificacionMedia(NodoArbol nodo,int[]cont) {
        double suma = 0, media = 0;
        if (nodo != null) {
            suma = suma + nodo.getDato().getCalificacion();
            suma += calificacionMedia(nodo.getIz(),cont);
            suma += calificacionMedia(nodo.getDe(),cont);
            cont[0]++;
        }
        return suma;
    }
    public double calificacionMedia(){
        double media=0;
        int[] cont = {0};
        media = calificacionMedia(raiz,cont); // ahora media es el resultado de mi anterior función
       if(cont[0]!=0){
           media = media / cont[0];
       }
       return media;
    }
   private void maxCalif(NodoArbol nodo , Alumno[] a){
        if(nodo!=null) {
            maxCalif(nodo.getIz(), a);
            if (nodo.getDato().getCalificacion() > a[0].getCalificacion()) {
          a[0] = nodo.getDato();
            }
            maxCalif(nodo.getDe(), a); // abajo , queremos recorrido en orden central
        }
    }
    public void maxCalif(){
        Alumno[]a = {new Alumno()};
        maxCalif(raiz,a);
        System.out.println("La calificacion maxima es : ");
        a[0].mostrarAlumno();

    }

}