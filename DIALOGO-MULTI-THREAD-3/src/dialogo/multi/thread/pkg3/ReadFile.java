
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
    
    public void leggi() throws IOException{
        String str = br.readLine();
        String taglio = str.substring(0, 2);
        String prova = str.substring(4,8);
        System.out.println("prova = " + prova);
        if(prova == "Ciao"){
            System.out.println("prova");
        }else{
            System.out.println("prova è diversa da ciao");
        }
        System.out.println("taglio = " + taglio);
        if (taglio == "t1"){
            System.out.println("taglio è t1");
        }else {
            System.out.println("taglio è diverso da t1"); 
        }
    }
}
