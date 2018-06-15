package owlapi.tutorial.msc;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.ToStringRenderer;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.util.SimpleRenderer;
import org.semanticweb.HermiT.Configuration;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.model.IRI;

import com.github.jsonldjava.core.RDFDataset.Node;

public class OWLAPIFirst_V3 {
	public static void main(String[] args) throws OWLOntologyCreationException {
		OWLOntologyManager man = OWLManager.createOWLOntologyManager(); 
		System.out.println(man.getOntologies().size());
	
		OWLOntology o2;
		
		File file2 = new File("/Users/pallegra/Downloads/IA-master 2/Ontology5.owl");
		o2 = man.loadOntologyFromOntologyDocument(file2);
		ReasonerFactory f2 = new ReasonerFactory();
        Reasoner hReasoner= (Reasoner) f2.createReasoner(o2);
		
		
		// First, we create an OWLOntologyManager object. The manager will load and 
        // save ontologies. 
        OWLOntologyManager manager=OWLManager.createOWLOntologyManager();
        // We will create several things, so we save an instance of the data factory
        OWLDataFactory dataFactory=manager.getOWLDataFactory();
        // Now, we create the file from which the ontology will be loaded. 
        // Here the ontology is stored in a file locally in the ontologies subfolder
        // of the examples folder.
              
        // First, create several OWL API objects that we will use in our queries
            
        //Load from the Ontology
        String x = "http://www.semanticweb.org/pallegra/ontologies/2018/4/untitled-ontology-3#";
        //House Classes
        OWLClass house = dataFactory.getOWLClass(IRI.create(x +"House"));
        OWLClass apartment = dataFactory.getOWLClass(IRI.create(x +"apartment"));
        OWLClass student = dataFactory.getOWLClass(IRI.create(x +"Student"));
        OWLClass working = dataFactory.getOWLClass(IRI.create(x +"Working"));
        OWLClass retired = dataFactory.getOWLClass(IRI.create(x +"Retired"));

        //Object Properties
        OWLObjectProperty  isSuitableFor =  dataFactory.getOWLObjectProperty(IRI.create(x+"isSuitableFor"));

        //Data Properties
        OWLDataProperty  amountBudget =  dataFactory.getOWLDataProperty(IRI.create(x+"amountBudget"));
        OWLDataProperty  amountPool =  dataFactory.getOWLDataProperty(IRI.create(x+"amountPool"));
        OWLDataProperty  amountSpace =  dataFactory.getOWLDataProperty(IRI.create(x+"amountSpace"));
        OWLDataProperty  amountBathroom =  dataFactory.getOWLDataProperty(IRI.create(x+"amountBathroom"));
        OWLDataProperty  amountBedroom =  dataFactory.getOWLDataProperty(IRI.create(x+"amountBedroom"));
        OWLDataProperty  amountExtra =  dataFactory.getOWLDataProperty(IRI.create(x+"amountExtra"));
        OWLDataProperty  amountParking =  dataFactory.getOWLDataProperty(IRI.create(x+"amountParking"));
        OWLDataProperty  amountKitchen =  dataFactory.getOWLDataProperty(IRI.create(x+"amountKitchen"));
        OWLDataProperty  amountLivingroom =  dataFactory.getOWLDataProperty(IRI.create(x+"amountLivingroom"));
        OWLDataProperty  amountOutdoor =  dataFactory.getOWLDataProperty(IRI.create(x+"amountOutdoor"));
        OWLDataProperty  amountBalcony =  dataFactory.getOWLDataProperty(IRI.create(x+"amountBalcony"));
        OWLDataProperty  amountGarage =  dataFactory.getOWLDataProperty(IRI.create(x+"amountGarage"));
        OWLDataProperty  amountGarden =  dataFactory.getOWLDataProperty(IRI.create(x+"amountGarden"));
        OWLDataProperty  amountTerrace =  dataFactory.getOWLDataProperty(IRI.create(x+"amountTerrace"));
        OWLDataProperty  amountToilet =  dataFactory.getOWLDataProperty(IRI.create(x+"amountToilet"));
        OWLDataProperty  amountSqrm =  dataFactory.getOWLDataProperty(IRI.create(x+"amountSqrm"));
        OWLDataProperty  disableAccessibility =  dataFactory.getOWLDataProperty(IRI.create(x+"disableAccessibility"));
        OWLDataProperty  hasCloseNeighbours =  dataFactory.getOWLDataProperty(IRI.create(x+"hasCloseNeighbours"));
        OWLDataProperty  isCloseToCityCentre =  dataFactory.getOWLDataProperty(IRI.create(x+"isCloseToCityCentre"));
        OWLDataProperty  isCloseToCityNature =  dataFactory.getOWLDataProperty(IRI.create(x+"isCloseToCityNature"));
        OWLDataProperty  isCloseToPT =  dataFactory.getOWLDataProperty(IRI.create(x+"isCloseToPT"));
        OWLDataProperty  linkHouse =  dataFactory.getOWLDataProperty(IRI.create(x+"linkToHouse"));
        //House Database
        OWLNamedIndividual House1 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Vancouverdreef_55"));
        OWLNamedIndividual House2 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Prof.Hugo_de_Vrieslaan_40"));
        OWLNamedIndividual House3 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Paul_Citroenstraat_43"));
        OWLNamedIndividual House4 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Park_boswijk_570"));
        OWLNamedIndividual House5 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Oudegracht_256_B"));
        OWLNamedIndividual House6 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Oldambt_63"));
        OWLNamedIndividual House7 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Europaplei_844"));
        OWLNamedIndividual House8 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Celebesstraat_16"));
        OWLNamedIndividual House9 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Anthoniedijk_25"));
        
        ArrayList <OWLNamedIndividual> houseArray= new ArrayList<OWLNamedIndividual>();
        houseArray.add(House1);
        houseArray.add(House2);
        houseArray.add(House3);
        houseArray.add(House4);
        houseArray.add(House5);
        houseArray.add(House6);
        houseArray.add(House7);
        houseArray.add(House8);
        houseArray.add(House9);
        
        //Preference Database
        OWLNamedIndividual P_Balcony1 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Balcony1"));
        OWLNamedIndividual P_Balcony2 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Balcony2"));
        OWLNamedIndividual P_Balcony3 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Balcony3"));
        OWLNamedIndividual P_Balcony4 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Balcony4"));
        OWLNamedIndividual P_Bathroom1 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bathroom1"));
        OWLNamedIndividual P_Bathroom2 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bathroom2"));
        OWLNamedIndividual P_Bathroom3 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bathroom3"));
        OWLNamedIndividual P_Bathroom4 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bathroom4"));
        OWLNamedIndividual P_Bedroom1 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bedroom1"));
        OWLNamedIndividual P_Bedroom2 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bedroom2"));
        OWLNamedIndividual P_Bedroom3 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bedroom3"));
        OWLNamedIndividual P_Bedroom4 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bedroom4"));
        OWLNamedIndividual P_Bedroom5 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Bedroom5"));
        OWLNamedIndividual P_Budget50 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Budget50"));
        OWLNamedIndividual P_Budget100 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Budget100"));
        OWLNamedIndividual P_Budget200 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Budget200"));
        OWLNamedIndividual P_Budget500 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Budget500"));
        OWLNamedIndividual P_Budget1000 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Budget1000+"));
        OWLNamedIndividual P_closeToCityCentre = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_closeToCityCentre"));
        OWLNamedIndividual P_closeToNature = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_closeToNature"));
        OWLNamedIndividual P_closeToPT = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_closeToPT"));
        OWLNamedIndividual P_disableAccessible = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_disableAccessible"));
        OWLNamedIndividual P_Garage = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Garage"));
        OWLNamedIndividual P_Garden = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Garden"));
        OWLNamedIndividual P_Kitchen = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Kitchen"));
        OWLNamedIndividual P_Livingroom1 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Livingroom1"));
        OWLNamedIndividual P_Livingroom2 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Livingroom2"));
        OWLNamedIndividual P_noCloseNeighbours = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_noCloseNeighbours"));
        OWLNamedIndividual P_parking = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_parking"));
        OWLNamedIndividual P_Pool = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Pool"));
        OWLNamedIndividual P_solarPanel = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_solarPanel"));
        OWLNamedIndividual P_Terrace1 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Terrace1"));
        OWLNamedIndividual P_Terrace2 = dataFactory.getOWLNamedIndividual(IRI.create(x+"P_Terrace2"));

        ArrayList <OWLNamedIndividual> preferenceArray= new ArrayList<OWLNamedIndividual>();
        preferenceArray.add(P_Balcony1);
        preferenceArray.add(P_Balcony2);
        preferenceArray.add(P_Balcony3);
        preferenceArray.add(P_Balcony4);
        preferenceArray.add(P_Bathroom1);
        preferenceArray.add(P_Bathroom2);
        preferenceArray.add(P_Bathroom3);
        preferenceArray.add(P_Bathroom4);
        preferenceArray.add(P_Bedroom1);
        preferenceArray.add(P_Bedroom2);
        preferenceArray.add(P_Bedroom3);
        preferenceArray.add(P_Bedroom4);
        preferenceArray.add(P_Bedroom5);
        preferenceArray.add(P_Budget50);
        preferenceArray.add(P_Budget100);
        preferenceArray.add(P_Budget200);
        preferenceArray.add(P_Budget500);
        preferenceArray.add(P_Budget1000);
        preferenceArray.add(P_closeToCityCentre);
        preferenceArray.add(P_closeToNature);
        preferenceArray.add(P_closeToPT);
        preferenceArray.add(P_disableAccessible);
        preferenceArray.add(P_Garage);
        preferenceArray.add(P_Garden);
        preferenceArray.add(P_Kitchen);
        preferenceArray.add(P_Livingroom1);
        preferenceArray.add(P_Livingroom2);
        preferenceArray.add(P_noCloseNeighbours);
        preferenceArray.add(P_parking);
        preferenceArray.add(P_Pool);
        preferenceArray.add(P_solarPanel);
        preferenceArray.add(P_Terrace1);
        preferenceArray.add(P_Terrace2);

        

       //QUERY, ask for amount Bedroom and returns the funda links of all the houses from the database
        //(to be loaded in a array as above) that respect it --- this has to be done from the Knowledge Base by the agent without user's input (just the questionnaire)
        
        SimpleRenderer rend=new SimpleRenderer();
        rend.setPrefixesFromOntologyFormat(o2, true);
        System.out.println("Insert number of Bedroom:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 0; i < 9; i++){
            OWLDataPropertyAssertionAxiom housss = dataFactory.getOWLDataPropertyAssertionAxiom(amountBedroom, houseArray.get(i), number);

        	if (hReasoner.isEntailed(housss) == true){
        		//.out.println(houseArray.get(i));
                Set<OWLLiteral> sub1 = hReasoner.getDataPropertyValues(houseArray.get(i), linkHouse);                
                System.out.println("Link to House: ");
                for (OWLLiteral equivalents : sub1) {
                   
                    System.out.println(equivalents);
                }
        	}
        }   
        
        //QUERY for preferences given "occupation" (i.e. student)
        SimpleRenderer rend1=new SimpleRenderer();
        rend.setPrefixesFromOntologyFormat(o2, true);
        System.out.println("Insert occupation:");
        Scanner sc1 = new Scanner(System.in);
        String string = sc1.toString();
        
        OWLClass occupation;
//        if(string.compareTo("student")==0){
//        	 occupation = dataFactory.getOWLClass(iri);//qua carichi lo studente
//        }
//        else{
//        	 occupation = dataFactory.getOWLClass(iri);//qua carichi il lavoratore
//
//        }
        
        
        
        
        OWLClassExpression suitable = dataFactory.getOWLObjectSomeValuesFrom(isSuitableFor, student);

        for (int i = 0; i < 32; i++){
            OWLClassAssertionAxiom isSuitable = dataFactory.getOWLClassAssertionAxiom(suitable, preferenceArray.get(i));

        	if (hReasoner.isEntailed(isSuitable) == true){
        		//.out.println(houseArray.get(i));
                //Set<OWLLiteral> sub2 = hReasoner.getDataPropertyValues(preferenceArray.get(i), linkHouse);                
                //System.out.println(preferenceArray.get(i));
                //for (OWLLiteral equivalents : sub2) {
                   
                    System.out.println(preferenceArray.get(i));
               // }
        	}
        } 
        
 
	}
}