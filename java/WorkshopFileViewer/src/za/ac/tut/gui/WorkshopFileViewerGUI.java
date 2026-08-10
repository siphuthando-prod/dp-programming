
package za.ac.tut.gui;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
        //registerListeners();
        
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
        
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    private void createInterface() {
        //Configuring the interface++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.lblStatus = new JLabel("No workshop file loaded");
        this.lblStatus.setForeground(Color.RED);
        
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        statusPanel.setBorder(BorderFactory.createTitledBorder("File Status"));
        statusPanel.add(this.lblStatus);
        
        this.taWorkshops = new JTextArea(18, 60);
        this.taWorkshops.setEditable(false);
        this.taWorkshops.setTabSize(18);
        this.taWorkshops.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JScrollPane scrollPane = new JScrollPane(this.taWorkshops);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Workshop Records"));
        
        this.setLayout(new BorderLayout(8, 8));
        this.add(statusPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    /*private void registerListeners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
    
    //MAIN METHOD+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new WorkshopFileViewerGUI();
    }
}
