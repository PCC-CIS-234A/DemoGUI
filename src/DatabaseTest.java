import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by SYTC307u8365 on 10/24/2017.
 */
class DatabaseTest {
    private static final String EMAIL = "marc.goodman@pcc.edu";
    private static final String PASSWORD = "test password";
    private static final String ROLE = "Admin";
    private static final int ID = 1;

    @Test
    void lookupUserWhoExists() {
        Database db = new Database();
        User u = db.lookupUser(EMAIL);

        assertEquals(ID, u.getUserID());
    }

    @Test
    void lookupNonexistentUser() {
        Database db = new Database();
        User u = db.lookupUser("bogus@bogus.com");

        assertNull(u);
    }

    @Test
    void registerUser() {
    }

}