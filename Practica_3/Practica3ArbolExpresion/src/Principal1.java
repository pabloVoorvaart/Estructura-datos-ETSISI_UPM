public class Principal1 {
 public static void main (String [] args){
     MetodosAE m = new MetodosAE();
     Arbol a = m.notacInfija("((5+2)*(8-3))/4");
     System.out.println(a.calcularValor());
 }
}
