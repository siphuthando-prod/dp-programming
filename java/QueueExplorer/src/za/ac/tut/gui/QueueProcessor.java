
package za.ac.tut.gui;
//Import statements++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
public class QueueProcessor extends JFrame{
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
    
    //Constructor+++++++++++++++++++++
     public QueueProcessor() {
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
            "Queues process values in first-in-first-out order. "
            + "\nA paragraph can be cleaned into words, "
            + "and every word can join the rear of the queue."
            + "\n The first word becomes the head item. "
        );

        taResult = new JTextArea();

        this.tfWord = new JTextField();

        lblStatus = new JLabel(
            "Stack size: 0 | Stack is empty",
            SwingConstants.CENTER
        );


        // ========================================
        // BUTTONS
        // ========================================

        btnLoad = new JButton("Load Paragraph"); 
        btnDisplay = new JButton("Display Queue"); 
        this.btnProcessAll = new JButton("Process All"); 
        this.btnOffer = new JButton("Offer Word"); 
        this.btnFind = new JButton("Find Position"); 
        btnPeek = new JButton("Peek Front"); 
        this.btnPoll = new JButton("Poll Front"); 
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

        this.wordQueue = new LinkedList<>();
        
        this.btnLoad.addActionListener(new BtnLoadClickListener());
        this.btnDisplay.addActionListener(new BtnDisplayClickListener());
        this.btnOffer.addActionListener(new BtnOfferClickListener());
        this.btnPeek.addActionListener(new BtnPeekClickListener());
        this.btnPoll.addActionListener(new BtnPollClickListener());
        this.btnFind.addActionListener(new BtnFindClickListener());
        this.btnProcessAll.addActionListener(new BtnProcessAllClickListener());
        this.btnClear.addActionListener(new BtnClearClickListener());

        // ========================================
        // TOP BUTTON PANEL
        // ========================================

        JPanel pnlTopButtons = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlTopButtons.add(this.btnLoad); 
        pnlTopButtons.add(btnDisplay); 
        pnlTopButtons.add(this.btnProcessAll);

        // ========================================
        // WORD INPUT PANEL
        // ========================================

        JPanel pnlWord = new JPanel(new BorderLayout(10, 0)); 
        this.tfWord.setToolTipText("Enter a word..."); 
        pnlWord.add( this.tfWord, BorderLayout.CENTER ); 
        JPanel pnlWordButtons = new JPanel(new FlowLayout()); 
        pnlWordButtons.add(this.btnOffer); 
        pnlWordButtons.add(this.btnFind); 
        pnlWord.add( pnlWordButtons, BorderLayout.EAST );

        // ========================================
        // STACK OPERATION BUTTON PANEL
        // ========================================

        JPanel pnlStackButtons = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        pnlStackButtons.add(btnPeek); 
        pnlStackButtons.add(this.btnPoll); 
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

    private class BtnLoadClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            wordQueue.clear();
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
                wordQueue.offer(word);
            }
            
            lblStatus.setText("Loaded " + wordQueue.size() 
                    + " words. Front: " + wordQueue.peek());
        }
    }
    
    private class BtnOfferClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String word = tfWord.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z]", " ")
                    .trim();
            
            if(word.isEmpty()){
                lblStatus.setText("Enter one valid word.");
                return;
            }
            
            boolean added = wordQueue.offer(word);
            if(added){
                lblStatus.setText(word + " joined the rear.");
            }
        }
    }
    
    private class BtnPeekClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String front = wordQueue.peek();
            
            if(front == null){
                lblStatus.setText("Cannot peek: Queue is empty.");
            } else{
                lblStatus.setText("Front word: " + front);
            }
        }
    }
    
    private class BtnPollClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String removed = wordQueue.poll();
            
            if(removed == null){
                lblStatus.setText("Cannot poll: Queue is empty.");
            } else{
                lblStatus.setText(removed + " was processed." 
                                + wordQueue.size() + " words remain.");
            }
        }
    }
    
    private class BtnDisplayClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            taResult.setText("");
            
            int position = 1;
            
            for (String word : wordQueue) {
                taResult.append(position + ". " + word + " \n");
                position++;
            }
        }
    }
    
    private class BtnFindClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String target = tfWord.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z]", "")
                    .trim();
            
            int position = 1;
            int foundPosition = -1;
            
            for (String word : wordQueue) {
                if(word.equals(target)){
                    foundPosition = position;
                    break;
                }
                position++;
            }
            
            if(foundPosition == -1){
                lblStatus.setText(target + " was Not found.");
            } else{
                lblStatus.setText(target + " is position " + foundPosition + " from the front.");
            }
        }
    }

    private class BtnProcessAllClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Queue<String> copy = new LinkedList<>();
            copy.addAll(wordQueue);
            
            String processed = "";
            
            while(!copy.isEmpty()){
                processed += processed + copy.poll() + "\n";
            }
            
            taResult.setText(.trim());
        }
    }

    private class BtnClearClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
   //Main method++++++++++++++++++++++++++++++++++++
     public static void main(String[]args){
         new QueueProcessor();
     }
}
