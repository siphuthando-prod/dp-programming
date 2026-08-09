
package ac.za.tut.cargui;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import za.ac.aop.CarManager;

/**
 *
 * @author S. X Mabuza
 */
public class CarGUI extends JFrame{
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Panels+++++++++++++
    private JPanel ui;
    private JPanel pnlData;
    //Labels+++++++++++++++++++++++++++++++
    private JLabel lblName;
    private JLabel lblModel;
    private JLabel lblResult;
    //Text fields+++++++++++++++++++++++++++++
    private JTextField tfBrandName;
    private JTextField tfYearModel;
    //Text area+++++++++++++++++++++++++++
    private JTextArea carOutput;
    //Buttons+++++++++++++++++++++++++++++++
    private JButton btnAdd;
    private JButton btnDisplay;
    private JButton btnSearch;
    //Car manager++++++++++++++++++++++++++++++
    private CarManager cm;
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public CarGUI(){
        this.setTitle("Car Management System");
        this.setSize(430, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.cm = new CarManager();
        
        this.buildInterface();
        this.registerListeners();
        
        this.setVisible(true);
    }

    //PRIVATE METHODS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void buildInterface() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void registerListeners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
