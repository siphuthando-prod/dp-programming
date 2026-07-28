
package za.ac.tut.ui;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.border.SoftBevelBorder;
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
        
        //Creating Labels+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.headingLbl = new JLabel("Membership Form");
        this.headingLbl.setFont(new Font(Font.SANS_SERIF, Font.ITALIC + Font.BOLD, 20));
        this.headingLbl.setForeground(Color.BLUE);
        this.headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        this.nameLbl = new JLabel("Name:                ");
        this.surnameLbl = new JLabel("Surname:    ");
        this.idNoLbl = new JLabel("Id no:                  ");
        this.genderLbl = new JLabel("Gender:        ");
        this.contractTypeLbl = new JLabel("Type of contract:    ");
        this.peresonalTrainerLbl = new JLabel("Select the checkbox if you need a personal trainer ");
        
        //Creating textfields++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.nameTxtFld = new JTextField(10);
        this.surnameTxtFld = new JTextField(10);
        this.idNoTxtFld = new JTextField(10);
        
        //Creating combobox++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.genderComboBox = new JComboBox();
        this.genderComboBox.addItem("Male");
        this.genderComboBox.addItem("Female");
        
        //Creating radio buttons++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.monthToMonthRadBtn = new JRadioButton("Month-to-month");
        this.sixMonthsRadBtn = new JRadioButton("Six months");
        this.annualRadBtn = new JRadioButton("Annual");
        
        //Creating checkbox++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.personalTrainerChkBx = new JCheckBox();
        
        //Creating button group++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.btnGrp = new ButtonGroup();
        this.btnGrp.add(this.monthToMonthRadBtn);
        this.btnGrp.add(this.sixMonthsRadBtn);
        this.btnGrp.add(this.annualRadBtn);
        
        //Creating text area+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
        this.commentsArea = new JTextArea(20, 40);
        this.commentsArea.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Comments"));
        
        this.scrollableTxtArea = new JScrollPane(this.commentsArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                                                                                            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //Creating button+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.applyBtn = new JButton("Apply");
        
        //Adding components to panels++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.headingPnl.add(this.headingLbl);   //--> first collective panel
        
        this.namePnl.add(this.nameLbl);
        this.namePnl.add(this.nameTxtFld);
        
        this.surnamePnl.add(this.surnameLbl);
        this.surnamePnl.add(this.surnameTxtFld);
        
        this.idNoPnl.add(this.idNoLbl);
        this.idNoPnl.add(this.idNoTxtFld);
        
        this.genderPnl.add(this.genderLbl);
        this.genderPnl.add(this.genderComboBox);
        
        this.clientPnl.add(this.namePnl);   //--> Second collective panel
        this.clientPnl.add(this.surnamePnl);
        this.clientPnl.add(this.idNoPnl);
        this.clientPnl.add(this.genderPnl);
        
        this.headingClientCombinedPnl.add(this.headingPnl, BorderLayout.NORTH);
        this.headingClientCombinedPnl.add(this.clientPnl, BorderLayout.CENTER);
        
        this.contractsPnl.add(this.contractTypeLbl);
        this.contractsPnl.add(this.monthToMonthRadBtn);     //--> Third collective panel
        this.contractsPnl.add(this.sixMonthsRadBtn);
        this.contractsPnl.add(this.annualRadBtn);
        
        this.personalTrainerOptionPnl.add(this.peresonalTrainerLbl);
        this.personalTrainerOptionPnl.add(this.personalTrainerChkBx);
        
        this.membershipPnl.add(this.contractsPnl);
        this.membershipPnl.add(this.personalTrainerOptionPnl);
        
        this.commentsPnl.add(this.scrollableTxtArea);
        
        this.membershipCommentsCombinedPnl.add(this.membershipPnl, BorderLayout.NORTH);
        this.membershipCommentsCombinedPnl.add(this.commentsPnl,
                                                                                                                           BorderLayout.CENTER);
        
        this.btnsPnl.add(this.applyBtn);
        
        this.mainPnl.add(this.headingClientCombinedPnl, BorderLayout.NORTH);
        this.mainPnl.add(this.membershipCommentsCombinedPnl, BorderLayout.CENTER);
        this.mainPnl.add(this.btnsPnl, BorderLayout.SOUTH);
        
        add(this.mainPnl);
        
        pack();
        setVisible(true);
    }
}
