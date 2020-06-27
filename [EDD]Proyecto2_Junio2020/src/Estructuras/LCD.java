package Estructuras;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LCD {

    public NodoLCD Cabeza;
    public NodoLCD Cola;

    public LCD() {
        this.Cabeza = null;
        this.Cola = null;
    }

    //**********************************************************************GET******************************
    public NodoLCD getCabeza() {
        return Cabeza;
    }

    public NodoLCD getCola() {
        return Cola;
    }

    //**********************************************************************SET******************************
    public void setCabeza(NodoLCD Cabeza) {
        this.Cabeza = Cabeza;
    }

    public void setCola(NodoLCD Cola) {
        this.Cola = Cola;
    }

    //************************************************************************METODOS*********************
    public void InsertarInicio(String DPI, String Nombres, String Apellidos, String Licencia, String Genero, String fecha, String Telefono, String Direccion) {
        NodoLCD nuevo = new NodoLCD(Long.parseLong(DPI), Nombres, Apellidos, Licencia, Genero, fecha, Telefono, Direccion);
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

    public void InsertarFin(String DPI, String Nombres, String Apellidos, String Licencia, String Genero, String fecha, String Telefono, String Direccion) {
        NodoLCD nuevo = new NodoLCD(Long.parseLong(DPI), Nombres, Apellidos, Licencia, Genero, fecha, Telefono, Direccion);
        if (Cabeza == null) {
            nuevo.Siguiente = nuevo;
            nuevo.Anterior = nuevo;
            Cabeza = nuevo;
        } else {
            nuevo.Siguiente = Cabeza;
            nuevo.Anterior = Cola;
            Cola.Siguiente = nuevo;
            Cabeza.Anterior = nuevo;
        }
        Cola = nuevo;
    }

    public NodoLCD BuscarNodo(String DPI) {
        if (Cabeza != null) {
            NodoLCD aux = Cabeza;
            while (aux != Cola) {
                if (aux.DPI == Long.parseLong(DPI)) {
                    return aux;
                }
                aux = aux.Siguiente;
            }
            aux = Cola;
            if (aux.DPI == Long.parseLong(DPI)) {
                return aux;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void EliminarNodo(String DPI) {
        if (Cabeza != null) {
            if (Cabeza == Cola) {
                Cabeza = Cola = null;
            } else {
                NodoLCD aux = BuscarNodo(DPI);
                aux.Siguiente.Anterior = aux.Anterior;
                aux.Anterior.Siguiente = aux.Siguiente;
                if (aux == Cabeza) {
                    Cabeza = aux.Siguiente;
                } else if (aux == Cola) {
                    Cola = aux.Anterior;
                }
            }
        }
    }

    public void RecorrerLCD() {
        NodoLCD aux = Cabeza;
        if (aux != null) {
            while (aux != Cola) {
                System.out.println("DPI: " + aux.DPI + " Nombres: " + aux.Nombres + " Apellidos: " + aux.Apellidos + " Tipo Licencia: " + aux.TipoLicencia + " Genero: " + aux.Genero + " Fecha Nacimiento: " + aux.FechaNac + " Telefono: " + aux.Telefono + " Direccion; " + aux.Direccion);
                aux = aux.Siguiente;
            }
            aux = Cola;
            System.out.println("DPI: " + aux.DPI + " Nombres: " + aux.Nombres + " Apellidos: " + aux.Apellidos + " Tipo Licencia: " + aux.TipoLicencia + " Genero: " + aux.Genero + " Fecha Nacimiento: " + aux.FechaNac + " Telefono: " + aux.Telefono + " Direccion; " + aux.Direccion);
        }
    }

    public void InsertarOrden(String DPI, String Nombres, String Apellidos, String Licencia, String Genero, String fecha, String Telefono, String Direccion) {
        NodoLCD nuevo = new NodoLCD(Long.parseLong(DPI), Nombres, Apellidos, Licencia, Genero, fecha, Telefono, Direccion);
        NodoLCD existe = BuscarNodo(DPI);
        if(existe != null){
            JOptionPane.showMessageDialog(null, "El DPI de conductor ya existe!");
        }else{
            if (Cabeza == null) {
            nuevo.Siguiente = nuevo;
            nuevo.Anterior = nuevo;
            Cola = nuevo;
            Cabeza = nuevo;
        } else {
            NodoLCD inicio = Cabeza;
            while ((inicio.Siguiente != Cabeza) && (inicio.DPI < nuevo.DPI)) {
                inicio = inicio.Siguiente;
            }
            if ((inicio.getSiguiente() == Cabeza) && (inicio.DPI < nuevo.DPI)) {
                nuevo.setSiguiente(Cabeza);
                nuevo.setAnterior(inicio);
                inicio.setSiguiente(nuevo);
                //inicio.setAnterior(Cola);
                Cola = nuevo;
            } else {
                NodoLCD ant = inicio.getAnterior();
                nuevo.setAnterior(ant);
                ant.setSiguiente(nuevo);
                nuevo.setSiguiente(inicio);
                inicio.setAnterior(nuevo);
                if ((inicio == Cabeza) && (Cabeza.DPI > nuevo.DPI)) {
                    Cabeza = nuevo;
                }
            }
        }
        Cabeza.Anterior = Cola;
        Cola.Siguiente = Cabeza;
        }
    }

    public void CargaMasiva() {
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
        }
        carga = texto.split(";");
        matriz1 = new String[carga.length][8];
        for (int i = 0; i < carga.length; i++) {
            matriz1[i] = carga[i].split("%");
            if (BuscarNodo(matriz1[i][0]) == null) {
                InsertarOrden(matriz1[i][0], matriz1[i][1], matriz1[i][2], matriz1[i][3], matriz1[i][4], matriz1[i][5], matriz1[i][6], matriz1[i][7]);
            } else {
                System.out.println("El conductor ya existe");
            }
        }
        JOptionPane.showMessageDialog(null, "Carga Completa");
    }

    public void ReporteGraphviz() {
        NodoLCD anterior = Cabeza;
        NodoLCD siguiente = null;
        String contenido = "";
        String ranks = "{rank=same;";
        FileWriter documento = null;
        PrintWriter crear;
        String archivo = "Conductores.dot";
        String direccion = "Conductores.png";
        //****************************************************************************************************CONTENIDO ARCHIVO
        if (anterior != null) {
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
        }
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
