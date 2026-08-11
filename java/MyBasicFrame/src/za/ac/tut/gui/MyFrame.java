
package za.ac.tut.gui;
//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author S. X Mabuza
 */
public class MyFrame extends JFrame implements ActionListener {
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    private JMenuItem loadItem ;
    private JMenuItem saveItem;
    private JMenuItem exitItem;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public MyFrame(){
        super("Basic Menu bar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        //Configuring menu bar++++++++++++++++++++++++++++
        menuBar = new JMenuBar();
        //Menus+++++++++++++++++++++++++++++++++++++
         fileMenu = new JMenu("Fle");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");
        
        //Menu items++++++++++++++++++++++++++++++
        loadItem = new JMenuItem("Load");
         saveItem = new JMenuItem("Save");
         exitItem = new JMenuItem("Exit");
        
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        
        //Configuring shortcuts++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.fileMenu.setMnemonic(KeyEvent.VK_F);  //Alt + f for Load
        this.editMenu.setMnemonic(KeyEvent.VK_E);  //Alt + e for save
        this.helpMenu.setMnemonic(KeyEvent.VK_H);  //Alt + h for exit
        this.loadItem.setMnemonic(KeyEvent.VK_L);  //l for exit
        this.saveItem.setMnemonic(KeyEvent.VK_S);  //s for exit
        this.exitItem.setMnemonic(KeyEvent.VK_E);  //e for exit
        
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
        if(e.getSource() == loadItem){
        System.out.println("You loaded a file");
        }
        if(e.getSource() == saveItem){
            System.out.println("You saved a file");
        }
        if(e.getSource() == exitItem){
            System.exit(0);
        }
    }
    
    public static void main(String[]args){
        new MyFrame(); 
    }
}
