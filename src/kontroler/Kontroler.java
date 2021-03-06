/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import komunikacija.Komunikacija;
import domain.Klijent;
import domain.Korisnik;
import domain.Ocena;
import domain.Rezervacija;
import domain.Smestaj;
import domain.VlasnikSmestaja;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import sesija.Sesija;
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

    public Korisnik login(String username, String password, boolean jesteVlasnik) throws Exception {
        Korisnik k;
        if (jesteVlasnik) {
            k = new VlasnikSmestaja();
            k.setKorisnickoIme(username);
            k.setLozinka(password);
        } else {
            k = new Klijent();
            k.setKorisnickoIme(username);
            k.setLozinka(password);
        }
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, k);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Korisnik) odgovor.getPodaci();
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
            VlasnikSmestaja vlasnik = new VlasnikSmestaja(licnaKarta, telefon, username, password, ime + " " + prezime, JMBG, email);
            Zahtev zahtev = new Zahtev(Operacije.REGISTRACIJA, vlasnik);
            Komunikacija.getInstance().saljiZahtev(zahtev);
            Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
            if (odgovor.getStatus() == StatusOdgovora.OK) {
                return (Korisnik) odgovor.getPodaci();
            }
            Exception ex = (Exception) odgovor.getError();
            throw ex;
        } else {
            Klijent k = new Klijent(0, username, password, ime + " " + prezime, JMBG, email);
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

    public Smestaj kreirajSmestaj(String naziv, String opis, int brKreveta, double cena) throws Exception {
        Smestaj s = new Smestaj();
        s.setBrojKreveta(brKreveta);
        s.setCenaPrenocista(cena);
        s.setNazivSmestaja(naziv);
        s.setOpis(opis);
        s.setVlasnik((VlasnikSmestaja) Sesija.getInstance().getKorisnik());
        Zahtev zahtev = new Zahtev(Operacije.SMESTAJ_KREIRANJE, s);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Smestaj) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public LinkedList<Smestaj> vratiSveSmestaje(String kriterijum) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.SMESTAJ_UCITAVANJE, kriterijum);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        return (LinkedList<Smestaj>) odgovor.getPodaci();
    }

    public Smestaj izmeniSmestaj(Smestaj s) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.SMESTAJ_IZMENA, s);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Smestaj) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public Smestaj obrisiSmestaj(Smestaj s) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.SMESTAJ_BRISANJE, s);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Smestaj) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public Rezervacija kreirajRezervaciju(Smestaj s, Klijent k, Date datumOd, Date datumDo, double ukupanIznos) throws Exception {
        Rezervacija r = new Rezervacija(s, k, datumOd, datumDo, ukupanIznos);
        Zahtev zahtev = new Zahtev(Operacije.REZERVACIJA_KREIRANJE, r);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Rezervacija) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public Ocena kreirajOcenu(Smestaj s, int ocena, String komentar) throws Exception {
        Ocena o = new Ocena((Klijent) Sesija.getInstance().getKorisnik(), s, ocena, komentar);
        Zahtev zahtev = new Zahtev(Operacije.OCENA_KREIRANJE, o);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Ocena) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public List<Rezervacija> vratiSveRezervacije(Rezervacija pom) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.REZERVACIJA_UCITAVANJE, pom);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (LinkedList<Rezervacija>) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }

    public Rezervacija otkaziRezervaciju(Rezervacija r) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.REZERVACIJA_BRISANJE, r);
        Komunikacija.getInstance().saljiZahtev(zahtev);
        Odgovor odgovor = Komunikacija.getInstance().citajOdgovor();
        if (odgovor.getStatus() == StatusOdgovora.OK) {
            return (Rezervacija) odgovor.getPodaci();
        }
        Exception ex = (Exception) odgovor.getError();
        throw ex;
    }
}
