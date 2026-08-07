
package za.ac.tut.learner;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author S. X Mabuza
 */
public class LearnerInfoGUI extends JFrame{
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JTextField tfLearner;
    private JSpinner spnAge;
    
    private JRadioButton rbtnMale;
    private JRadioButton rbtnFemale;
    private ButtonGroup genderGroup;
    
    private JCheckBox ckbRespitory;
    private JCheckBox FoodDrugs;
    private JCheckBox ckbContact;
    
    private JButton btnSave;
    private JButton btnClear;
    
    private JTextArea taOutput;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public LearnerInfoGUI(){
        this.setTitle("My First Swing Application");
        this.setSize(530, 540);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        
    }
}
