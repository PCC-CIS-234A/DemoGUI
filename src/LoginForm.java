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

    LoginForm(User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        emailTextField.setText(email);
        passwordTextField.setText(password);

        loginButton.addActionListener(actionEvent -> {
            User.login(emailTextField.getText(), passwordTextField.getText());
        });

        newAccountButton.addActionListener(actionEvent -> {
            Main.setUser(new User(-1, emailTextField.getText(), passwordTextField.getText(), ""));
            Main.showRegister();
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
