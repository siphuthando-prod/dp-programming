package za.ac.aop.m3;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import za.ac.aop.processor.CallDetailProcessor; //ADD jar to resolve errors

/**
 *
 * @author LANGARM
 */
public class Mini3GUI extends JFrame{
    private JPanel tab1;
    
    // TAB 1 Thingz
    private JLabel lblFileStatus;
    private JTextArea taContent;
    private JButton btnCalculateDurations;
    private JComboBox cmbProviders;
    private JCheckBox ckbFilter;
    private JButton btnFormatCountryCode;
    
    private CallDetailProcessor cdp; //add jar to resolve

    public Mini3GUI() {
        setTitle("Mini Assignment 3 - AOP/AOR216D");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open File");
        openItem.addActionListener(new MenuItemOpenClickListener());
        JMenuItem saveItem = new JMenuItem("Save File");
        saveItem.addActionListener(new MenuItemSaveClickListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new MenuItemExitClickListener());

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        Question1Tab(); //initializing tab2 in here

        // Add tabs
        tabbedPane.addTab("Q1", tab1);

        add(tabbedPane);

        setVisible(true);
    }
    
    //TAB 1 => Complete the following Event Listeners
    private void Question1Tab() {
        tab1 = new JPanel(new BorderLayout());
        taContent = new JTextArea(10, 30);
        taContent.setFont(new Font("Arial", Font.BOLD, 12));
        taContent.setEditable(false);
        taContent.setTabSize(4);
        JScrollPane scrollPane = new JScrollPane(taContent);
        
        lblFileStatus = new JLabel("File not read yet");
        lblFileStatus.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblFileStatus.setForeground(Color.red);
        
        JPanel topPnl = new JPanel();
        topPnl.setBorder(BorderFactory.createTitledBorder("File Operation"));
        topPnl.add(lblFileStatus);
        
        JPanel bottomPnl = new JPanel(new GridLayout(1, 3, 5, 5));
        bottomPnl.setBorder(BorderFactory.createTitledBorder("Functionality"));
        
        btnCalculateDurations = new JButton("Calculate sum of durations");
        btnCalculateDurations.setBackground(Color.decode("#ccafca"));
        btnCalculateDurations.addActionListener(new BtnCalculateDurationsClickListener());
        
        String[] providers = new String[]{"Choose Provider", "Vodacom", "MTN", "CellC", "Telkom", "FNB", "ECN"};
        cmbProviders = new JComboBox(providers);
        cmbProviders.setBackground(Color.decode("#afb6cc"));
        cmbProviders.setSelectedIndex(0);
        
        ckbFilter = new JCheckBox("Apply Filter");
        ckbFilter.setBackground(Color.decode("#c0ccaf"));
        ckbFilter.addActionListener(new CkbFilterChangeListener());
        
        btnFormatCountryCode = new JButton("Format Numbers (+27)");
        btnFormatCountryCode.setBackground(Color.decode("#cccbaf"));
        btnFormatCountryCode.addActionListener(new BtnFormatNumbersClickListener());
        
        bottomPnl.add(btnCalculateDurations); bottomPnl.add(cmbProviders);
        bottomPnl.add(ckbFilter); bottomPnl.add(btnFormatCountryCode);
        
        tab1.add(topPnl, BorderLayout.NORTH);
        tab1.add(scrollPane, BorderLayout.CENTER);
        tab1.add(bottomPnl, BorderLayout.SOUTH);
        
        cdp = new CallDetailProcessor();
    }
    
    private class MenuItemOpenClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Write code here
            
        }
    }
    
    private class BtnCalculateDurationsClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Write code here
            
        }
    }
    
    private class CkbFilterChangeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Write code here

        }
        
    }
    
    private class BtnFormatNumbersClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Write code here
            
        }
        
    }
    
    private class MenuItemSaveClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Write code here
            
        }
        
    }
    
    private class MenuItemExitClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Write code here
            
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Mini3GUI::new);
    }
}
