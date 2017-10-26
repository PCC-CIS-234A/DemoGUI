package demogui.logic;

import demogui.logic.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by SYTC307u8365 on 10/24/2017.
 */
class UserTest {
    @Test
    void login() {
    }

    @Test
    void register() {
    }

    @Test
    void getUserID() {
        User u = new User(-1, "marc.goodman@pcc.edu", "test password", "Admin");

        assertEquals(u.getUserID(), -1);
    }

    @Test
    void getEmail() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void getRole() {
    }

}