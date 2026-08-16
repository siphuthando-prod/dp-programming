//IMPORT STATEMENTS+++++++++++++++++++++++++++++++++++++++++++
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import za.ac.aop.processor.CallDetailProcessor;

public class CallDetailGUI extends JFrame {
    //Private members++++++++++++++++++++++++++++++++++++++++++
    private JLabel lblStatus;
    private JTextArea taRecords;
    private JComboBox<String> cmbProvider;
    private JCheckBox ckbApplyFilter;
    private JButton btnShowDurations;
    private JButton btnTotalDuration;
    private JButton btnMostCalls;
    private JButton btnLongestCall;

    private CallDetailProcessor processor;

    //CONSTRUCTOR+++++++++++++++++++++++++++++++++++++++++++++++++
    public CallDetailGUI(){
        //Configuring frame++++++++++++++++++++++++++++++++
        super("November Call Deatil Analyser");
        this.setSize(980, 620);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Configuring menu bar++++++++++++++++++++++++++++++++++++++
        JMenuBar mb = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem miOpen = new JMenuItem("Open");
        JMenuItem miExit = new JMenuItem("Exit");
        menuFile.add(miOpen);
        menuFile.add(miExit);
        mb.add(menuFile);

        //Configuring label++++++++++++++++++++++++++++++
        this.lblStatus = new JLabel("No call-detail file loaded");
        this.lblStatus.setForeground(Color.RED);

        //Configuring text area++++++++++++++++++++++++++++++
        this.taRecords = new JTextArea(22, 85);
        this.taRecords.setEditable(false);
        this.taRecords.setTabSize(12);
        this.taRecords.setFont(
            new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane sp = new JScrollPane(this.taRecords);
        
        String[] providers = {"All Providers", "Vodacom", "Telkom",
                                "MTN", "CellC", "ECN", "FNB"};
        this.cmbProvider = new JComboBox<String>(providers);
        this.ckbApplyFilter = new JCheckBox("Apply Filter");
        this.btnShowDurations = new JButton("Show Durations");
        this.btnTotalDuration = new JButton("Total Duration");
        this.btnMostCalls = new JButton("Most Calls by Extension");
        this.btnLongestCall = new JButton("Longest Call");

        //Configuring filter panel+++++++++++++++++++++++++
        JPanel filterJPnl = new JPanel();
        filterJPnl.add(this.cmbProvider);
        filterJPnl.add(this.ckbApplyFilter);

        //Configuring button panel+++++++++++++++++++++++++++++++++
        JPanel buttonPnl = new JPanel();
        buttonPnl.add(this.btnShowDurations);
        buttonPnl.add(this.btnTotalDuration);
        buttonPnl.add(this.btnMostCalls);
        buttonPnl.add(this.btnLongestCall);

        JPanel southPnl = new JPanel(new BorderLayout());
        southPnl.add(filterJPnl, BorderLayout.NORTH);
        southPnl.add(buttonPnl, BorderLayout.SOUTH);

        this.add(this.lblStatus, BorderLayout.NORTH);
        this.add(sp, BorderLayout.CENTER);
        this.add(southPnl, BorderLayout.SOUTH);
        this.setJMenuBar(mb);

        miOpen.addActionListener(
            new MenuItemOpenClickListener());
        miExit.addActionListener(
            new MenuItemExitClickListener());
        this.btnShowDurations.addActionListener(
            new BtnShowDurationsClickListener());
        this.btnTotalDuration.addActionListener(
            new BtnTotalDurationClickListener());
        this.btnMostCalls.addActionListener(
            new BtnMostCallsClickListener());
        this.btnLongestCall.addActionListener(
            new BtnLongestCallClickListener());
        this.cmbProvider.addActionListener(
            new ProviderFilterClickListener());
        this.ck.addActionListener(
            new ProviderFilterClickListener());
        
        this.processor = new CallDetailProcessor();
        
        this.setVisible(true);
    }
}
