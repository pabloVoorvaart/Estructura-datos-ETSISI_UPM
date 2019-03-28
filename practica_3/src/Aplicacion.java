import java.util.List;

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

        Alberto.darAlta();
        Ana.darAlta();
        Ernesto.darAlta();

        // 2.3.Ampliación del TAD Lista ordinal de Pacientes.
        /*lista.borrarAltas();
        Iterador x = lista.obtenerIterador();
        while(x.hasNext()){
            x.next().verPaciente();
        }
        */


        //2.4.Utilización del TAD Lista ordinal de Pacientes.
        verAltas(lista);

        //2.5 pacientesSintoma
        String sintoma = "mareo";
        Iterador i = pacientesSintoma(lista, sintoma).obtenerIterador();
        System.out.println("PACIENTES CON " + sintoma.toUpperCase() + ":");
        while(i.hasNext()){
            i.next().verPaciente();
        }
        System.out.println("------------------");

    }

    public static void verAltas(ListaOrdinal lista){
        Iterador i = lista.obtenerIterador();
        Paciente a;
        System.out.println("PACIENTES DE ALTA:");
        while(i.hasNext()){
            a = i.next();
            if(a.estaAlta()){
                a.verPaciente();
            }
        }
        System.out.println("------------------");
    }

    public static ListaOrdinal pacientesSintoma(ListaOrdinal lista, String sintoma){
        Iterador i = lista.obtenerIterador();
        ListaOrdinal pacientes = new ListaOrdinal();
        Paciente a;
        while(i.hasNext()){
            a = i.next();
            if(a.getSintomas().toLowerCase().contains(sintoma)){
                pacientes.insertar(a);
            }
        }
        return pacientes;
    }
}



