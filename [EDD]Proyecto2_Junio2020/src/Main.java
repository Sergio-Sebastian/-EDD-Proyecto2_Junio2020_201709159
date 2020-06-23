import Estructuras.*;

public class Main {
    public static void main(String[] args) {
        /*LCD Conductores = new LCD();
        Conductores.CargaMasiva();
        Conductores.RecorrerLCD();
        Conductores.ReporteGraphviz();*/
        ListaVertice ejemplo = new ListaVertice();
        ejemplo.CargaMasiva();
        ejemplo.Recorrer();
        ejemplo.ReporteListaAdyacencia();
        ejemplo.ReporteGrafo();
        /*ejemplo.Insertar("Guatemala", "Peten", 5);
        ejemplo.Insertar("Guatemala", "Jalapa", 10);
        ejemplo.Insertar("Jutiapa", "Jalapa", 10);
        ejemplo.Insertar("Zacapa", "Chiquimula", 18);
        ejemplo.Insertar("Guatemala", "Chiquimula", 18);
        ejemplo.Insertar("Jutiapa", "Chiquimula", 18);
        ejemplo.Insertar("Jalapa", "Chiquimula", 18);
        ejemplo.Insertar("Zacapa", "Alta Verapaz", 18);
        ejemplo.Recorrer();
        System.out.println("");
        ejemplo.EliminarVertice("Zacapa");
        ejemplo.Recorrer();
        System.out.println("");
        ejemplo.EliminarArista("Guatemala", "Jalapa", 10);
        ejemplo.Recorrer();
        System.out.println("");
        ejemplo.EliminarArista("Jalapa", "Chiquimula", 18);
        ejemplo.Recorrer();*/
    }
}


