package owlapi.tutorial.msc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import javax.swing.JCheckBox;

public class Preferences {

	private JFrame frmPreferences;
	private JTextField bedroomTextField;
	private JTextField sizeTextField;

	// Preferences
	public int size1;

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

	HashMap <String,Integer> housePrefMap= new HashMap <String,Integer>();
	HashMap <String,Integer> infPrefMap= new HashMap <String,Integer>();
	ArrayList <String> inferredPref = new ArrayList <String>();
	ArrayList <OWLNamedIndividual> resultHouse = new ArrayList <OWLNamedIndividual>();
	HashMap<String, Integer> newPrefMap = new HashMap<String, Integer>(); 
	static JTextArea display = new JTextArea();

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


	static OWLAPIFirst reasoner = new OWLAPIFirst();
	private JTextField parkingTextField;
	private JTextField solarTextField;
	JCheckBox luxuryCheckbox;
	JCheckBox silenceCheckbox;
	JCheckBox petCheckbox;
	JCheckBox carCheckbox;
	JCheckBox disabledCheckbox;
	JCheckBox energyCheckbox;
	JCheckBox poolCheckbox;

	public static void main(String[] args) throws OWLOntologyCreationException {
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
		
		GridLayout grid1 = new GridLayout(1,2);
		JPanel leftSide = new JPanel();
		JPanel rightSide = new JPanel();
		JPanel comboboxesPanel = new JPanel();
		comboboxesPanel.setLayout(new GridLayout(1,3));
		String[] occupationStrings = { "Student", "Working","Retired" };
		String[] compositionStrings = { "Couple", "Family","Single" };
		//String[] featuresStrings = { "student", "worker","nullafacente" };


		//Create the combo box, select item at index 4.
		//Indices start at 0, so 4 specifies the pig.
		final JComboBox occupationList = new JComboBox(occupationStrings);
		final JComboBox compositionList = new JComboBox(compositionStrings);
		//JComboBox featuresList = new JComboBox(occupationStrings);
		occupationList.setSelectedIndex(2);
		
		
		comboboxesPanel.add(occupationList);
		comboboxesPanel.add(compositionList);
		//comboboxesPanel.add(featuresList); no combobox for this because we may want more than one
		
		GridLayout grid2 = new GridLayout(21,1);
		leftSide.setLayout(grid2);
		frmPreferences = new JFrame();
		frmPreferences.setTitle("Agent 007");
		frmPreferences.setSize(new Dimension(1002, 604));
		frmPreferences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPreferences.getContentPane().setLayout(grid1);
		frmPreferences.getContentPane().add(leftSide);
		frmPreferences.getContentPane().add(rightSide);
        rightSide.setSize(new Dimension(349,520));
        
		leftSide.add(comboboxesPanel);

		JSplitPane sizePane = new JSplitPane();
		sizePane.setResizeWeight(0.5);
		leftSide.add(sizePane);
		

		JLabel lblSize = new JLabel("Preferred size in m^2");
		sizePane.setLeftComponent(lblSize);

		sizeTextField = new JTextField();
		sizePane.setRightComponent(sizeTextField);
		sizeTextField.setColumns(10);

		JSplitPane splitPane_8 = new JSplitPane();
		leftSide.add(splitPane_8);

		JLabel lblNewLabel_6 = new JLabel("Max Budget");
		splitPane_8.setLeftComponent(lblNewLabel_6);

		budgetTextField = new JTextField();
		splitPane_8.setRightComponent(budgetTextField);
		budgetTextField.setColumns(10);

		JSplitPane bedroomPane = new JSplitPane();
		bedroomPane.setResizeWeight(0.5);
		leftSide.add(bedroomPane);

		JLabel lblBedrooms = new JLabel("Prefered bedrooms");
		bedroomPane.setLeftComponent(lblBedrooms);

		bedroomTextField = new JTextField();
		bedroomPane.setRightComponent(bedroomTextField);
		bedroomTextField.setColumns(10);
		
		
		display.setLineWrap(true);
		display.setWrapStyleWord(true);
		display.setText("                                                              ");
		int red = 72;
		int green = 136;
		int blue = 240;
		Color myBlue = new Color(red,green,blue);
		display.setBackground(myBlue);
		display.setOpaque(true);
		display.setForeground(Color.WHITE);
		JScrollPane scrollpane = new JScrollPane(display);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setPreferredSize(new Dimension(400,500));
		rightSide.add(scrollpane);

		
		// Load the preferences when the submit button is clicked
		//
		//
		// Basically all logic gets handled in here

		JButton btnSubmit = new JButton("Submit preferences");
		
		ActionListener listener1 = new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
                // Clear the previous hashmap
				housePrefMap.clear();
				infPrefMap.clear();
				
				// Get all the available preferences integer
				// Size
				size1 = readAndSetIntPreference(sizeTextField.getText());
				housePrefMap.put("amountSqrm", size1);
				// Budget
				budget = readAndSetIntPreference(budgetTextField.getText());
				housePrefMap.put("amountBudget", budget);
				
				bedrooms = readAndSetIntPreference(bedroomTextField.getText());
				housePrefMap.put("amountBedroom", bedrooms);
				// Bathrooms
				bathrooms =readAndSetIntPreference(bathroomTextField.getText());
				housePrefMap.put("amountBathroom", bathrooms);
				// Toilets
				toilets =readAndSetIntPreference(toiletTextField.getText());
				housePrefMap.put("amountToilet", toilets);
				// Kitchens
				kitchens =readAndSetIntPreference(kitchenTextField.getText());
				housePrefMap.put("amountKitchen", kitchens);
				// Garages
				garages =readAndSetIntPreference(garageTextField.getText());
				housePrefMap.put("amountGarage", garages);
				// Gardens
				gardens =readAndSetIntPreference(gardenTextField.getText());
				housePrefMap.put("amountGarden", gardens);
				// Terraces
				terraces =readAndSetIntPreference(terraceTextField.getText());
				housePrefMap.put("amountTerrace", terraces);
				// Balconies
				balconies =readAndSetIntPreference(balconyTextField.getText());
				housePrefMap.put("amountBalcony", balconies);
				// Livingrooms
				livingrooms =readAndSetIntPreference(livingTextField.getText());
				housePrefMap.put("amountLivingroom", livingrooms);
				// Pools
				pools =readAndSetIntPreference(poolTextField.getText());
				housePrefMap.put("amountPool", pools);
				
				// Initiliaze these preferences
				// Disability access
				housePrefMap.put("disableAccessibility", -1);
				// City center
				housePrefMap.put("isCloseToCityCentre", -1);
				// Close to PT
				housePrefMap.put("isCloseToPT", -1);
				// Nature
				housePrefMap.put("isCloseToNature", -1);
				// Neighbours
				housePrefMap.put("hasCloseNeighbours", -1);			
				// Parkings
				housePrefMap.put("amountParking", -1);
				// Solar panels
				housePrefMap.put("amountSolarPanel", -1);

				//Composition
				infPrefMap.put("Single", 0);
				infPrefMap.put("Couple", 0);
				infPrefMap.put("Family", 0);
				String composition = (String) compositionList.getSelectedItem();
				infPrefMap.put(composition, 1);
			
				
				//Occupation
				infPrefMap.put("Student", 0);
				infPrefMap.put("Working", 0);
				infPrefMap.put("Retired", 0);
				String occupation = (String) occupationList.getSelectedItem();
				infPrefMap.put(occupation, 1);	
				
				//Features
				// Car owner
				int carOwner = carCheckbox.isSelected() ? 1 : 0;
				infPrefMap.put("carOwner", carOwner);
				// Disabled
				int disabled = disabledCheckbox.isSelected() ? 1 : 0;
				infPrefMap.put("Disable", disabled);
				// Energy saver
				int energy = energyCheckbox.isSelected() ? 1 : 0;
				infPrefMap.put("energySaver", energy);
				// Luxury
				int luxury = luxuryCheckbox.isSelected() ? 1 : 0;
				infPrefMap.put("likesLuxury", luxury);
				// Pet owner
				int pet = petCheckbox.isSelected() ? 1 : 0;
				infPrefMap.put("petOwner", pet);
				// Silence
				int silence = silenceCheckbox.isSelected() ? 1 : 0;
				infPrefMap.put("silenceLover", silence);
				// wantsPool
				int wantsPool = poolCheckbox.isSelected() ? 1 : 0;
				infPrefMap.put("wantsPool", wantsPool);


//==============================================================================
//
//==============================================================================				


				try {
					reasoner.initialization();
				} catch (OWLOntologyCreationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reasoner.setHashMap(housePrefMap);
				reasoner.setHashMap1(infPrefMap);
				reasoner.setInferredPref(inferredPref);
			    reasoner.setResults(resultHouse);
			    reasoner.setPrefMap(newPrefMap);

				reasoner.addToArray();
				
				display.append("\n");
			    display.append("results:\n");
				reasoner.houseQuery();
				reasoner.preferenceQuery(inferredPref, infPrefMap);
			    display.append("We infer that user might also like" + inferredPref+"\n");
				
				reasoner.setInferredPref(inferredPref);

				//System.out.println("old"+housePrefMap);
			    display.append("updating:\n");
				reasoner.updatePref(housePrefMap, inferredPref);
			    display.append("new results:\n");
				reasoner.houseQuery2(resultHouse, newPrefMap, infPrefMap);
				
			    //display.append("Selected occupation and composition:\n\n\n");
			    //display.append(""+occupationList.getSelectedItem()+"\n");
			    //display.append(""+compositionList.getSelectedItem()+"\n");


//==============================================================================				
//==============================================================================				

				
			}
		};
		
		btnSubmit.addActionListener(listener1);

		JSplitPane bathroomPane = new JSplitPane();
		leftSide.add(bathroomPane);

		JLabel lblPreferedBathrooms = new JLabel("Prefered bathrooms");
		bathroomPane.setLeftComponent(lblPreferedBathrooms);

		bathroomTextField = new JTextField();
		bathroomPane.setRightComponent(bathroomTextField);
		bathroomTextField.setColumns(10);

		JSplitPane splitPane = new JSplitPane();
		leftSide.add(splitPane);

		JLabel lblPreferedToilets = new JLabel("Prefered toilets");
		splitPane.setLeftComponent(lblPreferedToilets);

		toiletTextField = new JTextField();
		splitPane.setRightComponent(toiletTextField);
		toiletTextField.setColumns(10);

		JSplitPane splitPane_6 = new JSplitPane();
		leftSide.add(splitPane_6);

		JLabel lblNewLabel_4 = new JLabel("Prefered livingrooms");
		splitPane_6.setLeftComponent(lblNewLabel_4);

		livingTextField = new JTextField();
		splitPane_6.setRightComponent(livingTextField);
		livingTextField.setColumns(10);

		JSplitPane splitPane_1 = new JSplitPane();
		leftSide.add(splitPane_1);

		JLabel lblPref = new JLabel("Prefered kitchens");
		splitPane_1.setLeftComponent(lblPref);

		kitchenTextField = new JTextField();
		splitPane_1.setRightComponent(kitchenTextField);
		kitchenTextField.setColumns(10);

		JSplitPane splitPane_2 = new JSplitPane();
		leftSide.add(splitPane_2);

		garageTextField = new JTextField();
		splitPane_2.setRightComponent(garageTextField);
		garageTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Prefered garages");
		splitPane_2.setLeftComponent(lblNewLabel);

		JSplitPane splitPane_3 = new JSplitPane();
		leftSide.add(splitPane_3);

		JLabel lblNewLabel_1 = new JLabel("Prefered gardens");
		splitPane_3.setLeftComponent(lblNewLabel_1);

		gardenTextField = new JTextField();
		splitPane_3.setRightComponent(gardenTextField);
		gardenTextField.setColumns(10);

		JSplitPane splitPane_4 = new JSplitPane();
		leftSide.add(splitPane_4);

		terraceTextField = new JTextField();
		splitPane_4.setRightComponent(terraceTextField);
		terraceTextField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Prefered terraces");
		splitPane_4.setLeftComponent(lblNewLabel_2);

		JSplitPane splitPane_5 = new JSplitPane();
		leftSide.add(splitPane_5);

		JLabel lblNewLabel_3 = new JLabel("Prefered balconies");
		splitPane_5.setLeftComponent(lblNewLabel_3);

		balconyTextField = new JTextField();
		splitPane_5.setRightComponent(balconyTextField);
		balconyTextField.setColumns(10);

		JSplitPane splitPane_7 = new JSplitPane();
		leftSide.add(splitPane_7);

		JLabel lblNewLabel_5 = new JLabel("Prefered pools");
		splitPane_7.setLeftComponent(lblNewLabel_5);

		poolTextField = new JTextField();
		splitPane_7.setRightComponent(poolTextField);
		poolTextField.setColumns(10);
		
		JSplitPane splitPane_9 = new JSplitPane();
		leftSide.add(splitPane_9);
		
		JLabel lblNewLabel_7 = new JLabel("Number of parking spaces");
		splitPane_9.setLeftComponent(lblNewLabel_7);
		
		parkingTextField = new JTextField();
		splitPane_9.setRightComponent(parkingTextField);
		parkingTextField.setColumns(10);
		
		JSplitPane splitPane_10 = new JSplitPane();
		leftSide.add(splitPane_10);
		
		JLabel lblNewLabel_8 = new JLabel("Number of solar panels");
		splitPane_10.setLeftComponent(lblNewLabel_8);
		
		solarTextField = new JTextField();
		splitPane_10.setRightComponent(solarTextField);
		solarTextField.setColumns(10);
		
		JSplitPane splitPane_11 = new JSplitPane();
		leftSide.add(splitPane_11);
		
		poolCheckbox = new JCheckBox("Wants pool");
		splitPane_11.setRightComponent(poolCheckbox);
		
		carCheckbox = new JCheckBox("Owns car");
		splitPane_11.setLeftComponent(carCheckbox);
		
		JSplitPane splitPane_12 = new JSplitPane();
		leftSide.add(splitPane_12);
		
		disabledCheckbox = new JCheckBox("Has disability");
		splitPane_12.setLeftComponent(disabledCheckbox);
		
	    energyCheckbox = new JCheckBox("Prefers energy-saving");
		splitPane_12.setRightComponent(energyCheckbox);
		
		luxuryCheckbox = new JCheckBox("Prefers luxury");
		leftSide.add(luxuryCheckbox);
		
		petCheckbox = new JCheckBox("Owns pet");
		leftSide.add(petCheckbox);
		
		silenceCheckbox = new JCheckBox("Prefers silence");
		leftSide.add(silenceCheckbox);


		leftSide.add(btnSubmit);
	}

	// Gets a numerical preference from the GUI
	// Sets it to -1 if it is not set
	public int readAndSetIntPreference(String textfield)
	{
		if(textfield == "" || textfield.isEmpty() )
		{
			return Integer.valueOf(-1);
		}
		else
		{
			return Integer.parseInt(textfield);
		}
	}

	public static void printOnDisplay(String s){
		
		display.append(s+"\n");
	}




}