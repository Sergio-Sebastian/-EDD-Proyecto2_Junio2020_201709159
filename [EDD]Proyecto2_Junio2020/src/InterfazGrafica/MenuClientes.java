/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import Estructuras.ListaClientes;
import Objetos.GraphvizJava;
import Estructuras.NodoClienteLS;
import static Main.Entidades.direccionProyecto;
import static Main.Entidades.graficador;
import static Main.Entidades.miTablaUsuarios;
import Objetos.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Sebastian
 */
public class MenuClientes extends javax.swing.JFrame {

    private Cliente clienteAux;
    String fileInputPath = "";
    String fileOutputPath = "";

    /**
     * Creates new form MenuClientes
     */
    public MenuClientes() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        try {
            String urlImagen="Clientes.png";
            ImageIcon icon = new ImageIcon(ImageIO.read(new File(urlImagen)));
            icon.getImage().flush();
            lbImg.setIcon(icon);
        } catch (IOException e) {
            System.out.println("EXCEPTION");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        clientetxt = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Actualizar Imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Carga Masiva");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        clientetxt.setToolTipText("Ingresar DPi de cliente");

        jButton6.setText("Eliminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lbImg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientetxt))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        MenuPrincipal menu = new MenuPrincipal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        AgregarCliente menu = new AgregarCliente();
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(clientetxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No existe un cliente con ese DPI", "ATENCIÓN", 1);
        }else{
            try {
                long carnet = Long.parseLong(clientetxt.getText());
                if (miTablaUsuarios.DPIRegistrado(carnet)) {
                    ModificarCliente menu = new ModificarCliente(clientetxt.getText());
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un cliente con ese DPI", "ATENCIÓN", 1);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número en 'DPI'");
            } catch (Exception ed) {
                JOptionPane.showMessageDialog(null, " - ERROR, intenta mas tarde: "+ed+" - ", "ERROR", 1);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dibujarTabla("TablaDispersion");
        graficador.dibujar(fileInputPath, fileOutputPath);
        esperar();
        try {
            String urlImagen="Clientes.png";
            ImageIcon icon = new ImageIcon(ImageIO.read(new File(urlImagen)));
            icon.getImage().flush();
            lbImg.setIcon(icon);
        } catch (IOException e) {
            System.out.println("EXCEPTION");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        long dpi, tel;
        JFileChooser buscador = new JFileChooser();
        buscador.showOpenDialog(buscador);
        try {
            String patch = buscador.getSelectedFile().getAbsolutePath();
            FileInputStream archivo = new FileInputStream(patch);
            DataInputStream entrada = new DataInputStream(archivo);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            if (patch.endsWith(".txt")) {
                int var = 0;
                String lineas;
                while ((lineas = buffer.readLine()) != null) {
                    String clientes[] = lineas.split(";");
                    for (String cliente : clientes) {
                        String atributos[] = cliente.split(",");
                        try {
                            dpi = Long.parseLong(atributos[0].trim());
                            tel = Long.parseLong(atributos[5].trim());
                            if (miTablaUsuarios.DPIRegistrado(dpi)) {
                                var = var + 1;
                            } else {
                                Cliente nuevo = new Cliente(dpi, atributos[1], atributos[2], atributos[3], atributos[4], tel, atributos[6]);
                                miTablaUsuarios.insertar(nuevo);
                            }
                        } catch (Exception e) {
                            var = var + 1;
                        }
                    }
                }
                entrada.close();
                if (var > 0) {
                    JOptionPane.showMessageDialog(null, "Algun producto no se cargo correctamente o ya existia en el sistema", "ATENCIÓN", 1);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo cargado Exitosamente", "Procedimiento Finalizado", 1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo no tiene la extencion adecuada (.txt)", "ATENCIÓN", 1);
            }
        } catch (Exception ed) {
            System.out.println(ed);
            JOptionPane.showMessageDialog(null, "ERROR, intenta nuevamente", "ERROR", 1);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(clientetxt.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese un DPI", "ATENCIÓN", 1);
        }else{
            try {
                long dpi = Long.parseLong(clientetxt.getText());
                if (miTablaUsuarios.DPIRegistrado(dpi)) {
                    miTablaUsuarios.eliminar(dpi);
                    clientetxt.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe un cliente con ese DPI", "ATENCIÓN", 1);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número en 'DPI'");
            } catch (Exception ed) {
                JOptionPane.showMessageDialog(null, " - ERROR, intenta mas tarde: "+ed+" - ", "ERROR", 1);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuClientes().setVisible(true);
            }
        });
    }

    public void esperar() {
        try {
            Thread.sleep(800);
        } catch (Exception e) {
            // Mensaje en caso de que falle
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clientetxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImg;
    // End of variables declaration//GEN-END:variables
    public void dibujarTabla(String nombreReporte) {
        try {
            fileInputPath = "Clientes.dot";
            fileOutputPath = "Clientes.png";
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileInputPath.toString()));
                bw.write("");
                bw.close();
                PrintWriter writer = new PrintWriter(new FileWriter(fileInputPath.toString(), true));

                writer.append("digraph D {\nrankdir=LR\nnode [fontname=\"Arial\" style = \"filled\"];\n");

                int tamanio = miTablaUsuarios.getM(), group = 1;
                for (int i = 0; i < tamanio; i++) {
                    ListaClientes listaAux = miTablaUsuarios.getClientes(i);
                    int j = 0;
                    if (i == 0) {//writer.append("start-> nodo" + i + ";\n");
                    } else {
                        writer.append("nodo" + (i - 1) + "->nodo" + i + ";\n");
                    }
                    writer.append("nodo" + i + "[shape = box, label = \"INDICE " + i + "\", group = " + group + ", fillcolor = gold];\n");

                    NodoClienteLS nodoAux = listaAux.getCabeza();
                    while (nodoAux != null) {
                        if (j == 0) {
                            writer.append("nodo" + i + "-> n" + i + j + ";\n");
                        } else {
                            writer.append("n" + i + (j - 1) + "->n" + i + j + ";\n");
                        }
                        writer.append("n" + i + j + "[shape = record, label = \"DPI: " + nodoAux.getCliente().getDPI()
                                + " | " + nodoAux.getCliente().getNombre()
                                + " | " + nodoAux.getCliente().getApellido()
                                + "\", group = " + group + ", fillcolor = lavenderblush];\n");
                        j++;
                        nodoAux = nodoAux.getSiguiente();
                    }
                    group++;
                }
                writer.append("{rank = same;");
                for (int i = 0; i < tamanio; i++) {
                    writer.append("nodo" + i + ";");
                }
                writer.append("}\n}\n");
                writer.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
