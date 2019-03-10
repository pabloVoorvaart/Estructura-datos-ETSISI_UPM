public class main {
    public static void main(String args[]) {

        Cola col = new Cola();
        col.encolar(20); col.encolar(40); col.encolar(10); col.encolar(50);
        col.dejarN(2);
        col.escribirCola();
    }
}
