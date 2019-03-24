
public class Aplicacion {

    public static void main(String[] args) {

        ListaOrdinal lista = new ListaOrdinal();

        Paciente Alberto = new Paciente("Alberto", "Frecuentes mareos");
        Paciente Ana = new Paciente("Ana", "Infeccion resistente");
        Paciente Eva = new Paciente("Eva", "Problemas digestivos");
        Paciente Ernesto = new Paciente("Ernesto", "Problemas cardiovasculares");

        lista.insertar(Alberto);
        lista.insertar(Ana);
        lista.insertar(Eva);
        lista.insertar(Ernesto);

        Ana.darAlta();
        Eva.darAlta();

        /* 2.3.Ampliación del TAD Lista ordinal de Pacientes.
        lista.borrarAltas();
        Iterador i = lista.obtenerIterador();
        while(i.hasNext()) i.next().verPaciente();
        */

        Iterador x = lista.obtenerIterador();
        while(x.hasNext()){
            if(x.next().estaAlta()){
                x.next().verPaciente();
            }
            System.out.println(Ana.estaAlta());

        }
    }

        //2.4.Utilización del TAD Lista ordinal de Pacientes.
    }

