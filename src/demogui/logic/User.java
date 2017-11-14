package demogui.logic;

import demogui.database.Database;
import demogui.main.Main;

import java.awt.image.BufferedImage;

public class User {
    private int mUserID;
    private String mEmail;
    private String mPassword;
    private String mRole;
    private BufferedImage mImage;

    public static final String ADMIN_ROLE = "Admin";
    public static final String THERAPIST_ROLE = "Therapist";
    public static final String USER_ROLE = "User";

    public User(int userID, String email, String password, String role, BufferedImage image) {
        mUserID = userID;
        mEmail = email;
        mPassword = password;
        mRole = role;
        mImage = image;
    }

    public static void login(String em, String pwd) {

        // some logic to verify that the user is the legitimate user.
        Database db = new Database();
        User user = db.lookupUser(em);
        db.close();

        if(user == null) {
            System.out.println("demogui.logic.User not found, need an error dialog.");
            return;
        }
        System.out.println("ID: " + user.getUserID() + ", Email: " + user.getEmail() + ", Password: " + user.getPassword() + ", Role: " + user.getRole());
        if(user.getPassword().equals(pwd)) {
            System.out.println("demogui.logic.User " + user.getUserID() + " logged in successfully.");
            Main.setUser(user);
            Main.login();
        } else {
            System.out.println("Password incorrect, need an error dialog.");
        }
    }

    public static User register(String email, String password, String passwordConfirm, BufferedImage image) {
        if(!password.equals(passwordConfirm)) {
            System.out.println("Password not equal confirm password. Alert dialog goes here.");
            return null;
        }
        /// validate password and email
        Database db = new Database();
        User user = db.lookupUser(email);

        if(user != null) {
            System.out.println("demogui.logic.User already exists! Alert goes here.");
            return null;
        }

        user = db.registerUser(email, password, image);
        db.close();
        return user;
    }

    public int getUserID() {
        return mUserID;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getRole() {
        return mRole;
    }

    public BufferedImage getImage() {
        return mImage;
    }
}
