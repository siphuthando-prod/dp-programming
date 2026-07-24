
package za.tut.gui;

//IMPORT STATEMENTS++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author S. X Mabuza
 */
public class GreetingsGUI extends JFrame {
        //PANELS+++++++++++++++++++++++++++++++++++++++++++++
        private JPanel namePnl;
        private JPanel surnamePnl;
        private JPanel nameAndSurnamePnl;
        private JPanel greetingsAreaPnl;
        private JPanel btnsPnl;
        private JPanel mainPnl;
        private JPanel headingPnl;
        
        //LABELS++++++++++++++++++++++++++++++++++++++++++++++
        private JLabel headingLbl;
        private JLabel nameLbl;
        private JLabel surnameLbl;
        
        //TEXTFIELDS++++++++++++++++++++++++++++++++++++++++
        private JTextField nameTxtFld;
        private JTextField surnameTxtFld;
        
        //TEXTAREA++++++++++++++++++++++++++++++++++++++++++
        private JTextArea greetingsTxtArea;
        
       //BUTTONS++++++++++++++++++++++++++++++++++++++++++++++
        private JButton greetBtn;
        private JButton clearBtn;
        private JButton exitBtn;
        
        public GreetingsGUI(){
            //Configuring the GUI++++++++++++++++++++++++++++++++++++
            setLayout(new BorderLayout());
            setTitle("Greetings UI");
            setSize(700, 750);
            setBackground(Color.YELLOW);
            
            //Creating the panels+++++++++++++++++++++++++++++++++++++++
            namePnl = new JPanel(new FlowLayout());
            surnamePnl = new JPanel(new FlowLayout());
            
            nameAndSurnamePnl = new JPanel(new GridLayout(2, 1));
            
            greetingsAreaPnl = new JPanel(new FlowLayout());
            greetingsAreaPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Greetings"));
            
            btnsPnl = new JPanel(new FlowLayout());
            mainPnl = new JPanel(new FlowLayout());
            
            headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
            headingPnl.setBorder(new BevelBorder(BevelBorder.RAISED));
            
            
        }
}
