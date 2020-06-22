package Estructuras;

public class NodoArista {
    public NodoArista Siguiente;
    public String Origen;
    public String Destino;
    public int Tiempo;
    public NodoArista(String origen, String destino, int tiempo){
        Siguiente = null;
        Origen = origen;
        Destino = destino;
        Tiempo = tiempo;
    }
    //****************************************************METODOS GET**************************************
    public NodoArista getSiguiente() {
        return Siguiente;
    }
    public String getOrigen() {
        return Origen;
    }
    public String getDestino() {
        return Destino;
    }
    public int getTiempo() {
        return Tiempo;
    }
    //************************************************************ METODOS SET*****************************
    public void setSiguiente(NodoArista Siguiente) {
        this.Siguiente = Siguiente;
    }
    public void setOrigen(String Origen) {
        this.Origen = Origen;
    }
    public void setDestino(String Destino) {
        this.Destino = Destino;
    }
    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }
}
