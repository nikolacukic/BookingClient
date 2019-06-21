/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import domain.Klijent;
import domain.VlasnikSmestaja;
import form.smestaj.FormListaSmestaja;
import form.smestaj.FormNoviSmestaj;
import form.util.ListaSmestajaFormMode;
import javax.swing.JDialog;
import sesija.Sesija;

/**
 *
 * @author Nikola PC
 */
public class FormMain extends javax.swing.JFrame {

    /**
     * Creates new form FormMain
     */
    public FormMain() {
        initComponents();
        popuniIme();
        omoguciMenije();
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

        lblDobrodosao = new javax.swing.JLabel();
        lblImePrezime = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuSmestaj = new javax.swing.JMenu();
        menuItemKreirajSmestaj = new javax.swing.JMenuItem();
        menuItemIzmeniSmestaj = new javax.swing.JMenuItem();
        menuItemObrisiSmestaj = new javax.swing.JMenuItem();
        menuItemPretraziSmestaj = new javax.swing.JMenuItem();
        menuRezervacije = new javax.swing.JMenu();
        menuItemRezervisi = new javax.swing.JMenuItem();
        menuItemPretraziRezervacije = new javax.swing.JMenuItem();
        menuItemOtkaziRezervaciju = new javax.swing.JMenuItem();
        menuOcene = new javax.swing.JMenu();
        menuItemKreirajOcenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BuKing - Glavni prozor");

        lblDobrodosao.setText("Dobrodosao/la");

        menuSmestaj.setText("Smestaj");

        menuItemKreirajSmestaj.setText("Kreiraj");
        menuItemKreirajSmestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKreirajSmestajActionPerformed(evt);
            }
        });
        menuSmestaj.add(menuItemKreirajSmestaj);

        menuItemIzmeniSmestaj.setText("Izmeni");
        menuItemIzmeniSmestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIzmeniSmestajActionPerformed(evt);
            }
        });
        menuSmestaj.add(menuItemIzmeniSmestaj);

        menuItemObrisiSmestaj.setText("Obrisi");
        menuItemObrisiSmestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemObrisiSmestajActionPerformed(evt);
            }
        });
        menuSmestaj.add(menuItemObrisiSmestaj);

        menuItemPretraziSmestaj.setText("Pretrazi");
        menuItemPretraziSmestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretraziSmestajActionPerformed(evt);
            }
        });
        menuSmestaj.add(menuItemPretraziSmestaj);

        menuBar.add(menuSmestaj);

        menuRezervacije.setText("Rezervacije");

        menuItemRezervisi.setText("Rezervisi");
        menuItemRezervisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemRezervisiActionPerformed(evt);
            }
        });
        menuRezervacije.add(menuItemRezervisi);

        menuItemPretraziRezervacije.setText("Pretraga rezervacije");
        menuItemPretraziRezervacije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretraziRezervacijeActionPerformed(evt);
            }
        });
        menuRezervacije.add(menuItemPretraziRezervacije);

        menuItemOtkaziRezervaciju.setText("Otkazi rezervaciju");
        menuRezervacije.add(menuItemOtkaziRezervaciju);

        menuBar.add(menuRezervacije);

        menuOcene.setText("Ocene");

        menuItemKreirajOcenu.setText("Oceni smestaj");
        menuItemKreirajOcenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemKreirajOcenuActionPerformed(evt);
            }
        });
        menuOcene.add(menuItemKreirajOcenu);

        menuBar.add(menuOcene);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblDobrodosao)
                .addGap(18, 18, 18)
                .addComponent(lblImePrezime)
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDobrodosao)
                    .addComponent(lblImePrezime))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemPretraziRezervacijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPretraziRezervacijeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemPretraziRezervacijeActionPerformed

    private void menuItemKreirajSmestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKreirajSmestajActionPerformed
        JDialog frm = new FormNoviSmestaj(this, true);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemKreirajSmestajActionPerformed

    private void menuItemIzmeniSmestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIzmeniSmestajActionPerformed
        JDialog frm = new FormListaSmestaja(this, true, ListaSmestajaFormMode.IZMENI);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemIzmeniSmestajActionPerformed

    private void menuItemObrisiSmestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemObrisiSmestajActionPerformed
        JDialog frm = new FormListaSmestaja(this, true, ListaSmestajaFormMode.OBRISI);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemObrisiSmestajActionPerformed

    private void menuItemPretraziSmestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPretraziSmestajActionPerformed
        JDialog frm = new FormListaSmestaja(this, true, ListaSmestajaFormMode.PRETRAZI);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemPretraziSmestajActionPerformed

    private void menuItemRezervisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemRezervisiActionPerformed
        JDialog frm = new FormListaSmestaja(this, true, ListaSmestajaFormMode.REZERVISI);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemRezervisiActionPerformed

    private void menuItemKreirajOcenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemKreirajOcenuActionPerformed
        JDialog frm = new FormListaSmestaja(this, true, ListaSmestajaFormMode.OCENI);
        frm.setVisible(true);
    }//GEN-LAST:event_menuItemKreirajOcenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDobrodosao;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemIzmeniSmestaj;
    private javax.swing.JMenuItem menuItemKreirajOcenu;
    private javax.swing.JMenuItem menuItemKreirajSmestaj;
    private javax.swing.JMenuItem menuItemObrisiSmestaj;
    private javax.swing.JMenuItem menuItemOtkaziRezervaciju;
    private javax.swing.JMenuItem menuItemPretraziRezervacije;
    private javax.swing.JMenuItem menuItemPretraziSmestaj;
    private javax.swing.JMenuItem menuItemRezervisi;
    private javax.swing.JMenu menuOcene;
    private javax.swing.JMenu menuRezervacije;
    private javax.swing.JMenu menuSmestaj;
    // End of variables declaration//GEN-END:variables

    private void popuniIme() {
        lblImePrezime.setText(Sesija.getInstance().getKorisnik().getImePrezime());
    }

    private void omoguciMenije() {
        if (Sesija.getInstance().getKorisnik() instanceof VlasnikSmestaja) {
            menuItemKreirajOcenu.setEnabled(false);
            menuItemOtkaziRezervaciju.setEnabled(false);
            menuItemRezervisi.setEnabled(false);
        } else if (Sesija.getInstance().getKorisnik() instanceof Klijent) {
            menuItemIzmeniSmestaj.setEnabled(false);
            menuItemKreirajSmestaj.setEnabled(false);
            menuItemObrisiSmestaj.setEnabled(false);
            menuItemPretraziRezervacije.setEnabled(false);
        }
    }
}
