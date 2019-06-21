/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import form.FormLogin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.Zahtev;
import transfer.util.Operacije;

/**
 *
 * @author user
 */
public class Osluskivac extends Thread{

    FormLogin frm;

    public Osluskivac(FormLogin frm) {
        this.frm = frm;
    }
    
    
    @Override
    public void run() {
        try {
            Socket soket = new Socket("localhost", 9000);
            ObjectInputStream in = new ObjectInputStream(soket.getInputStream());
            while (true) {
                Zahtev zahtev = (Zahtev) in.readObject();
                if (zahtev.getOperacija()== Operacije.GASENJE) {
                    frm.ugasi();
                    return;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Osluskivac.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Osluskivac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
