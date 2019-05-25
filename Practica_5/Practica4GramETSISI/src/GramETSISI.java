public class GramETSISI {
    private int maxNodos;             // Tamaño máximo de la tabla.
    private int numVertices;          // Número de vértices.
    private boolean matrizAdy[][];    // Matriz de adyacencias del grafo.
    private Persona contactos[];


    public GramETSISI(int n) { //construye una matriz de nxn sin arcos
        maxNodos = n;
        numVertices = 0;
        matrizAdy = new boolean[n][n];
        contactos = new Persona[n];
    }

    public int getMaxNodos() {
        return maxNodos;
    }

    public int getNumVertices() {
        return numVertices;
    }

    // ------------------------------------

    // MÉTODOS PARA INSERTAR Y ELIMINAR VERTICES

    // ------------------------------------

    public void insertaVertice() {
        if (maxNodos == numVertices)
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        else {
            for (int i = 0; i <= numVertices; i++) {
                //simplemento añado el valor false a las celdas
                matrizAdy[i][numVertices] = matrizAdy[numVertices][i] = false;
            }
            Persona nuevo = new Persona();
            nuevo.leerDatos();
            contactos[numVertices] = nuevo;
            numVertices++;
        }
    }

    public void insertaVertice(Persona a) {
        if (maxNodos == numVertices)
            System.out.println("Error, se supera el número de nodos máximo del grafo");
        else {
            for (int i = 0; i <= numVertices; i++) {
                matrizAdy[i][numVertices] = matrizAdy[numVertices][i] = false;
            }
            contactos[numVertices] = a;
            numVertices++;
        }
    }

    public void eliminarVertice(int v) {
        if (v < numVertices && v >= 0) {
            numVertices--;
            int i;
            for (i = 0; i < v; i++) {
                for (int j = v; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i][j + 1];
                }
            }
            for (i = v; i < numVertices; i++) {
                contactos[i] = contactos[i + 1];
                int j;
                for (j = 0; j < v; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j];
                }
                for (j = v; j < numVertices; j++) {
                    matrizAdy[i][j] = matrizAdy[i + 1][j + 1];
                }
            }
        } else System.out.println("Error, fuera de rango");
    }

    // ------------------------------------

    // MÉTODOS PARA INSERTAR Y ELIMINAR ARISTAS

    // ------------------------------------

    public void insertaArista(int i, int j) {
        if ((i >= numVertices) || (j >= numVertices))
            System.out.println("Error, los vertices no se encuentran en el grafo.");
        else {
            matrizAdy[i][j] = true;
            matrizAdy[j][i] = matrizAdy[i][j];
        }
    }

    public boolean existeArista(int i, int j) {
        if ((i >= numVertices) || (j >= numVertices)) {
            System.out.println("Error, los vertices no se encuentran en el grafo.");
            return false;
        }
        return matrizAdy[i][j];
    }

    public void imprimirGrafo() {
        System.out.println("Contenido del vector: ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            contactos[i].mostrarPersona();
        }
    }

    // ------------------------------------

    // MÉTODOS PARA CONTAR GRUPOS

    // -----------------------------------

    public void contarGrupos() {
        int grupos = 0;
        boolean visitados[] = new boolean[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) visitados[i] = false;
        for (int i = 0; i < this.numVertices; i++) {
            if (!visitados[i]) {
                grupos ++;
                recorrerProfundidad(this, i, visitados);
            }
        }
        System.out.println("\nHay " + grupos + " grupos\n");
    }

    private int recorrerProfundidad(GramETSISI g, int v, boolean[] visitados) {
        visitados[v] = true;
        int miembros = visitados.length;
        for (int i = 0; i < this.numVertices; i++) {
            if ((v != i) && (!visitados[i]) && (g.existeArista(v, i))){
                recorrerProfundidad(g, i, visitados);
            }
        }
        return miembros;
    }

    // ------------------------------------

    // MÉTODOS PARA MOSTRAR EL MAYOR GRUPO

    // -----------------------------------

    public void mayorGrupo(){
        int resul = 0;
        int mayor = 0;
        int componente = 0;
        boolean[] visitados = new boolean[numVertices];

        for(int i = 0;i < numVertices; i++){
            visitados[i] = false;
        }
        for(int i = 0; i < numVertices; i++){
            if (!visitados[i]){
                resul = mayorGrupo(i, visitados);
                if(resul > mayor){
                    mayor = resul;
                    componente = i;
                }
            }
        }
        mostrarGrupo(componente);
    }

    private int mayorGrupo(int v, boolean[] visitados){
        int resul = 1;
        visitados[v] = true;
        for(int i = 0; i<numVertices;i++){
            if(v!=i && !visitados[i] && this.existeArista(v,i)){
                resul +=mayorGrupo(i,visitados);
            }
        }
        return resul;
    }

    private void mostrarGrupo(int v){
        boolean[] visitados_2 = new boolean[numVertices];
        for(int i = 0; i < numVertices; i++){
            visitados_2[i] = false;
        }
        mostrarGrupo(v, visitados_2);
    }

    private void mostrarGrupo(int v, boolean[] visitados){
        visitados[v] = true;
        contactos[v].mostrarPersona();

        for(int i = 0; i < numVertices; i++){
            if(v!=i && !visitados[i] && this.existeArista(v,i)){
                mostrarGrupo(i,visitados);
            }
        }
    }

    // ------------------------------------

    // MÉTODOS PARA MOSTRAR AMIGOS

    // -----------------------------------

    public void mostrarAmigos(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < numVertices; i++) {
            if (nombre.equals(contactos[i].getNombre())) {
                System.out.println(nombre + " existe");;

                for (int j = 0; j < numVertices; j++) {
                    if (matrizAdy[i][j]){
                        System.out.println(contactos[j].getNombre() + " es amigo de " + nombre);
                    }

                }
            }
        }
    }

}