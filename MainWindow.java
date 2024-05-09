package a9;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Arrays;

import javax.swing.*;

public class MainWindow extends JFrame {
	
	JLabel lblType = new JLabel("Type");
	JLabel lblName = new JLabel("Name");
	JLabel lblDate = new JLabel("Date");
	JLabel lblDuration = new JLabel("Duration");
	JLabel lblDistance = new JLabel("Distance");
	JLabel lblAddComments = new JLabel("Add Comments");
	JLabel lblExerciseSummary = new JLabel("Exercise Summary");

	JTextField txtName = new JTextField(10);
	JTextField txtDate = new JTextField(15);
	JTextField txtDuration = new JTextField(10);
	JTextField txtDistance = new JTextField(10);
	JTextArea tarAddComments = new JTextArea();
	JTextArea tarSummary = new JTextArea();

	JButton btnAddExercise = new JButton("Add Exercise");
	
	String[] options = new String[] {"Run Walk", "WeightLifting", "RockClimbing"};
	JComboBox<String> type = new JComboBox<String>(options);
	
	JMenuItem miLogin = new JMenuItem("Log in");
	JMenuItem miLogout = new JMenuItem("Log out");
	JMenuItem miSave = new JMenuItem("Save Exercises");
	JMenuItem miClear = new JMenuItem("About");
	JMenuItem miExit = new JMenuItem("Exit");
	
	LoginFrame passDialog;

	public void SetupGui() {
		
		setLayout(new BorderLayout(5,5));	 
		
		JPanel pnlInfo = new JPanel(new GridLayout(6,0));
		pnlInfo.add(lblType);
		pnlInfo.add(type);
		pnlInfo.add(lblName);
		pnlInfo.add(txtName);
		pnlInfo.add(lblDate);
		pnlInfo.add(txtDate);
		pnlInfo.add(lblDuration);
		pnlInfo.add(txtDuration);
		pnlInfo.add(lblDistance);
		pnlInfo.add(txtDistance);
		type.setEnabled(false);;
		txtName.setEditable(false);
		txtDate.setEditable(false);
		txtDuration.setEditable(false);
		txtDistance.setEditable(false);
		
		JPanel comments = new JPanel(new BorderLayout());
		pnlInfo.add(lblAddComments, BorderLayout.NORTH);
		pnlInfo.add(tarAddComments, BorderLayout.CENTER);
		tarAddComments.setEditable(false);
		
		JPanel leftPanel = new JPanel();
		leftPanel.add(pnlInfo);
		leftPanel.add(comments);
		
		JPanel pnlSummary = new JPanel(new BorderLayout());
		pnlSummary.add(lblExerciseSummary, BorderLayout.NORTH);
		pnlSummary.add(tarSummary, BorderLayout.CENTER);
		tarSummary.setEditable(false);
		
		JPanel pnlNorth = new JPanel(new GridLayout(0, 2));
		pnlNorth.add(leftPanel);
		pnlNorth.add(pnlSummary);
		
		JPanel pnlCenter = new JPanel(new FlowLayout());
		pnlCenter.add(btnAddExercise);
		
		add(pnlNorth, BorderLayout.NORTH);
		add(pnlCenter, BorderLayout.CENTER);
		
		btnAddExercise.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String text = tarSummary.getText();
						if(!text.isBlank()) {
							text+="\n";
						}
						
						text += txtName.getText().trim()+"\t";
						text += type.getSelectedItem().toString().trim()+"\t";
						text += txtDate.getText().trim()+"\t";
						text += txtDuration.getText().trim()+"\t";
						text += txtDistance.getText().trim()+"\t";
						text += tarAddComments.getText().trim()+"\t";
						if (!text.isBlank()) {
							tarSummary.setText(text);
						}
					}
				}
		);
		
		btnAddExercise.setEnabled(false);
		
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		JMenu mnuFile = new JMenu("File");
		mbar.add(mnuFile);
		
		miLogin.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						passDialog.setVisible(true);					}
				}
		);
		miSave.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						File f;
						JFileChooser chooser = new JFileChooser();
						if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
							f = chooser.getSelectedFile();
						}
					}
				}
		);
		
		miLogout.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						disableAll();
					}
				}
		);
		
		miExit.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				}
		);
		mnuFile.add(miLogin);
		mnuFile.add(miSave);
		mnuFile.add(miLogout);
		mnuFile.add(miExit);
		
		JMenu mnuTools = new JMenu("Help");
		mbar.add(mnuTools);
		miClear.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Exercise Tracker, Spring 2024");
					}
				}
		);
		mnuTools.add(miClear);
		miLogout.setEnabled(false);
		miSave.setEnabled(false);
	}
	
	public void disableAll() {
		tarSummary.setEditable(false);
		type.setEditable(false);
		type.setEnabled(false);
		txtName.setEditable(false);
		txtDate.setEditable(false);
		txtDuration.setEditable(false);
		txtDistance.setEditable(false);
		tarAddComments.setEditable(false);
		btnAddExercise.setEnabled(false);
		miLogout.setEnabled(false);
		miSave.setEnabled(false);
	}
	
	public void endableAll() {
		tarSummary.setEditable(false);
		type.setEditable(false);
		type.setEnabled(true);
		txtName.setEditable(true);
		txtDate.setEditable(true);
		txtDuration.setEditable(true);
		txtDistance.setEditable(true);
		tarAddComments.setEditable(true);
		btnAddExercise.setEnabled(true);
		miLogout.setEnabled(true);
		miSave.setEnabled(true);
	}

	public MainWindow(){
		SetupGui();
		setTitle("Exercise Tracker");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		setSize(700,300);	
		passDialog = LoginFrame.V(this);
	}
	
	public static void main(String[] args) {
		MainWindow w = new MainWindow();
	}
}
