
package za.ac.tut.ui;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author S. X Mabuza
 */
public class GymMembershipFrame extends JFrame {
    //Panels+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JPanel headingPnl;
    private JPanel clientPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractsPnl;
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
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++
    public GymMembershipFrame(){
        //Configuring frame++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.setTitle("Gym membership");
        this.setSize(500, 500);
        
        //Creatnig Panels+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        this.clientPnl = new JPanel(new GridLayout(4, 1, 1, 1));
        this.clientPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Client Details"));
        
        this.namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.idNoPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        this.contractsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.personalTrainerOptionPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        this.membershipPnl = new JPanel(new GridLayout(2, 1, 1, 1));
        this.membershipPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1)));
        
        this.commentsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        this.btnsPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.headingClientCombinedPnl = new JPanel(new BorderLayout());
        this.membershipCommentsCombinedPnl = new JPanel(new BorderLayout());
        this.mainPnl = new JPanel(new BorderLayout());
    }
}
