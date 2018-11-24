package demogui.stub;

import logic.User;
import main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SYTC307u8365 on 10/10/2017.
 */
public class StubForm {
    private JButton startOverButton;
    private JPanel rootPanel;
    private ui.PicturePanel picturePanel;


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public StubForm(User user) {
        picturePanel.setImage(user.getImage());

        picturePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.setUser(user);
                Main.showBigPicture();
            }
        });
        startOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.setUser(new User(-1, "", "", "", null));
                Main.showLogin();
            }
        });
    }
}
