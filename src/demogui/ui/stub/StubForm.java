package demogui.ui.stub;

import demogui.logic.User;
import demogui.main.Main;
import demogui.ui.PicturePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by SYTC307u8365 on 10/10/2017.
 */
public class StubForm {
    private JButton startOverButton;
    private JPanel rootPanel;
    private PicturePanel picturePanel1;
    private PicturePanel picturePanel2;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public StubForm(User user) {
        picturePanel1.setImage(user.getImage());
        try {
            BufferedImage image2 = ImageIO.read(new File("images/trump.png"));
            picturePanel2.setImage(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        picturePanel1.setCallback(() -> System.out.println("Clicked panel 1"));
        picturePanel2.setCallback(() -> System.out.println("Clicked Trump"));
        startOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.setUser(new User(-1, "", "", "", null));
                Main.showLogin();
            }
        });
    }
}
