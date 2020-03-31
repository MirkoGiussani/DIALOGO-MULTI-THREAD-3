
package dialogo.multi.thread.pkg3;

import java.io.IOException;

/**
 *
 * @author Mirko
 */
public class DIALOGOMULTITHREAD3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ReadFile r = new ReadFile("file.txt");
        
        Thread T1 = new Thread(new T('a', r));
        T1.start();
        Thread T2 = new Thread(new T('b', r));
        T2.start();
    }
    
}
