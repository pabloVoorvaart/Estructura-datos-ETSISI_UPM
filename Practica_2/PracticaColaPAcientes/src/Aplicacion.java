
public class Aplicacion {

    public static void main(String[] args) {
        Paciente Alberto = new Paciente("Alberto", "Frecuentes mareos");
        Paciente Ana = new Paciente("Ana", "Infeccion resistente");
        Paciente Eva = new Paciente("Eva", "Problemas digestivos");
        Paciente Ernesto = new Paciente("Ernesto", "Problemas cardiovasculares");

        //pruebas 1
        /*
        Cola cola = new Cola();
        cola.encolar(Alberto); cola.encolar(Ana);
        cola.encolar(Eva); cola.encolar(Ernesto);
        cola.verCola();
        while(!cola.colaVacia()){
            cola.desencolar().verPaciente();
        }
        cola.verCola();
        */

        //pruebas ColaPrioridades
        ColaPrioridades cola = new ColaPrioridades();

        cola.encolar(2, Ana);
        cola.encolar(4, Alberto);
        cola.encolar(4, Eva);
        cola.verColaPrioridades();

        System.out.println("----------------------\nPACIENTE ATENDIDO:");
        cola.desencolar().verPaciente();
        System.out.println("----------------------");
        cola.verColaPrioridades();
        System.out.println("--------------\nLLEGA ERNESTOOOOOOOO CON PRIORIDAD 1:");
        cola.encolar(1, Ernesto);
        cola.verColaPrioridades();
    }

}

