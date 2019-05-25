public class TElemento {
	private int nivel;
	private NodoArbol nodo;
	public TElemento() {
		nivel = 0;
		nodo = null;
	}
	public TElemento (NodoArbol a, int n) {
		nivel = n;
		nodo = a;
	}
	public NodoArbol getNodoArbol () {
		return nodo;
	}
	public int getNivel () {
		return nivel;
	}
}
