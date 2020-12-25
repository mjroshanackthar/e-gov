package authorized;

import java.util.Scanner;

/**
 *
 * @author Panagiotis Bellias
 */
public class AuthorizedPerson {
    
    private long taxIdentificationNumber;
    private String fullName, identityCard;

    public AuthorizedPerson(long taxIdentificationNumber, String fullName, String identityCard) {
        this.taxIdentificationNumber = taxIdentificationNumber;
        this.fullName = fullName;
        this.identityCard = identityCard;
    }

    public AuthorizedPerson() {
    }
    
    public long getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(long taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
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
    
    public static AuthorizedPerson createOne(){
        
        Scanner input = new Scanner(System.in);
        AuthorizedPerson authorizedPerson = new AuthorizedPerson();
        System.out.print("Please enter the tax identification number of the authorized person: ");
        authorizedPerson.setTaxIdentificationNumber(input.nextLong());
        System.out.print("Please enter the full name of the authorized person: ");
        input = new Scanner(System.in);
        authorizedPerson.setFullName(input.nextLine());
        System.out.print("Please enter the identity card of the authorized person: ");
        authorizedPerson.setIdentityCard(input.nextLine());
        
        return authorizedPerson;
        
    }
    
}
