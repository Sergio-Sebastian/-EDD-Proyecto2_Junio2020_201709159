/*
 * @author JESSICA
 * Utilizando M = 37 inicialmente.
 * Porcentaje máximo de ocupación del 75%
 */
package Estructuras;
import Objetos.Cliente;
import javax.swing.JOptionPane;

public class TablaHash {
    private ListaClientes[] listaClientes;//Arreglo de listas
    private int ocupado;//Ocupacion
    private int m;//Cantidad
    private double factor;//75%

    public TablaHash(int cantidad) {
        this.listaClientes = new ListaClientes[cantidad];
        this.ocupado = 0;
        this.m = cantidad;
        this.factor = cantidad * 0.75;
        inicializandoListas();
    }

    public void inicializandoListas() {
        for (int i = 0; i < m; i++) {
            listaClientes[i] = new ListaClientes();
        }
    }

    public void insertar(Cliente c) {
        int posicion = funcionDispersion(c.getDPI());
        if (posicion >= 0 && posicion < m) {
            listaClientes[posicion].insertarUltimo(c);
        } else {
            JOptionPane.showMessageDialog(null, "Atención, el DPI porporcionado no es valido", "ATENCIÓN", 0);
        }
        if(maximaOcupacion()){
            rehash();
        }
    }
    
    public void insertarSinProblema(Cliente c) {
        int posicion = funcionDispersion(c.getDPI());
        if (posicion >= 0 && posicion < m) {
            listaClientes[posicion].insertarUltimo(c);
        } else {
            System.out.println("DatoProblema: " + c.getDPI());
        }
    }
    
    private boolean maximaOcupacion(){
        ocupado=0;
        for(int i=0;i<getM();i++){
            if(!listaClientes[i].estaVacia())
                ocupado++;
        }
        if(ocupado >= (int)factor)
            return true;
        else
            return false;
    }
    
    private void rehash(){
        //ALMACENANDO DATOS ANTERIORES
        System.out.println("REHASH");
        int cantAnt = m;
        ListaClientes[] listaAnterior = listaClientes;
        
        //NUEVOS DATOS
        m = m + 37;
        factor = m * 0.75;
        listaClientes = new ListaClientes[m];
        inicializandoListas();
        NodoClienteLS aux;
        
        for(int i=0; i<cantAnt; i++){
            if(!listaAnterior[i].estaVacia()){
                aux=listaAnterior[i].getCabeza();
                while(aux != null){
                    insertarSinProblema(aux.getCliente());
                    aux = aux.getSiguiente();
                }
            }
        }
    }
    
    public int funcionDispersion(long x) {
        return (int) x % getM();
    }

    public Cliente obtenerCliente(long x) {//SOLO cuando ya sabemos que existe
        NodoClienteLS aux = buscarNodo(x);
        return aux.getCliente();
    }
    
    public NodoClienteLS buscarNodo(long x) {
        int posicion = funcionDispersion(x);
        NodoClienteLS aux = listaClientes[posicion].getCabeza();
        while (aux != null) {
            if (aux.getCliente().getDPI() == x){
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public void eliminar(long x) {
        int posicion = funcionDispersion(x);
        if (posicion >= 0 && posicion < m) {
            listaClientes[posicion].eliminar(x);
        } else {
            JOptionPane.showMessageDialog(null, "Atención, el DPI porporcionado no es valido", "ATENCIÓN", 0);
        }
         
    }
    
    public boolean DPIRegistrado(long carnet) {
        int posicion = funcionDispersion(carnet);
        if (posicion >= 0 && posicion < m) {
            NodoClienteLS aux = listaClientes[posicion].getCabeza();
            while (aux != null) {
                if (aux.getCliente().getDPI() == carnet) {
                    return true;
                }
                aux = aux.getSiguiente();
            }
        }
        return false;
    }

    
    public ListaClientes getClientes(int pos) {
        return listaClientes[pos];
    }

    public int getOcupado() {
        return ocupado;
    }
    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    public int getM() {
        return m;
    }
    public void setM(int m) {
        this.m = m;
    }

}