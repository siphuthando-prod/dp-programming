
package za.ac.tut.frames;
//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author S. X Mabuza
 */
public class PasswordGUI extends JFrame {
    //PANELS+++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JPanel usernamePnl;
    private JPanel passwordPnl;
    private JPanel usernameAndPasswordPnl;
    private JPanel titlePnl;
    private JPanel headingPnl;
    private JPanel btnsPnl;
    private JPanel mainPnl;
    
    //LABELS++++++++++++++++++++++++++++++++++++++++++++++++++
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JLabel titleLbl;
    private JLabel headingLbl;
    
    //TEXTFIELDS+++++++++++++++++++++++++++++++++++++++++++++
    private JTextField usernameTxtFld;
    private JTextField passwordTxtFld;
    
    //BUTTONS++++++++++++++++++++++++++++++++++++++++++++++++
    private JButton submitBtn;
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++
    public PasswordGUI(){
        //Configuring GUI+++++++++++++++++++++++++++++++++++++++++++++
        this.setLayout(new BorderLayout());
        this.setTitle("Password GUI");
        this.setSize(200, 250);
        this.setBackground(Color.BLUE);
        
        //Creating panels++++++++++++++++++++++++++++++++++++++++++++++
        this.usernamePnl = new JPanel(new FlowLayout());
        this.passwordPnl = new JPanel(new FlowLayout());        
        this.usernameAndPasswordPnl = new JPanel(new GridLayout(2,1));
        
        this.titlePnl = new JPanel(new FlowLayout());
        
        this.headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.headingPnl.setBorder(new BevelBorder(BevelBorder.RAISED));
        
        this.btnsPnl = new JPanel(new FlowLayout());
        this.mainPnl = new JPanel(new FlowLayout());
        
        //Creating labels+++++++++++++++++++++++++++++++++++++++++++++++
        this.headingLbl = new JLabel("User login page");
        this.titleLbl = new JLabel("Login details");
        this.usernameLbl = new JLabel("Username: ");
        this.passwordLbl = new JLabel("Password: ");
        
        //Creating text fields++++++++++++++++++++++++++++++++++++++++++
        this.usernameTxtFld = new JTextField(20);
        this.passwordTxtFld = new JTextField(20);
        
        //Creating button++++++++++++++++++++++++++++++++++++++++++++++
        this.submitBtn = new JButton("Submit");
        
        //Adding username label & textfield to the panel++++++++++++++++++++++++++++
        this.usernamePnl.add(this.usernameLbl);
        this.usernamePnl.add(this.usernameTxtFld);
        
        //Adding password label & textfield to the panel++++++++++++++++++++++++++++
        this.passwordPnl.add(this.passwordLbl);
        this.passwordPnl.add(this.passwordTxtFld);
        
        //Adding username and password panels to the collective panel+++++++++++++++++++++
        this.usernameAndPasswordPnl.add(this.usernamePnl);
        this.usernameAndPasswordPnl.add(this.passwordPnl);
        
        //Adding title label to the panel++++++++++++++++++++++++++++++++++++++++++++
        this.titlePnl.add(this.titleLbl);
        
        //Adding heading label to the panel++++++++++++++++++++++++++++++++++++++++++
        this.headingPnl.add(this.headingLbl);
        
        //Adding button label to the panel+++++++++++++++++++++++++++++++++++++++++++
        this.btnsPnl.add(this.submitBtn);
        
        //Adding all panels to the main panel+++++++++++++++++++++++++++++++++++
        this.mainPnl.add(this.titlePnl, BorderLayout.NORTH);
        this.mainPnl.add(this.usernameAndPasswordPnl, BorderLayout.CENTER);
        this.mainPnl.add(this.btnsPnl, BorderLayout.SOUTH);
        
        //Adding panels to the frame+++++++++++++++++++++++++++++++++++++++++
        this.add(this.headingLbl, BorderLayout.NORTH);
        this.add(this.mainPnl, BorderLayout.CENTER);
        
        //Making the frame visible+++++++++++++++++++++++++++++++++++++++++++++++++
        this.setVisible(true);
    }
}
