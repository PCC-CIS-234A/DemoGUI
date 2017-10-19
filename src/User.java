public class User {
    private int mUserID;
    private String mEmail;
    private String mPassword;
    private String mRole;

    public User(int userID, String email, String password, String role) {
        mUserID = userID;
        mEmail = email;
        mPassword = password;
        mRole = role;
    }

    public static void login(String em, String pwd) {

        // some logic to verify that the user is the legitimate user.
        Database db = new Database();
        User user = db.lookupUser(em);
        db.close();

        if(user == null) {
            System.out.println("User not found, need an error dialog.");
            return;
        }
        System.out.println("ID: " + user.getUserID() + ", Email: " + user.getEmail() + ", Password: " + user.getPassword() + ", Role: " + user.getRole());
        if(user.getPassword().equals(pwd)) {
            System.out.println("User " + user.getUserID() + " logged in successfully.");
            Main.setUser(user);
            Main.login();
        } else {
            System.out.println("Password incorrect, need an error dialog.");
        }
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
}
