
package za.ac.tut.gui;

//Import statements+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
        
        //Configuring status label+++++++++++++++++++++++++++++++++++++++++++++
        this.lblStatus = new JLabel("No call-detail file loaded");
        this.lblStatus.setForeground(Color.red);
        
        //Configuring text area+++++++++++++++++++++++++++++++++++++
        this.taRecords = new JTextArea(22, 85);
        this.taRecords.setEditable(false);
        this.taRecords.setTabSize(12);
        this.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(this.taRecords);
        
        //Configuring appearence of button+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        String[] providers = {"All Providers", "Vodacom", "Telkom", "MTN", "CellC", "ECN", "FNB"};
        
        this.cmbProvider = new JComboBox<>(providers);
        this.ckbApplyFilter = new JCheckBox("Apply Filter");
        this.btnShowDurations = new JButton("Show Durations");
        this.btnTotalDuration = new JButton("Total Durations");
        this.btnMostCalls = new JButton("Most Call by Extension");
        this.btnLongestCall = new JButton("Longest Call");
        
        //Configuring filter panel+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel filterPan = new JPanel();
        filterPan.add(this.cmbProvider);
        filterPan.add(this.ckbApplyFilter);
        
        JPanel buttonPn1 = new JPanel();
        buttonPn1.add(this.btnShowDurations);
        buttonPn1.add(this.btnTotalDuration);
        buttonPn1.add(this.btnMostCalls);
        buttonPn1.add(this.btnLongestCall);
        
        this.setVisible(true);
    }
    
    //Main method+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new CallDetailGUI();
    }
    
}
