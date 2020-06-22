package Estructuras;

public class NodoVertice {
    public String Nombre;
    public ListaArista aristas;
    public NodoVertice Abajo;
    public NodoVertice(String nombre){
        Nombre = nombre;
        Abajo = null;
        aristas = new ListaArista();
    }
    //************************************************GET*******************************************************
    public String getNombre() {
        return Nombre;
    }
    public ListaArista getAristas() {
        return aristas;
    }
    public NodoVertice getAbajo() {
        return Abajo;
    }
    //********************************************************SET***********************************************
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public void setAristas(ListaArista aristas) {
        this.aristas = aristas;
    }
    public void setAbajo(NodoVertice Abajo) {
        this.Abajo = Abajo;
    }
}
