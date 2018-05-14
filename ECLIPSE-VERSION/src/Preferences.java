import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Preferences {

	private JFrame frmPreferences;
	private JTextField bedroomTextField;
	private JTextField sizeTextField;
	
	// Preferences
	public int size;
	public int bedrooms;
	public int gardenPref;
	public int kitchenPref;

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
		frmPreferences.getContentPane().setLayout(new GridLayout(5, 1, 1, 1));
		
		JSplitPane sizePane = new JSplitPane();
		frmPreferences.getContentPane().add(sizePane);
		
		JLabel lblSize = new JLabel("Preferred size in m^2");
		sizePane.setLeftComponent(lblSize);
		
		sizeTextField = new JTextField();
		sizeTextField.setText("100");
		sizePane.setRightComponent(sizeTextField);
		sizeTextField.setColumns(10);
		
		JSplitPane bedroomPane = new JSplitPane();
		frmPreferences.getContentPane().add(bedroomPane);
		
		JLabel lblBedrooms = new JLabel("Preffered number of bedrooms");
		bedroomPane.setLeftComponent(lblBedrooms);
		
		bedroomTextField = new JTextField();
		bedroomTextField.setText("0");
		bedroomPane.setRightComponent(bedroomTextField);
		bedroomTextField.setColumns(10);
		
		JSplitPane gardenPane = new JSplitPane();
		frmPreferences.getContentPane().add(gardenPane);
		
		JLabel lblGarden = new JLabel("Garden importance");
		gardenPane.setLeftComponent(lblGarden);
		
		JSlider gardenSlider = new JSlider();
		gardenSlider.setMinorTickSpacing(1);
		gardenSlider.setMinimum(1);
		gardenSlider.setMaximum(5);
		gardenSlider.setSnapToTicks(true);
		gardenSlider.setPaintTicks(true);
		gardenSlider.setPaintLabels(true);
		gardenPane.setRightComponent(gardenSlider);
		
		JSplitPane kitchenPane = new JSplitPane();
		frmPreferences.getContentPane().add(kitchenPane);
		
		JLabel lblKitchen = new JLabel("Kitchen importance");
		kitchenPane.setLeftComponent(lblKitchen);
		
		JSlider kitchenSlider = new JSlider();
		kitchenSlider.setMinimum(1);
		kitchenSlider.setPaintTicks(true);
		kitchenSlider.setPaintLabels(true);
		kitchenSlider.setMinorTickSpacing(1);
		kitchenSlider.setMaximum(5);
		kitchenPane.setRightComponent(kitchenSlider);
		
		// Load the preferences when the submit button is clicked
		JButton btnSubmit = new JButton("Submit preferences");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				size = Integer.parseInt(sizeTextField.getText());
				bedrooms  = Integer.parseInt(bedroomTextField.getText());
				kitchenPref = kitchenSlider.getValue();
				gardenPref = gardenSlider.getValue();
			}
		});
		
		frmPreferences.getContentPane().add(btnSubmit);
	}

}
