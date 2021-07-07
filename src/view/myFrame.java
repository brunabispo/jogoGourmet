/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import model.Comida;
import model.ListaComidas;

/**
 *
 * @author bruna
 */
public class myFrame extends javax.swing.JFrame {

    private final ListaComidas listaMassas;
    private final ListaComidas listaSemMassa;
    
    private int resposta;

    /**
     * Creates new form myFrame
     */
    public myFrame() {
        initComponents();
        this.listaSemMassa = new ListaComidas();
        this.listaMassas = new ListaComidas();
        this.listaMassas.getComidas().add(new Comida("Lasanha", ""));
        this.listaSemMassa.getComidas().add(new Comida("Bolo de Chocolate", ""));
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Pense em um prato que goste");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // When the game starts
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resposta = JOptionPane.showConfirmDialog(this, "O prato que você pensou é massa?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resposta == JOptionPane.YES_OPTION) {
            advinhaComida(listaMassas);
        }
        else if(resposta == JOptionPane.NO_OPTION) {
            advinhaComida(listaSemMassa);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void advinhaComida(ListaComidas comida) {
        int count;
        int listSize = comida.getComidas().size() -1;
        // System.out.println(comida.getComidas().size() -1);
        
        for(count = listSize; count > 0; count--) {
            resposta = qualComida(comida, count);
            
            if(resposta == JOptionPane.YES_OPTION) {
                resposta = qualComida(comida, count);
                
                if(resposta == JOptionPane.YES_OPTION) {
                    correto();
                    break;
                }
                else if((resposta == JOptionPane.NO_OPTION) && (count == 0)) {
                    adicionaComida(comida, count);
                    break;
                }
            }
        }
        
        if(count == 0) {
            resposta = qualComida(comida, count);
            
            if(resposta == JOptionPane.YES_OPTION) {
                correto();
                return;
            }
            adicionaComida(comida, count);
        }
    }
    
    private int qualComida(ListaComidas comida, int count) {
        return JOptionPane.showConfirmDialog(this, 
                    "O prato que pensou é ".concat(comida.getComidas().get(count).getComida()).concat("?"),
                    "Confirma", JOptionPane.YES_NO_OPTION);
    }
    
    private void adicionaComida(ListaComidas comida, int ordem) {
        comida.getComidas().add(novaComida(comida, ordem));
    }
    
    private void correto() {
        JOptionPane.showMessageDialog(this, "Acertei de novo!", "Acertei!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private Comida novaComida(ListaComidas comida, int ordem) {
        String nomeComida = JOptionPane.showInputDialog(this, "Qual prato você pensou?", "Desisto", JOptionPane.QUESTION_MESSAGE);
        String atributoComida = JOptionPane.showInputDialog(this, 
                nomeComida.concat(" é ____________ mas ").concat(comida.getComidas().get(ordem).getComida()).concat(" não."),
                "Complete", JOptionPane.QUESTION_MESSAGE);
        
        Comida newComida = new Comida(nomeComida, atributoComida);
        return newComida;
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
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new myFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}