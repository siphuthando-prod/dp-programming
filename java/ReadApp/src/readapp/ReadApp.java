/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package readapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;

/**
 *
 * @author Student
 */
public class ReadApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFileChooser jc = new JFileChooser();
        int option = jc.showOpenDialog(null);
        
        if(option != JFileChooser.OPEN_DIALOG){
            System.out.println("Cancelled");
            return;
        }        
        File file = jc.getSelectedFile();
            
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line = br.readLine();
            
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
