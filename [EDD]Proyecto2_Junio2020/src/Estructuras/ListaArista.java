package Estructuras;

public class ListaArista {
    public NodoArista Cabeza;
    public ListaArista(){
        Cabeza = null;
    }
    //**************************************************GET**************************
    public NodoArista getCabeza() {
        return Cabeza;
    }
    //**************************************************SET**************************
    public void setCabeza(NodoArista Cabeza) {
        this.Cabeza = Cabeza;
    }
    //***********************************************************METODOS******************
    public void InsertarFin(String origen, String destino, int tiempo){
        NodoArista nuevo = new NodoArista(origen,destino,tiempo);
        NodoArista aux = Cabeza;
        if(Cabeza == null){
            Cabeza = nuevo;
        }else{
            while(aux != null){
                if(aux.Siguiente == null){
                    aux.Siguiente = nuevo;
                    return;
                }
                aux = aux.Siguiente;
            }
            aux = nuevo;
        }
    }
    public void Recorrer(){
        NodoArista aux = Cabeza;
        if(Cabeza != null){
            while(aux != null){
                System.out.println("Origen: " + aux.Origen + " Destino: " + aux.Destino + " Tiempo: " + aux.Tiempo);
                aux = aux.Siguiente;
            }
        }
    }
}
