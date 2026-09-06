
package za.ac.tut.gui;
//Import statements++++++++++++++++++++++++++
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

/**
 *
 * @author S. X Mabuza
 */
public class StackProcessor extends JFrame{
    //Private members++++++++++++++++++++++++++++
    private JTextArea taParagraph;
    private JTextArea taResult;
    private JTextField txtWord;
    private JLabel lblStatus;
    
    private JButton btnLoad;
    private JButton btnDisplay;
    private JButton btnPush;
    private JButton btnPeek;
    private JButton btnPop;
    private JButton btnSearch;
    private JButton btnReverse;
    private JButton btnClear;
    
    private Stack<String> wordStack;
    
    //Construcor++++++++++++++++++
    public StackProcessor() {
        // ========================================
        // FRAME
        // ========================================

        setTitle("Paragraph Stack Explorer");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // ========================================
        // CREATE COMPONENTS
        // ========================================

        taParagraph = new JTextArea(
            "Stacks process values in last-in-first-out order. "
            + "\nA paragraph can be cleaned into words, and every "
            + "word can be pushed onto the stack. \nThe final word "
            + "becomes the top item."
        );

        taResult = new JTextArea();

        txtWord = new JTextField();

        lblStatus = new JLabel(
            "Stack size: 0 | Stack is empty",
            SwingConstants.CENTER
        );


        // ========================================
        // BUTTONS
        // ========================================

        btnLoad = new JButton("Load Paragraph"); 
        btnDisplay = new JButton("Display Stack"); 
        btnReverse = new JButton("Reverse Paragraph"); 
        btnPush = new JButton("Push Word"); 
        btnSearch = new JButton("Search Position"); 
        btnPeek = new JButton("Peek Top"); 
        btnPop = new JButton("Pop Top"); 
        btnClear = new JButton("Clear Stack");


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

        this.wordStack = new Stack<>();
        
        this.btnLoad.addActionListener(new BtnLoadClickListener());
        this.btnDisplay.addActionListener(new BtnDisplayClickListener());
        this.btnPush.addActionListener(new BtnPushClickListener());
        this.btnPeek.addActionListener(new BtnPeekClickListener());
        this.btnPop.addActionListener(new BtnPopClickListener());
        this.btnSearch.addActionListener(new BtnSearchClickListener());
        this.btnReverse.addActionListener(new BtnReverseClickListener());
        this.btnClear.addActionListener(new BtnClearClickListener());

        // ========================================
        // TOP BUTTON PANEL
        // ========================================

        JPanel pnlTopButtons = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlTopButtons.add(this.btnLoad); 
        pnlTopButtons.add(btnDisplay); 
        pnlTopButtons.add(btnReverse);

        // ========================================
        // WORD INPUT PANEL
        // ========================================

        JPanel pnlWord = new JPanel(new BorderLayout(10, 0)); 
        txtWord.setToolTipText("Enter a word..."); 
        pnlWord.add( txtWord, BorderLayout.CENTER ); 
        JPanel pnlWordButtons = new JPanel(new FlowLayout()); 
        pnlWordButtons.add(btnPush); 
        pnlWordButtons.add(btnSearch); 
        pnlWord.add( pnlWordButtons, BorderLayout.EAST );

        // ========================================
        // STACK OPERATION BUTTON PANEL
        // ========================================

        JPanel pnlStackButtons = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlStackButtons.add(btnPeek); 
        pnlStackButtons.add(btnPop); 
        pnlStackButtons.add(btnClear);

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

        taResult.setEditable(false);

        pnlResult.add(
            new JScrollPane(taResult),
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
        mainPanel.add(pnlStackButtons);
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

    //main method+++++++++++++
    public static void main(String[]args){
        new StackProcessor();
    }

    private class BtnLoadClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            wordStack.clear();
            
            String cleaned = taParagraph.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z]", " ")
                    .replaceAll("\\s+", " ")
                    .trim();
            
            if(cleaned.isEmpty()){
                lblStatus.setText("Enter a paragraph first.");
                return;
            }
            
            String[] words = cleaned.split("\\s+");
            
            for (String word : words) {
                wordStack.push(word);
            }
            
            lblStatus.setText("Loaded " + wordStack.size() + " words. Top: " + wordStack.peek());
        }
    }

    private class BtnPushClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String word = txtWord.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z]", " ")
                    .trim();
            
            if(word.isEmpty()){
                lblStatus.setText("Enter one valid word");
                return;
            }
            
            wordStack.push(word);
            lblStatus.setText(word + " pushed to the top.");
        }
    }
    
    private class BtnPeekClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(wordStack.isEmpty()){
                lblStatus.setText("Cannot peek: Stack is empty.");
            } else{
                lblStatus.setText("Top word: " + wordStack.peek());
            }
        }
    }

    private class BtnPopClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            if(wordStack.isEmpty()){
                lblStatus.setText("Cannot pop: Stack is empty");
            } else{
                String removed = wordStack.pop();
                lblStatus.setText(removed + " was popped. " + wordStack.size() + " items remain.");
            }
        }
    }

    private class BtnSearchClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String target = txtWord.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z]", " ")
                    .trim();
            
            int position = wordStack.search(target);
            
            if(position == -1){
                lblStatus.setText(target + " was NOT found.");
            } else{
                lblStatus.setText(target + " is position " + position + " from the top.");
            }
        }
    }

     private class BtnDisplayClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            taResult.setText("");
            
            Stack<String> copy = new Stack<>();
            copy.addAll(wordStack);
            int position = 1;
            
            while(!copy.empty()){
                taResult.append(position + ". " + copy.pop() + "\n");
                position++;
            }
        }
    }

    private class BtnReverseClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Stack<String> copy = new Stack<>();
            copy.addAll(wordStack);
            
            String reversed = "";
            
            while(!copy.empty()){
                reversed = reversed + copy.pop() + " ";
            }
            
            taResult.setText(reversed.trim());
        }
    }

    private class BtnClearClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            wordStack.clear();
            taResult.setText("");
            lblStatus.setText("The Stack has been cleared.");
        }
    }

}
