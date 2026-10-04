package za.ac.tut.o4.lab1;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private JLabel lblStatusMessage;
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

        lblStatusMessage = new JLabel("Ready");
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
                btnConnect.setEnabled(false);
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
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement viewing all equipment records in the table
            tableModelEquipment.setRowCount(0);
            
            String sql = "SELECT * FROM APP.LAB_EQUIPMENT "
                    + "ORDER BY EQUIPMENT_ID";
            try {
                Statement stmnt = conn.createStatement();
                ResultSet rs = stmnt.executeQuery(sql);
                
                while(rs.next()){
                    Object[] row = {
                        rs.getInt("EQUIPMENT_ID"),
                        rs.getString("NAME"),
                        rs.getString("DEPARTMENT"),
                        rs.getDate("PURCHASE_DATE"),
                        rs.getString("CONDITION"),
                        rs.getBoolean("IN_USE"),
                        rs.getDouble("PRICE")
                    };
                    
                    tableModelEquipment.addRow(row);
                }
                
                lblStatusMessage.setText("Displaying " + tableModelEquipment.getRowCount() + 
                        " rows.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Database Error: " 
                        + ex.getMessage());
            }
        }
    }

    private class BtnAddEquipmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement adding a new equipment record
            String name = JOptionPane.showInputDialog("Enter equipment name", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(name == null || name.trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Empty entry/Cancelled.");
                return;
            }
            
            String depTxt = JOptionPane.showInputDialog("Enter Department", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(depTxt == null || depTxt.trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Empty entry/Cancelled.");
                return;
            }
            
            String dateTxt = JOptionPane.showInputDialog("Enter Date(YYYY-MM-DD)", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(dateTxt == null || dateTxt.trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Empty entry/Cancelled.");
                return;
            }
            
            String conTxt = JOptionPane.showInputDialog("Enter equipment condition", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(conTxt == null || conTxt.trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Empty entry/Cancelled.");
                return;
            }
            
            String useTxt = JOptionPane.showInputDialog("Enter state of equipment", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(useTxt == null ||useTxt.trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Empty entry/Cancelled.");
                return;
            }
            
            boolean inUse =Boolean.parseBoolean(useTxt);
            
            String priceTxt = JOptionPane.showInputDialog("Enter equipment price", 
                    JOptionPane.YES_NO_CANCEL_OPTION);
            
            if(priceTxt == null || Integer.parseInt(priceTxt) == 1 ||  Integer.parseInt(priceTxt) == 2){
                JOptionPane.showMessageDialog(rootPane, "Empty entry/Cancelled.");
                return;
            } else if( Integer.parseInt(priceTxt) < 0){
                JOptionPane.showMessageDialog(rootPane, "Negative price.");
                return;
            }
            
            try {
                double price = Double.parseDouble(priceTxt);
                
                String sql = "INSERT INTO LAB_EQUIPMENT(NAME, DEPARTMENT,"
                    + "PURCHASE_DATE, CONDITION, IN_USE, PRICE) "
                        + "VALUES(?, ?, ?, ?, ?, ?)";
                
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, depTxt);
                ps.setDate(3, java.sql.Date.valueOf(LocalDate.parse(dateTxt, 
                        DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
                ps.setString(4, conTxt);
                ps.setBoolean(5, inUse);
                ps.setDouble(6, price);
                
                int row = ps.executeUpdate();
                if(row > 0){
                    JOptionPane.showMessageDialog(rootPane, row
                            + " row(s) added successfully.");
                    btnViewRecords.doClick();
                } else{
                    JOptionPane.showMessageDialog(rootPane, "NO row added.");
                }
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Number Error: " 
                        + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Database Error: " 
                        + ex.getMessage());
            }
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
