package authorized;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthorizedPersonTest {

    @Test
    void shouldCreateAuthorizedPersonWithValidData() {
        AuthorizedPerson person = new AuthorizedPerson(1, "John Doe", "JOHNDOE");

        assertNotNull(person);
        assertEquals("John Doe", person.getFullName());
        assertEquals("JOHNDOE", person.getIdentityCard());
    }

    @Test
    void shouldReturnFullName() {
        AuthorizedPerson person = new AuthorizedPerson(1, "John Doe", "JOHNDOE");

        assertEquals("John Doe", person.getFullName());
    }

    @Test
    void givenValidNames_whenCreatingPerson_thenFieldsAreSet() {
        AuthorizedPerson person = new AuthorizedPerson(1, "John Doe", "JOHNDOE");

        assertAll(
                () -> assertEquals(1, person.getTaxIdentificationNumber()),
                () -> assertEquals("John Doe", person.getFullName()),
                () -> assertEquals("JOHNDOE", person.getIdentityCard())
        );
    }
}
