
package za.ac.tut.gui;

//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author S. X Mabuza
 */
public class WorkshopFileViewerGUI extends JFrame{
    //PRIVATE MEMBERS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private JMenuItem miOpen;
    private JMenuItem miExit;
    private JLabel lblStatus;
    private JTextArea taWorkshops;
    
    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public WorkshopFileViewerGUI(){
        //Configuring the frame++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        super("Campus Workshop File Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createMenu();
        createInterface();
        registerListeners();
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //PRIVATE METHODS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void createMenu() {
        //Configuring menu++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        
        this.miOpen = new JMenuItem("Open");
        this.miExit = new JMenuItem("Exit");
        
        fileMenu.add(this.miOpen);
        fileMenu.addSeparator();
        fileMenu.add(this.miExit);
        
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    private void createInterface() {
        //Configuring the interface++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        this.lblStatus = new JLabel("No workshop file loaded");
        this.lblStatus.setForeground(Color.RED);
        
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        statusPanel.setBorder(BorderFactory.createTitledBorder("File Status"));
        statusPanel.add(this.lblStatus);
        
        this.taWorkshops = new JTextArea(18, 60);
        this.taWorkshops.setEditable(false);
        this.taWorkshops.setTabSize(18);
        this.taWorkshops.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JScrollPane scrollPane = new JScrollPane(this.taWorkshops);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Workshop Records"));
        
        this.setLayout(new BorderLayout(8, 8));
        this.add(statusPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void registerListeners() {
        this.miOpen.addActionListener(new MenuItemOpenListener());
        this.miExit.addActionListener(new MenuItemExitListener());
    }
    
    //ACTION LISTENERS++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private  class MenuItemOpenListener implements ActionListener {
        //Configuring open menu item listener++++++++++++++++++++++++++++
        @Override
        public void actionPerformed(ActionEvent e){
            JFileChooser chooser = new JFileChooser();
            
            int result = chooser.showOpenDialog(WorkshopFileViewerGUI.this);
            
            if(result != JFileChooser.APPROVE_OPTION){
                return;
            }
            
            File selectedFile = chooser.getSelectedFile();
            readWorkshopFile(selectedFile);
        }

        private void readWorkshopFile(File selectedFile){
            StringBuilder output = new StringBuilder();
            
            output.append("Code\tTitle\tVenue\tCapacity\n");
            output.append("-------------------------------------------------------------------------------------------------------\n");
            
            int rowsRead = 0;
            int skippedRows = 0;
            
            try(BufferedReader reader = new BufferedReader(new FileReader(selectedFile))){
                String line;
                
                while((line = reader.readLine()) != null){
                    if(line.trim().isEmpty()){
                        continue;
                    }
                    
                    String[] fields = line.split("[, \\s]+");
                    if(fields.length != 4){
                        skippedRows++;
                        continue;
                    }
                    
                    String code = fields[0].trim();
                    String title = fields[1].trim();
                    String venue = fields[2].trim();
                    String capacityText = fields[3].trim();
                    
                    try{
                        int capacity = Integer.parseInt(capacityText);
                        
                        output.append(code).append("\t").append(title).append("\t").append(venue).append("\t")
                                .append(capacity).append("\t").append("\n");
                    } catch(NumberFormatException ex){
                        skippedRows++;
                    }
                }
                
                taWorkshops.setText(output.toString());
                taWorkshops.setCaretPosition(0);
                
                lblStatus.setForeground(Color.BLUE);
                lblStatus.setText(selectedFile.getName() + " loaded: " + rowsRead + " workshop records read");
                
                if(skippedRows > 0){
                    JOptionPane.showMessageDialog(WorkshopFileViewerGUI.this, skippedRows +
                                                                                                " malformed record(s) were skipped.", "File Read Warning",
                                                                                                 JOptionPane.WARNING_MESSAGE);
                }
            } catch(IOException exception){
                lblStatus.setForeground(Color.RED);
                lblStatus.setText("The selected file could not be read");
                JOptionPane.showMessageDialog(WorkshopFileViewerGUI.this,
                                                                                                "Unable to read the selected file. \n"
                                                                                                    + exception.getMessage(), "File Read Error",
                                                                                                 JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private  class MenuItemExitListener implements ActionListener {
        //Configuring exit menu item++++++++++++++++++++++++++++++++++++++++++++++++++++
        @Override
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }
    //MAIN METHOD+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[]args){
        new WorkshopFileViewerGUI();
    }

    
}
