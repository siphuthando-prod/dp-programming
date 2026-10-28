
package simplewriterprogram;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;

/**
 *
 * @author Student
 */
public class SimpleWriterProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = null;
        
        JFileChooser jc = new JFileChooser();
        int option = jc.showOpenDialog(null);
        file = jc.getSelectedFile();
        
        if(option == JFileChooser.OPEN_DIALOG){            
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
                bw.write("S Mabuza");
                bw.newLine();
                bw.write("https://www.github.com/siphuthando-prod/");
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
