/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.util;

import form.FormRegistracija;

/**
 *
 * @author Nikola PC
 */
public class FormIzbor extends javax.swing.JDialog {

    /**
     * Creates new form FormaIzbor
     */
    public FormIzbor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPitanje = new javax.swing.JLabel();
        btnKlijent = new javax.swing.JButton();
        btnVlasnicki = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BuKing - Izbor tipa naloga");

        lblPitanje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPitanje.setText("Koji tip naloga zelite da napravite?");

        btnKlijent.setText("Klijentski");
        btnKlijent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlijentActionPerformed(evt);
            }
        });

        btnVlasnicki.setText("Vlasnicki");
        btnVlasnicki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVlasnickiActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKlijent)
                        .addGap(18, 18, 18)
                        .addComponent(btnVlasnicki)
                        .addGap(18, 18, 18)
                        .addComponent(btnOdustani))
                    .addComponent(lblPitanje))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblPitanje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKlijent)
                    .addComponent(btnVlasnicki)
                    .addComponent(btnOdustani))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKlijentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlijentActionPerformed
        FormRegistracija frm = new FormRegistracija(false);
        frm.setVisible(true);
        getParent().setVisible(false);
    }//GEN-LAST:event_btnKlijentActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnVlasnickiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVlasnickiActionPerformed
        FormRegistracija frm = new FormRegistracija(true);
        frm.setVisible(true);
        getParent().setVisible(false);
    }//GEN-LAST:event_btnVlasnickiActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKlijent;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnVlasnicki;
    private javax.swing.JLabel lblPitanje;
    // End of variables declaration//GEN-END:variables
}