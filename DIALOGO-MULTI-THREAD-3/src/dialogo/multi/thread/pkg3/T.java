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
    FileReader fr;
    BufferedReader br;
    
    T(char nome) throws IOException {
        this.nome = nome;
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
    
    public char getNome(){
        return nome;
    }
    
    public void esecuzione() throws IOException, InterruptedException {    //va aggiunta una gestione dell'eccezioni
        ReadFile r = new ReadFile();
        for (int i = 0; i < 22; i++) {  //44 numero righe del file ma dato che va già a capo con readLine allora 44/2 = 22
            String dialogo = r.leggiDialogo();
            int pausa = r.leggiPausa();
            if (getNomeD(dialogo).equals("t1")) {
                if(getNome()=='a'){
                    System.out.println("A: " + getDialogoT(dialogo));
                }
            } else if(getNomeD(dialogo).equals("t2")){
               if(getNome()=='b'){
                    System.out.println("B: " + getDialogoT(dialogo));
                }
            }
            
            Thread.sleep(pausa);
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
