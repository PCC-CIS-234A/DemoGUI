import java.sql.*;

public class Database {
    private static final String SERVER = "cisdbss.pcc.edu";
    private static final String DATABASE = "DemoGUI";
    private static final String USERNAME = "DemoGUI";
    private static final String PASSWORD = "DemoGUI";
    private static final String CONNECTION_STRING = "jdbc:jtds:sqlserver://"
            + SERVER + "/" + DATABASE + ";user=" + USERNAME + ";password=" + PASSWORD;
    private Connection mConnection = null;

    private void connect() {
        if(mConnection != null)
            return;
        try {
            mConnection = DriverManager.getConnection(CONNECTION_STRING);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User lookupUser(String email) {
        connect();
        String query = "SELECT UserID, Email, Password, Role FROM USERS WHERE Email = ?";
        try {
            PreparedStatement stmt = mConnection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new User(rs.getInt("UserID"), rs.getString("Email"), rs.getString("Password"), rs.getString("role"));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void close() {
        if(mConnection != null) {
            System.out.println("Closing database connection.");
            try {
                mConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void finalize() {
        close();
    }
}
