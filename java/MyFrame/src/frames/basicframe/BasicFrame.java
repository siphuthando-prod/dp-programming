
package frames.basicframe;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author S. X Mabuza
 */
public class BasicFrame extends JFrame {
    //CONSTRUCTOR+++++++++++++++++++++++++++++
    public BasicFrame(){
        setTitle("S. X Mabuza");
        setSize(200, 250);
        setResizable(true);
        setDefaultLookAndFeelDecorated(true);
        setForeground(Color.GREEN);
        setVisible(true);
    }
}
