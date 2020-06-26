package Estructuras;
import Objetos.Cliente;
/**
 * @author JESSICA
 * NODO PARA LA LISTA SIMPLE DE CLIENTES
 */
public class NodoClienteLS {
    private Cliente cliente;
    private NodoClienteLS siguiente;
    
    public NodoClienteLS(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente= null;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    
    public NodoClienteLS getSiguiente(){
        return siguiente;
    }
    
    public void setSiguiente(NodoClienteLS siguiente){
        this.siguiente=siguiente;
    }
}