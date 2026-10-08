/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehiclefleetapp;

/**
 *
 * @author sibus
 */
/*
 * Mini-Assignment 5 (Tutorial Version)
 * Fleet Database Operations Console - STARTER CODE
 *
 * The GUI is complete. Students complete the body of every private
 * ActionListener class (Questions 1 - 10) at the bottom of this file.
 *
 * Database : jdbc:derby://localhost:1527/FleetDB   (run fleet_setup.sql first)
 * Table    : APP.FLEET_VEHICLE
 * Library  : add the Derby client driver (derbyclient.jar / Java DB Driver) to the project.
 *
 * Rules: one shared Connection, no JTable row selection, no lambdas,
 *        no helper-method refactoring, no StringBuilder, parameterised SQL
 *        for any value taken from a GUI control.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class VehicleFleetApp extends JFrame {

    // ---------------- Shared JDBC resources ----------------
    private Connection conn;            // ONE shared Connection


    // ---------------- Database Login ----------------
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JButton btnConnect;
    private JLabel lblConnectionStatus;

    // ---------------- Insert Vehicle ----------------
    private JTextField tfModel;
    private JTextField tfBranch;
    private JTextField tfDailyRate;
    private JCheckBox chkRented;
    private JButton btnInsertVehicle;

    // ---------------- Search and Filter ----------------
    private JButton btnLoadBranches;
    private JComboBox<String> cmbBranch;
    private JButton btnFilterBranch;
    private JTextField tfModelSearch;
    private JButton btnFilterModelResultSet;
    private JButton btnViewAll;

    // ---------------- Records table ----------------
    private DefaultTableModel tableModel;
    private JTable tblVehicles;
    private JLabel lblRecordCount;
    private JButton btnClearResults;

    // ---------------- Dashboard ----------------
    private JLabel lblTotalVehicles;
    private JLabel lblAverageRate;
    private JLabel lblTotalBranches;
    private JLabel lblCheapest;
    private JLabel lblMostExpensive;
    private JButton btnLoadDashboard;

    // ---------------- Database Operations ----------------
    private JComboBox<String> cmbMonth;
    private JButton btnServiceDurban;
    private JButton btnDeleteRetired;
    private JButton btnExit;
    private JLabel lblOperationStatus;
    
    private ResultSet baseline;

    private static final Color TEAL = new Color(0, 121, 107);
    private static final Color BLUE = new Color(40, 123, 146);
    private static final Color AMBER = new Color(178, 106, 0);
    private static final Color RED = new Color(159, 57, 52);
    private static final Color SLATE = new Color(96, 125, 139);
    private static final Color DARK = new Color(55, 71, 79);

    public VehicleFleetApp() {
        super("Fleet Database Operations Console");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        // ============ NORTH: login, insert, search ============
        JPanel pnlNorth = new JPanel();
        pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));

        // ---- Database Login ----
        JPanel pnlLogin = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        pnlLogin.setBorder(titled("Database Login"));
        tfUsername = new JTextField("app", 12);
        pfPassword = new JPasswordField(12);
        btnConnect = makeButton("Connect", TEAL);
        lblConnectionStatus = new JLabel("Not connected");
        lblConnectionStatus.setForeground(RED);
        pnlLogin.add(new JLabel("Username:"));
        pnlLogin.add(tfUsername);
        pnlLogin.add(new JLabel("Password:"));
        pnlLogin.add(pfPassword);
        pnlLogin.add(btnConnect);
        pnlLogin.add(Box.createHorizontalStrut(12));
        pnlLogin.add(new JLabel("Status:"));
        pnlLogin.add(lblConnectionStatus);

        // ---- Insert Vehicle ----
        JPanel pnlInsert = new JPanel(new BorderLayout());
        pnlInsert.setBorder(titled("Insert Vehicle"));
        JPanel pnlInsertRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        tfModel = new JTextField(14);
        tfBranch = new JTextField(12);
        tfDailyRate = new JTextField("0.00", 7);
        chkRented = new JCheckBox("Currently Rented");
        btnInsertVehicle = makeButton("Insert Vehicle", TEAL);
        pnlInsertRow.add(new JLabel("Model:"));
        pnlInsertRow.add(tfModel);
        pnlInsertRow.add(new JLabel("Branch:"));
        pnlInsertRow.add(tfBranch);
        pnlInsertRow.add(new JLabel("Daily Rate (R):"));
        pnlInsertRow.add(tfDailyRate);
        pnlInsertRow.add(chkRented);
        pnlInsertRow.add(btnInsertVehicle);
        JLabel lblInsertNote = new JLabel(
                "   Registration Date = current date  ·  Status = Active  ·  ID = generated by Derby");
        lblInsertNote.setFont(lblInsertNote.getFont().deriveFont(Font.ITALIC, 11f));
        lblInsertNote.setForeground(Color.DARK_GRAY);
        pnlInsert.add(pnlInsertRow, BorderLayout.CENTER);
        pnlInsert.add(lblInsertNote, BorderLayout.SOUTH);

        // ---- Search and Filter ----
        JPanel pnlSearch = new JPanel(new GridLayout(2, 1));
        pnlSearch.setBorder(titled("Search and Filter"));
        JPanel pnlSearchRow1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        btnLoadBranches = makeButton("Load Branches", BLUE);
        cmbBranch = new JComboBox<String>();
        cmbBranch.setPreferredSize(new Dimension(180, 26));
        btnFilterBranch = makeButton("Filter Branch", TEAL);
        btnViewAll = makeButton("View All", BLUE);
        pnlSearchRow1.add(btnLoadBranches);
        pnlSearchRow1.add(new JLabel("Branch:"));
        pnlSearchRow1.add(cmbBranch);
        pnlSearchRow1.add(btnFilterBranch);
        pnlSearchRow1.add(Box.createHorizontalStrut(20));
        pnlSearchRow1.add(btnViewAll);
        JPanel pnlSearchRow2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        tfModelSearch = new JTextField(18);
        btnFilterModelResultSet = makeButton("Filter Existing ResultSet", TEAL);
        pnlSearchRow2.add(new JLabel("Vehicle Model:"));
        pnlSearchRow2.add(tfModelSearch);
        pnlSearchRow2.add(btnFilterModelResultSet);
        pnlSearch.add(pnlSearchRow1);
        pnlSearch.add(pnlSearchRow2);

        pnlNorth.add(pnlLogin);
        pnlNorth.add(pnlInsert);
        pnlNorth.add(pnlSearch);

        // ============ CENTER: records table ============
        JPanel pnlRecords = new JPanel(new BorderLayout(4, 4));
        pnlRecords.setBorder(titled("Vehicle Records"));
        String[] columns = {"ID", "Model", "Branch", "Registration Date", "Status", "Rented", "Daily Rate"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;   // the JTable is a view only
            }
        };
        tblVehicles = new JTable(tableModel);
        tblVehicles.setRowSelectionAllowed(false);   // no row selection is used in this application
        tblVehicles.setFocusable(false);
        tblVehicles.getTableHeader().setReorderingAllowed(false);
        tblVehicles.setRowHeight(22);
        JScrollPane spTable = new JScrollPane(tblVehicles);
        spTable.setPreferredSize(new Dimension(720, 300));

        JPanel pnlRecordsFooter = new JPanel(new BorderLayout());
        lblRecordCount = new JLabel("Records displayed: 0");
        lblRecordCount.setFont(lblRecordCount.getFont().deriveFont(Font.BOLD));
        btnClearResults = makeButton("Clear Results", SLATE);
        pnlRecordsFooter.add(lblRecordCount, BorderLayout.WEST);
        pnlRecordsFooter.add(btnClearResults, BorderLayout.EAST);

        pnlRecords.add(spTable, BorderLayout.CENTER);
        pnlRecords.add(pnlRecordsFooter, BorderLayout.SOUTH);

        // ============ EAST: dashboard ============
        JPanel pnlDashboard = new JPanel();
        pnlDashboard.setLayout(new BoxLayout(pnlDashboard, BoxLayout.Y_AXIS));
        pnlDashboard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(6, 0, 6, 6),
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(TEAL, 2),
                        "Fleet Dashboard", TitledBorder.CENTER, TitledBorder.TOP,
                        new Font("SansSerif", Font.BOLD, 13), TEAL)));
        pnlDashboard.setPreferredSize(new Dimension(250, 300));

        lblTotalVehicles = new JLabel("0");
        lblAverageRate = new JLabel("R0.00");
        lblTotalBranches = new JLabel("0");
        lblCheapest = new JLabel("Not loaded");
        lblMostExpensive = new JLabel("Not loaded");
        pnlDashboard.add(makeTile("Total Vehicles", lblTotalVehicles));
        pnlDashboard.add(makeTile("Average Daily Rate", lblAverageRate));
        pnlDashboard.add(makeTile("Total Branches", lblTotalBranches));
        pnlDashboard.add(makeTile("Cheapest Vehicle", lblCheapest));
        pnlDashboard.add(makeTile("Most Expensive Vehicle", lblMostExpensive));
        btnLoadDashboard = makeButton("Load Dashboard", TEAL);
        btnLoadDashboard.setAlignmentX(0.5f);
        pnlDashboard.add(Box.createVerticalStrut(6));
        pnlDashboard.add(btnLoadDashboard);

        // ============ SOUTH: database operations ============
        JPanel pnlOps = new JPanel(new BorderLayout());
        pnlOps.setBorder(titled("Database Operations"));
        JPanel pnlOpsRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
        cmbMonth = new JComboBox<String>(months);
        btnServiceDurban = makeButton("Send Durban Vehicles to Service", AMBER);
        btnDeleteRetired = makeButton("Delete Retired Not Rented", RED);
        pnlOpsRow.add(new JLabel("Registration Month:"));
        pnlOpsRow.add(cmbMonth);
        pnlOpsRow.add(btnServiceDurban);
        pnlOpsRow.add(btnDeleteRetired);
        btnExit = makeButton("Exit", DARK);
        JPanel pnlExit = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 4));
        pnlExit.add(btnExit);
        lblOperationStatus = new JLabel("Operation Status: Ready");
        lblOperationStatus.setFont(lblOperationStatus.getFont().deriveFont(Font.BOLD));
        lblOperationStatus.setBorder(BorderFactory.createEmptyBorder(2, 10, 4, 4));
        pnlOps.add(pnlOpsRow, BorderLayout.CENTER);
        pnlOps.add(pnlExit, BorderLayout.EAST);
        pnlOps.add(lblOperationStatus, BorderLayout.SOUTH);

        add(pnlNorth, BorderLayout.NORTH);
        add(pnlRecords, BorderLayout.CENTER);
        add(pnlDashboard, BorderLayout.EAST);
        add(pnlOps, BorderLayout.SOUTH);

        // ---- Database controls stay disabled until a successful login (Question 1) ----
        btnInsertVehicle.setEnabled(false);
        btnLoadBranches.setEnabled(false);
        btnFilterBranch.setEnabled(false);
        btnFilterModelResultSet.setEnabled(false);
        btnViewAll.setEnabled(false);
        btnLoadDashboard.setEnabled(false);
        btnServiceDurban.setEnabled(false);
        btnDeleteRetired.setEnabled(false);

        // ---- Register the named private listeners ----
        btnConnect.addActionListener(new BtnConnectClickListener());
        btnInsertVehicle.addActionListener(new BtnInsertVehicleClickListener());
        btnViewAll.addActionListener(new BtnViewAllClickListener());
        btnLoadBranches.addActionListener(new BtnLoadBranchesClickListener());
        btnFilterBranch.addActionListener(new BtnFilterBranchClickListener());
        btnFilterModelResultSet.addActionListener(new BtnFilterModelResultSetClickListener());
        btnServiceDurban.addActionListener(new BtnServiceDurbanClickListener());
        btnDeleteRetired.addActionListener(new BtnDeleteRetiredClickListener());
        btnLoadDashboard.addActionListener(new BtnLoadDashboardClickListener());
        btnClearResults.addActionListener(new BtnClearResultsClickListener());
        btnExit.addActionListener(new BtnExitClickListener());

        // Closing the window behaves exactly like the Exit button
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                btnExit.doClick();
            }
        });

        pack();
        setMinimumSize(new Dimension(1050, 720));
        setLocationRelativeTo(null);
    }

    // ---------------- GUI construction helpers (GUI only - not part of the assessment) ----------------
    private TitledBorder titled(String title) {
        TitledBorder border = BorderFactory.createTitledBorder(title);
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 12));
        return border;
    }

    private JButton makeButton(String text, Color background) {
        JButton button = new JButton(text);
        button.setBackground(background);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 12));
        button.setFocusPainted(false);
        button.setOpaque(true);
        return button;
    }

    private JPanel makeTile(String caption, JLabel valueLabel) {
        JPanel tile = new JPanel(new GridLayout(2, 1));
        tile.setBackground(Color.WHITE);
        tile.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createEmptyBorder(3, 6, 3, 6),
                        BorderFactory.createMatteBorder(1, 5, 1, 1, TEAL)),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        tile.setMaximumSize(new Dimension(Integer.MAX_VALUE, 58));
        JLabel lblCaption = new JLabel(caption);
        lblCaption.setFont(lblCaption.getFont().deriveFont(Font.PLAIN, 11f));
        valueLabel.setFont(valueLabel.getFont().deriveFont(Font.BOLD, 15f));
        tile.add(lblCaption);
        tile.add(valueLabel);
        return tile;
    }

    // =====================================================================
    //                    ASSESSED LISTENER CLASSES
    // =====================================================================

    private class BtnConnectClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 1: Connect to the database.
            String url = "jdbc:derby://localhost:1527/FleetDB";
            
            String user = tfUsername.getText().trim();
            
            String pass = pfPassword.getText().trim();
            
            try {
                if(!pass.equals("app")){
                    lblConnectionStatus.setText("Connection failed");
                    JOptionPane.showMessageDialog(rootPane, "Could not connect" ,
                            "Password Error"
                            , JOptionPane.ERROR_MESSAGE);
                } else{
                    conn = DriverManager.getConnection(url, user, pass);
                    
                    lblConnectionStatus.setForeground(Color.GREEN);
                    lblConnectionStatus.setText("Connected to app");
                    
                    btnConnect.setEnabled(false);
                    btnInsertVehicle.setEnabled(true);
                    btnLoadBranches.setEnabled(true);
                    btnFilterBranch.setEnabled(true);
                    btnFilterModelResultSet.setEnabled(true);
                    btnViewAll.setEnabled(true);
                    btnLoadDashboard.setEnabled(true);
                    btnServiceDurban.setEnabled(true);
                    btnDeleteRetired.setEnabled(true);
                    
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Database error: " 
                        + ex.getMessage(), "Database error"
                            , JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class BtnInsertVehicleClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 2: Insert a vehicle using default values.
            String model = tfModel.getText().trim();
            String branch = tfBranch.getText().trim();
            String priceTxt = tfDailyRate.getText().trim();
            boolean rented = chkRented.isSelected();
            
            if(model.isEmpty() || branch.isEmpty() || priceTxt.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Empty value(s)",
                        "Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            try{
                double price = Double.parseDouble(priceTxt);
                if(price < 0){
                    JOptionPane.showMessageDialog(rootPane, "Daily rate cannot be negative.",
                            "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                LocalDate date = LocalDate.now();
                String status = "Active";
                
                String sql = "INSERT INTO FLEET_VEHICLE(MODEL, BRANCH, "
                        + "REGISTRATION_DATE, STATUS, IS_RENTED, DAILY_RATE) "
                        + "VALUES(?, ?, ?, ?, ?, ?)";
                
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, model);
                ps.setString(2, branch);
                ps.setDate(3, java.sql.Date.valueOf(date));
                ps.setString(4, status);
                ps.setBoolean(5, rented);
                ps.setDouble(6, price);
                
                int row = ps.executeUpdate();
                
                if(row == 1){
                    JOptionPane.showMessageDialog(rootPane, "Vehicle inserted successfully");
                    
                    btnViewAll.doClick();
                    
                    tfBranch.setText("");
                    tfDailyRate.setText("0.00");
                    tfModel.setText("");
                    chkRented.setSelected(false);
                }
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Daily rate must be a decimal number.",
                            "Error", JOptionPane.WARNING_MESSAGE);
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(rootPane, "Database error: " 
                        + ex.getMessage(), "Database error"
                            , JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class BtnViewAllClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            try {
                // Question 3: View all and prepare the baseline ResultSet.
                Statement state = conn.createStatement(baseline.TYPE_SCROLL_SENSITIVE, 
                        baseline.CONCUR_READ_ONLY);
                
                String sql = "SELECT * FROM FLEET_VEHICLE "
                        + "ORDER BY VEHICLE_ID";
                
                baseline = state.executeQuery(sql);                
                tableModel.setRowCount(0);
                
                while(baseline.next()){
                    Object[] row = {
                        baseline.getInt("VEHICLE_ID"),
                        baseline.getString("MODEL"),
                        baseline.getString("BRANCH"),
                        baseline.getDate("REGISTRATION_DATE"),
                        baseline.getString("STATUS"),
                        baseline.getBoolean("IS_RENTED"),
                        baseline.getDouble("DAILY_RATE")
                    };
                    
                    tableModel.addRow(row);
                }
                
                lblOperationStatus.setText(tableModel.getRowCount() 
                        + " row displayed.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
            }
        }
    }

    private class BtnLoadBranchesClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 4: Load unique branch names using SQL.
            cmbBranch.removeAllItems();
            
            String sql = "SELECT DISTINCT BRANCH FROM FLEET_VEHICLE "
                    + "ORDER BY BRANCH";
            
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                int row = 0;
                while(rs.next()){
                    cmbBranch.addItem(rs.getString("BRANCH"));
                    row++;
                }
                
                lblOperationStatus.setText(row + " branches loaded.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
            }
        }
    }

    private class BtnFilterBranchClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 5: Filter by branch using SQL.
        }
    }

    private class BtnFilterModelResultSetClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 6: Filter models using the existing ResultSet.
        }
    }

    private class BtnServiceDurbanClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 7: Send Durban vehicles registered in the selected month to Service.
        }
    }

    private class BtnDeleteRetiredClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 8: Delete retired vehicles that are not rented.
        }
    }

    private class BtnLoadDashboardClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 9: Load the five dashboard metrics.
        }
    }

    private class BtnClearResultsClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 10A: Clear only visible results.
        }
    }

    private class BtnExitClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Question 10B: Close resources and exit.
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VehicleFleetApp().setVisible(true);
            }
        });
    }
}