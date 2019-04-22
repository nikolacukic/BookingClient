/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Odgovor;
import transfer.Zahtev;

/**
 *
 * @author Nikola PC
 */
public class Komunikacija {
    private static Komunikacija instance;
    private Socket socket;

    private Komunikacija() throws IOException {
        socket = new Socket("localhost", 9000);
    }

    public static Komunikacija getInstance() throws IOException {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void saljiZahtev (Zahtev zahtev) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(zahtev);
    }

    public Odgovor citajOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        return (Odgovor) inSocket.readObject();
    }
 
}
