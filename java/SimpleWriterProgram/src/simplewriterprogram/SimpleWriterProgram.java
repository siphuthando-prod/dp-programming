
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
                bw.write("Surname: Mabuza");
                bw.newLine();
                
                bw.write("Initials: S. X");
                bw.newLine();
                
                bw.write("GitHub: https://www.github.com/siphuthando-prod/");
                bw.newLine();
                
                bw.write("LinkedIn: https://www.linkedin.com/in/siphuthando-mabuza-228abb433/");
                bw.write("");
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
