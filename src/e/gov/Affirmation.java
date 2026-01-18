package e.gov;

import authorized.AuthorizedPerson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Panagiotis Bellias
 */
@SuppressWarnings("PMD.DataClass")
public class Affirmation {

    private static final Logger LOG = Logger.getLogger(Affirmation.class.getName());

    private long taxIdentificationNumber;
    private long cellPhoneNumber;
    private String fullName;
    private String identityCard;
    private String depositor;
    private String statementText;
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

        try (Scanner input = new Scanner(System.in)) {
            LOG.info("Please enter your tax identification number: ");
            long taxIdentificationNumber = input.nextLong();
            input.nextLine();
            LOG.info("Please enter your full name: ");
            String fullName = input.nextLine();
            LOG.info("Please enter your cell phone number: ");
            long cellPhoneNumber = input.nextLong();
            input.nextLine();
            LOG.info("Please enter your identity card: ");
            String identityCard = input.nextLine();

            LOG.info("Please enter the depositor: ");
            String depositor = input.nextLine();
            Affirmation validator = new Affirmation();
            while (!validator.isDepositorValid(depositor)) {
                LOG.info("Too long name for depositor. Try again...");
                depositor = input.nextLine();
            }

            LOG.info("Please enter your text of statement: ");
            String statementText = input.nextLine();
            while (!new Affirmation().isStatementTextValid(statementText)) {
                LOG.info("Too long text. Try again...");
                statementText = input.nextLine();
            }

            LOG.info("Is your document an authorization? Enter \"YES\" or \"NO\": ");
            String authorizationDoc = input.next();

            if ("NO".equals(authorizationDoc)) {
                Affirmation affirmation = new Affirmation(taxIdentificationNumber, cellPhoneNumber, fullName, identityCard,
                        depositor, statementText, id);
                return affirmation;
            } else {
                Authorization authorization = new Authorization(taxIdentificationNumber, cellPhoneNumber, fullName,
                        identityCard, depositor, statementText, id);
                authorization.createAndSetAuthorizedPerson();
                LOG.info("Please enter the reason of authorization: \n"
                        + "1 for receipt, \n"
                        + "2 for deposit or \n"
                        + "3 for signature");
                int reasonCode = input.nextInt();
                input.nextLine();
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

    }

    public boolean isDepositorValid(String depositor) {
        return depositor != null && depositor.length() <= 12;
    }

    public boolean isStatementTextValid(String statementText) {
        return statementText != null && statementText.length() <= 15;
    }

    @SuppressWarnings("PMD.LawOfDemeter")
    public static List<Affirmation> searching(List<Affirmation> documents){
        
        LOG.info("Enter your unique document code: ");
        int id;
        try (Scanner input = new Scanner(System.in)) {
            id = input.nextInt();
        }
        ArrayList<Affirmation> results = new ArrayList<>();
        Iterator<Affirmation> doc = documents.iterator();
        while(doc.hasNext()){
            Affirmation document = doc.next();
            if (document.hasUniqueCode(id)) {
                results.add(document);
            }
        }
        return results;
        
    }

    public boolean hasUniqueCode(int id) {
        return this.uniqueCode == id;
    }

    @SuppressWarnings("PMD.LawOfDemeter")
    public static void docResults(List<Affirmation> results){
        
        Iterator<Affirmation> res = results.iterator();
        while(res.hasNext()){
            Affirmation aff = res.next();
            if (LOG.isLoggable(Level.INFO)) {
                String kind = aff.getDocumentKind();
                LOG.info("Unique Document Code: " + aff.getUniqueCode() + "\n"
                        + "Citizen Full Name: " + aff.getFullName() + "\n"
                                + "Document Kind: " + kind);
            }
        }
        
    }

    private boolean hasValidStatementText() {
        return statementText != null && !statementText.isEmpty();
    }

    public boolean isValid() {
        return hasValidStatementText();
    }

    @SuppressWarnings("PMD.LawOfDemeter")
    public String getDocumentKind() {
        return this.getClass().getSimpleName();
    }

    public void logSummary(Logger log) {
        if (log.isLoggable(Level.INFO)) {
            log.info(this.toString());
        }
    }

    @Override
    public String toString() {
        return "Document is created for " + getFullName() + "\n"
                + "with unique docuement code: " + getUniqueCode();
    }
    
}
