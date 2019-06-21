/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.rezervacija.model;

import domain.Rezervacija;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class TableModelRezervacija extends AbstractTableModel {

    private List<Rezervacija> rezervacije;
    private final String header[] = new String[]{"Naziv smestaja", "Datum dolaska", "Datum odlaska", "Ukupna zarada", "Gost"};

    public TableModelRezervacija(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @Override
    public int getRowCount() {
        if (rezervacije == null) {
            return 0;
        }
        return rezervacije.size();
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
        Rezervacija r = rezervacije.get(rowIndex);
        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        switch (columnIndex) {
            case 0:
                return r.getSmestaj().getNazivSmestaja();
            case 1:
                String datum = df.format(r.getDatumOd());
                return datum;
            case 2:
                String datum2 = df.format(r.getDatumDo());
                return datum2;
            case 3:
                return r.getUkupanIznos();
            case 4:
                return r.getKlijent().getKorisnickoIme();
            default:
                return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Rezervacija getRezervacija(int rowIndex) {
        return rezervacije.get(rowIndex);
    }

    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    
    
}
