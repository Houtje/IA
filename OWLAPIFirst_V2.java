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
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
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

public class OWLAPIFirst {
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
            
        //HOUSING
        String x = "http://www.semanticweb.org/pallegra/ontologies/2018/4/untitled-ontology-3#";
        OWLClass house = dataFactory.getOWLClass(IRI.create(x + "House"));
        OWLClass apartment = dataFactory.getOWLClass(IRI.create(x + "apartment"));
        OWLNamedIndividual House1 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Vancouverdreef_55"));
        OWLNamedIndividual House2 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Prof.Hugo_de_Vrieslaan_40"));
        OWLNamedIndividual House3 = dataFactory.getOWLNamedIndividual(IRI.create(x+"H_Paul_Citroenstraat_43"));
        OWLDataProperty  amountBedroom =  dataFactory.getOWLDataProperty(IRI.create(x+"amountBedroom"));
        OWLDataProperty  linkHouse =  dataFactory.getOWLDataProperty(IRI.create(x+"linkToHouse"));
        ArrayList <OWLNamedIndividual> houseArray= new ArrayList<OWLNamedIndividual>();
        houseArray.add(House1);
        houseArray.add(House2);
        houseArray.add(House3);
        
       //QUERY, ask for amount Bedroom and returns the funda links of all the houses from the database
        //(to be loaded in a array as above) that respect it --- this has to be done from the Knowledge Base by the agent without user's input (just the questionnaire)
        
        SimpleRenderer rend=new SimpleRenderer();
        rend.setPrefixesFromOntologyFormat(o2, true);
        System.out.println("Insert number of Bedroom:");
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();

        for (int i = 0; i < 3; i++){
            OWLDataPropertyAssertionAxiom housss = dataFactory.getOWLDataPropertyAssertionAxiom(amountBedroom, houseArray.get(i), numero);

        	if (hReasoner.isEntailed(housss) == true){
        		//.out.println(houseArray.get(i));
                Set<OWLLiteral> sub1 = hReasoner.getDataPropertyValues(houseArray.get(i), linkHouse);                
                System.out.println("Link to House: ");
                for (OWLLiteral equivalents : sub1) {
                   
                    System.out.println(equivalents);
                }
        	}
        }
        
   
        
        
}
	}