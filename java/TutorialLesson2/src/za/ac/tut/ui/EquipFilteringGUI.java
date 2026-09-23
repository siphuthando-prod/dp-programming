
package za.ac.tut.ui;

import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    private JTable tblEquipment;
    private DefaultTableModel tableModel;
    private Connection connection;
}
