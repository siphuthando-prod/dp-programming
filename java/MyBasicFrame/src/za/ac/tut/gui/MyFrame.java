
package za.ac.tut.gui;
//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author S. X Mabuza
 */
public class MyFrame extends JFrame implements ActionListener {
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public MyFrame(){
        super("Basic Menu bar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        
        this.setVisible(true);
    }
    
    //PUBLIC mETHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
