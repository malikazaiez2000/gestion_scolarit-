import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Msi
 */
public class loginprof extends javax.swing.JFrame {
 DefaultTableModel model4=new DefaultTableModel();
        Connecter conn4=new Connecter();
    Statement stm4;
    ResultSet Rs4;
  String username_input;
    
    
    /**
     * Creates new form loginprof
     */
    public loginprof() {
initComponents();
model4.addColumn("id");
model4.addColumn("username");
model4.addColumn("password");
model4.addColumn("branche");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        password = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Jbutton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        password.setText("Login");
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordMouseClicked(evt);
            }
        });
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 209, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Login Systems");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 0, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 85, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 134, -1, -1));

        pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 127, 112, -1));

        username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 81, 112, -1));

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 209, -1, -1));

        Jbutton3.setText("Exit");
        Jbutton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbutton3ActionPerformed(evt);
            }
        });
        getContentPane().add(Jbutton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 209, 82, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Msi\\Desktop\\Malik Azaiez\\adobestock_183480611_c_monkey_business_0.jpeg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 490, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseClicked

    }//GEN-LAST:event_passwordMouseClicked

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
         
    int flag=1;
    try{
             stm4 = conn4.obtenirconnexion().createStatement();
            Rs4=stm4.executeQuery("select * from register"); 
           
            while(Rs4.next())
            {
                if(Rs4.getString("username").equals(username.getText()) && Rs4.getString("password").equals(pass.getText())     )
                {
                    flag = 0 ; 
                    break ;
                }
            }}
    catch(Exception e){System.err.println(e);}
            if(flag==0)
            {
                JOptionPane.showMessageDialog(this,"connexion réussie");
                this.username_input = username.getText();

                Gestion_des_notes_profs menu = new Gestion_des_notes_profs(this.username_input);
                menu.show();
                dispose();
            }
            else
            {
                
                JOptionPane.showMessageDialog(null,"échec de la connexion","erreur",JOptionPane.ERROR_MESSAGE );
                
            }
            
        

    }//GEN-LAST:event_passwordActionPerformed
public String gettextfield(){
   
    return username.getText();
    

}
    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        username.setText(null);
        pass.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Jbutton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbutton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Jbutton3ActionPerformed
private void systemExit()
{
WindowEvent winCloseing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
}
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
            java.util.logging.Logger.getLogger(loginprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginprof.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginprof().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbutton3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField pass;
    private javax.swing.JButton password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables

}
