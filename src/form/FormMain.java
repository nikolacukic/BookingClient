/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

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
        menuItemPretraziSmestaj = new javax.swing.JMenuItem();
        menuItemObrisiSmestaj = new javax.swing.JMenuItem();
        menuRezervacije = new javax.swing.JMenu();
        menuItemKreirajRezervaciju = new javax.swing.JMenuItem();
        menuItemPretraziRezervacije = new javax.swing.JMenuItem();
        menuItemOtkaziRezervaciju = new javax.swing.JMenuItem();
        menuOcene = new javax.swing.JMenu();
        menuItemKreirajOcenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDobrodosao.setText("Dobrodosao/la");

        lblImePrezime.setText("a");

        menuSmestaj.setText("Smestaj");

        menuItemKreirajSmestaj.setText("Kreiraj");
        menuSmestaj.add(menuItemKreirajSmestaj);

        menuItemIzmeniSmestaj.setText("Izmeni");
        menuSmestaj.add(menuItemIzmeniSmestaj);

        menuItemPretraziSmestaj.setText("Pretrazi");
        menuSmestaj.add(menuItemPretraziSmestaj);

        menuItemObrisiSmestaj.setText("Obrisi");
        menuSmestaj.add(menuItemObrisiSmestaj);

        menuBar.add(menuSmestaj);

        menuRezervacije.setText("Rezervacije");

        menuItemKreirajRezervaciju.setText("Kreiraj");
        menuRezervacije.add(menuItemKreirajRezervaciju);

        menuItemPretraziRezervacije.setText("Pretrazi");
        menuRezervacije.add(menuItemPretraziRezervacije);

        menuItemOtkaziRezervaciju.setText("Otkazi");
        menuRezervacije.add(menuItemOtkaziRezervaciju);

        menuBar.add(menuRezervacije);

        menuOcene.setText("Ocene");

        menuItemKreirajOcenu.setText("Oceni smestaj");
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
                .addContainerGap(242, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDobrodosao)
                    .addComponent(lblImePrezime))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDobrodosao;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemIzmeniSmestaj;
    private javax.swing.JMenuItem menuItemKreirajOcenu;
    private javax.swing.JMenuItem menuItemKreirajRezervaciju;
    private javax.swing.JMenuItem menuItemKreirajSmestaj;
    private javax.swing.JMenuItem menuItemObrisiSmestaj;
    private javax.swing.JMenuItem menuItemOtkaziRezervaciju;
    private javax.swing.JMenuItem menuItemPretraziRezervacije;
    private javax.swing.JMenuItem menuItemPretraziSmestaj;
    private javax.swing.JMenu menuOcene;
    private javax.swing.JMenu menuRezervacije;
    private javax.swing.JMenu menuSmestaj;
    // End of variables declaration//GEN-END:variables
}
