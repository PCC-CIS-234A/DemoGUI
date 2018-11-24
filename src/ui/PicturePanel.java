package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PicturePanel extends JPanel implements MouseListener {
    private BufferedImage image = null;
    private ArrayList<ActionListener> mListeners;
    private int mId = 0; // stubbed for now, if you want to have multiple picture panels, you need to include distinct IDs
                         // so that the listeners know which one was clicked.

    public PicturePanel() {
        super();
    }

    public void setImage(BufferedImage value) {
        image = value;
        repaint();
        addMouseListener(this);
        mListeners = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        g.clearRect(0, 0, panelWidth - 1, panelHeight - 1);

        if (image != null) {
            // Draw image
            g.drawImage(image, 0, 0, panelWidth, panelHeight, null);
        }

        // Draw frame around panel
        g.drawRect(0, 0, panelWidth - 1, panelHeight - 1);
    }

    public void addActionListener(ActionListener listener) {
        mListeners.add(listener);
    }

    private void notifyListeners(MouseEvent evt) {
        ActionEvent e = new ActionEvent(
                evt.getSource(),
                ActionEvent.ACTION_PERFORMED,
                "Click",
                evt.getWhen(),
                evt.getModifiers());
        for (ActionListener listener : mListeners) {
            listener.actionPerformed(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        notifyListeners(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
