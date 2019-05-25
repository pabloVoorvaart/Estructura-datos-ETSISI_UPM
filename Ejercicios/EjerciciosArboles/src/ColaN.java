class NodoColaN {
	NodoColaN siguiente;
	  // Constructores
	TElemento elem;
	NodoColaN (NodoArbol a, int n, NodoColaN sig) { 
		elem = new TElemento (a, n); 
		siguiente = sig; 
	}
	NodoColaN (TElemento e, NodoColaN sig) {
		elem = e;
		siguiente = sig;
	}
	NodoColaN (TElemento e) {
		elem = e;
		siguiente = null;
	}
	public TElemento construirElemento (NodoArbol a, int n) {
		return new TElemento (a,n);
	}	
}

public class ColaN  {

	private NodoColaN principio;
	private NodoColaN fin;

	public ColaN () {
		principio = null;
		fin = null;
	}
	
	public boolean colaVacia () {
		return principio==null;	
	}
	public void encolar (TElemento e) {
        NodoColaN aux = new NodoColaN (e);
        if (principio == null) 
        	{principio = aux;
        	fin = aux;
        	}
        else {
        	fin.siguiente = aux;
        	fin = aux;
        }
	}
	
	public TElemento desencolar () {
        TElemento resultado = null;
        if (!colaVacia ()) {
        	resultado = principio.elem;
        	principio = principio.siguiente;
        	if (principio == null)
        		fin = null;
        }
        return resultado;
	}
}
