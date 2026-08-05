package za.ac.tut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import za.ac.ex1.tut.PronicNumber;
import za.ac.ex1.tut.SenteNumberProcessor;

/**
 *
 * @author S. X Mabuza
 */
public class Exercise1GUI extends JFrame{
    private final JTextField tfSentence;
    private final JButton btnProcess;
    private final JLabel lblSentence;
    private final JButton btnGenerate;
    private final JTextArea taPronicOutput;
    private final JButton btnProduct;
    
    public Exercise1GUI(){
        setTitle("Assignment 1 - Practice");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel upper = new JPanel(new GridLayout(2,1,0,0));
        upper.setBorder(javax.swing.BorderFactory.createTitledBorder("Question 1 - sentence manipulation"));
        
        JPanel mPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tfSentence = new JTextField("TalK is chEAp, SHOW me tHe Code");
        tfSentence.setEditable(false);
        tfSentence.setFont(new Font("Comic Sans", Font.BOLD, 15));
        
        btnProcess = new JButton("Process sentence");
        btnProcess.setBackground(Color.GREEN);
        btnProcess.addActionListener(new BtnProcessClick());
        mPnl.add(tfSentence);
        mPnl.add(btnProcess);
        
        lblSentence = new JLabel("Display processed sentence here");
        lblSentence.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblSentence.setHorizontalAlignment(JLabel.CENTER);
        upper.add(mPnl);
        upper.add(lblSentence);
        
        add(upper, BorderLayout.NORTH);
        
        JPanel below = new JPanel(new GridLayout(1, 1));
        below.setBorder(javax.swing.BorderFactory.createTitledBorder("Question 2 - number works"));
        
        btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener(new BtnGenerateClick());
        btnGenerate.setBackground(Color.ORANGE);
        btnProduct = new JButton("Find Product");
        btnProduct.setBackground(Color.MAGENTA);
        btnProduct.addActionListener(new BtnProductClick());
        
        taPronicOutput = new JTextArea(10, 10);
        mPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mPnl.add(btnGenerate);
        mPnl.add(taPronicOutput);
        mPnl.add(btnProduct);
        
        below.add(mPnl);
        
        add(below, BorderLayout.CENTER);
        
        pack();
        setVisible(true);
    }

    private class BtnProcessClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Reading sentence from text field+++++++++++++++++++
            String sentence = tfSentence.getText();
            //Separating sentence into words++++++++++++++++++++++++++++
            String[] words = sentence.split("[,\\s]+");
            //Dertemining number of letters in each word+++++++++++++++++++++++++++
            int nrLetters = 0;
            String processed = "";
            for (String word : words) {
                nrLetters = word.length();
                processed += word + " " + nrLetters + ", ";
            }
            //Placing processed result in label++++++++++++++++++++++++++++++++++++
            lblSentence.setText(processed);
            //Setting label foreground colour++++++++++++++++++++++++
            lblSentence.setForeground(Color.red);
            //Setting result label font++++++++++++++++++++++++++++
            lblSentence.setFont(new Font("Comic Sans", Font.BOLD, 15));            
        }
    }
    
    private class BtnGenerateClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Prompting for quantity of pronic numbers++++++++++++++++++++
            String userIn =JOptionPane.showInputDialog(null, "How many pronic number do you want");
            
            if(userIn == null){
                JOptionPane.showMessageDialog(null, "Operation cancelled");
            }
            else if(userIn.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter a value");
            }
            int numPronics = 0;
            
            try{
                numPronics = Integer.parseInt(userIn);
            }
            catch(NumberFormatException v){
                JOptionPane.showMessageDialog(null, "Non numeric value entered!!");
            }
            
            if(numPronics == 0){
                JOptionPane.showMessageDialog(null, "Zero is not allowed, type a whole number");
                return;
            }
            else if(numPronics < 0){
                JOptionPane.showMessageDialog(null, "A negative number is NOT allowed!!\nEnter a positive number");
                return;
            }   
            //Generating the number of values requested by the user+++++++++++++++++++++
            SenteNumberProcessor processor = new SenteNumberProcessor();
            processor.generatePronicNumbers(numPronics);
                
            //Clearng text area++++++++++++++++++++++++++++++++++++
            taPronicOutput.setText("");
            //Adding generated values to text area++++++++++++++++++++++++++++++
            ArrayList<PronicNumber> pronicNumbers = processor.getNumbers();
            for (PronicNumber pronicNumber : pronicNumbers) {
                taPronicOutput.append(pronicNumber.getNumPronics() + "\n");
            }
        }
    }
    
    private class BtnProductClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           //write code for btnProduct
        }
    }
    
    public static void main(String[] args){ new Exercise1GUI(); }

    
}
