package e.gov;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EGovTest {

    @Test
    void applicationShouldStartWithoutErrors() {
        assertDoesNotThrow(() -> EGov.main(new String[]{ "--test" }));
    }
}
