package e.gov;

import authorized.AuthorizedPerson;

/**
 *
 * @author Panagiotis Bellias
 */
public class Authorization extends Affirmation {
    
    private AuthorizedPerson authorizedPerson = new AuthorizedPerson();
    private String authorizationReason;

    public Authorization(long taxIdentificationNumber, long cellPhoneNumber, String fullName, String identityCard, 
            String depositor, String statementText, int uniqueCode) {
        super(taxIdentificationNumber, cellPhoneNumber, fullName, identityCard, depositor, statementText, uniqueCode);
    }

    public Authorization(long taxIdentificationNumber, long cellPhoneNumber, String fullName, String identityCard, 
            String depositor, String statementText, AuthorizedPerson authorizedPerson, 
            String authorizationReason, int uniqueCode) {
        super(taxIdentificationNumber, cellPhoneNumber, fullName, identityCard, depositor, statementText, uniqueCode);
        this.authorizedPerson = authorizedPerson;
        this.authorizationReason = authorizationReason;
    }

    public Authorization(AuthorizedPerson authorizedPerson, Affirmation affirmation) {
        super(affirmation.getTaxIdentificationNumber(), affirmation.getCellPhoneNumber(), affirmation.getFullName(), affirmation.getIdentityCard(), affirmation.getDepositor(), affirmation.getStatementText(), affirmation.getUniqueCode());
        this.authorizedPerson = authorizedPerson;
    }
    
    public Authorization(){
        super();
    }
    
    public AuthorizedPerson getAuthorizedPerson() {
        return authorizedPerson;
    }

    public void setAuthorizedPerson(AuthorizedPerson authorizedPerson) {
        this.authorizedPerson = authorizedPerson;
    }

    public String getAuthorizationReason() {
        return authorizationReason;
    }

    public void setAuthorizationReason(String authorizationReason) {
        this.authorizationReason = authorizationReason;
    }

    public boolean isAuthorized() {
        return authorizationReason != null && !authorizationReason.isEmpty() && authorizedPerson != null &&
                authorizedPerson.getFullName() != null && !authorizedPerson.getFullName().isEmpty() &&
                authorizedPerson.getIdentityCard() != null && !authorizedPerson.getIdentityCard().isEmpty() &&
                authorizedPerson.getTaxIdentificationNumber() > 0;
    }
    
}
