
package ac.za.tut.cargui;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import za.ac.aop.CarManager;

/**
 *
 * @author S. X Mabuza
 */
public class CarGUI extends JFrame{
    //PRIVATE MEMBERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Panels+++++++++++++
    private JPanel ui;
    private JPanel pnlData;
    //Labels+++++++++++++++++++++++++++++++
    private JLabel lblName;
    private JLabel lblModel;
    private JLabel lblResult;
    //Text fields+++++++++++++++++++++++++++++
    private JTextField tfBrandName;
    private JTextField tfYearModel;
    //Text area+++++++++++++++++++++++++++
    private JTextArea carOutput;
    //Buttons+++++++++++++++++++++++++++++++
    private JButton btnAdd;
    private JButton btnDisplay;
    private JButton btnSearch;
    //Car manager++++++++++++++++++++++++++++++
    private CarManager cm;
    
    //CONSTRUCTOR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public CarGUI(){
        this.setTitle("Car Management System");
        this.setSize(430, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.cm = new CarManager();
        
        this.buildInterface();
        this.registerListeners();
        
        this.setVisible(true);
    }

    //PRIVATE METHODS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void buildInterface() {
        this.ui = new JPanel(new BorderLayout(8, 8));        
        this.pnlData = new JPanel(new GridLayout(2, 2, 8, 8));
        
        this.lblName = new JLabel("Brand Name");
        this.lblModel = new JLabel("Year Model");
        
        this.tfBrandName = new JTextField();
        this.tfYearModel = new JTextField();
        
        this.pnlData.add(this.lblName);
        this.pnlData.add(this.tfBrandName);
        this.pnlData.add(this.lblModel);
        this.pnlData.add(this.tfYearModel);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        this.btnAdd = new JButton("Add Car");
        this.btnDisplay = new JButton("Display Cars");
        this.btnSearch = new JButton("Search Car");
        
        buttonPanel.add(this.btnAdd);
        buttonPanel.add(this.btnDisplay);
        buttonPanel.add(this.btnSearch);
        
        JPanel northPanel = new JPanel(new BorderLayout(5, 5));
        northPanel.add(this.pnlData, BorderLayout.CENTER);
        northPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        this.lblResult = new JLabel("Result");
        
        this.carOutput = new JTextArea();
        this.carOutput.setEditable(false);
        this.carOutput.setLineWrap(true);
        this.carOutput.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(this.carOutput);
        
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(this.lblResult, BorderLayout.NORTH);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        
        this.ui.add(northPanel, BorderLayout.NORTH);
        this.ui.add(outputPanel, BorderLayout.CENTER);
        
        this.add(this.ui);
    }

    private void registerListeners(){
        this.btnAdd.addActionListener(new BtnAddClickListener());
        this.btnDisplay.addActionListener(new BtnDisplayClickListener());
        this.btnSearch.addActionListener(new BtnSearchClickListener());
    }

    private static class BtnAddClickListener implements ActionListener {

        public BtnAddClickListener() {
        }
    }

    private static class BtnDisplayClickListener implements ActionListener {

        public BtnDisplayClickListener() {
        }
    }

    private static class BtnSearchClickListener implements ActionListener {

        public BtnSearchClickListener() {
        }
    }
}
