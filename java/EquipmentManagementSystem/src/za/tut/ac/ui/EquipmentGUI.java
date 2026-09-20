
package za.tut.ac.ui;
//Import Statementd+++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author S. X Mabuza
 */
public class EquipmentGUI extends JFrame{
    //private memebers+++++++++++++++++++++++++++++++
    private JTextField tfEqipmentId;
    private JTextField tfName;
    private JTextField tfDepartment;
    private JTextField tfPurchaseDate;
    private JTextField tfPrice;    
    private JComboBox<String> cmbCondition;
    private JCheckBox ckbInUse;
    private JButton btnAdd;
    private JButton btnView;
    private JButton btnLoadSelected;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnClear;
    private JButton btnExit;
    private JLabel lblStatus;
    private JTable tblEquipment;
    private DefaultTableModel tableModel;
    private Connection connection;
    
    //Constructor++++++++++++++++++++++++++++++
    public EquipmentGUI() {
        // Frame setup
        JFrame frame = new JFrame("Equipment Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 580);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Main background panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 15, 15, 15));
        mainPanel.setBackground(new Color(238, 242, 240));

        // --- TOP PANEL: Equipment Details Form ---
        JPanel detailsPanel = new JPanel(new BorderLayout(5, 5));
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 215, 210), 1),
                new EmptyBorder(12, 15, 12, 15)
        ));

        JLabel lblTitle = new JLabel("Equipment Details");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTitle.setForeground(new Color(0, 102, 84));
        lblTitle.setBorder(new EmptyBorder(0, 0, 10, 0));
        detailsPanel.add(lblTitle, BorderLayout.NORTH);

        // Grid for form fields (2 rows x 4 columns)
        JPanel gridPanel = new JPanel(new GridLayout(2, 4, 12, 10));
        gridPanel.setOpaque(false);

        // Row 1 Fields
        // Equipment ID
        JPanel pnlEqId = new JPanel(new BorderLayout(0, 4));
        pnlEqId.setOpaque(false);
        pnlEqId.add(new JLabel("Equipment ID:"), BorderLayout.NORTH);
        tfEqipmentId = new JTextField("Generated or selected ID");
        tfEqipmentId.setEnabled(false);
        pnlEqId.add(tfEqipmentId, BorderLayout.CENTER);

        // Name
        JPanel pnlName = new JPanel(new BorderLayout(0, 4));
        pnlName.setOpaque(false);
        pnlName.add(new JLabel("Name:"), BorderLayout.NORTH);
        tfName = new JTextField("Equipment name");
        pnlName.add(tfName, BorderLayout.CENTER);

        // Department
        JPanel pnlDept = new JPanel(new BorderLayout(0, 4));
        pnlDept.setOpaque(false);
        pnlDept.add(new JLabel("Department:"), BorderLayout.NORTH);
        tfDepartment = new JTextField("Department name");
        pnlDept.add(tfDepartment, BorderLayout.CENTER);

        // Purchase Date
        JPanel pnlDate = new JPanel(new BorderLayout(0, 4));
        pnlDate.setOpaque(false);
        pnlDate.add(new JLabel("Purchase Date:"), BorderLayout.NORTH);
        tfPurchaseDate = new JTextField("yyyy-MM-dd");
        pnlDate.add(tfPurchaseDate, BorderLayout.CENTER);

        // Row 2 Fields
        // Condition
        JPanel pnlCond = new JPanel(new BorderLayout(0, 4));
        pnlCond.setOpaque(false);
        pnlCond.add(new JLabel("Condition:"), BorderLayout.NORTH);
        cmbCondition = new JComboBox<>(new String[]{"New", "Used", "Refurbished", "Damaged"});
        pnlCond.add(cmbCondition, BorderLayout.CENTER);

        // In Use
        JPanel pnlInUse = new JPanel(new BorderLayout(0, 4));
        pnlInUse.setOpaque(false);
        pnlInUse.add(new JLabel("In Use:"), BorderLayout.NORTH);
        ckbInUse = new JCheckBox("Currently in use");
        ckbInUse.setOpaque(false);
        pnlInUse.add(ckbInUse, BorderLayout.CENTER);

        // Price
        JPanel pnlPrice = new JPanel(new BorderLayout(0, 4));
        pnlPrice.setOpaque(false);
        pnlPrice.add(new JLabel("Price:"), BorderLayout.NORTH);
        tfPrice = new JTextField("0.00");
        pnlPrice.add(tfPrice, BorderLayout.CENTER);

        // Status
        JPanel pnlStatus = new JPanel(new BorderLayout(0, 4));
        pnlStatus.setOpaque(false);
        pnlStatus.add(new JLabel("Status:"), BorderLayout.NORTH);
        lblStatus = new JLabel(" Ready ", SwingConstants.CENTER);
        lblStatus.setOpaque(true);
        lblStatus.setBackground(new Color(230, 245, 235));
        lblStatus.setForeground(new Color(0, 102, 84));
        lblStatus.setBorder(BorderFactory.createLineBorder(new Color(180, 220, 195)));
        lblStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
        pnlStatus.add(lblStatus, BorderLayout.CENTER);

        // Add all components to grid
        gridPanel.add(pnlEqId);
        gridPanel.add(pnlName);
        gridPanel.add(pnlDept);
        gridPanel.add(pnlDate);
        gridPanel.add(pnlCond);
        gridPanel.add(pnlInUse);
        gridPanel.add(pnlPrice);
        gridPanel.add(pnlStatus);

        detailsPanel.add(gridPanel, BorderLayout.CENTER);

        // --- MIDDLE PANEL: Buttons ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setOpaque(false);

        btnView = new JButton("View All");
        btnAdd = new JButton("Add");
        btnLoadSelected = new JButton("Load Selected");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");
        btnClear = new JButton("Clear Form");
        btnExit = new JButton("Exit");

        // Styling buttons to match color scheme
        Color tealColor = new Color(0, 102, 84);
        Color blueTealColor = new Color(40, 120, 140);
        Color redColor = new Color(160, 50, 45);
        Color grayColor = new Color(90, 110, 120);
        Color darkGrayColor = new Color(50, 60, 65);

        JButton[] buttons = {btnView, btnAdd, btnLoadSelected, btnUpdate, btnDelete, btnClear, btnExit};
        Color[] colors = {tealColor, tealColor, blueTealColor, tealColor, redColor, grayColor, darkGrayColor};

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(colors[i]);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFocusPainted(false);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 12));
            buttonPanel.add(buttons[i]);
        }

        // Top Container (Details Form + Buttons)
        JPanel topContainer = new JPanel(new BorderLayout(10, 10));
        topContainer.setOpaque(false);
        topContainer.add(detailsPanel, BorderLayout.CENTER);
        topContainer.add(buttonPanel, BorderLayout.SOUTH);

        // --- BOTTOM PANEL: Table ---
        JPanel tableContainer = new JPanel(new BorderLayout(5, 5));
        tableContainer.setBackground(Color.WHITE);
        tableContainer.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 215, 210), 1),
                new EmptyBorder(5, 5, 5, 5)
        ));

        String[] columnNames = {"ID", "Name", "Department", "Purchase Date", "Condition", "In Use", "Price"};
        Object[][] sampleData = {
            {"1", "Desktop PC", "Computer Science", "2023-02-10", "New", "true", "14500.00"},
            {"2", "Webcam", "Computer Science", "2023-03-12", "New", "true", "12500.00"},
            {"3", "Mechanical Keyboard", "Computer Science", "2022-05-18", "Used", "true", "950.00"}
        };
        
        String url = "jdbc:derby://localhost:1527/labData";
        String username = "app";
        String password = "app";
        try {
            connection = DriverManager.getConnection(url, username, password);
            
            lblStatus.setText("Connected to labData.");
        } catch (SQLException ex) {
            lblStatus.setText("Database connection failed");
            
            JOptionPane.showMessageDialog(rootPane, "Database error: " + ex.getMessage());
        }
        
        this.btnView.addActionListener(new BtnViewClickListener());
        this.btnAdd.addActionListener(new BtnAddClickListener());
        this.btnLoadSelected.addActionListener(new BtnLoadSelectedClickListener());
        this.btnUpdate.addActionListener(new BtnUpdateClickListener());
        this.btnDelete.addActionListener(new BtnDeleteClickListener());
        this.btnClear.addActionListener(new BtnClearClickListener());
        this.btnExit.addActionListener(new BtnExitClickListener());

        tableModel = new DefaultTableModel(sampleData, columnNames);
        tblEquipment = new JTable(tableModel);
        tblEquipment.setRowHeight(24);
        tblEquipment.getTableHeader().setBackground(new Color(225, 235, 230));
        tblEquipment.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 11));

        JScrollPane scrollPane = new JScrollPane(tblEquipment);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JLabel lblFooter = new JLabel("Remaining records loaded from APP.LAB_EQUIPMENT", SwingConstants.CENTER);
        lblFooter.setFont(new Font("SansSerif", Font.ITALIC, 10));
        lblFooter.setForeground(Color.GRAY);
        lblFooter.setBorder(new EmptyBorder(5, 0, 5, 0));

        tableContainer.add(scrollPane, BorderLayout.CENTER);
        tableContainer.add(lblFooter, BorderLayout.SOUTH);

        // Add to main frame
        mainPanel.add(topContainer, BorderLayout.NORTH);
        mainPanel.add(tableContainer, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }
    
    //Event Handlers+++++++++++++++++++++++++++++++++++++++
    private class BtnViewClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String sql = "SELECT  EQUIPMENT_ID,NAME, "
                    + "DEPARTMENT, PURCHASE_DATE, CONDITION, "
                    + "IN_USE, PRICE "
                    + "FROM LAB_EQUIPMENT "
                    + "ORDER BY EQUIPMENT_ID";
            
            tableModel.setRowCount(0);
            try(Statement statement = connection.createStatement();
                    ResultSet results = statement.executeQuery(sql)){
                int totalRows = 0;
                
                while(results.next()){
                    Object[] row = {
                        results.getInt("EQUIPMENT_ID"), 
                        results.getString("NAME"), 
                        results.getString("DEPARTMENT"), 
                        results.getDate("PURCHASE_DATE"), 
                        results.getString("CONDITION"), 
                        results.getBoolean("IN_USE"), 
                        results.getDouble("PRICE")};
                    tableModel.addRow(row);
                    totalRows++;
                }
                
                lblStatus.setText(totalRows + " records displayed.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Database error: " + ex.getMessage());
            }
        }
    }

    private class BtnAddClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String name = tfName.getText().trim();
            String department = tfDepartment.getText().trim();
            String dateText = tfPurchaseDate.getText().trim();
            String condition = (String) cmbCondition.getSelectedItem();
            boolean inUse =ckbInUse.isSelected();
            String priceText = tfPrice.getText().trim();
            
            if(name.isEmpty() || department.isEmpty() || dateText.isEmpty() || priceText.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Complete all required fields.");
                return;
            }
            
            try{
                LocalDate purchaseDate = LocalDate.parse(dateText);
                java.sql.Date sqlDate = java.sql.Date.valueOf(purchaseDate);
                double price = Double.parseDouble(priceText);
                
                if(price < 0){
                    JOptionPane.showMessageDialog(rootPane, "Price cannot be negative.");
                    return;
                }
                
                String sql = "INSERT INTO LAB_EQUIPMENT"
                        + "(NAME, DEPARTMENT, PURCHASE_DATE,"
                        + " CONDITION, IN_USE, PRICE) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                
                try(PreparedStatement ps = connection.prepareStatement(sql)){
                    ps.setString(1, name);
                    ps.setString(2, department);
                    ps.setDate(3, sqlDate);
                    ps.setString(4, condition);
                    ps.setBoolean(5, inUse);
                    ps.setDouble(6, price);
                    
                    int rows = ps.executeUpdate();
                    if(rows == 1){
                        lblStatus.setText("Equipment added successfully.");
                        btnView.doClick();
                        btnClear.doClick();
                    }
                }
            } catch(DateTimeParseException ex){
                JOptionPane.showMessageDialog(rootPane, "Enter date as yyyy-MM-dd.");
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Enter a valid price.");
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(rootPane, "Database error: " + ex.getMessage());
            }
        }
    }

    private class BtnLoadSelectedClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            int selectedRow = tblEquipment.getSelectedRow();
            
            if(selectedRow == -1){
                JOptionPane.showMessageDialog(rootPane, "Select a table row first.");
                return;
            }
            
            tfEqipmentId.setText(tableModel.getValueAt(selectedRow, 0).toString());
            tfName.setText(tableModel.getValueAt(selectedRow, 1).toString());
            tfDepartment.setText(tableModel.getValueAt(selectedRow, 2).toString());
            tfPurchaseDate.setText(tableModel.getValueAt(selectedRow, 3).toString());
            cmbCondition.setSelectedItem(tableModel.getValueAt(selectedRow, 4).toString());
            ckbInUse.setSelected((boolean)tableModel.getValueAt(selectedRow, 5));
            tfPrice.setText(tableModel.getValueAt(selectedRow,6).toString());
            
            lblStatus.setText("Selected record loaded into form.");
        }
    }

    private class BtnUpdateClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(tfEqipmentId.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Load selected record first.");
                return;
            }
            
            int equipmentId = Integer.parseInt(tfEqipmentId.getText().trim());
            String name = tfName.getText().trim();
            String department = tfDepartment.getText().trim();
            LocalDate date = LocalDate.parse(tfPurchaseDate.getText().trim());
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            String condition = (String)cmbCondition.getSelectedItem();
            Boolean inUse = ckbInUse.isSelected();
            Double price = Double.valueOf(tfPrice.getText().trim());
            
            int option = JOptionPane.showConfirmDialog(rootPane, "Update equipment ID " +
                                           equipmentId, "Confirm Update", 
                                           JOptionPane.YES_NO_OPTION);
            if(option != JOptionPane.YES_OPTION){return;}
            
            String sql = "UPDATE LAB_EQUIPMENT "
                    + "SET NAME = ?, DEPARTMENT = ?, "
                    + "PURCHASE_DATE = ?, CONDITION = ?,"
                    + "IN_USE = ?, PRICE = ? "
                    + "WHERE EQUIPMENT_ID = ?";
            
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1,name);
                ps.setString(2, department);
                ps.setDate(3, sqlDate);
                ps.setString(4, condition);
                ps.setBoolean(5, inUse);
                ps.setDouble(6, price);
                ps.setInt(7, equipmentId);
                
                int rows = ps.executeUpdate();
                if(rows == 1){
                    lblStatus.setText("Equipment added successfully.");
                }
                
                btnView.doClick();
                btnClear.doClick();
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(rootPane, "Database Error: " + ex.getMessage());
            }
        }
    }

    private class BtnDeleteClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(tfEqipmentId.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Load a selected row first.");
                return;
            }
            
            int equipmentId = Integer.parseInt(tfEqipmentId.getText().trim());
            int option = JOptionPane.showConfirmDialog(rootPane, "Delete equipment ID "
                                                + equipmentId + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if(option != JOptionPane.YES_OPTION){return;}
            
            String sql = "DELETE FROM LAB_EQUIPMENT "
                    + "WHERE EQUIPMENT_ID = ?";
            
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, equipmentId);
                
                int rows = ps.executeUpdate();
                if(rows == 1){
                    lblStatus.setText("Equipment deleted successfully.");
                    btnView.doClick();
                    btnClear.doClick();
                }
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(rootPane, "Database Error: " + ex.getMessage());
            }
        }
    }

    private class BtnClearClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            tfEqipmentId.setText("");
            tfName.setText("");
            tfDepartment.setText("");
            tfPurchaseDate.setText("");
            cmbCondition.setSelectedItem("New");
            ckbInUse.setSelected(false);
            tfPrice.setText("");
            tblEquipment.clearSelection();
            
            lblStatus.setText("Form cleared.");
        }
    }

    private class BtnExitClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                if(connection != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Error closing connection: " + 
                        ex.getMessage());
            }
            
            System.exit(0);
        }
    }
    
    //Main method+++++++++++++++++++++
    public static void main(String[]args){
        new EquipmentGUI();
    }
}
