package Estructuras;
import Objetos.Cliente;
/**
 * @author JESSICA
 * LISTA SIMPLE DE CLIENTES PARA LA TABLA HASH
 */
public class ListaClientes {
    private NodoClienteLS cabeza, cola;

    public ListaClientes() {
        this.cabeza = null;
        this.cola = null;
    }

    public boolean estaVacia() {
        return getCabeza() == null;
    }

    public void insertarUltimo(Cliente user) {
        NodoClienteLS nuevoNodo = new NodoClienteLS(user);
        if (estaVacia()) {
            this.setCabeza(nuevoNodo);
            //En la clase "NodoCliente" ya coloqué que el siguiente=null
            this.setCola(nuevoNodo);
        } else {
            cola.setSiguiente(nuevoNodo);
            cola=nuevoNodo;
        }
    }
    
    public void eliminar(long x) {//PUEDO VOLVERLA BOOL, PARA SABER SI ELIMINO O NO, aunque actualmente no la utilizo
        if (estaVacia()) {
            //MENSAJE
        } else {
            if((cabeza==cola) && (cabeza.getCliente().getDPI()==x)){
                cabeza=cola=null;
            }else if(cabeza.getCliente().getDPI()==x){
                cabeza=cabeza.getSiguiente();
            }else{
                NodoClienteLS anterior, temp;
                anterior=cabeza;
                temp=cabeza.getSiguiente();
                while(temp!=null && temp.getCliente().getDPI()!=x){
                    anterior=anterior.getSiguiente();
                    temp=temp.getSiguiente();
                }
                if(temp!=null){
                    anterior.setSiguiente(temp.getSiguiente());
                    if(temp==cola){
                        cola=anterior;
                    }
                }
            }
        }
    }
    
    public NodoClienteLS getCabeza() {
        return cabeza;
    }
    public void setCabeza(NodoClienteLS cabeza) {
        this.cabeza = cabeza;
    }

    public NodoClienteLS getCola() {
        return cola;
    }
    public void setCola(NodoClienteLS cola) {
        this.cola = cola;
    }
}