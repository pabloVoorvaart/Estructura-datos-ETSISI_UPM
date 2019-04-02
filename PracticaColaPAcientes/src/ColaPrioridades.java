public class ColaPrioridades {
    private NodoPrioridad inicio;

    public ColaPrioridades() {
        inicio = null;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    /** Inserta el paciente en la cola que le corresponde según su prioridad.
     * Si no hay ningún paciente con la misma prioridad, crea una cola nueva en la que mete al paciente.
     */
    public void encolar(int prioridad, Paciente paciente) {
        // TODO encolar con prioridad
        NodoPrioridad nuevo;
        Cola cola = new Cola();
        boolean entry = true;
        if (this.estaVacia()||prioridad < inicio.getClave()) {
            inicio = new NodoPrioridad(prioridad, cola, inicio);
            inicio.getDato().encolar(paciente);
        }
        else {
            NodoPrioridad actual = inicio;
            while (actual != null && entry) {
                if (prioridad == actual.getClave()) {
                    actual.getDato().encolar(paciente);
                    entry = false;
                }
                if (prioridad > actual.getClave() && (actual.getSiguiente() == null || prioridad < actual.getSiguiente().getClave())) {
                    nuevo = new NodoPrioridad(prioridad, cola, actual.getSiguiente());
                    nuevo.getDato().encolar(paciente);
                    actual.setSiguiente(nuevo);
                    entry = false;
                }
                actual = actual.getSiguiente();
            }
        }
    }

    /** Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
     * y si no la encuentra devuelve NULL.
     */
    public Paciente desencolar() {
        // TODO desencolar
        Paciente paciente;
        if(!this.estaVacia()){
            paciente =  inicio.getDato().desencolar();
            if(inicio.getDato().colaVacia()){
                inicio = inicio.getSiguiente();
            }
            return paciente;
        }
        return null;
    }

    /** Visualizar todos los pacientes del hospital, ordenados por prioridad
     */
    public void verColaPrioridades() {
        // TODO verDatos
        NodoPrioridad actual = inicio;
        while(actual!=null){
            System.out.println("Preferencia " + actual.getClave() + ":");
            actual.getDato().verCola();
            actual = actual.getSiguiente();
        }
    }
}

