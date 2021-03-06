/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.ocena;

import domain.Klijent;
import domain.Ocena;
import domain.Rezervacija;
import domain.Smestaj;
import form.smestaj.FormListaSmestaja;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

/**
 *
 * @author user
 */
public class FormNovaOcena extends javax.swing.JDialog {

    private Smestaj s;
    /**
     * Creates new form FormNovaOcena
     */
    public FormNovaOcena(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public FormNovaOcena(java.awt.Dialog parent, boolean modal, Smestaj smestaj) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.s = smestaj;
        popuni();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNaziv = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        spinOcena = new javax.swing.JSpinner();
        lblOcena = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKomentar = new javax.swing.JTextArea();
        btnOceni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BuKing - Ocena smestaja");

        lblNaziv.setText("Naziv smestaja:");

        txtNaziv.setEnabled(false);

        spinOcena.setModel(new javax.swing.SpinnerNumberModel(3, 1, 5, 1));

        lblOcena.setText("Ocena:");

        lblOpis.setText("Komentar:");

        txtKomentar.setColumns(20);
        txtKomentar.setLineWrap(true);
        txtKomentar.setRows(5);
        jScrollPane1.setViewportView(txtKomentar);

        btnOceni.setText("Oceni");
        btnOceni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOceniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNaziv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOpis, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblOcena, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                            .addComponent(spinOcena, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)))
                    .addComponent(btnOceni, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinOcena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOcena))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOpis)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnOceni)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOceniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOceniActionPerformed
        int ocena = (Integer) spinOcena.getValue();
        String komentar = txtKomentar.getText();
        Klijent trenutni = (Klijent) Sesija.getInstance().getKorisnik();
        List<Ocena> pom = trenutni.getOcene();
        for(Ocena oc: pom){
            if(oc.getSmestaj().equals(s)){
                JOptionPane.showMessageDialog(this, "Vec ste ocenili ovaj smestaj!", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        List<Rezervacija> rez = trenutni.getRezervacije();
        for(Rezervacija r: rez){
            if(r.getSmestaj().equals(s) && r.getDatumDo().compareTo(new Date()) > 0){
                JOptionPane.showMessageDialog(this, "Vas boravak jos nije gotov! Molimo vas da ocenite smestaj po napustanju smestaja.", "Greska", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        try {
            Ocena o = Kontroler.getInstance().kreirajOcenu(s, ocena, komentar);

            JOptionPane.showMessageDialog(this.getParent(), "Sistem je zapamtio ocenu!", "Obavestenje", JOptionPane.INFORMATION_MESSAGE);
            s.getOcene().add(o);
            s.azurirajProsek();
            FormListaSmestaja mama = (FormListaSmestaja)this.getParent();
            mama.azurirajTabeluPosleOcene();
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnOceniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOceni;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblOcena;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JSpinner spinOcena;
    private javax.swing.JTextArea txtKomentar;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuni() {
        txtNaziv.setText(s.getNazivSmestaja());
    }
    
}
