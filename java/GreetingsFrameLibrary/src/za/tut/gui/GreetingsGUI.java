
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
            
            //CREATING THE LABELS+++++++++++++++++++++++++++++++
            headingLbl = new JLabel("Greetings App");
            nameLbl = new JLabel("Name: ");
            surnameLbl = new JLabel("Surname: ");
            
            //CREATING TEXT FIELDS+++++++++++++++++++++++++++++++
            nameTxtFld = new JTextField(20);
            surnameTxtFld = new JTextField(20);
            
            //CREATING TEXT AREAS++++++++++++++++++++++++++++++++
            greetingsTxtArea = new JTextArea(40, 50);
            greetingsTxtArea.setEditable(false);
            this.greetingsTxtArea.setText("Hello [name] [surname]");
            
            //CREATING BUTTONS+++++++++++++++++++++++++++++++++++++
            this.greetBtn = new JButton("Greet");
            this.clearBtn = new JButton("Clear");
            this.exitBtn = new JButton("Exit");
            
            //adding name label textfield to the name panel++++++++++++++++++++++++++++++
            this.namePnl.add(this.nameLbl);
            this.namePnl.add(this.nameTxtFld);
            
            //adding label textfield to the surname panel+++++++++++++++++++++++++++++++
            this.surnamePnl.add(this.surnameLbl);
            this.surnamePnl.add(this.surnameTxtFld);
            
            //adding the name and surname panels to the collective panel+++++++++++++++++
            this.nameAndSurnamePnl.add(this.namePnl);
            this.nameAndSurnamePnl.add(this.surnamePnl);
            
            //adding greetings area to its panel++++++++++++++++++++++++++++++++++++
            this.greetingsAreaPnl.add(this.greetingsTxtArea);
            
            //adding buttons to their panels+++++++++++++++++++++++++++++++++++++++
            this.btnsPnl.add(this.greetBtn);
            this.btnsPnl.add(this.clearBtn);
            this.btnsPnl.add(this.exitBtn);
            
            //adding all the panels to the main panel+++++++++++++++++++++++++++++++++
            this.mainPnl.add(this.nameAndSurnamePnl, BorderLayout.NORTH);
            this.mainPnl.add(this.greetingsAreaPnl, BorderLayout.CENTER);
            this.mainPnl.add(this.btnsPnl, BorderLayout.SOUTH);
            
            this.add(this.headingPnl, BorderLayout.NORTH);
            this.add(this.mainPnl, BorderLayout.CENTER);
            
            //Making frame visible++++++++++++++++++++++++++++++++++++++++++++++
            this.setVisible(true);
        }
}
