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
import javax.swing.UIManager;

public class Preferences {

	private JFrame frmPreferences;
	private JTextField bedroomTextField;
	private JTextField sizeTextField;
	
	// Preferences
	public int size;
	public int budget;
	public int bedrooms;	
	public int bathrooms;
	public int toilets;
	public int kitchens;
	public int garages;
	public int gardens; 
	public int terraces;
	public int balconies;
	public int livingrooms;
	public int pools;


	
	
	private final ButtonGroup workButtonGroup = new ButtonGroup();
	private JTextField bathroomTextField;
	private JTextField toiletTextField;
	private JTextField kitchenTextField;
	private JTextField garageTextField;
	private JTextField gardenTextField;
	private JTextField terraceTextField;
	private JTextField balconyTextField;
	private JTextField livingTextField;
	private JTextField poolTextField;
	private JTextField budgetTextField;

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
		frmPreferences.setBounds(100, 100, 450, 399);
		frmPreferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPreferences.getContentPane().setLayout(new GridLayout(13, 1, 1, 1));
		
		JSplitPane sizePane = new JSplitPane();
		sizePane.setResizeWeight(0.5);
		frmPreferences.getContentPane().add(sizePane);
		
		JLabel lblSize = new JLabel("Preferred size in m^2");
		sizePane.setLeftComponent(lblSize);
		
		sizeTextField = new JTextField();
		sizePane.setRightComponent(sizeTextField);
		sizeTextField.setColumns(10);
		
		JSplitPane splitPane_8 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_8);
		
		JLabel lblNewLabel_6 = new JLabel("Max Budget");
		splitPane_8.setLeftComponent(lblNewLabel_6);
		
		budgetTextField = new JTextField();
		splitPane_8.setRightComponent(budgetTextField);
		budgetTextField.setColumns(10);
		
		JSplitPane bedroomPane = new JSplitPane();
		bedroomPane.setResizeWeight(0.5);
		frmPreferences.getContentPane().add(bedroomPane);
		
		JLabel lblBedrooms = new JLabel("Prefered bedrooms");
		bedroomPane.setLeftComponent(lblBedrooms);
		
		bedroomTextField = new JTextField();
		bedroomPane.setRightComponent(bedroomTextField);
		bedroomTextField.setColumns(10);
		
		// Load the preferences when the submit button is clicked
		//
		//
		// Basically all logic gets handled in here
		
		JButton btnSubmit = new JButton("Submit preferences");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Get all the available preferences integer				
				// Size
				size = readAndSetIntPreference(sizeTextField.getText());			
				// Budget
				budget = readAndSetIntPreference(budgetTextField.getText());				
				// Bedrooms
				bedrooms = readAndSetIntPreference(bedroomTextField.getText());	
				// Bathrooms
				bathrooms =readAndSetIntPreference(bathroomTextField.getText());					
				// Toilets
				toilets =readAndSetIntPreference(toiletTextField.getText());	
				// Kitchens
				kitchens =readAndSetIntPreference(kitchenTextField.getText());					
				// Garages
				garages =readAndSetIntPreference(garageTextField.getText());
				// Gardens
				gardens =readAndSetIntPreference(gardenTextField.getText());
				// Terraces
				terraces =readAndSetIntPreference(terraceTextField.getText());
				// Balconies
				balconies =readAndSetIntPreference(balconyTextField.getText());
				// Livingrooms
				livingrooms =readAndSetIntPreference(livingTextField.getText());
				// Pools
				pools =readAndSetIntPreference(poolTextField.getText());				
					
			}
		});
		
		JSplitPane bathroomPane = new JSplitPane();
		frmPreferences.getContentPane().add(bathroomPane);
		
		JLabel lblPreferedBathrooms = new JLabel("Prefered bathrooms");
		bathroomPane.setLeftComponent(lblPreferedBathrooms);
		
		bathroomTextField = new JTextField();
		bathroomPane.setRightComponent(bathroomTextField);
		bathroomTextField.setColumns(10);
		
		JSplitPane splitPane = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane);
		
		JLabel lblPreferedToilets = new JLabel("Prefered toilets");
		splitPane.setLeftComponent(lblPreferedToilets);
		
		toiletTextField = new JTextField();
		splitPane.setRightComponent(toiletTextField);
		toiletTextField.setColumns(10);
		
		JSplitPane splitPane_6 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_6);
		
		JLabel lblNewLabel_4 = new JLabel("Prefered livingrooms");
		splitPane_6.setLeftComponent(lblNewLabel_4);
		
		livingTextField = new JTextField();
		splitPane_6.setRightComponent(livingTextField);
		livingTextField.setColumns(10);
		
		JSplitPane splitPane_1 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_1);
		
		JLabel lblPref = new JLabel("Prefered kitchens");
		splitPane_1.setLeftComponent(lblPref);
		
		kitchenTextField = new JTextField();
		splitPane_1.setRightComponent(kitchenTextField);
		kitchenTextField.setColumns(10);
		
		JSplitPane splitPane_2 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_2);
		
		garageTextField = new JTextField();
		splitPane_2.setRightComponent(garageTextField);
		garageTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Prefered garages");
		splitPane_2.setLeftComponent(lblNewLabel);
		
		JSplitPane splitPane_3 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_3);
		
		JLabel lblNewLabel_1 = new JLabel("Prefered gardens");
		splitPane_3.setLeftComponent(lblNewLabel_1);
		
		gardenTextField = new JTextField();
		splitPane_3.setRightComponent(gardenTextField);
		gardenTextField.setColumns(10);
		
		JSplitPane splitPane_4 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_4);
		
		terraceTextField = new JTextField();
		splitPane_4.setRightComponent(terraceTextField);
		terraceTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prefered terraces");
		splitPane_4.setLeftComponent(lblNewLabel_2);
		
		JSplitPane splitPane_5 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_5);
		
		JLabel lblNewLabel_3 = new JLabel("Prefered balconies");
		splitPane_5.setLeftComponent(lblNewLabel_3);
		
		balconyTextField = new JTextField();
		splitPane_5.setRightComponent(balconyTextField);
		balconyTextField.setColumns(10);
		
		JSplitPane splitPane_7 = new JSplitPane();
		frmPreferences.getContentPane().add(splitPane_7);
		
		JLabel lblNewLabel_5 = new JLabel("Prefered pools");
		splitPane_7.setLeftComponent(lblNewLabel_5);
		
		poolTextField = new JTextField();
		splitPane_7.setRightComponent(poolTextField);
		poolTextField.setColumns(10);

		
		frmPreferences.getContentPane().add(btnSubmit);
	}
	
	// Gets a numerical preference from the GUI
	// Sets it to -1 if it is not set
	public int readAndSetIntPreference(String textfield)
	{
		if(textfield == "" || textfield.isEmpty())
		{
			return -1;
		}
		else
		{
			return Integer.parseInt(textfield);
		}
	}

}
