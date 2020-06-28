package Estructuras;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JComboBox;

public class BlockChain {
    public int cont;
    public NodoBlockChain Cabeza;
    public NodoBlockChain Cola;
    public BlockChain() {
        this.Cabeza = null;
        this.Cola = null;
    }
   public void InsertarInicio(String origen, String destino, NodoClienteLS cliente, NodoLCD conductor, NodoVehiculoAB vehiculo, ListaVertice vertices) {
        cont++;
        NodoBlockChain nuevo = new NodoBlockChain(cont, origen, destino, cliente, conductor, vehiculo, vertices);
        if (Cabeza == null) {
            nuevo.Siguiente = nuevo;
            nuevo.Anterior = nuevo;
            Cola = nuevo;
        } else {
            nuevo.Siguiente = Cabeza;
            nuevo.Anterior = Cola;
            Cola.Siguiente = nuevo;
            Cabeza.Anterior = nuevo;
        }
        Cabeza = nuevo;
    }
   /*public NodoBlockChain BuscarNodo(String llave) {
        if (Cabeza != null) {
            NodoBlockChain aux = Cabeza;
            while (aux != Cola) {
                if (aux.Llave.equals(llave)) {
                    return aux;
                }
                aux = aux.Siguiente;
            }
            aux = Cola;
            if (aux.Llave.equals(llave)) {
                return aux;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }*/
   public NodoBlockChain BuscarNodo(int llave) {
        if (Cabeza != null) {
            NodoBlockChain aux = Cabeza;
            while (aux != Cola) {
                if (aux.Llave == llave) {
                    return aux;
                }
                aux = aux.Siguiente;
            }
            aux = Cola;
            if (aux.Llave == llave) {
                return aux;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
   public JComboBox LlenarComboBox(JComboBox combo){
       NodoBlockChain aux = Cabeza;
        if(aux != null){
            while(aux != null && aux != Cola){
                combo.addItem(aux.Llave);
                aux = aux.Siguiente;
            }
        }
        if(aux == Cola && aux != null){
            combo.addItem(aux.Llave);
        }
       return combo;
   }
   public void RecorrerBlockChain() {
        NodoBlockChain aux = Cabeza;
        if (aux != null) {
            while (aux != Cola) {
                System.out.println("Origen: " + aux.Origen + "Destino: " + aux.Destino + " Fecha: " + aux.FechaHora + " Conductor: " + aux.Conductor.Nombres);
                aux = aux.Siguiente;
            }
            aux = Cola;
            System.out.println("Origen: " + aux.Origen + "Destino: " + aux.Destino + " Fecha: " + aux.FechaHora + " Conductor: " + aux.Conductor.Nombres);
        }
    }
   public void ReporteCaminoCorto() {
        NodoBlockChain anterior = Cabeza;
        NodoBlockChain siguiente = null;
        String contenido = "";
        String ranks = "{rank=same;";
        FileWriter documento = null;
        PrintWriter crear;
        String archivo = "Viaje.dot";
        String direccion = "Viaje.png";
        //****************************************************************************************************CONTENIDO ARCHIVO
        /*if (anterior != null) {
            while (anterior != Cola) {
                ranks += "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + ";";
                siguiente = anterior.Siguiente;
                contenido += "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + "->" + "\"" + siguiente.DPI + "(" + siguiente.Nombres + ")" + "\"" + ";\n" + "\"" + siguiente.DPI + "(" + siguiente.Nombres + ")" + "\"" + "->" + "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + ";\n";
                anterior = anterior.Siguiente;
            }
            if (Cabeza == Cola) {
                ranks += "\"" + Cabeza.DPI + "(" + Cabeza.Nombres + ")" + "\"" + ";";
                contenido += "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + "->" + "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + ";\n" + "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + "->" + "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + ";\n";
            } else if (anterior == Cola) {
                ranks += "\"" + anterior.DPI + "(" + anterior.Nombres + ")" + "\"" + ";";
                contenido += "\"" + Cabeza.DPI + "(" + Cabeza.Nombres + ")" + "\"" + "->" + "\"" + Cola.DPI + "(" + Cola.Nombres + ")" + "\"" + ";\n" + "\"" + Cola.DPI + "(" + Cola.Nombres + ")" + "\"" + "->" + "\"" + Cabeza.DPI + "(" + Cabeza.Nombres + ")" + "\"" + ";\n";
            }
            contenido += ranks + "};\n";
        } else {
            contenido += "NULL\n";
        }*/
        //****************************************************************************************************FIN CONTENIDO ARCHIVO
        String comando = "digraph D {\n" + "rankdir=LR;\n node [fontname=\"Arial\"];\n" + "\n" + contenido + "\n}";
        try {
            documento = new FileWriter(archivo);
            crear = new PrintWriter(documento);
            crear.print(comando);
            crear.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
        try {
            Runtime.getRuntime().exec("dot -Tpng " + archivo + " -o " + direccion);
        } catch (Exception e) {
            System.err.println("");
        }
    }
}
