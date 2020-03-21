
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
    
    ReadFile(){
        try {
            fr = new FileReader("file.txt");
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            System.out.println("File non trovato!");
        }
    }
    
    
    public String leggiDialogo() throws IOException{
        String str = br.readLine();
        String nome = str.substring(0, 2);
        String frase = str.substring(str.indexOf('"')+1, str.length()-1);
        return (frase + "^" + nome); 
    }
    
    public int leggiPausa() throws IOException{
        String str = br.readLine();
        String nome = str.substring(0, 2);
        int pausa = 0;
        if((nome.equals("t1") != true) && (nome.equals("t2") != true)){     //se non è uguale a t1 e t2
            pausa = Integer.parseInt(str);
        }
        return pausa;
    }
}
