
package za.ac.tut.ui;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author S. X Mabuza
 */
public class GymMembershipFrame extends JFrame {
    //Panels+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JPanel headingPnl;
    private JPanel clientPnl;
    private JPanel namePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractPnl;
    private JPanel personalTrainerOptionPnl;
    private JPanel membershipPnl;
    private JPanel commentsPnl;
    private JPanel btnsPnl;
    private JPanel headingClientCombinedPnl;
    private JPanel membershipCommentsCombinedPnl;
    private JPanel mainPnl;
    
    //Labels+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel peresonalTrainerLbl;
    private JLabel contractTypeLbl;
    
    //Textfields++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JTextField nameTxtFld;
    private JTextField  surnameTxtFld;
    private JTextField idNoTxtFld;
    
    //Combbox++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JComboBox genderComboBox;
    
    //Radio buttons+++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JRadioButton monthToMonthRadBtn;
    private JRadioButton sixMonthsRadBtn;
    private JRadioButton annualRadBtn;
    
    //Checkbox++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JCheckBox personalTrainerChkBx;
    
    //Buttongroup++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private ButtonGroup btnGrp;
    
    //Textarea++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JTextArea commentsArea;
    
    //Scrollpane+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JScrollPane scrollableTxtArea;
    
    //Private button++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JButton applyBtn;
    
    
}
