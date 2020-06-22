package Estructuras;

public class ListaVertice {
    public NodoVertice Cabeza;
    public ListaVertice(){
        Cabeza = null;
    }
    //**********************************************GET*****************************************
    public NodoVertice getCabeza() {
        return Cabeza;
    }
    //**********************************************SET*****************************************
    public void setCabeza(NodoVertice Cabeza) {
        this.Cabeza = Cabeza;
    }
    //*********************************************************METODOS**********************************************
    public void InsertarFin(String nombre){
        NodoVertice nuevo = new NodoVertice(nombre);
        NodoVertice aux = Cabeza;
        if(Cabeza == null){
            Cabeza = nuevo;
        }else{
            while(aux != null){
                if(aux.Abajo == null){
                    aux.Abajo = nuevo;
                    return;
                }
                aux = aux.Abajo;
            }
            aux = nuevo;
        }
    }
}
