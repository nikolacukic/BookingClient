/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.smestaj.model;

import domain.Smestaj;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sesija.Sesija;

/**
 *
 * @author user
 */
public class TableModelSmestaj extends AbstractTableModel{

    private List<Smestaj> smestaji;
    private final String header[] = new String[]{"Sifra smestaja", "Naziv smestaja", "Broj kreveta", "Cena prenocista", "Opis", "Prosecna ocena", "Vlasnik"};

    public TableModelSmestaj(List<Smestaj> smestaji) {
        this.smestaji = smestaji;
    }
    
    
    @Override
    public int getRowCount() {
        if(smestaji == null){
            return 0;
        }
        return smestaji.size();
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
         Smestaj smestaj = smestaji.get(rowIndex);
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
                return String.format("%.2f", smestaj.getProsecnaOcena());
            case 6:
                return smestaj.getVlasnik().getKorisnickoIme();
            default:
                return "n/a";
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        /*if(!smestaji.get(rowIndex).getVlasnik().getKorisnickoIme().equals(Sesija.getInstance().getKorisnik().getKorisnickoIme())){
            return false;
        }
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
            case 6:
                return false;
            default:
                return false;
        }*/
        return false;
    }
    
    public Smestaj getSmestaj(int rowIndex) {
        return smestaji.get(rowIndex);
    }

    public void setSmestaji(List<Smestaj> smestaji) {
        this.smestaji = smestaji;
    }
 
    
}
