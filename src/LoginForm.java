import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SYTC307u8365 on 10/5/2017.
 */
public class LoginForm {
    JPanel rootPanel;
    JTextField emailTextField;
    JButton newAccountButton;
    JButton loginButton;
    JTextField passwordTextField;

    LoginForm(String email, String password) {
        emailTextField.setText(email);
        passwordTextField.setText(password);

        loginButton.addActionListener(actionEvent -> {
            // some logic to verify that the user is the legitimate user.
            Database db = new Database();
            String em = emailTextField.getText();
            String pwd = passwordTextField.getText();
            User user = db.lookupUser(em);
            db.close();

            if(user == null) {
                System.out.println("User not found, need an error dialog.");
                return;
            }
            System.out.println("ID: " + user.getUserID() + ", Email: " + user.getEmail() + ", Password: " + user.getPassword() + ", Role: " + user.getRole());
            if(user.getPassword().equals(pwd)) {
                System.out.println("User " + user.getUserID() + " logged in successfully.");
                Main.setEmail(emailTextField.getText());
                Main.setPassword(passwordTextField.getText());
                Main.login();
            } else {
                System.out.println("Password incorrect, need an error dialog.");
            }
        });

        newAccountButton.addActionListener(actionEvent -> {
            Main.setEmail(emailTextField.getText());
            Main.setPassword(passwordTextField.getText());
            Main.showRegister();
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
