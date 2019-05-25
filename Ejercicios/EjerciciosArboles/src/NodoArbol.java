//Clase NodoArbol; almacena un nodo de un �rbol.

public class NodoArbol {
	// Constructor vacío
	private int clave;
	private NodoArbol iz;
	private NodoArbol de;

	// Constructor con clave
	public NodoArbol (int clave) {
		this.clave = clave;
		iz = null;
		de = null;
	}

	public NodoArbol(int clave, NodoArbol iz, NodoArbol de) {
		this.clave = clave;
		this.iz = iz;
		this.de = de;
	}

	public NodoArbol getIz () {
		return iz;
	}

	public NodoArbol getDe () {
		return de;
	}

	public int getClave () {
		return clave;
	}

	public void setIz (NodoArbol nuevoIz) {
		iz = nuevoIz;
	}

	public void setDe (NodoArbol nuevoDe) {
		de = nuevoDe;
	}

	public void setClave (int nuevaClave) {
		clave = nuevaClave;
	}

}