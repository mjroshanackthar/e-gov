package e.gov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AffirmationTest {

    @Test
    void shouldBeValidWhenStatementIsProvided() {
        Affirmation affirmation = new Affirmation();
        affirmation.setStatementText("I declare this is true");
        assertTrue(affirmation.isValid());
    }

    @Test
    void shouldBeInvalidWhenStatementIsEmpty() {
        Affirmation affirmation = new Affirmation();

        assertFalse(affirmation.isValid());
    }
}
