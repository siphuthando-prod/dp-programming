package za.ac.aop.m3;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import za.ac.aop.model.DetailRecord;
import za.ac.aop.processor.CallDetailProcessor; //ADD jar to resolve errors

/**
 *
 * @author LANGARM
 */
public class Mini3GUI extends JFrame{
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JPanel tab1;
    
    // TAB 1 Thingz
    private JLabel lblFileStatus;
    private JTextArea taContent;
    private JButton btnCalculateDurations;
    private JComboBox cmbProviders;
    private JCheckBox ckbFilter;
    private JButton btnFormatCountryCode;
    
    private CallDetailProcessor cdp; //add jar to resolve
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Mini3GUI() {
        //Configuring Frame+++++++++++++++++++++++++++++++++++++++++++++++++++
        setTitle("Mini Assignment 3 - AOP/AOR216D");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //Configuring menu bar++++++++++++++++++++++++++++++++++++++++++++++
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem openItem = new JMenuItem("Open File");
        openItem.addActionListener(new MenuItemOpenClickListener());
        JMenuItem saveItem = new JMenuItem("Save File");
        //saveItem.addActionListener(new MenuItemSaveClickListener());
        JMenuItem exitItem = new JMenuItem("Exit");
        //exitItem.addActionListener(new MenuItemExitClickListener());

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
        //Configuring Tab 1++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
    
    //Event handlers+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private class MenuItemOpenClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Configuring open menu item+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            JFileChooser chooser = new JFileChooser();
            StringBuilder builder = new StringBuilder();
            builder.append("Date\t\tStart Time\tEnd Time\tExtension\tPhone Number\tService Provider\n");
                        
            int approve = chooser.showOpenDialog(Mini3GUI.this);
            
            if(approve != JFileChooser.APPROVE_OPTION){
             return;   
            }
            
            File selectedFile = chooser.getSelectedFile();
                       
            int rowsRead = 0;
            int skippedRows = 0;
            
            try {
                BufferedReader bfReader = new BufferedReader(new FileReader(selectedFile));
                String line;
                
                while((line = bfReader.readLine())!= null){
                    if(line.trim().isEmpty()){
                        continue;
                    }
                    
                    String[] fields = line.split(",");
                    if(fields.length != 6){
                        skippedRows++;
                        continue;
                    }
                    
                    //Conversion++++++++++++++++++++++++++++++++++++++++++++++
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    
                    LocalDate date = LocalDate.parse(fields[0], formatter);
                    LocalTime startTime = LocalTime.parse(fields[1]);
                    LocalTime endTime = LocalTime.parse(fields[2]);
                    String phoneNumber = fields[4];
                    String provider = fields[5];
                    
                    try{
                        Long extension = Long.valueOf(fields[3]);
                        DetailRecord record = new DetailRecord();
                        record.setDate(date);
                        record.setStartTime(startTime);
                        record.setEndTime(endTime);
                        record.setExtension(extension);
                        record.setPhoneNumber(phoneNumber);
                        record.setProvider(provider);

                        cdp.addDR(record);
                        builder.append(date).append("\t")
                            .append(startTime).append("\t")
                            .append(endTime).append("\t")
                            .append(extension).append("\t\t")
                            .append(phoneNumber).append("\t")
                            .append(provider).append("\n");
                    
                    rowsRead++;
                    } catch(NumberFormatException eq){
                        skippedRows++;
                    }

                }   
                
                taContent.setText(builder.toString());
                   
                lblFileStatus.setForeground(Color.BLUE);
                lblFileStatus.setText(selectedFile + " loaded successfully: " + rowsRead + " rows read");
                
                if(skippedRows > 0){
                    JOptionPane.showMessageDialog(Mini3GUI.this, skippedRows + " malformed reord(s) were skipped");
                }
                
            } catch (IOException ex) {
                ex.getMessage();
            }
            
        }
    }
    
    private class BtnCalculateDurationsClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Configuring calculate duration button+++++++++++++++++++++++++++++++++++++++++++++
            int sum = 0;
            for(DetailRecord record: cdp.getRecords()){
                    //System.out.println("Start time: " + record.getStartTime());
                    //System.out.println("End time: " + record.getEndTime());
                if(record.getStartTime() == null || record.getEndTime() == null){
                    JOptionPane.showMessageDialog(Mini3GUI.this, "No record found", 
                                                                                            "No Records found",
                                                                                            JOptionPane.ERROR_MESSAGE);
                }
            
                 sum += record.getEndTime().toSecondOfDay() - record.getStartTime().toSecondOfDay();
            }
            JOptionPane.showMessageDialog(Mini3GUI.this, "The sum of all call logs: " + sum, 
                                                                                    "Total Call Duration",
                                                                                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class CkbFilterChangeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Configuring Service provider combo box+++++++++++++++++++++++++++++++++++++++++++++++++++
            int inputRead = cmbProviders.getSelectedIndex();
            
            StringBuilder builder = new StringBuilder();
            builder.append("Date\t\tStart Time\tEnd Time\tExtension\tPhone Number\tService Provider\n");
            
            boolean found = false;
            for (DetailRecord record : cdp.getRecords()) {
                if(ckbFilter.isSelected()){
                    if(record.getProvider() != null && record.getProvider().equalsIgnoreCase((String)cmbProviders.getItemAt(inputRead))){
                        builder.append(record.getDate()).append("\t") 
                                       .append(record.getStartTime()).append("\t")
                                    .append(record.getEndTime()).append("\t")
                            .append(record.getExtension()).append("\t\t")
                            .append(record.getPhoneNumber()).append("\t")
                            .append(record.getProvider()).append("\n");
                        //taContent.setText(builder.toString());
                        found = true;
                    } 
            }else {
                        builder.append(record.getDate()).append("\t")
                                     .append(record.getStartTime()).append("\t")
                                     .append(record.getEndTime()).append("\t")
                                     .append(record.getExtension()).append("\t\t")
                                     .append(record.getPhoneNumber()).append("\t")
                                      .append(record.getProvider()).append("\n");
                }
            }
                  
                if(ckbFilter.isSelected() && !found){
                        taContent.setText("No matching records found");
                } else{
                    taContent.setText(builder.toString());
                }
        }
     }
            
                
    private class BtnFormatNumbersClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Configuring number format button++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            StringBuilder builder = new StringBuilder();
            builder.append("Date\t\tStart Time\tEnd Time\tExtension\tPhone Number\tService Provider\n");
            builder.append("Updated list\n");
            
            for (DetailRecord record : cdp.getRecords()) {
                if(record.getPhoneNumber() != null){
                    if(record.getPhoneNumber().startsWith("0")){
                        String replacement = record.getPhoneNumber().replaceFirst("0", "+27");
                        record.setPhoneNumber(replacement);
                    }
                }
                 builder.append(record.getDate()).append("\t")
                                     .append(record.getStartTime()).append("\t")
                                     .append(record.getEndTime()).append("\t")
                                     .append(record.getExtension()).append("\t\t")
                                     .append(record.getPhoneNumber()).append("\t")
                                      .append(record.getProvider()).append("\n");
            }
            taContent.setText(builder.toString());
        }
        
    }
    
    /*private class MenuItemSaveClickListener implements ActionListener{

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
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Mini3GUI::new);
    }
}
