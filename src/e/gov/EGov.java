package e.gov;

import java.util.*;

/**
 *
 * @author Panagiotis Bellias
 */
public class EGov {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Affirmation> documents = new ArrayList<>();
        int id = 1; 
        boolean exit = false;
        
        while(exit == false) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose operation:\n"
                    + "1 for document creation,\n"
                    + "2 for document checking and \n"
                    + "3 to quit the program");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    Affirmation affirmation = Affirmation.createOne(id);
                    id++;
                    documents.add(affirmation);
                    System.out.println(affirmation.toString());
                    break;
                case 2:
                    ArrayList<Affirmation> results = Affirmation.searching(documents);
                    Affirmation.docResults(results);
                    break;
                case 3:
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Not right number. Try again");
                    break;
            }
        }
        
    }
    
}
