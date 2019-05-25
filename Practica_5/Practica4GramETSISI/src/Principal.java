/**
 * Created by bp0062 on 10/05/2019.
 */
public class Principal {
    public static void main(String args[]){

        Persona p0 = new Persona("Juan","123456","Albufera");
        Persona p1 = new Persona("José","231465","Princesa" );
        Persona p2 = new Persona("Eva","321654","Gaztambide");
        Persona p3 = new Persona("Alicia","789456","Castellana");
        Persona p4 = new Persona("Ernesto","654321","Arboleda");
        Persona p5 = new Persona("Guillermo","159267","Arapiles");
        Persona p6 = new Persona("Alberto","123456","Gaztambide");
        Persona p7 = new Persona("Lucas","231465","Princesa");
        Persona p8 = new Persona("Clara","789456","Castellana");
        Persona p9 = new Persona ("Mario", "934578", "Castellana");

        GramETSISI g = new GramETSISI(10);

        g.insertaVertice(p0);
        g.insertaVertice(p1);
        g.insertaVertice(p2);
        g.insertaVertice(p3);
        g.insertaVertice(p4);
        g.insertaVertice(p5);
        g.insertaVertice(p6);
        g.insertaVertice(p7);
        g.insertaVertice(p8);
        g.insertaVertice(p9);

        g.insertaArista(0,1);
        g.insertaArista(4,0);
        g.insertaArista(5,0);
        g.insertaArista(4,5);
        g.insertaArista(4,1);

        g.insertaArista(2,9);
        g.insertaArista(2,7);
        g.insertaArista(9,7);

        g.insertaArista(6,8);
        g.insertaArista(6,3);

        g.imprimirGrafo();

        g.contarGrupos();

        g.mostrarAmigos("Alberto");

        g.mayorGrupo();

    }

}
