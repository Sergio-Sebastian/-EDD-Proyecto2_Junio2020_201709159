package Main;

import Estructuras.ListaArista;
import Estructuras.ListaVertice;
import InterfazGrafica.*;
import java.awt.Image;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

public class Main {
    public static Entidades Objetos = new Entidades();
    public static void main(String args[]){
        if(Objetos.Vertices.CargaMasiva()){
            Objetos.Vertices.ReporteGrafo();
            Objetos.Vertices.ReporteListaAdyacencia();
            MenuPrincipal menu = new MenuPrincipal();
        }else{
            System.exit(0);
        }
        
    }
}
