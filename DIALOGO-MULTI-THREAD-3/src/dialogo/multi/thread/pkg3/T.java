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

    @Override
    public void run() {
        try {
            ReadFile r = new ReadFile();
            r.leggi();
        } catch (IOException ex) {
            Logger.getLogger(T.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
