/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import form.FormLogin;
import nit.Osluskivac;

/**
 *
 * @author Nikola PC
 */
public class Start {
    
    public static void main(String[] args) {
        FormLogin frm = new FormLogin();
        frm.setVisible(true);
        new Osluskivac(frm).start();
    }
    
}
