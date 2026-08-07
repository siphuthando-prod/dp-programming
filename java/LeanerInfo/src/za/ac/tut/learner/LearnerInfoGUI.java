
package za.ac.tut.learner;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

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
    private JCheckBox ckbFoodDrugs;
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
        
        //Learner row+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel learnerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lblLearner = new JLabel("Learner");
        this.tfLearner = new JTextField(12);
        
        learnerPanel.add(lblLearner);
        learnerPanel.add(this.tfLearner);
        
        //Building Age row++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lblAge = new JLabel("Age");
        
        this.spnAge = new JSpinner(
                new SpinnerNumberModel(
                        1,              //initial value
                        1,      //minimum value
                        6,      //maximum value
                        1       //step size
                )
        );
        
        agePanel.add(lblAge);
        agePanel.add(this.spnAge);
        
        //Building Gender row++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lblGender = new JLabel("Gender");
        this.rbtnMale = new JRadioButton("Male");
        this.rbtnFemale = new JRadioButton("Female");
        
        this.genderGroup = new ButtonGroup();
        this.genderGroup.add(this.rbtnMale);
        this.genderGroup.add(this.rbtnFemale);
        
        genderPanel.add(lblGender);
        genderPanel.add(this.rbtnMale);
        genderPanel.add(this.rbtnFemale);
        
        //Building Allergies row+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel allergyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel lblAllergies = new JLabel("Allergies?");
        this.ckbRespitory = new JCheckBox("Respiratory");
        this.ckbFoodDrugs = new JCheckBox("Food/Drugs");
        this.ckbContact = new JCheckBox("Contact");
        
        allergyPanel.add(lblAllergies);
        allergyPanel.add(this.ckbRespitory);
        allergyPanel.add(this.ckbFoodDrugs);
        allergyPanel.add(this.ckbContact);
        
        //Building the Button row++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        this.btnSave = new JButton("Save Info");
        this.btnClear = new JButton("Clear Info");
        
        buttonPanel.add(this.btnSave);
        buttonPanel.add(this.btnClear);
        
        //Stacking the input rows+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JPanel inputPanel = new JPanel(new GridLayout(5, 1));
        
        inputPanel.add(learnerPanel);
        inputPanel.add(agePanel);
        inputPanel.add(genderPanel);
        inputPanel.add(allergyPanel);
        inputPanel.add(buttonPanel);
        
        
    }
}
