/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author sartre
 */
public class InicioPantalla extends javax.swing.JFrame {

    /**
     * Creates new form InicioPantalla
     */
    public InicioPantalla() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnJugador = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        lblDescripcion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        btnJugador.setText("Jugador");
        btnJugador.setToolTipText("Ingresar como jugador");
        btnJugador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJugador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnJugadorMousePressed(evt);
            }
        });
        getContentPane().add(btnJugador);
        btnJugador.setBounds(230, 130, 171, 50);

        btnAdministrador.setText("Administrador");
        btnAdministrador.setToolTipText("Ingresar como administrador");
        btnAdministrador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdministrador);
        btnAdministrador.setBounds(20, 130, 171, 50);

        lblDescripcion.setText("Para ingresar al sistema elija la opción que le corresponde");
        getContentPane().add(lblDescripcion);
        lblDescripcion.setBounds(30, 60, 370, 70);

        jLabel1.setFont(new java.awt.Font("Menlo for Powerline", 2, 24)); // NOI18N
        jLabel1.setText("P O K E R");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 20, 140, 40);

        setBounds(0, 0, 428, 232);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJugadorMousePressed
        // TODO add your handling code here:
        new VistaLoginJugador().setVisible(true);
    }//GEN-LAST:event_btnJugadorMousePressed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed
          new VistaLoginAdmin().setVisible(true);
    }//GEN-LAST:event_btnAdministradorActionPerformed

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
            java.util.logging.Logger.getLogger(InicioPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioPantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDescripcion;
    // End of variables declaration//GEN-END:variables
}
