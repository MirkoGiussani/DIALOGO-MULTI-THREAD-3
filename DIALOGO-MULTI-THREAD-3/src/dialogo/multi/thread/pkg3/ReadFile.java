
package dialogo.multi.thread.pkg3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mirko
 */
public class ReadFile {
    
    FileReader fr;
    BufferedReader br;
    String str = "";
    
    ReadFile() throws IOException{
        try {
            fr = new FileReader("file.txt");
            br = new BufferedReader(fr);
            incrementaDialogo();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato!");
        }
    }
    
    
    public synchronized String leggiDialogo() throws IOException{
        String nome = str.substring(0, 2);
        String frase = str.substring(str.indexOf('"')+1, str.length()-1);
        return (frase + "^" + nome); 
    }
    
    public void incrementaDialogo() throws IOException{
        str = br.readLine();
    }
        
    
    public synchronized int leggiPausa() throws IOException{
        String nome = str.substring(0, 2);
        if((nome.equals("t1") != true) && (nome.equals("t2") != true)){     //se non è uguale a t1 e t2
            return Integer.parseInt(str);
        }
        return 0;
    }
}
