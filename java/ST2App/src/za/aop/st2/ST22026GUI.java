package za.aop.st2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.SwingWorker;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author LANGARM
 */
public class ST22026GUI extends JFrame {

    private JPanel tab1, tab2;

    // TAB 1 Thingz
    private JTextArea taInput, taOutput;
    private JButton btnMapWordVowel;

    //TAB 2 Thingz
    private JButton btnConnect, btnViewRecords;
    private JLabel lblStatus;
    private DefaultTableModel tblData; //FOR MANAGING DATA IN THE TABLE
    private JButton btnResetEquipCondition, btnAddEquipment;

    public ST22026GUI() {
        setTitle("ST2 2026 - AOP216D/AOR216D");
        setMinimumSize(new Dimension(570, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Color.decode("#bac244"));

        Question1Tab(); //initializing tab1 in here

        Question2Tab(); //Initializing tab2 in here

        // Add tabs
        tabbedPane.addTab("Q1", tab1);
        tabbedPane.addTab("Q2", tab2);
        tabbedPane.addChangeListener((ChangeEvent e) -> {
            if (tabbedPane.getSelectedIndex() == 1) { //Second tab
                SwingUtilities.invokeLater(() -> {
                    setSize(750, 560);
                    revalidate();
                    repaint();
                });
            } else {
                setSize(570, 500);
                revalidate();
                repaint();
            }
        });

        add(tabbedPane);

        setVisible(true);
    }

    private void Question1Tab() {
        tab1 = new JPanel(new BorderLayout());
        String sampleText = "The 2:00 AM video audio queue is absolute chaos. Our ongoing online area assessment has a unique "
                + "dilemma as an immediate visual error ruins our entire academic presentation. "
                + "Our naive cohort is surviving solely on absolute panic, audio feeds, and ideas "
                + "as we evaluate the issue. If we actually survive this quiet structural routine, "
                + "every single one of us deserves an ideal route, an easy A grade "
                + "and a 12-hour nap!";


        JPanel pnlArea = new JPanel(new GridLayout(1, 2));
        pnlArea.setBorder(new TitledBorder(new LineBorder(Color.decode("#bac444"), 3), "Text Areas"));

        taInput = new JTextArea(6, 35);
        taInput.setFont(new Font("Arial", Font.PLAIN, 16));
        taInput.setLineWrap(true);
        taInput.setWrapStyleWord(true);
        taInput.setText(sampleText);
        taInput.setEditable(false);
        JScrollPane inputScroll = new JScrollPane(taInput);

        taOutput = new JTextArea(6, 35);
        taOutput.setFont(new Font("Monospaced", Font.BOLD, 12));
        taOutput.setWrapStyleWord(true);
        JScrollPane outputScroll = new JScrollPane(taOutput);

        pnlArea.add(inputScroll);
        pnlArea.add(outputScroll);

        btnMapWordVowel = new JButton("Flag and Map Heavy-Vowel Words ");
        btnMapWordVowel.setBackground(Color.decode("#cdcfb0"));
        btnMapWordVowel.setBorder(BorderFactory.createRaisedBevelBorder());
        btnMapWordVowel.addActionListener(new BtnFlagHeavyVowelWordClickListener());

        tab1.add(pnlArea, BorderLayout.CENTER);
        tab1.add(btnMapWordVowel, BorderLayout.SOUTH);
    }

    //TOTAL [16]
    private class BtnFlagHeavyVowelWordClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //WRITE YOUR CODE HERE
            String par = taInput.getText().trim().
                    toLowerCase().replaceAll("[^a-z0-9:-]", " ");
            String[] tokens = par.split("\\s+");
            
            Map<String, Boolean> words = new HashMap<>();
            
            for (String token : tokens) {
                int vowels = 0;
                int consonants = 0;
                
                for (int k = 0; k < token.length(); k++) {
                    char ch = token.charAt(k);
                    
                    if(Character.isLetter(ch)){
                        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                            vowels++;
                        } else{
                            consonants++;
                        }
                    }
                }
                
                if(vowels > consonants){
                    words.put(token, true);
                } else{
                    words.put(token, false);
                }
            }
            
            for (Map.Entry<String, Boolean> entry : words.entrySet()) {
                String key = entry.getKey();
                Boolean value = entry.getValue();
                
                taOutput.append(key + " ==> " + value + "\n");
            }
        }
    }

    private void Question2Tab() {
        tab2 = new JPanel(new BorderLayout());
        JLabel lblHeading = new JLabel("Lab Equipment App");
        lblHeading.setFont(new Font("Monospace", Font.BOLD, 19));
        lblHeading.setHorizontalAlignment(JLabel.CENTER);

        JPanel pPnl = new JPanel(new BorderLayout());
        pPnl.setBorder(new TitledBorder("Database"));

        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnConnect = new JButton("Connect");
        lblStatus = new JLabel("STATUS: Not connected");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
        row.add(btnConnect); row.add(lblStatus);

        JPanel topPnl = new JPanel(new BorderLayout());
        topPnl.add(lblHeading, BorderLayout.NORTH);
        topPnl.add(row, BorderLayout.CENTER);

        tblData = new DefaultTableModel(
                new String[]{
                    "Equipment ID",
                    "Name",
                    "Department",
                    "Purchase Date",
                    "Condition",
                    "Is In-Use",
                    "Price"},
                0);
        
        JTable tbl = new JTable(tblData);
        tbl.getTableHeader().setBackground(Color.decode("#b6b8a2"));
        tbl.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(155);
        tbl.getTableHeader().setForeground(Color.white);
        tbl.getTableHeader().setOpaque(true);
        tbl.setColumnSelectionAllowed(false);
        tbl.setRowSelectionAllowed(true);
        JScrollPane sp = new JScrollPane(tbl);

        btnViewRecords = new JButton("View Equipments");
        btnViewRecords.setEnabled(false);
        btnResetEquipCondition = new JButton("Reset Condition of Informatics Dept");
        btnResetEquipCondition.setEnabled(false);
        btnAddEquipment = new JButton("Add Equipment");
        btnAddEquipment.setEnabled(false);
        JPanel row2 = new JPanel();
        row2.add(btnViewRecords); row2.add(btnResetEquipCondition); row2.add(btnAddEquipment);

        pPnl.add(sp, BorderLayout.CENTER);
        pPnl.add(row2, BorderLayout.SOUTH);

        //ACTION LISTENERS
        btnConnect.addActionListener(new BtnConnectListener());
        btnViewRecords.addActionListener(new BtnDisplayListener());
        btnResetEquipCondition.addActionListener(new BtnResetListener());
        btnAddEquipment.addActionListener(new BtnAddListener());

        tab2.add(topPnl, BorderLayout.NORTH);
        tab2.add(pPnl, BorderLayout.CENTER);
    }

    private Connection conn; //Use this connection
    
    //TOTAL [6]
    private class BtnConnectListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new SwingWorker<Void, Void>(){
                @Override
                protected Void doInBackground() throws Exception {
                    //WRITE YOUR CODE HERE
                    
                    
                    
                    return null;
                }
                
            }.execute();
        }
    }
    
    //TOTAL [8]
    private class BtnDisplayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //WRITE YOUR CODE HERE
            
            
        }

    }
    
    //TOTAL [10]
    private class BtnResetListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //WRITE YOUR CODE HERE
            
            
        }
    }
    
    //TOTAL [12]
    private class BtnAddListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //WRITE YOUR CODE HERE
            
            
            
        }
    }

    //PROVIDED
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ST22026GUI::new);
    }
}
