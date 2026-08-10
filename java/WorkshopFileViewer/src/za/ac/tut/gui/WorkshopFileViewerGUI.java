
package za.ac.tut.gui;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author S. X Mabuza
 */
public class WorkshopFileViewerGUI extends JFrame{
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JMenuItem miOpen;
    private JMenuItem miExit;
    private JLabel lblStatus;
    private JTextArea taWorkshops;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public WorkshopFileViewerGUI(){
        //Configuring the frame++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        super("Campus Workshop File Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMenu();
        createInterface();
        registerListeners();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //PRIVATE METHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void createMenu() {
        //Configuring menu++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        this.miOpen = new JMenuItem("Open");
        this.miExit = new JMenuItem("Exit");
        
        fileMenu.add(this.miOpen);
        fileMenu.addSeparator();
        fileMenu.add(this.miExit);
    }

    private void createInterface() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void registerListeners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
