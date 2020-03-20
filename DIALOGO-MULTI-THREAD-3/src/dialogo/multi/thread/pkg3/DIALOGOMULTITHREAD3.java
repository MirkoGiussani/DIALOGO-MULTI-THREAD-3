
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
        Thread T1 = new Thread(new T('a'));
        T1.start();
    }
    
}
