package Estructuras;

public class ListaArista {
    public NodoArista Cabeza;
    public ListaArista() {
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
    public void InsertarFin(String origen, String destino, int tiempo) {
        NodoArista nuevo = new NodoArista(origen, destino, tiempo);
        NodoArista aux = Cabeza;
        if (Cabeza == null) {
            Cabeza = nuevo;
        } else {
            while (aux != null) {
                if (aux.Siguiente == null) {
                    aux.Siguiente = nuevo;
                    return;
                }
                aux = aux.Siguiente;
            }
            aux = nuevo;
        }
    }
    public void Recorrer() {
        NodoArista aux = Cabeza;
        if (Cabeza != null) {
            while (aux != null) {
                System.out.println("Origen: " + aux.Origen + " Destino: " + aux.Destino + " Tiempo: " + aux.Tiempo);
                aux = aux.Siguiente;
            }
        }
    }
    public void EliminarArista(String origen, String destino, int tiempo) {
        NodoArista aux = Cabeza;
        if (aux != null) {
            if (aux.Origen == origen && aux.Destino == destino && aux.Tiempo == tiempo && aux.Siguiente == null && aux == Cabeza) {
                aux = Cabeza = null;
            } else if (Cabeza.Origen == origen && Cabeza.Destino == destino && Cabeza.Tiempo == tiempo && Cabeza.Siguiente != null) {
                Cabeza = Cabeza.Siguiente;
            } else {
                NodoArista ant, temp;
                ant = Cabeza;
                temp = Cabeza.Siguiente;
                while (temp != null && (temp.Origen != origen || temp.Destino != destino || temp.Tiempo != tiempo)) {
                    ant = ant.Siguiente;
                    temp = temp.Siguiente;
                }
                if (temp != null) {
                    ant.Siguiente = temp.Siguiente;
                    if (temp.Siguiente == null) {
                        temp = ant;
                    }
                }
            }
        }
    }
    public NodoArista BuscarArista(String origen, String destino, int tiempo){
        NodoArista aux = Cabeza;
        while(aux != null){
            if(aux.Origen.equals(origen) && aux.Destino.equals(destino) && aux.Tiempo == tiempo){
                return aux;
            }
            aux = aux.Siguiente;
        }
        return null;
    }
}
