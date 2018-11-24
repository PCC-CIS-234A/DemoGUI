package demogui.bigPicture;

import logic.User;
import main.Main;
import ui.PicturePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class BigPicture {

    private JButton startOverButton;
    private JPanel rootPanel;
    private ui.PicturePanel picturePanel;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public BigPicture(User user) {
        BufferedImage image = user.getImage();
        picturePanel.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        picturePanel.setImage(image);
    }

}
