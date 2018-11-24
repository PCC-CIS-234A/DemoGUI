package demogui.login;

import logic.User;
import main.Main;
import ui.DroppablePicturePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SYTC307u8365 on 10/5/2017.
 */
public class RegisterForm implements DroppablePicturePanel.PictureChangedListener {
    JPanel rootPanel;
    JTextField emailTextField;
    JButton loginExistingButton;
    JButton registerButton;
    JTextField passwordTextField;
    private JPasswordField passwordConfirmField;
    private DroppablePicturePanel picturePanel;
    private BufferedImage image = null;

    public RegisterForm(User user) {
        String email = user.getEmail();
        String password = user.getPassword();

        emailTextField.setText(email);
        passwordTextField.setText(password);

        picturePanel.addPictureChangedListener(this);

        picturePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clicked droppable picture panel.");
                chooseImageFile();
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                User user = User.register(
                        emailTextField.getText(),
                        passwordTextField.getText(),
                        passwordConfirmField.getText(),
                        image
                );
                // some logic to verify that the user is the legitimate user.
                if(user != null) {
                    Main.setUser(user);
                    System.out.println("Logged in: ID: " + user.getUserID() +
                        ", Email: " + user.getEmail() + ", Role: " + user.getRole());
                    Main.login();
                }
            }
        });
        loginExistingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.setUser(new User(-1, emailTextField.getText(), passwordTextField.getText(), "", null));
                Main.showLogin();
            }
        });
    }

    private void chooseImageFile() {
        JFileChooser chooser = new JFileChooser();
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            System.out.println("Chose file " + chooser.getSelectedFile());
            try {
                image = ImageIO.read(chooser.getSelectedFile());
                picturePanel.setImage(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    @Override
    public void pictureChanged(DroppablePicturePanel droppablePicturePanel, BufferedImage img) {
        // Got a new image, let's remember it for later.
        image = img;
        System.out.println("Got picture " + image);
    }
}
