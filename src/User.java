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
