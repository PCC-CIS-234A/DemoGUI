import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SYTC307u8365 on 10/5/2017.
 */
public class RegisterForm {
    JPanel rootPanel;
    JTextField emailTextField;
    JButton loginExistingButton;
    JButton registerButton;
    JTextField passwordTextField;
    private JPasswordField passwordConfirmField;

    public RegisterForm(String email, String password) {
        emailTextField.setText(email);
        passwordTextField.setText(password);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // some logic to verify that the user is the legitimate user.
                Main.setEmail(emailTextField.getText());
                Main.setPassword(passwordTextField.getText());
                Main.login();
            }
        });
        loginExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.setEmail(emailTextField.getText());
                Main.setPassword(passwordTextField.getText());
                Main.showLogin();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
