public class Main {
    public static void main (String [] args){
        MetodosAE metodo = new MetodosAE();
        Arbol a = metodo.notacInfija("((5+2)*(8-3))/4");
        a.postOrden();
        a.ordenCentral();
        a.preOrden();
        a.calcularValor();
    }
}
