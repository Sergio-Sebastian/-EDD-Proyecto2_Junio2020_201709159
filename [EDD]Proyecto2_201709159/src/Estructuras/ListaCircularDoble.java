package Estructuras;

public class ListaCircularDoble {
    public NodoListaCircularDoble Cabeza;
    public NodoListaCircularDoble Cola;
    public ListaCircularDoble(){
        this.Cabeza = null;
        this.Cola = null;
    }
    //**********************************************************************METODOS GET******************************
    public NodoListaCircularDoble getCabeza() {
        return Cabeza;
    }
    public NodoListaCircularDoble getCola() {
        return Cola;
    }
    //**********************************************************************METODOS SET******************************
    public void setCabeza(NodoListaCircularDoble Cabeza) {
        this.Cabeza = Cabeza;
    }
    public void setCola(NodoListaCircularDoble Cola) {
        this.Cola = Cola;
    }
    //************************************************************************METODOS PRINCIPALES*********************
    public void InsertarInicio(String DPI, String Nombres, String Apellidos, String Licencia, String Genero, String Telefono, String Direccion){
        NodoListaCircularDoble nuevo = new NodoListaCircularDoble(DPI,Nombres,Apellidos,Licencia,Genero,Telefono,Direccion);
        if(Cabeza == null){
            nuevo.Siguiente = nuevo;
            nuevo.Anterior = nuevo;
            Cola = nuevo;
        }else{
            nuevo.Siguiente = Cabeza; 
            nuevo.Anterior = Cola;    
            Cola.Siguiente = nuevo;   
            Cabeza.Anterior = nuevo;  
        }
        Cabeza = nuevo;
    }
    public void InsertarFin(String DPI, String Nombres, String Apellidos, String Licencia, String Genero, String Telefono, String Direccion){
        NodoListaCircularDoble nuevo = new NodoListaCircularDoble(DPI,Nombres,Apellidos,Licencia,Genero,Telefono,Direccion);
        if(Cabeza == null){
            nuevo.Siguiente = nuevo;
            nuevo.Anterior = nuevo;
            Cabeza = nuevo;
        }else{
            nuevo.Siguiente = Cabeza;
            nuevo.Anterior = Cola;
            Cola.Siguiente = nuevo;
            Cabeza.Anterior = nuevo;
        }
	Cola = nuevo;
    }
    public NodoListaCircularDoble BuscarNodo(String DPI){
        if(Cabeza != null){
            NodoListaCircularDoble aux = Cabeza;
            while(aux != Cola){
                if(aux.DPI == DPI){
                    return aux;
                }
                aux = aux.Siguiente;
            }
            aux = Cola;
            if(aux.DPI == DPI){
                return aux;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
    public void EliminarNodo(String DPI){
        NodoListaCircularDoble aux = BuscarNodo(DPI);
        aux.Siguiente.Anterior = aux.Anterior;
	aux.Anterior.Siguiente = aux.Siguiente; 
        if(aux == Cabeza){
            Cabeza = aux.Siguiente;
        }else if(aux == Cola){
            Cola = aux.Anterior;
        }
    }
    public void RecorrerLCD(){
        NodoListaCircularDoble aux = Cabeza;
        if(aux != null){
            while(aux != Cola){
                System.out.println("DPI: " + aux.DPI + " Nombres: " + aux.Nombres + " Apellidos: " + aux.Apellidos + " Tipo Licencia: " + aux.TipoLicencia + " Genero: " + aux.Genero + " Telefono: " + aux.Telefono + " Direccion; " + aux.Direccion);
                aux = aux.Siguiente;
            }
            aux = Cola;
            System.out.println("DPI: " + aux.DPI + " Nombres: " + aux.Nombres + " Apellidos: " + aux.Apellidos + " Tipo Licencia: " + aux.TipoLicencia + " Genero: " + aux.Genero + " Telefono: " + aux.Telefono + " Direccion; " + aux.Direccion);
        }
    }
}
