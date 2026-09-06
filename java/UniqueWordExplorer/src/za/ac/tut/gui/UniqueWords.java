
package za.ac.tut.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
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
public class UniqueWords extends JFrame {
    //Import statements++++++++++++++++++++++++++++++++++
    private JTextArea taParagraph;
    private JTextArea taUniqueWords;
    private JTextField txtWord;
    private JTextField txtIgnoreWords;
    private JLabel lblStatus;
    
    private JButton btnProcess;
    private JButton btnDisplay;
    private JButton btnContains;
    private JButton btnRemove;
    private JButton btnRemoveIgnored;
    private JButton btnStatistics;
    private JButton btnClear;
    
    private Set<String> uniqueWords;   
    
    public UniqueWords() {

    // Set
    uniqueWords = new HashSet<>();

    // Frame
    setTitle("Unique Word Explorer");
    setSize(500, 650);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);


    // ========================================
    // CREATE COMPONENTS
    // ========================================

    taParagraph = new JTextArea(
        "Java collections help programmers organise data. "
        + "Java sets store unique values,\n while data cleaning prepares "
        + "words for reliable comparison.\n A SET ignores duplicate "
        + "elements, but case and punctuation must be cleaned first!"
    );

    taUniqueWords = new JTextArea();

    txtWord = new JTextField();
    txtIgnoreWords = new JTextField("a,the,and,of,to");

    lblStatus = new JLabel(
        "Unique words: 0 | Set is empty",
        SwingConstants.CENTER
    );


    // ========================================
    // BUTTONS
    // ========================================

    btnProcess = new JButton("Process Paragraph");
    btnDisplay = new JButton("Display Set");

    btnContains = new JButton("Contains?");
    btnRemove = new JButton("Remove");

    btnRemoveIgnored = new JButton("Remove Ignored Words");

    btnStatistics = new JButton("Statistics");

    btnClear = new JButton("Clear Set");


    // ========================================
    // LISTENERS
    // ========================================

    btnProcess.addActionListener(new BtnProcessClickListener());
    btnDisplay.addActionListener(new BtnDisplayClickListener());
    btnContains.addActionListener(new BtnContainsClickListener());
    btnRemove.addActionListener(new BtnRemoveClickListener());
    btnRemoveIgnored.addActionListener(new BtnRemoveIgnoredClickListener());
    btnStatistics.addActionListener(new BtnStatisticsClickListener());
    btnClear.addActionListener(new BtnClearClickListener());


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


    // ========================================
    // TOP BUTTON PANEL
    // ========================================

    JPanel pnlTopButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));

    pnlTopButtons.add(btnProcess);
    pnlTopButtons.add(btnDisplay);
    pnlTopButtons.add(btnStatistics);


    // ========================================
    // SEARCH PANEL
    // ========================================

    JPanel pnlSearch = new JPanel(new BorderLayout(10, 0));

    txtWord.setToolTipText("Search or remove a word...");

    pnlSearch.add(txtWord, BorderLayout.CENTER);


    JPanel pnlSearchButtons = new JPanel(new FlowLayout());

    pnlSearchButtons.add(btnContains);
    pnlSearchButtons.add(btnRemove);

    pnlSearch.add(pnlSearchButtons, BorderLayout.EAST);


    // ========================================
    // IGNORED WORDS PANEL
    // ========================================

    JPanel pnlIgnored = new JPanel(new BorderLayout(10, 0));

    pnlIgnored.add(txtIgnoreWords, BorderLayout.CENTER);

    pnlIgnored.add(
        btnRemoveIgnored,
        BorderLayout.EAST
    );


    // ========================================
    // UNIQUE WORDS PANEL
    // ========================================

    JPanel pnlUniqueWords = new JPanel(new BorderLayout());

    pnlUniqueWords.setBorder(
        BorderFactory.createTitledBorder("Unique words")
    );

    taUniqueWords.setEditable(false);

    pnlUniqueWords.add(
        new JScrollPane(taUniqueWords),
        BorderLayout.CENTER
    );


    // ========================================
    // BOTTOM BUTTON PANEL
    // ========================================

    JPanel pnlBottomButtons =
            new JPanel(new FlowLayout(FlowLayout.LEFT));

    pnlBottomButtons.add(btnClear);


    // ========================================
    // STATUS PANEL
    // ========================================

    JPanel pnlStatus = new JPanel(new BorderLayout());

    pnlStatus.add(lblStatus, BorderLayout.CENTER);


    // ========================================
    // MAIN PANEL
    // ========================================

    JPanel mainPanel = new JPanel();

    mainPanel.setLayout(
        new BoxLayout(mainPanel, BoxLayout.Y_AXIS)
    );


    mainPanel.add(pnlParagraph);
    mainPanel.add(pnlTopButtons);
    mainPanel.add(pnlSearch);
    mainPanel.add(pnlIgnored);
    mainPanel.add(pnlUniqueWords);
    mainPanel.add(pnlBottomButtons);
    mainPanel.add(pnlStatus);


    // Add to JFrame

    add(mainPanel);


    // Show JFrame

    setVisible(true);
}

    private  class BtnDisplayClickListener implements ActionListener {
     @Override
        public void actionPerformed(ActionEvent e) {
            taUniqueWords.setText("");
            
            for (String uniqueWord : uniqueWords) {
             taUniqueWords.append(uniqueWord + "\n");
         }
        }
    }

    private  class BtnContainsClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String target = txtWord.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z]", " ")
                    .trim();
            
            if(target.isEmpty()){
                lblStatus.setText("Enter one word to search");
            } else if(uniqueWords.contains(target)){
                lblStatus.setText(target + " is in the Set.");
            } else{
                lblStatus.setText(target + " is NOT in the Set.");
            }
            
        }
    }

    private  class BtnRemoveClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String target = txtWord.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z]", " ")
                    .trim();
            boolean removed = uniqueWords.remove(target);
            if(removed){
                lblStatus.setText(target + " was removed.");
            } else{
                lblStatus.setText(target + " was NOT found!");
            }
        }
    }

    private  class BtnRemoveIgnoredClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ignoredText = txtIgnoreWords.getText()
                    .toLowerCase()
                    .trim();
            
            Set<String> requiredWords = new HashSet<>();
            requiredWords.add("java");
            requiredWords.add("data");
            
            boolean hasEveryRequiredWord =
                    uniqueWords.containsAll(requiredWords);
            
            Set<String> technicalWords = new HashSet<>();
            technicalWords.add("java");
            technicalWords.add("data");
            technicalWords.add("collections");
            technicalWords.add("set");
            
            Set<String> matches = new HashSet<>();
            matches.addAll(uniqueWords);
            matches.retainAll(technicalWords);
            
            String[] ignoredArray = ignoredText.split(",");
            Set<String> ignoredWords = new HashSet<>();
            
            for (String string : ignoredArray) {
                if(!string.trim().isEmpty()){
                    ignoredWords.add(string.trim());
                }
            }
            
            uniqueWords.removeAll(ignoredWords);
            lblStatus.setText("Ignored words removed. " + uniqueWords.size() + " words remain");
        }
    }

    private  class BtnStatisticsClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(uniqueWords.isEmpty()){
                lblStatus.setText("Set is empty.");
            } else{
                lblStatus.setText("The Set contains " + uniqueWords.size() + " unique words.");
            }
        }
    }

    private  class BtnClearClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            uniqueWords.clear();
            taUniqueWords.setText("");
            lblStatus.setText("The Set has been cleared");
        }
    }

    private  class BtnProcessClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            uniqueWords.clear();
            
            String paragraph = taParagraph.getText();
            
            String cleanedText = paragraph.toLowerCase() //first change the text to lower case
                    .replaceAll("[^a-z]", " ") //the replace every character that is NOT a lowercase letter(a to z), with a space
                    .trim();  //lastly, trim the text
            
            if(cleanedText.isEmpty()){
                lblStatus.setText("Enter a paragraph first.");
                return;
            }
            
            String[] words = cleanedText.split("\\s+");
            /*for (String word : words) {
                uniqueWords.add(word);
             }*/
            
            int accepted = 0;
            int duplicates = 0;
            
            for (String word : words) {
                boolean changed = uniqueWords.add(word);
                if(changed){
                    accepted++;
                } else{
                    duplicates++;
                }
            }
            lblStatus.setText("Unique words: " + uniqueWords.size() );
        }
            
    }
    
    public static void main(String[]args){
        new UniqueWords();
    }
}
