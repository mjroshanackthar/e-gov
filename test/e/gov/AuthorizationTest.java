package e.gov;

import authorized.AuthorizedPerson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationTest {

    @Test
    void shouldAuthorizeWhenPersonAndAffirmationAreValid() {
        AuthorizedPerson person = new AuthorizedPerson(1, "Jane Doe", "JANEDOE");
        Affirmation affirmation = new Affirmation(person.getTaxIdentificationNumber(), 1234567890, person.getFullName(), person.getIdentityCard(), person.getFullName(), "Confirmed", 1);

        Authorization authorization = new Authorization(person, affirmation, "test");
        System.out.println(authorization.getAuthorizationReason());
        System.out.println(authorization.getAuthorizedPerson());
        System.out.println(authorization.getFullName());
        System.out.println(authorization.getIdentityCard());
        System.out.println(authorization.getTaxIdentificationNumber());
        assertTrue(authorization.isAuthorized());
    }

    @Test
    void shouldNotAuthorizeWhenAffirmationIsInvalid() {
        AuthorizedPerson person = new AuthorizedPerson(1, "Jane Doe", "JANEDOE");
        Affirmation affirmation = new Affirmation();

        Authorization authorization = new Authorization(person, affirmation, null);

        assertFalse(authorization.isAuthorized());
    }

    @Test
    void givenNullPerson_whenAuthorizing_thenReturnsFalse() {
        Affirmation affirmation = new Affirmation();
        affirmation.setStatementText("Confirmed");
        Authorization authorization = new Authorization(null, affirmation, null);

        assertFalse(authorization.isAuthorized());
    }
}
