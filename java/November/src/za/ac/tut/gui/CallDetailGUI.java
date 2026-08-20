
package za.ac.tut.gui;

//Import statements++++++++++++++++++++++++++++++++++++++++++++++
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import za.ac.aop.processor.CallDetailProcessor;

/**
 *
 * @author S. X Mabuza
 */
public class CallDetailGUI extends JFrame{
    
    //Private Members++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JLabel lblStatus;
    private JTextArea taRecords;
    private JComboBox<String> cmbProvider;
    private JCheckBox ckbApplyFilter;
    private JButton btnShowDurations;
    private JButton btnTotalDuration;
    private JButton btnMostCalls;
    private JButton btnLongestCall;
    
    private CallDetailProcessor processor;
    
}
