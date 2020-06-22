package Estructuras;

public class ListaAdyacencia {
    public ListaVertice Lista;
    public ListaAdyacencia(){
        Lista = new ListaVertice();
    }
    //*********************************************************GET********************************************
    public ListaVertice getLista() {
        return Lista;
    }
    //*********************************************************SET********************************************
    public void setLista(ListaVertice Lista) {
        this.Lista = Lista;
    }
    //************************************************************METODOS*************************************
    public void InsertarNodo(String origen, String destino, int tiempo){
        
    }
}
