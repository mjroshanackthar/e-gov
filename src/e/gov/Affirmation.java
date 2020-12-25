package e.gov;

import authorized.*;
import java.util.*;

/**
 *
 * @author Panagiotis Bellias
 */
public class Affirmation {
    
    private long taxIdentificationNumber, cellPhoneNumber;
    private String fullName, identityCard, depositor, statementText;
    private int uniqueCode;

    public Affirmation(long taxIdentificationNumber, long cellPhoneNumber, String fullName, String identityCard, 
            String depositor, String statementText, int uniqueCode) {
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.cellPhoneNumber = cellPhoneNumber;
        this.fullName = fullName;
        this.identityCard = identityCard;
        this.depositor = depositor;
        this.statementText = statementText;
        this.uniqueCode = uniqueCode;
    }

    public Affirmation() {
    }

    public long getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(long taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public long getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(long cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getStatementText() {
        return statementText;
    }

    public void setStatementText(String statementText) {
        this.statementText = statementText;
    }

    public int getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(int uniqueCode) {
        this.uniqueCode = uniqueCode;
    }
    
    public static Affirmation createOne(int id){
        
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your tax identification number: ");
        long taxIdentificationNumber = input.nextLong();
        System.out.print("Please enter your full name: ");
        input = new Scanner(System.in);
        String fullName = input.nextLine();
        System.out.print("Please enter your cell phone number: ");
        input = new Scanner(System.in);
        long cellPhoneNumber = input.nextLong();
        System.out.print("Please enter your identity card: ");
        input = new Scanner(System.in);
        String identityCard = input.nextLine();
        System.out.print("Please enter the depositor: ");
        input = new Scanner(System.in);
        String depositor = input.nextLine();
        while (depositor.length() > 12){
            System.out.println("Too long name for depositor. Try again...");
            depositor = input.nextLine();
        }
        System.out.print("Please enter your text of statement: ");
        String statementText = input.nextLine();
        while (statementText.length() > 15){
            System.out.println("Too long text. Try again...");
            statementText = input.nextLine();
        }
        System.out.print("Is your document an authorization? Enter \"YES\" or \"NO\": ");
        String authorizationDoc = input.next();
        
        if(authorizationDoc.equals("NO")) {
            Affirmation affirmation = new Affirmation(taxIdentificationNumber, cellPhoneNumber, fullName, identityCard, 
                    depositor, statementText, id);
            return affirmation;
        } else {
            Authorization authorization = new Authorization(taxIdentificationNumber, cellPhoneNumber, fullName, 
                    identityCard, depositor, statementText, id);
            authorization.setAuthorizedPerson(AuthorizedPerson.createOne());
            System.out.println("Please enter the reason of authorization: \n"
                    + "1 for receipt, \n"
                    + "2 for deposit or \n"
                    + "3 for signature");
            int reasonCode = input.nextInt();
            String reason;
            switch (reasonCode) {
                case 1:
                    reason = "Receipt";
                    break;
                case 2:
                    reason = "Deposit";
                    break;
                default:
                    reason = "Signature";
                    break;
            }
            authorization.setAuthorizationReason(reason);
            return authorization;
        }
        
    }
    
    public static ArrayList<Affirmation> searching(ArrayList<Affirmation> documents){
        
        System.out.print("Enter your unique document code: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        ArrayList<Affirmation> results = new ArrayList<>();
        Iterator<Affirmation> doc = documents.iterator();
        while(doc.hasNext()){
            Affirmation document = doc.next();
            if(document.getUniqueCode() == id)
                results.add(document);
        }
        return results;
        
    }
    
    public static void docResults(ArrayList<Affirmation> results){
        
        Iterator<Affirmation> res = results.iterator();
        while(res.hasNext()){
            Affirmation aff = res.next();
            System.out.println("Unique Document Code: " + aff.getUniqueCode() + "\n"
                    + "Citizen Full Name: " + aff.getFullName() + "\n"
                            + "Document Kind: " + aff.getClass().getSimpleName());
        }
        
    }

    @Override
    public String toString() {
        return "Document is created for " + getFullName() + "\n"
                + "with unique docuement code: " + getUniqueCode();
    }
    
}
