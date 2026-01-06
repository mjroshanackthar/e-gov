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

    @Test
    void givenEmptyStatement_whenValidating_thenReturnsFalse() {
        Affirmation affirmation = new Affirmation(0, 0, "", "", "", "", 0);

        assertFalse(affirmation.isValid());
    }

    @Test
    void givenWhitespaceOnlyStatement_whenValidating_thenReturnsFalse() {
        Affirmation affirmation = new Affirmation(0, 0, "   ", "   ", "   ", "   ", 0);

        assertFalse(affirmation.isValid());
    }

    @Test
    void givenNullStatement_whenValidating_thenReturnsFalse() {
        Affirmation affirmation = new Affirmation(0, 0, null, null, null, null, 0);

        assertFalse(affirmation.isValid());
    }
}
