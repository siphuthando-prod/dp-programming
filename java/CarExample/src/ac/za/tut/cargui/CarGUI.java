
package ac.za.tut.cargui;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import za.ac.aop.Car;
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
    
    //EVENT HANDLERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private  class BtnDisplayClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            ArrayList<Car> cars = cm.getCars();
            
            if(cars.isEmpty()){
                carOutput.setText("No cars have been added.");
                return;
            }
            
            String output = "Dealership: " + cm.getDealershipName() + "\n\n";
            
            for (Car car : cars) {
                output += "Brand: " + car.getBrandName() + "\n";
                output += "Model Year: " + car.getYearModel() + "\n\n";
            }
            
            carOutput.setText(output);
        }
    }

    private  class BtnSearchClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String brand = tfBrandName.getText().trim();
            String yearText = tfYearModel.getText().trim();
            
            if(brand.isEmpty() || yearText.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter the brand and model year to search.");
                return;
            }
            
            try{
                int year = Integer.parseInt(yearText);                
                Car found = cm.searchCar(brand, year);
                
                if(found == null){
                    carOutput.setText("No matching car was found");
                } else{
                    carOutput.setText("Matching Car\n\n" 
                                                                    + "Brand: " + found.getBrandName()
                                                                    + "\nModel Year: " + found.getYearModel());
                }
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "Year model must be a whole number.");
            }
        }
    }

    private  class BtnAddClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a){
            String brand = tfBrandName.getText().trim();
            String yearText = tfYearModel.getText().trim();
            
            if(brand.isEmpty() || yearText.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Enter the brand and model year");
                return;
            }
            
            try{
                int year = Integer.parseInt(yearText);
                
                Car car = new Car();
                car.setBrandName(brand);
                car.setYearModel(year);
                
                cm.addCar(car);
                
                JOptionPane.showMessageDialog(rootPane, "Car added successfully");
                
                clearInputs();
                
            } catch(NumberFormatException q){
                JOptionPane.showMessageDialog(rootPane, "Year model must be a whole number.");
            }
        }
    }

    private void clearInputs() {
            tfBrandName.setText("");
            tfYearModel.setText("");
            tfBrandName.requestFocus();
        }
    
    //MAIN METHOD++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new CarGUI();
    }
}

