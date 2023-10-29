/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Welcome extends javax.swing.JFrame {

    public static GrafoMA grafo;
    
    /**
     * Creates new form Welcome
     */
    public Welcome() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
    
    public static void setGrafo(GrafoMA grafo) {
        Welcome.grafo = grafo;
    }
    
    
    public Welcome(DataEdition v2, GrafoMA grafo) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        v2.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Bienvenida = new javax.swing.JLabel();
        Boton_EditarDatos = new javax.swing.JButton();
        Boton_CargarDatos = new javax.swing.JButton();
        Boton_MostrarGrafo = new javax.swing.JButton();
        Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bienvenida.setBackground(new java.awt.Color(255, 255, 255));
        Bienvenida.setForeground(new java.awt.Color(0, 0, 0));
        Bienvenida.setText("¡Bienvenido/a a la interfaz de Análisis de Redes Sociales!");
        jPanel1.add(Bienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 350, -1));

        Boton_EditarDatos.setText("Editar Datos");
        Boton_EditarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EditarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(Boton_EditarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, 40));

        Boton_CargarDatos.setText("Cargar Datos");
        Boton_CargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_CargarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(Boton_CargarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 130, 40));

        Boton_MostrarGrafo.setText("Mostrar Grafo");
        Boton_MostrarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_MostrarGrafoActionPerformed(evt);
            }
        });
        jPanel1.add(Boton_MostrarGrafo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 130, 40));

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/smartphones_1.jpg"))); // NOI18N
        Wallpaper.setText("jLabel1");
        jPanel1.add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 840, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_EditarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EditarDatosActionPerformed
    //Este algoritmo verifica que hayan datos cargados antes de avanzar en la interfaz
        if (grafo == null) {
            JOptionPane.showMessageDialog(null, "¡Aún no hay ningún archivo cargado!", "Error", HEIGHT);
        } else{
            new DataEdition(this, grafo);
        }
    }//GEN-LAST:event_Boton_EditarDatosActionPerformed

    private void Boton_CargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_CargarDatosActionPerformed
       // En esta sección se carga el archivo txt para la construcción del grafo
        Texto txt = new Texto();
        File archivo = txt.FileChooser();
        txt.LeerFichero(archivo);
        GrafoMA grafo_registrado = txt.LeerTxt(archivo);
        this.setGrafo(grafo_registrado);
        grafo.imprimirMA();
    }//GEN-LAST:event_Boton_CargarDatosActionPerformed

    private void Boton_MostrarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_MostrarGrafoActionPerformed
        // ¡¡AQUÍ SE DEBE EJECUTAR LA FUNCIÓN DE MOSTRAR EL GRAFO!!
    }//GEN-LAST:event_Boton_MostrarGrafoActionPerformed

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JButton Boton_CargarDatos;
    private javax.swing.JButton Boton_EditarDatos;
    private javax.swing.JButton Boton_MostrarGrafo;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
