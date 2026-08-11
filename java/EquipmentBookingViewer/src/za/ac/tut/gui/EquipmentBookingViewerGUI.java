
package za.ac.tut.gui;
//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author S. X Mabuza
 */
public class EquipmentBookingViewerGUI extends JFrame {
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JMenuItem miOpen;
    private JMenuItem miExit;
    private JLabel lblStatus;
    private JTextArea taBookings;
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public EquipmentBookingViewerGUI(){
        //Configuring Frame++++++++++++++++++++++++++++++++++++++++++
        super("Equipment Booking File Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMenu();
        createMenuInterface();
        registerLIsteners();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //PRIVATE METHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void createMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void createMenuInterface() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void registerLIsteners() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
