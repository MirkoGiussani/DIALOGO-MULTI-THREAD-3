/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogo.multi.thread.pkg3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mirko
 */
public class T implements Runnable {        //cambiare nome

    private char nome;  //il nome o è a oppure b
    ReadFile r = new ReadFile();

    T(char nome, ReadFile r) throws IOException {
        this.nome = nome;
        this.r = r;
    }

    public String getDialogoT(String d) {
        String str = d;
        String dialogo = str.substring(0, str.indexOf("^"));
        return dialogo;
    }

    public String getNomeD(String d) {
        String str = d;
        String dialogo = str.substring(str.indexOf("^") + 1);
        return dialogo;
    }

    public char getNome() {
        return nome;
    }

    public void esecuzione() throws IOException, InterruptedException {    //va aggiunta una gestione dell'eccezioni
        for (int i = 0; i <= 21; i++) {
            String dialogo = r.leggiDialogo();
            int pausa = r.leggiPausa();

            if (getNomeD(dialogo).equals("t1") && (getNome() == 'a')) {
                System.out.println("A: " + getDialogoT(dialogo));
                Thread.sleep(pausa / 2);             //????????????????????????????????????
                r.incrementa();
                Thread.sleep(pausa / 2);

            } else if (getNomeD(dialogo).equals("t2") && ((getNome() == 'b'))) {
                System.out.println("B: " + getDialogoT(dialogo));
                Thread.sleep(pausa / 2);
                r.incrementa();
                Thread.sleep(pausa / 2);
            } else {
                Thread.sleep(pausa + 50);   //+50 ????????????????????????????????????
            }

        }
    }

    @Override
    public void run() {
        try {
            esecuzione();
        } catch (IOException ex) {
            Logger.getLogger(T.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(T.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
