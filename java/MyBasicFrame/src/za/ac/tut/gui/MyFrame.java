
package za.ac.tut.gui;
//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
        //Configuring menu bar++++++++++++++++++++++++++++
        JMenuBar menuBar = new JMenuBar();
        //Menus+++++++++++++++++++++++++++++++++++++
        JMenu fileMenu = new JMenu("Fle");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        
        //Menu items++++++++++++++++++++++++++++++
        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        
         fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }
    
    //PUBLIC mETHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
    
    public static void main(String[]args){
        new MyFrame(); 
    }
}
