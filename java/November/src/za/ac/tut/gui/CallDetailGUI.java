
package za.ac.tut.gui;

//Import statements+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import za.ac.aop.processor.CallDetailProcessor;

/**
 *
 * @author S. X Mabuza
 */
public class CallDetailGUI extends JFrame{
    
    //Private Members++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JLabel lblStatus;
    private JTextArea taRecords;
    private JComboBox<String> cmbProvider;
    private JCheckBox ckbApplyFilter;
    private JButton btnShowDurations;
    private JButton btnTotalDuration;
    private JButton btnMostCalls;
    private JButton btnLongestCall;
    
    private CallDetailProcessor processor;
    
    //Constructor+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public CallDetailGUI(){
        //Configuring Frame appearence++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        super("November Call Detail Analyser");
        this.setSize(980, 620);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Configuring menu bar++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JMenuBar mb =new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem miOpen = new JMenuItem("Open");
        JMenuItem miExit = new JMenuItem("Exit");
        menuFile.add(miOpen);
        menuFile.add(miExit);
        mb.add(menuFile);
        
        this.setVisible(true);
    }
    
    //Main method+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new CallDetailGUI();
    }
    
}
