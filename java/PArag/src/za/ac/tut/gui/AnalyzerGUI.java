
package za.ac.tut.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author S. X Mabuza
 */
public class AnalyzerGUI extends JFrame{
    //Private members++++++++++++++++++++++++++
    private JTextArea taSample;
    private JTextArea taOutput;
    private JButton btnFindUnique, btnFindWordOccurrences, btnReverse;
    
    public AnalyzerGUI(){
        super("Outcome 3 - paragraph analyzer");
        setSize(550, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        taSample = new JTextArea(12, 40);
        taSample.setEditable(false);
        taSample.setLineWrap(true);
        taSample.setWrapStyleWord(true);
        taSample.setText("The quick brown fox jumps over the lazy dog. "
                + "\nThe dog barked, but the fox was gone.");
        taSample.setFont(new Font("Comic Sans", Font.PLAIN, 22));
        JScrollPane sp = new JScrollPane(taSample);
        
        JPanel pnlBtns = new JPanel();
        
        btnFindUnique = new JButton("Find unique");
        btnFindWordOccurrences = new JButton("Find word occurrences");
        btnReverse = new JButton("Reverse");
        
        pnlBtns.add(btnFindUnique); pnlBtns.add(btnFindWordOccurrences); pnlBtns.add(btnReverse);
        
        this.taOutput = new JTextArea(14, 40);
        
        JPanel pnlOutput = new JPanel(new BorderLayout());
        JLabel lblOutput = new JLabel("Analysis output");
        pnlOutput.add(lblOutput, BorderLayout.NORTH);
        pnlOutput.add(new JScrollPane(this.taOutput), BorderLayout.CENTER);
        add(sp, BorderLayout.NORTH);
        
        JPanel pnlMiddle = new JPanel(new BorderLayout());

        pnlMiddle.add(pnlBtns, BorderLayout.NORTH);
        pnlMiddle.add(pnlOutput, BorderLayout.CENTER);
        
        add(pnlMiddle, BorderLayout.CENTER);
        
        setVisible(true);
        
        btnFindUnique.addActionListener(new BtnFindUniqueClick());
        btnReverse.addActionListener(new BtnReverseClick());
        btnFindWordOccurrences.addActionListener(new BtnFindwordOccurrencesClick());
    }

    //Event listeners++++++++++++++++++++++++++++++++++++++++++++++
    private class BtnFindUniqueClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String paragraph = taSample.getText()
                    .toLowerCase()
                    .replaceAll("[^a-z0-9\\s]", " ");
            
            String[] words = paragraph.split("\\s+");
            
            Set<String> uniqueWords = new LinkedHashSet<>();
            
            for (String word : words) {
                uniqueWords.add(word);
            }
            
            taOutput.setText("Unique words: " + uniqueWords);
        }
    }

    private class BtnReverseClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    private class BtnFindwordOccurrencesClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }
    
    //Main method+++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new AnalyzerGUI();
    }
}
