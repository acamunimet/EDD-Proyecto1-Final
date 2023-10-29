/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class DataEdition extends javax.swing.JFrame {

    public static Welcome v1;
    public static GrafoMA grafo;
    
    /**
     * Creates new form DataEdition
     */
    public DataEdition(Welcome v1, GrafoMA grafo) {
        initComponents();
        this.setLocationRelativeTo(null);
        v1.setVisible(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Boton_Regresar = new javax.swing.JButton();
        Boton_EliminarUsuario = new javax.swing.JButton();
        Boton_AgregarUsuario = new javax.swing.JButton();
        Selection_Text = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Boton_Regresar.setText("Regresar");
        Boton_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_RegresarActionPerformed(evt);
            }
        });
        jPanel2.add(Boton_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 30));

        Boton_EliminarUsuario.setText("Eliminar Usuario");
        Boton_EliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_EliminarUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(Boton_EliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, 40));

        Boton_AgregarUsuario.setText("Agregar Usuario");
        Boton_AgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AgregarUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(Boton_AgregarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 130, 40));

        Selection_Text.setText("¿Qué acción desea realizar con los datos cargados?");
        jPanel2.add(Selection_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 320, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_RegresarActionPerformed
        this.setVisible(false);
        new Welcome(this, grafo);
    }//GEN-LAST:event_Boton_RegresarActionPerformed

    private void Boton_EliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_EliminarUsuarioActionPerformed
        //¡¡AQUÍ VA UN CONDICIONAL QUE SAQUE ERROR SI EL USUARIO A ELIMINAR NO ESTÁ EN LA LISTA!!
        String user_deletion = JOptionPane.showInputDialog(null, "Ingrese el usuario que desea eliminar: ");
        JOptionPane.showMessageDialog(null, "¡Usuario eliminado!");
    }//GEN-LAST:event_Boton_EliminarUsuarioActionPerformed

    private void Boton_AgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AgregarUsuarioActionPerformed
        String user_addition = JOptionPane.showInputDialog(null, "Ingrese el usuario que desea agregar: ");
    }//GEN-LAST:event_Boton_AgregarUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(DataEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataEdition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataEdition(v1,grafo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_AgregarUsuario;
    private javax.swing.JButton Boton_EliminarUsuario;
    private javax.swing.JButton Boton_Regresar;
    private javax.swing.JLabel Selection_Text;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}