import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Preferences {

	private JFrame frmPreferences;
	private JTextField bedroomTextField;
	private JTextField sizeTextField;
	
	// Preferences
	public int size;
	public int bedrooms;
	
	// To deduce
	public int bathrooms;
	public String kitchenSize;
	public boolean transit;
	public boolean parking;
	
	
	private final ButtonGroup workButtonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preferences window = new Preferences();
					window.frmPreferences.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Preferences() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPreferences = new JFrame();
		frmPreferences.setTitle("Preferences");
		frmPreferences.setBounds(100, 100, 450, 300);
		frmPreferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPreferences.getContentPane().setLayout(new GridLayout(4, 1, 1, 1));
		
		JSplitPane sizePane = new JSplitPane();
		sizePane.setResizeWeight(0.5);
		frmPreferences.getContentPane().add(sizePane);
		
		JLabel lblSize = new JLabel("Preferred size in m^2");
		sizePane.setLeftComponent(lblSize);
		
		sizeTextField = new JTextField();
		sizeTextField.setText("100");
		sizePane.setRightComponent(sizeTextField);
		sizeTextField.setColumns(10);
		
		JSplitPane bedroomPane = new JSplitPane();
		bedroomPane.setResizeWeight(0.5);
		frmPreferences.getContentPane().add(bedroomPane);
		
		JLabel lblBedrooms = new JLabel("Preffered number of bedrooms");
		bedroomPane.setLeftComponent(lblBedrooms);
		
		bedroomTextField = new JTextField();
		bedroomTextField.setText("0");
		bedroomPane.setRightComponent(bedroomTextField);
		bedroomTextField.setColumns(10);
		
		
		JSplitPane studentPane = new JSplitPane();
		studentPane.setResizeWeight(0.5);
		frmPreferences.getContentPane().add(studentPane);
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setSelected(true);
		workButtonGroup.add(rdbtnStudent);
		studentPane.setLeftComponent(rdbtnStudent);
		
		JRadioButton rdbtnWorking = new JRadioButton("Working");
		workButtonGroup.add(rdbtnWorking);
		studentPane.setRightComponent(rdbtnWorking);
		
		// Load the preferences when the submit button is clicked
		JButton btnSubmit = new JButton("Submit preferences");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				size = Integer.parseInt(sizeTextField.getText());
				bedrooms  = Integer.parseInt(bedroomTextField.getText());
				
				// Deduce
				if(bedrooms > 3)
				{
					bathrooms = 2;
					kitchenSize = "Big";
				}
				else
				{
					bathrooms = 1;
					kitchenSize = "Regular";
				}
				
				String location;
				
				if(rdbtnStudent.isSelected())
				{
					transit = true;
					location = "Close to public transportation";
				}
				else
				{
					parking = true;
					location = "With parking space";
				}						
				
				// Output deductions
			    JOptionPane.showMessageDialog(null, "Deduced amount of bathrooms: " + bathrooms + '\n' + "Deduced size of kitchen: " + kitchenSize + '\n' + "Location: " + location);
			}
		});

		
		frmPreferences.getContentPane().add(btnSubmit);
	}

}
