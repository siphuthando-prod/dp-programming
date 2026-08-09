
package za.ac.tut.aliengame;

//IMPORT STATEMENTS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author S. X Mabuza
 */
public class AlienGame extends JFrame{
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JLabel scoreLabel = new JLabel("Score: 0");
    private int score;
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public AlienGame(){
        this.setTitle("Catch the alien");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(this.scoreLabel, BorderLayout.NORTH);
        this.setVisible(true);
    }
    
    //MAIN METHOD++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new AlienGame();
    }
}
