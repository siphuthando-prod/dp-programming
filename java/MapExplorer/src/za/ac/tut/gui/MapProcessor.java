
package za.ac.tut.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author S. X Mabuza
 */
public class MapProcessor extends JFrame{
    //Private members++++++++++++++++++
    private JTextArea taParagraph;
    private JTextArea taOutput;
    private JTextField tfSentenceNumber;
    private JTextField tfReplacement;
    private JLabel lblStatus;
    
    private JButton btnBuild;
    private JButton btnDisplay;
    private JButton btnFind;
    private JButton btnReplace;
    private JButton btnRemove;
    private JButton btnKeys;
    private JButton btnValues;
    private JButton btnLongest;
    private JButton btnClear;
    
    private HashMap<Integer, String> sentenceMap;
    
    //Constructor+++++++++++++++++++
    public MapProcessor() {
        // ========================================
        // FRAME
        // ========================================

        setTitle("Sentence Analytics Index");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // ========================================
        // CREATE COMPONENTS
        // ========================================

        taParagraph = new JTextArea(
            "Data structures organise information for different purposes. "
            + " A HashMap associates one key with one value. "
            + " Sentence numbers can become keys,"
            + " while the sentences become values. Keys make direct retrieval possible."
        );

        this.taOutput = new JTextArea();

        this.tfSentenceNumber = new JTextField();
        this.tfReplacement = new JTextField();
        
        lblStatus = new JLabel(
            "Mappings: 0 | No key exists | Longest sentence: 0",
            SwingConstants.CENTER
        );


        // ========================================
        // BUTTONS
        // ========================================

        this.btnBuild = new JButton("Build Sentence Map"); 
        btnDisplay = new JButton("Display Entries"); 
        this.btnLongest = new JButton("Show Longest Sentence"); 
        this.btnFind= new JButton("Find"); 
        this.btnReplace = new JButton("Replace"); 
        this.btnRemove = new JButton("Remove"); 
        this.btnKeys = new JButton("Show Keys"); 
        this.btnValues = new JButton("Show Values"); 
        btnClear = new JButton("Clear Queue");


        // ========================================
        // SOURCE PARAGRAPH PANEL
        // ========================================

        JPanel pnlParagraph = new JPanel(new BorderLayout());

        pnlParagraph.setBorder(
            BorderFactory.createTitledBorder("Source paragraph")
        );

        pnlParagraph.add(
            new JScrollPane(taParagraph),
            BorderLayout.CENTER
        );

        this.sentenceMap = new HashMap<>();
        
        /*this.btnBuild.addActionListener(new QueueProcessor.BtnBuildClickListener());
        this.btnDisplay.addActionListener(new QueueProcessor.BtnDisplayClickListener());
        this.btnLongest.addActionListener(new QueueProcessor.BtnLongestClickListener());
        this.btnFind.addActionListener(new QueueProcessor.BtnFindClickListener());
        this.btnReplace.addActionListener(new QueueProcessor.BtnReplaceClickListener());
        this.btnRemove.addActionListener(new QueueProcessor.BtnRemoveClickListener());
        this.btnKeys.addActionListener(new QueueProcessor.BtnKeysClickListener());
        this.btnValues.addActionListener(new QueueProcessor.BtnValuesClickListener());
        this.btnClear.addActionListener(new QueueProcessor.BtnClearClickListener());*/

        // ========================================
        // TOP BUTTON PANEL
        // ========================================

        JPanel pnlTopButtons = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlTopButtons.add(this.btnBuild); 
        pnlTopButtons.add(btnDisplay); 
        pnlTopButtons.add(this.btnLongest);

        // ========================================
        // WORD INPUT PANEL
        // ========================================

        JPanel pnlWord = new JPanel(new BorderLayout(10, 0)); 
        pnlWord.add(new JLabel("Sentence number:"));
        pnlWord.add(tfSentenceNumber);

        pnlWord.add(new JLabel("Replacement:"));
        pnlWord.add(tfReplacement);
        
        JPanel pnlWordButtons = new JPanel(new FlowLayout()); 
        pnlWordButtons.add(this.btnFind); 
        pnlWordButtons.add(this.btnReplace); 
        pnlWordButtons.add(this.btnRemove); 
        pnlWord.add( pnlWordButtons, BorderLayout.EAST );

        // ========================================
        // STACK OPERATION BUTTON PANEL
        // ========================================

        JPanel pnlMapButtons = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlMapButtons.add(this.btnKeys); 
        pnlMapButtons.add(this.btnValues); 
        pnlMapButtons.add(btnClear);

        // ========================================
        // STACK VISUALISATION / RESULT PANEL
        // ========================================

        JPanel pnlResult =
                new JPanel(new BorderLayout());

        pnlResult.setBorder(
            BorderFactory.createTitledBorder(
                "Stack visualisation / result"
            )
        );

        this.taOutput.setEditable(false);

        pnlResult.add(
            new JScrollPane(this.taOutput),
            BorderLayout.CENTER
        );


        // ========================================
        // STATUS PANEL
        // ========================================

        JPanel pnlStatus =
                new JPanel(new BorderLayout());

        pnlStatus.add(
            lblStatus,
            BorderLayout.CENTER
        );


        // ========================================
        // MAIN PANEL
        // ========================================

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(
            new BoxLayout(
                mainPanel,
                BoxLayout.Y_AXIS
            )
        );

        mainPanel.add(pnlParagraph);
        mainPanel.add(pnlTopButtons);
        mainPanel.add(pnlWord);
        mainPanel.add(pnlMapButtons);
        mainPanel.add(pnlResult);
        mainPanel.add(pnlStatus);


        // ========================================
        // ADD TO FRAME
        // ========================================

        add(mainPanel);


        // ========================================
        // SHOW FRAME
        // ========================================

        setVisible(true);
    }

  //Main method++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new MapProcessor();
    }
}
