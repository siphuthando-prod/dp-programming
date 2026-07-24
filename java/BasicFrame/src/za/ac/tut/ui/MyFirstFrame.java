
package za.ac.tut.ui;
//IMPORT STATEMENTS++++++++++++++++++++++++++++
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author S. X Mabuza
 */
public class MyFirstFrame extends JFrame{
    //CONSTRUCTOR++++++++++++++++++++++++
    public MyFirstFrame(){
        setTitle("My First GUI");
        setSize(200, 250);
        setDefaultLookAndFeelDecorated(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setForeground(Color.BLUE);
        setVisible(true);
    }
}
