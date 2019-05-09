/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import komunikacija.Komunikacija;
import domain.Klijent;
import domain.Korisnik;
import domain.VlasnikSmestaja;
import java.util.HashMap;
import transfer.Odgovor;
import transfer.Zahtev;
import transfer.util.Operacije;
import transfer.util.StatusOdgovora;

/**
 *
 * @author Nikola PC
 */
public class Kontroler {

    private static Kontroler instance;

    private Kontroler() {

    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public Klijent loginKlijent(String username, String password) throws Exception {
        Klijent klijent = new Klijent();
        klijent.setKorisnickoIme(username);
        klijent.setLozinka(password);
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, klijent);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Klijent) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public VlasnikSmestaja loginVlasnik(String username, String password) throws Exception {
        VlasnikSmestaja vlasnik = new VlasnikSmestaja();
        vlasnik.setKorisnickoIme(username);
        vlasnik.setLozinka(password);
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, vlasnik);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (VlasnikSmestaja) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public Korisnik registracija(HashMap<String, String> recnik) throws Exception {
        String ime = recnik.get("ime");
        String prezime = recnik.get("prezime");
        String JMBG = recnik.get("JMBG");
        String username = recnik.get("username");
        String password = recnik.get("password");
        String email = recnik.get("email");
        String licnaKarta = recnik.get("licnaKarta");
        String telefon = recnik.get("telefon");
        if (!licnaKarta.isEmpty()) {
            VlasnikSmestaja vlasnik = new VlasnikSmestaja(licnaKarta, telefon, 0, username, password, ime + " " + prezime, JMBG, email);
            Zahtev zahtev = new Zahtev(Operacije.REGISTRACIJA, vlasnik);
            Komunikacija.getInstance().saljiZahtev(zahtev);
            Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
            if (odgovor.getStatus() == StatusOdgovora.OK) {
                return (Korisnik) odgovor.getPodaci();
            }
            Exception ex = (Exception) odgovor.getError();
            throw ex;
        } else {
            Klijent k = new Klijent(0, 0, username, password, ime + " " + prezime, JMBG, email);
            Zahtev zahtev = new Zahtev(Operacije.REGISTRACIJA, k);
            Komunikacija.getInstance().saljiZahtev(zahtev);
            Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
            if (odgovor.getStatus() == StatusOdgovora.OK) {
                return (Korisnik) odgovor.getPodaci();
            }
            Exception ex = (Exception) odgovor.getError();
            throw ex;
        }
    }
}
