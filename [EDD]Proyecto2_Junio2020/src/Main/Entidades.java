package Main;

import Estructuras.LCD;
import Estructuras.ListaVertice;
import Estructuras.TablaHash;
import Objetos.GraphvizJava;

public class Entidades {
    public static LCD Conductores = new LCD();
    public static ListaVertice Vertices = new ListaVertice();
    public static TablaHash miTablaUsuarios = new TablaHash(37);
    public static GraphvizJava graficador = new GraphvizJava();
    public static String direccionProyecto=System.getProperty("user.dir") + "\\DocsReportes\\";
    public Entidades(){
        
    }
}
