
package za.ac.tut.aliengame;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;
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
    private Random random = new Random();
    private int alien;
    
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
            final int index = k;
            
            this.buttons[k].addActionListener(e -> {
                if(index == this.alien){
                    this.score++;
                    this.scoreLabel.setText("Score: " + this.score);
                    moveAlien();
                }
            });
            
            this.gamePanel.add(this.buttons[k]);
        }
        
        moveAlien();
        
        this.setVisible(true);
    }
    //PRIVATE METHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void moveAlien(){
        for (JButton button : buttons) {
            button.setText("");
        }
        
        this.alien = random.nextInt(this.buttons.length);
        this.buttons[this.alien].setText("👽");        
    }
    //MAIN METHOD++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new AlienGame();
    }
}
