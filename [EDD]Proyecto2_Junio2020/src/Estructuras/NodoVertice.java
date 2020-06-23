package Estructuras;

public class NodoVertice {
    public String Nombre;
    public ListaArista Aristas;
    public NodoVertice Abajo;
    public NodoVertice(String nombre){
        Nombre = nombre;
        Abajo = null;
        Aristas = new ListaArista();
    }
    //************************************************GET*******************************************************
    public String getNombre() {
        return Nombre;
    }
    public ListaArista getAristas() {
        return Aristas;
    }
    public NodoVertice getAbajo() {
        return Abajo;
    }
    //********************************************************SET***********************************************
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public void setAristas(ListaArista aristas) {
        this.Aristas = aristas;
    }
    public void setAbajo(NodoVertice Abajo) {
        this.Abajo = Abajo;
    }
}
