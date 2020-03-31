
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
    
    //FileReader fr;
    private BufferedReader br;
    private String strDialogo = "";
    private String strPausa = "";
    private int line;
    
    ReadFile(String fileNome) throws IOException{
        try {
            br = new BufferedReader(new FileReader(fileNome));
            line = contatoreLinee();
            br.close();
            br = new BufferedReader(new FileReader(fileNome));
            incrementa();
            //contatoreLinee();
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato!");
        }
    }
    
    public int contatoreLinee(){
        String s;
        int i = 1;
        try{
            s = br.readLine();
            while(s != null){
                s = br.readLine();
                i++;
            }
        } catch (IOException ex){
            System.out.println("IOExc in contatore linee");
        }
        System.out.println("Linea contatore catch " + i);
        return i-1;
    }
    
    public int getLinea(){
        return this.line;
    }
    
    public synchronized String leggiDialogo() throws IOException{
        
        String nome = strDialogo.substring(0, 2);
        String frase = strDialogo.substring(strDialogo.indexOf('"')+1, strDialogo.length()-1);
        return (frase + "^" + nome);
    }
    
    public void incrementa() throws IOException{
        strDialogo = br.readLine();
        strPausa = br.readLine();
    }
        
    
    public synchronized int leggiPausa() throws IOException{
        String nome = strPausa.substring(0, 2);
        if((nome.equals("t1") != true) && (nome.equals("t2") != true)){     //se non è uguale a t1 e t2
            return Integer.parseInt(strPausa);
        }
        return 0;
    }
}
