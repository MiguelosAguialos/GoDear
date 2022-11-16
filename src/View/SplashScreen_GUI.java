package View;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SplashScreen_GUI extends javax.swing.JFrame {

    
    public SplashScreen_GUI() {
        initComponents();
        new Thread(){
            
            public void run(){
             
                for(int i=0;i<101;i++){
                    try {
                        sleep(60);
                        progresso_bar.setValue(i);
                        if (progresso_bar.getValue()==10){
                            mensagem_lbl.setText("Acessando o servidor");
                            sleep(20);
                            mensagem_lbl.setText("Fazendo conexão do banco de dados");
                        } else if (progresso_bar.getValue()<60){
                            mensagem_lbl.setText("Carregando Banco de Dados");
                        }else if (progresso_bar.getValue()<100){
                            mensagem_lbl.setText("Carregamento Quase completo");
                        }else if (progresso_bar.getValue()>= 100){
                           mensagem_lbl.setText("Carregamento completo");
                             sleep(3000);
                            new TelaLogin_GUI().setVisible(true);
                            dispose();
                        }
                        
                        
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(splashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
        }.start();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        progresso_bar = new javax.swing.JProgressBar();
        mensagem_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        panelImage1.setLayout(null);

        progresso_bar.setForeground(new java.awt.Color(0, 144, 110));
        panelImage1.add(progresso_bar);
        progresso_bar.setBounds(10, 192, 745, 20);

        mensagem_lbl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        mensagem_lbl.setForeground(new java.awt.Color(255, 255, 255));
        mensagem_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensagem_lbl.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        panelImage1.add(mensagem_lbl);
        mensagem_lbl.setBounds(150, 160, 500, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel mensagem_lbl;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JProgressBar progresso_bar;
    // End of variables declaration//GEN-END:variables
}
