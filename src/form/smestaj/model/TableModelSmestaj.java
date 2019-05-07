/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.smestaj.model;

import domain.Smestaj;
import domain.VlasnikSmestaja;
import javax.swing.table.AbstractTableModel;
import sesija.Sesija;

/**
 *
 * @author user
 */
public class TableModelSmestaj extends AbstractTableModel{

    private VlasnikSmestaja vlasnik;
    private String header[] = new String[]{"Sifra smestaja", "Naziv smestaja", "Broj kreveta", "Cena prenocista", "Opis", "Prosecna ocena"};

    public TableModelSmestaj() {
        this.vlasnik = (VlasnikSmestaja)Sesija.getInstance().getKorisnik();
    }
    
    
    @Override
    public int getRowCount() {
        return vlasnik.getSmestaji().size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Smestaj smestaj = vlasnik.getSmestaji().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return smestaj.getSifraSmestaja();
            case 1:
                return smestaj.getNazivSmestaja();
            case 2:
                return smestaj.getBrojKreveta();
            case 3:
                return smestaj.getCenaPrenocista();
            case 4:
                return smestaj.getOpis();
            case 5:
                return smestaj.getProsecnaOcena();
            default:
                return "n/a";
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return false;
            default:
                return false;
        }
    }
    
}
