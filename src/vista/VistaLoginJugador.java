/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorLoginJugador;
import controlador.InterfaceLoginJugador;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Participante;

/**
 *
 * @author sartre
 */
public class VistaLoginJugador extends javax.swing.JFrame implements InterfaceLoginJugador{
    private ControladorLoginJugador controlador;
    /**
     * Creates new form LoginJugador
     */
    public VistaLoginJugador() {
        initComponents();
        this.setLocation(10, 25);
        this.setResizable(false);
        this.txtUser.requestFocus();
        this.controlador = new ControladorLoginJugador(this);
    }
    
    private void limpiarPantalla(){
        this.txtUser.setText("");
        this.txtPass.setText("");
        this.txtUser.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMinimize = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        lblBarra = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtPass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        lblIngresar = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/utilidades/iconos/minimize.png"))); // NOI18N
        lblMinimize.setToolTipText("Minimizar");
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMinimizeMousePressed(evt);
            }
        });
        getContentPane().add(lblMinimize);
        lblMinimize.setBounds(30, 0, 14, 20);

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/utilidades/iconos/close.png"))); // NOI18N
        lblClose.setToolTipText("Cerrar");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCloseMousePressed(evt);
            }
        });
        getContentPane().add(lblClose);
        lblClose.setBounds(10, 0, 20, 20);

        lblTitulo1.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 204));
        lblTitulo1.setText("P O K E R");
        lblTitulo1.setToolTipText("");
        getContentPane().add(lblTitulo1);
        lblTitulo1.setBounds(90, 30, 70, 30);

        lblBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblBarraMouseDragged(evt);
            }
        });
        lblBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBarraMousePressed(evt);
            }
        });
        getContentPane().add(lblBarra);
        lblBarra.setBounds(0, 0, 390, 40);

        lblTitulo.setFont(new java.awt.Font("Fira Code", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 204));
        lblTitulo.setText("~ Nuevo juego ~");
        lblTitulo.setToolTipText("");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(70, 50, 120, 40);

        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/utilidades/iconos/user.png"))); // NOI18N
        getContentPane().add(lblUser);
        lblUser.setBounds(10, 110, 30, 30);

        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/utilidades/iconos/pass.png"))); // NOI18N
        getContentPane().add(lblPass);
        lblPass.setBounds(10, 160, 30, 30);

        txtUser.setBackground(new java.awt.Color(0, 0, 0));
        txtUser.setForeground(new java.awt.Color(204, 204, 204));
        txtUser.setBorder(null);
        txtUser.setSelectionColor(new java.awt.Color(255, 255, 204));
        getContentPane().add(txtUser);
        txtUser.setBounds(40, 100, 170, 30);

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setToolTipText("");
        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(40, 130, 170, 20);

        txtPass.setBackground(new java.awt.Color(0, 0, 0));
        txtPass.setForeground(new java.awt.Color(204, 204, 204));
        txtPass.setBorder(null);
        getContentPane().add(txtPass);
        txtPass.setBounds(40, 150, 170, 30);

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setToolTipText("");
        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(40, 180, 170, 20);

        lblIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/utilidades/iconos/btnIngresar_1.png"))); // NOI18N
        lblIngresar.setToolTipText("Ingresar al próximo juego ");
        lblIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblIngresar.setPreferredSize(new java.awt.Dimension(150, 26));
        lblIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIngresarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblIngresarMousePressed(evt);
            }
        });
        lblIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblIngresarKeyPressed(evt);
            }
        });
        getContentPane().add(lblIngresar);
        lblIngresar.setBounds(50, 210, 150, 24);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/utilidades/background/background_login.jpg"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, -20, 490, 310);

        setBounds(0, 0, 389, 249);
    }// </editor-fold>//GEN-END:initComponents

    private void lblBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-x1, y-y1);
    }//GEN-LAST:event_lblBarraMouseDragged
    int x1;
    int y1;
    private void lblBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarraMousePressed
        x1 = evt.getX();
        y1 = evt.getY();
    }//GEN-LAST:event_lblBarraMousePressed

    private void lblIngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseEntered
        // TODO add your handling code here:
        ImageIcon ico = new ImageIcon(getClass().getResource("utilidades/iconos/btnIngresar_2.png"));
        this.lblIngresar.setIcon(ico);
    }//GEN-LAST:event_lblIngresarMouseEntered

    private void lblIngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMouseExited
        // TODO add your handling code here:
        ImageIcon ico = new ImageIcon(getClass().getResource("utilidades/iconos/btnIngresar_1.png"));
        this.lblIngresar.setIcon(ico);
    }//GEN-LAST:event_lblIngresarMouseExited

    private void lblCloseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCloseMousePressed

    private void lblMinimizeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMousePressed

    private void lblIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIngresarMousePressed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_lblIngresarMousePressed

    private void lblIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblIngresarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblIngresarKeyPressed

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
            java.util.logging.Logger.getLogger(VistaLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLoginJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBarra;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblIngresar;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void login() {
        if(validarCampoUsuario() && validarCampoPassword()) controlador.login(txtUser.getText().trim(), txtPass.getText().trim());
        if(!validarCampoUsuario()) mostrarError("Usuario vacío");
        if(!validarCampoPassword()) mostrarError("Password vacío");
        limpiarPantalla();
    }
    
    private boolean validarCampoUsuario(){
        return (txtUser.getText().trim().length()>0);
    }
    private boolean validarCampoPassword(){
        return (txtPass.getText().trim().length()>0);
    }

    @Override
    public void mostrarParticipante(Participante p) {
        new VistaJuego(p).setVisible(true);
    }

}
