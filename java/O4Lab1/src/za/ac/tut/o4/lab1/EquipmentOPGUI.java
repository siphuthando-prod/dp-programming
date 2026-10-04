package za.ac.tut.o4.lab1;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main GUI class for the Equipment Basic Operations Lab application. Recreates
 * the user interface shown in the screenshot using Java Swing components and
 * layouts.
 */
public class EquipmentOPGUI extends JFrame {

    // Components requiring access outside the constructor for listeners
    private JButton btnConnect;
    private JLabel lblConnectionStatusValue;
    private JButton btnViewRecords;
    private JButton btnAddEquipment;
    private JButton btnFindEquipment;
    private JButton btnSetAllInUseToFalse;
    private JButton btnExit;
    private DefaultTableModel tableModelEquipment;

    public EquipmentOPGUI() {
        super("Equipment Basic Operations Lab");

        // Set up the main content pane with BorderLayout
        JPanel pnlContent = new JPanel();
        pnlContent.setLayout(new BorderLayout());
        setContentPane(pnlContent);

        // --- Header Panel (NORTH) ---
        JPanel pnlHeader = new JPanel();
        pnlHeader.setLayout(new BorderLayout());
        pnlHeader.setBackground(new Color(47, 60, 71)); // Dark grey background

        JLabel lblHeaderTitle = new JLabel("Equipment Basic Operations Lab", JLabel.CENTER);
        lblHeaderTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblHeaderTitle.setForeground(Color.WHITE);
        lblHeaderTitle.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Spacing inside header
        pnlHeader.add(lblHeaderTitle, BorderLayout.CENTER);

        pnlContent.add(pnlHeader, BorderLayout.NORTH);

        // --- Main Body (CENTER) - for nested panels ---
        JPanel pnlMainBody = new JPanel();
        pnlMainBody.setLayout(new BorderLayout());

        // --- Database Connection Section ---
        JPanel pnlDatabaseConnection = new JPanel();
        pnlDatabaseConnection.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnlDatabaseConnection.setBorder(new TitledBorder("Database Connection"));

        btnConnect = new JButton("Connect");
        pnlDatabaseConnection.add(btnConnect);

        JLabel lblConnectionStatusPrefix = new JLabel("Status:");
        pnlDatabaseConnection.add(lblConnectionStatusPrefix);

        lblConnectionStatusValue = new JLabel("Not connected");
        lblConnectionStatusValue.setForeground(Color.RED);
        lblConnectionStatusValue.setFont(new Font("Arial", Font.BOLD, 12));
        pnlDatabaseConnection.add(lblConnectionStatusValue);

        pnlMainBody.add(pnlDatabaseConnection, BorderLayout.NORTH);

        // --- Operations and Records Container ---
        JPanel pnlOperationsAndRecords = new JPanel();
        pnlOperationsAndRecords.setLayout(new BorderLayout());

        // --- Database Operations Section ---
        JPanel pnlDatabaseOperations = new JPanel();
        pnlDatabaseOperations.setLayout(new GridLayout(1, 4, 10, 0)); // Even spacing between 4 buttons
        pnlDatabaseOperations.setBorder(new TitledBorder("Database Operations"));

        btnViewRecords = new JButton("View Records");
        btnViewRecords.setEnabled(false); // Initially disabled
        pnlDatabaseOperations.add(btnViewRecords);

        btnAddEquipment = new JButton("Add Equipment");
        btnAddEquipment.setEnabled(false); // Initially disabled
        pnlDatabaseOperations.add(btnAddEquipment);

        btnFindEquipment = new JButton("Find Equipment by ID");
        btnFindEquipment.setEnabled(false); // Initially disabled
        pnlDatabaseOperations.add(btnFindEquipment);

        btnSetAllInUseToFalse = new JButton("Set All In-Use to False");
        btnSetAllInUseToFalse.setEnabled(false); // Initially disabled
        pnlDatabaseOperations.add(btnSetAllInUseToFalse);

        pnlOperationsAndRecords.add(pnlDatabaseOperations, BorderLayout.NORTH);

        // --- Equipment Records Section with JTable ---
        JPanel pnlEquipmentRecords = new JPanel();
        pnlEquipmentRecords.setLayout(new BorderLayout());
        pnlEquipmentRecords.setBorder(new TitledBorder("Equipment Records"));

        // Define column headers for the JTable
        String[] columnNames = {"ID", "Name", "Department", "Purchase Date", "Condition", "In Use", "Price"};

        // Create table model and make table non-editable
        tableModelEquipment = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells non-editable
            }
        };

        JTable tblEquipment = new JTable(tableModelEquipment);

        // Style the table header to match the screenshot (dark background, white text)
        JTableHeader tableHeader = tblEquipment.getTableHeader();
        tableHeader.setBackground(new Color(12, 66, 65)); // Dark teal/green background
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setFont(new Font("Arial", Font.BOLD, 12));

        // Place table in a scroll pane
        JScrollPane scpTable = new JScrollPane(tblEquipment);
        pnlEquipmentRecords.add(scpTable, BorderLayout.CENTER);

        pnlOperationsAndRecords.add(pnlEquipmentRecords, BorderLayout.CENTER);

        pnlMainBody.add(pnlOperationsAndRecords, BorderLayout.CENTER);

        pnlContent.add(pnlMainBody, BorderLayout.CENTER);

        // --- Footer Area (SOUTH) - status bar and exit ---
        JPanel pnlFooter = new JPanel();
        pnlFooter.setLayout(new BorderLayout());
        pnlFooter.setBorder(new TitledBorder("Operation Status"));

        JPanel pnlStatusBar = new JPanel();
        pnlStatusBar.setLayout(new BorderLayout());

        JLabel lblStatusMessage = new JLabel("Ready");
        lblStatusMessage.setFont(new Font("Arial", Font.BOLD, 12));
        pnlStatusBar.add(lblStatusMessage, BorderLayout.WEST);

        btnExit = new JButton("Exit");
        pnlStatusBar.add(btnExit, BorderLayout.EAST);

        pnlFooter.add(pnlStatusBar, BorderLayout.CENTER);

        pnlContent.add(pnlFooter, BorderLayout.SOUTH);

        // --- Register Listeners with components ---
        btnConnect.addActionListener(new BtnConnectListener());
        btnViewRecords.addActionListener(new BtnViewRecordsListener());
        btnAddEquipment.addActionListener(new BtnAddEquipmentListener());
        btnFindEquipment.addActionListener(new BtnFindEquipmentByIDListener());
        btnSetAllInUseToFalse.addActionListener(new BtnSetAllInUseToFalseListener());
        btnExit.addActionListener(new BtnExitListener());

        // --- Frame final setup ---
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Set reasonable default size
        // Alternatively use pack(); setLocationRelativeTo(null); to let Java size the components
        setLocationRelativeTo(null); // Center frame on screen
    }

    // --- Private Named ActionListener Inner Classes ---
    private Connection conn;

    private class BtnConnectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement database connection logic and update status/button state
            String user = "app";
            String pass = "app";
            String url = "jdbc:derby://localhost:1527/labData";
            
            try {
                conn = DriverManager.getConnection(url, user, pass);
                lblConnectionStatusValue.setText("Connected!");
                
                btnViewRecords.setEnabled(true);
                btnAddEquipment.setEnabled(true);
                btnFindEquipment.setEnabled(true);
                btnSetAllInUseToFalse.setEnabled(true);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Database Error: " 
                        + ex.getMessage());
            }
        }
    }

    private class BtnViewRecordsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // TODO: Implement viewing all equipment records in the table
            
            
        }
    }

    private class BtnAddEquipmentListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // TODO: Implement adding a new equipment record
            
            
        }
    }

    private class BtnFindEquipmentByIDListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // TODO: Implement finding and displaying a single equipment record by ID
            
            

        }
    }

    private class BtnSetAllInUseToFalseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // TODO: Implement updating all equipment records to set in-use status to false
            
            
        }
    }

    private class BtnExitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // TODO: Implement application exit functionality
            
            
        }
    }

    // --- Main Method to Run the GUI ---
    public static void main(String[] args) {
        // Run GUI code in the Event Dispatch Thread (EDT) without lambda expressions
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Using default cross-platform Java Look and Feel to match common lab environments
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new EquipmentOPGUI().setVisible(true);
            }
        });
    }
}
