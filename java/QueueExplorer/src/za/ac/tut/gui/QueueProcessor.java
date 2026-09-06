
package za.ac.tut.gui;
//Import statements++++++++++++++++++++++++
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author S. X Mabuza
 */
public class QueueProcessor {
    //Private members+++++++++++++++++++++++++++
    private JTextArea taParagraph;
    private JTextArea taResult;
    private JTextField tfWord;
    private JLabel lblStatus;
    
    private JButton btnLoad;
    private JButton btnDisplay;
    private JButton btnOffer;
    private JButton btnPeek;
    private JButton btnPoll;
    private JButton btnFind;
    private JButton btnProcessAll;
    private JButton btnClear;
    
    private Queue<String> wordQueue;
}
