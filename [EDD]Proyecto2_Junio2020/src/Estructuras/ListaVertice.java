package Estructuras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ListaVertice {
    private int cont = 0;
    public NodoVertice Cabeza;
    public ListaVertice() {
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
    public void Insertar(String origen, String destino, int tiempo) {
        NodoVertice nuevo = new NodoVertice(origen);
        NodoVertice nuevo2 = new NodoVertice(destino);
        NodoVertice aux = Cabeza;
        NodoVertice ver = BuscarVertice(origen);
        NodoVertice ver2 = BuscarVertice(destino);
        if (ver != null) {
            NodoArista comprobar = ver.Aristas.BuscarArista(origen, destino, tiempo);
            if(comprobar == null){
                BuscarVertice(origen).Aristas.InsertarFin(origen, destino, tiempo);
            }
            if(ver2 == null){
                while(aux != null){
                    if(aux.Abajo == null){
                        cont++;
                        nuevo2.matriz += cont;
                        aux.Abajo = nuevo2;
                        return;
                    }
                    aux = aux.Abajo;
                }
            }
        } else if (Cabeza == null) {
            cont++;
            nuevo.Aristas.InsertarFin(origen, destino, tiempo);
            nuevo.matriz += cont;
            Cabeza = nuevo;
            if(nuevo.Nombre.equals(nuevo2.Nombre)){
                
            }else{
                cont++;
                nuevo2.matriz += cont;
                Cabeza.Abajo = nuevo2;
            }
        } else {
            while (aux != null) {
                if (aux.Abajo == null) {
                    cont++;
                    nuevo.Aristas.InsertarFin(origen, destino, tiempo);
                    nuevo.matriz += cont;
                    aux.Abajo = nuevo;
                    if(ver2 == null){
                        cont++;
                        nuevo2.matriz = cont;
                        aux.Abajo.Abajo = nuevo2;
                    }
                    return;
                }
                aux = aux.Abajo;
            }
        }
    }
    public void Recorrer() {
        NodoVertice aux = Cabeza;
        if (Cabeza != null) {
            while (aux != null) {
                System.out.println("Lugar: " + aux.Nombre);
                aux.Aristas.Recorrer();
                aux = aux.Abajo;
            }
        }
    }
    public NodoVertice BuscarVertice(String nombre) {
        NodoVertice aux = Cabeza;
        while (aux != null) {
            if (aux.Nombre.equals(nombre)) {
                return aux;
            }
            aux = aux.Abajo;
        }
        return null;
    }
    public NodoVertice BuscarVerticePorPosicion(int pos) {
        NodoVertice aux = Cabeza;
        while (aux != null) {
            if (aux.matriz == pos) {
                return aux;
            }
            aux = aux.Abajo;
        }
        return null;
    }
    public void EliminarVertice(String nombre) {
        NodoVertice aux = Cabeza;
        if (aux != null) {
            if (aux.Nombre == nombre && aux.Abajo == null && aux == Cabeza) {
                aux = Cabeza = null;
            } else if (nombre == Cabeza.Nombre) {
                Cabeza = Cabeza.Abajo;
            } else {
                NodoVertice ant, temp;
                ant = Cabeza;
                temp = Cabeza.Abajo;
                while (temp != null && temp.Nombre != nombre) {
                    ant = ant.Abajo;
                    temp = temp.Abajo;
                }
                if (temp != null) {
                    ant.Abajo = temp.Abajo;
                    if (temp.Abajo == null) {
                        temp = ant;
                    }
                }
            }
        }
    }
    public void EliminarArista(String origen, String destino, int tiempo) {
        BuscarVertice(origen).Aristas.EliminarArista(origen, destino, tiempo);
        if (BuscarVertice(origen).Aristas.Cabeza == null) {
            EliminarVertice(origen);
        }
    }
    public boolean CargaMasiva() {
        File documento;
        String direccion;
        String carga[];
        String matriz1[][];
        String texto = "";
        JFileChooser seleccion = new JFileChooser();
        FileNameExtensionFilter tipo = new FileNameExtensionFilter("Arhivo text", "txt");
        seleccion.setFileFilter(tipo);
        seleccion.showOpenDialog(null);
        documento = seleccion.getSelectedFile();
        direccion = documento.getAbsolutePath();
        try {
            BufferedReader ventana = new BufferedReader(new FileReader(direccion));
            String linea;
            String contenido = "";
            while ((linea = ventana.readLine()) != null) {
                contenido = contenido + linea;
            }
            texto = contenido;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
        carga = texto.split("%");
        matriz1 = new String[carga.length][3];
        for (int i = 0; i < carga.length; i++) {
            matriz1[i] = carga[i].split("/");
            if(matriz1[i][0].equals(" ")){
                
            }else{
                 Insertar(matriz1[i][0], matriz1[i][1], Integer.parseInt(matriz1[i][2]));
            }
           
        }
        JOptionPane.showMessageDialog(null, "Carga Completa");
        return true;
    }
    public void ReporteListaAdyacencia() {
        if (Cabeza != null) {
            NodoVertice base = Cabeza;
            NodoArista inicio = null;
            String contenido = "";
            String ranks = "{rank=same;";
            FileWriter documento = null;
            PrintWriter crear;
            String archivo = "ListaAdyacencia.dot";
            String direccion = "ListaAdyacencia.png";
            //****************************************************************************************************CONTENIDO ARCHIVO
            while (base != null) {
                if (base.Aristas.Cabeza != null) {
                    ranks += "\"" + base.Nombre + "\"" + ";";
                    inicio = base.Aristas.Cabeza;
                    contenido += "\"" + base.Nombre + "\"" + "->" + "\"" + inicio.Destino + "(" + inicio.Tiempo + ")" + "\"" + ";\n";
                    while (inicio != null) {
                        if (inicio.Siguiente != null) {
                            contenido += "\"" + inicio.Destino + "(" + inicio.Tiempo + ")" + "\"" + "->" + "\"" + inicio.Siguiente.Destino + "(" + inicio.Siguiente.Tiempo + ")" + "\"" + ";\n";
                        }
                        inicio = inicio.Siguiente;
                    }
                }
                if (base.Abajo != null) {
                    contenido += "\"" + base.Nombre + "\"" + "->" + "\"" + base.Abajo.Nombre + "\"" + "[style=invis]" + ";";
                    base = base.Abajo;
                    ranks += "\"" + base.Nombre + "\"" + ";";
                } else {
                    base = base.Abajo;
                }
            }
            ranks += "}\n";
            contenido += ranks;
            //****************************************************************************************************FIN CONTENIDO ARCHIVO
            String comando = "digraph D {\n" + "rankdir=LR\n" + "node[shape=rectangle]\nnodesep=0;\n" + "\n" + contenido + "\n}";
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
    public void ReporteGrafo() {
        if (Cabeza != null) {
            NodoVertice base = Cabeza;
            NodoArista inicio = null;
            String contenido = "";
            FileWriter documento = null;
            PrintWriter crear;
            String archivo = "Grafo.dot";
            String direccion = "Grafo.png";
            //****************************************************************************************************CONTENIDO ARCHIVO
            while (base != null) {
                if (base.Aristas.Cabeza != null) {
                    inicio = base.Aristas.Cabeza;
                    contenido += "\"" + inicio.Origen + "\"" + "->" + "\"" + inicio.Destino + "\"" + "[label=" + inicio.Tiempo + "]" + ";\n";
                    while (inicio != null) {
                        if (inicio.Siguiente != null) {
                            contenido += "\"" + inicio.Siguiente.Origen + "\"" + "->" + "\"" + inicio.Siguiente.Destino + "\"" + "[label=" + inicio.Siguiente.Tiempo + "]" + ";\n";
                        }
                        inicio = inicio.Siguiente;
                    }
                }
                base = base.Abajo;
            }
            //****************************************************************************************************FIN CONTENIDO ARCHIVO
            String comando = "digraph G {\n" + contenido + "\n}";
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
    public int[][] CrearMatrizAdyacencia(int tamanyo){
        int MatrizAdyacencia[][] = new int[tamanyo][tamanyo];
        NodoVertice base = Cabeza;
        NodoArista aux;
        NodoVertice buscarpos;
        while(base != null){
            if(base.Aristas.Cabeza != null){
                aux = base.Aristas.Cabeza;
                while(aux != null){
                    buscarpos = BuscarVertice(aux.Destino);
                    if(buscarpos != null){
                        MatrizAdyacencia[base.matriz][buscarpos.matriz] = aux.Tiempo;
                    }
                    aux = aux.Siguiente;
                }
                base = base.Abajo;
            }else{
                base = base.Abajo;
            }
        }
        return MatrizAdyacencia;
    }
    public ListaArista CaminoCorto(String origen, String destino){
        int[][] MatrizPesos = CrearMatrizAdyacencia(cont);
        ListaArista lista = new ListaArista();
        NodoArista nuevo;
        NodoVertice existe;
        int [][] datos = new int[cont][3];
        for(int i=0; i<cont; i++){
            datos[i][0]=0;
            datos[i][1]= Integer.MAX_VALUE;
            datos[i][0]=0;
        }
        NodoVertice inicio = BuscarVertice(origen);
        int start;
        if(inicio != null){
            start = inicio.matriz;
        }else{
            return null;
        }
        datos[start][1]=0;
        int actual = start;
        do{
            datos[actual][0]=1;
            for(int col = 0; col < cont; col++){
                if(MatrizPesos[actual][col]!=0){
                    int distancia = MatrizPesos[actual][col] + datos[actual][1];
                    if(distancia<datos[col][1]){
                        datos[col][1] = distancia;
                        datos[col][2] = actual;
                    }                  
                }
            }
            int distmin = Integer.MAX_VALUE;
            int indmin =-1;
            for(int x =0; x<cont; x++){
                if(datos[x][1]<distmin && datos[x][0]==0){
                    indmin  = x;
                    distmin = datos[x][1];
                }
            }
            actual = indmin;
        }while(actual!=-1);
        ArrayList<Integer> ruta = new ArrayList<Integer>();
        int nodo;
        NodoVertice fin = BuscarVertice(destino);
         if(fin != null){
            nodo = fin.matriz;
        }else{
            return null;
        }
         while(nodo!= start){
             ruta.add(nodo);
             nodo = datos[nodo][2];
         }
         ruta.add(start);
         Collections.reverse(ruta);
         for (int pos : ruta) 
        { 
            existe = BuscarVerticePorPosicion(pos);
            if(existe!=null){
              nuevo = new NodoArista(existe.Nombre, datos[pos][1]); 
              lista.InsertarFin(nuevo.Origen,nuevo.Destino,nuevo.Tiempo);
            }
        }
         return lista;
    }
}
