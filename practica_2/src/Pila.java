public class Pila {
    private Nodo cima;
    private int numElem;


    public Pila() {
        this.cima = null;
        this.numElem = 0;
    }

    public void apilar(int num) {
        Nodo obj = new Nodo(num, this.cima);
        this.cima = obj;
        numElem++;
    }

    public int desapilar() {
        if (this.cima != null) {
            int valor = this.cima.getDato();
            this.cima = cima.getSiguiente();
            numElem--;
            return valor;
        } else {
            return -1;
        }
    }

    public int cima() {
        return this.cima.getDato();
    }

    public void decapitar() {
        if (this.cima != null) {
            this.cima = cima.getSiguiente();
            numElem--;
        }
    }

    public int numElemPila() {
        return this.numElem;
    }

    public void escribirPila() {
        int valor = this.desapilar();
        if (valor != -1) {
            System.out.println(valor);
            this.escribirPila();
            this.apilar(valor);
        }
    }

    public int sumarElementos(int valor) {
        int _cima;
        if (this.cima != null) {
            _cima = this.desapilar();
            valor += this.sumarElementos(_cima);
            this.apilar(_cima);
        }
        return valor;
    }

    public void juntarPila(Pila obj) {
        int paraApilar;
        if(obj.cima!= null) {
            paraApilar = obj.desapilar();
            this.juntarPila(obj);
            this.apilar(paraApilar);
        }
    }
}