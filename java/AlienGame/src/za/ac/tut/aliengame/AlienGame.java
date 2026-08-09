
package za.ac.tut.aliengame;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author S. X Mabuza
 */
public class AlienGame extends JFrame{
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JLabel scoreLabel = new JLabel("Score: 0");
    private int score;
    private JPanel gamePanel = new JPanel();
    private JButton[] buttons = new JButton[16];
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public AlienGame(){
        //Configuring the frame++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.setTitle("Catch the alien");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(this.scoreLabel, BorderLayout.NORTH);
        //Configuring game buttons+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.gamePanel.setLayout(new GridLayout(4, 4));
        this.add(this.gamePanel, BorderLayout.CENTER);
        
        for(int k = 0; k < this.buttons.length; k++){
            this.buttons[k] = new JButton();
            this.gamePanel.add(this.buttons[k]);
        }
        
        this.setVisible(true);
    }
    
    //MAIN METHOD++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new AlienGame();
    }
}
