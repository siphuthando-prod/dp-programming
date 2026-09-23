
package za.ac.tut.ui;
//Import Statement++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author S. X Mabuza
 */
public class EquipFilteringGUI extends JFrame{
    //PRIVATE MEMBERS+++++++++++++++++++++
    private JLabel lblStatus;    
    private JTextField tfUsername;
    private JTextField tfSearchName;
    private JTextField tfMinimumPrice;
    private JTextField tfMaximumPrice;    
    private JPasswordField pfPassword;    
    private JComboBox cmbDepartments;
    private JComboBox cmbConditions;
    private JButton btnConnect;
    private JButton btnViewAll;
    private JButton btnSearchName;
    private JButton btnFilterDepartment;
    private JButton btnFilterCondition;
    private JButton btnFilterPriceRange;
    private JButton btnClearResults;
    private JButton btnExit;
    private JTable tblEquipment;
    private DefaultTableModel tableModel;
    private Connection connection;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++
    public EquipFilteringGUI() {
        setTitle("Equipment Search Console");
        setSize(950, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- 1. TOP PANEL: Database Login ---
        JPanel pnlLogin = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlLogin.setBorder(BorderFactory.createTitledBorder(""));
        
        tfUsername = new JTextField("app", 8);
        pfPassword = new JPasswordField("********", 8);
        btnConnect = new JButton("Connect");
        lblStatus = new JLabel("Status: Not connected");

        pnlLogin.add(new JLabel("Database Login: Username"));
        pnlLogin.add(tfUsername);
        pnlLogin.add(new JLabel("Password"));
        pnlLogin.add(pfPassword);
        pnlLogin.add(btnConnect);
        pnlLogin.add(lblStatus);

        // --- 2. CENTER PANEL: Filtering & Search Controls ---
        JPanel pnlFilters = new JPanel();
        pnlFilters.setLayout(new BoxLayout(pnlFilters, BoxLayout.Y_AXIS));
        pnlFilters.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // Sub-panel 1: Search and Dropdowns
        JPanel pnlRow1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        tfSearchName = new JTextField("search text", 10);
        cmbDepartments = new JComboBox(new String[]{"All Departments"});
        cmbConditions = new JComboBox(new String[]{"All Conditions"});

        pnlRow1.add(new JLabel("Search: Name contains"));
        pnlRow1.add(tfSearchName);
        pnlRow1.add(new JLabel("Department"));
        pnlRow1.add(cmbDepartments);
        pnlRow1.add(new JLabel("Condition"));
        pnlRow1.add(cmbConditions);
        pnlRow1.add(new JLabel("Minimum Price"));

        // Sub-panel 2: Price Inputs
        JPanel pnlRow2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        tfMinimumPrice = new JTextField("0.00", 6);
        tfMaximumPrice = new JTextField("50000.00", 8);

        pnlRow2.add(tfMinimumPrice);
        pnlRow2.add(new JLabel("Maximum Price"));
        pnlRow2.add(tfMaximumPrice);

        // Sub-panel 3: Action Buttons
        JPanel pnlRow3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 10));
        btnViewAll = new JButton("View All");
        btnSearchName = new JButton("Search Name");
        btnFilterDepartment = new JButton("Filter Department");
        btnFilterCondition = new JButton("Filter Condition");
        btnFilterPriceRange = new JButton("Filter Price Range");
        btnClearResults = new JButton("Clear Results");
        btnExit = new JButton("Exit");

        // Styling specific buttons to match colors/theme if desired
        btnViewAll.setBackground(new java.awt.Color(0, 102, 102));
        btnViewAll.setForeground(java.awt.Color.WHITE);
        this.btnViewAll.setEnabled(false);
        btnSearchName.setBackground(new java.awt.Color(0, 102, 102));
        btnSearchName.setForeground(java.awt.Color.WHITE);
        this.btnSearchName.setEnabled(false);
        btnFilterDepartment.setBackground(new java.awt.Color(0, 102, 102));
        btnFilterDepartment.setForeground(java.awt.Color.WHITE);
        this.btnFilterDepartment.setEnabled(false);
        btnFilterCondition.setBackground(new java.awt.Color(0, 102, 102));
        btnFilterCondition.setForeground(java.awt.Color.WHITE);
        this.btnFilterCondition.setEnabled(false);
        btnFilterPriceRange.setBackground(new java.awt.Color(0, 102, 102));
        btnFilterPriceRange.setForeground(java.awt.Color.WHITE);
        this.btnFilterPriceRange.setEnabled(false);
        btnConnect.setBackground(new java.awt.Color(0, 102, 102));
        btnConnect.setForeground(java.awt.Color.WHITE);
        //this.btnConnect.setEnabled(false);
        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setForeground(java.awt.Color.WHITE);
        
        this.btnConnect.addActionListener(
                new BtnConnectClickListener());
        this.btnViewAll.addActionListener(
                new BtnViewAllClickListener());
        this.btnSearchName.addActionListener(
                new BtnSearchNameClickListener());
        this.btnFilterDepartment.addActionListener(
                new BtnFilterDepartmentClickListener());
        this.btnFilterCondition.addActionListener(
                new BtnFilterConditionClickListener());
        this.btnFilterPriceRange.addActionListener(
                new BtnFilterPriceRangeClickListener());
        this.btnClearResults.addActionListener(
                new BtnClearClickListener());
        this.btnExit.addActionListener(
                new BtnExitClickListener());

        pnlRow3.add(btnViewAll);
        pnlRow3.add(btnSearchName);
        pnlRow3.add(btnFilterDepartment);
        pnlRow3.add(btnFilterCondition);
        pnlRow3.add(btnFilterPriceRange);
        pnlRow3.add(btnClearResults);
        pnlRow3.add(btnExit);

        pnlFilters.add(pnlRow1);
        pnlFilters.add(pnlRow2);
        pnlFilters.add(pnlRow3);

        // Combine Login and Filters into a top container panel
        JPanel pnlTopContainer = new JPanel(new BorderLayout());
        pnlTopContainer.add(pnlLogin, BorderLayout.NORTH);
        pnlTopContainer.add(pnlFilters, BorderLayout.CENTER);
        
        // --- 3. BOTTOM PANEL: Table View ---
        String[] columnNames = {"ID", "Name", "Department", "Purchase Date", "Condition", "In Use", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tblEquipment = new JTable(tableModel);
        
        // Add sample row matching the reference image[cite: 1]
        tableModel.addRow(new Object[]{"1", "Desktop PC", "Computer Science", "2023-02-10", "New", "true", "14500.00"});

        JScrollPane scrollPane = new JScrollPane(tblEquipment);
        
        JPanel pnlTableContainer = new JPanel(new BorderLayout());
        pnlTableContainer.add(scrollPane, BorderLayout.CENTER);
        
        JLabel lblTableFooter = new JLabel("Filtered records appear here..");
        lblTableFooter.setHorizontalAlignment(SwingConstants.CENTER);
        pnlTableContainer.add(lblTableFooter, BorderLayout.SOUTH);

        // Add main containers to Frame
        add(pnlTopContainer, BorderLayout.NORTH);
        add(pnlTableContainer, BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    //Action Handlers+++++++++++++++++++++++++++++++++++++++++++++
    private class BtnConnectClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String username = tfUsername.getText().trim();
            char[] passwordChars = pfPassword.getPassword();
            String password = new String(passwordChars);
            String url = "jdbc:derby://localhost:1527/labData";
            
            try {
                connection = DriverManager.getConnection(url, username, password);
                lblStatus.setText("Connected.");
                btnConnect.setEnabled(false);
                btnViewAll.setEnabled(true);
                btnSearchName.setEnabled(true);
                btnFilterDepartment.setEnabled(true);
                btnFilterCondition.setEnabled(true);
                btnFilterPriceRange.setEnabled(true);
                
            } catch (SQLException ex) {
                lblStatus.setText("Status: Connection failed");
                JOptionPane.showMessageDialog(rootPane, "Database error: " + ex.getMessage());
            } finally{
                Arrays.fill(passwordChars, ' ');
            }
        }
    }

    private class BtnViewAllClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String sql = "SELECT * FROM APP.LAB_EQUIPMENT "
                    + "ORDER BY EQUIPMENT_ID ";
            
            tableModel.setRowCount(0);
            try (PreparedStatement ps = connection.prepareStatement(sql);
                        ResultSet rs = ps.executeQuery()){
                int count = 0;
                while(rs.next()){
                    Object[] row = {rs.getInt("EQUIPMENT_ID"),
                                                    rs.getString("NAME"),
                                                    rs.getString("DEPARTMENT"), 
                                                    rs.getDate("PURCHASE_DATE"),
                                                    rs.getString("CONDITION"),
                                                    rs.getBoolean("IN_USE"),
                                                    rs.getDouble("PRICE")};
                    
                    tableModel.addRow(row);
                    count++;
                }
                lblStatus.setText("Status: " + count + " records found.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Database error: "
                        + ex.getMessage());
            }
        }
    }

    private class BtnSearchNameClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String sql = "SELECT * FROM APP.LAB_EQUIPMENT "
                    + "WHERE UPPER(NAME) LIKE ? "
                    + "ORDER BY NAME";
            
            tableModel.setRowCount(0);
            String searchText = tfSearchName.getText().trim();
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, "%" + searchText.toUpperCase() + "%");
                ResultSet rs = ps.executeQuery();
                int count = 0;
                while(rs.next()){
                    Object[] row = {rs.getInt("EQUIPMENT_ID"), rs.getString("NAME"), 
                                                    rs.getString("DEPARTMENT"), rs.getDate("PURCHASE_DATE"), 
                                                    rs.getString("CONDITION"), rs.getBoolean("IN_USE"), 
                                                     rs.getDouble("PRICE")};
                    tableModel.addRow(row);
                    count++;
                }
                lblStatus.setText("Status: " + count + " records loaded.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Database error: " 
                        + ex.getMessage());
            }
        }
    }

    private class BtnFilterDepartmentClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    private class BtnFilterConditionClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    private class BtnFilterPriceRangeClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    private class BtnClearClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    private class BtnExitClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    //Main method+++++++++++++++++++++++++
    public static void main(String[]args){
        new EquipFilteringGUI();
    }
}
