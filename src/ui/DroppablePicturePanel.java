package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DroppablePicturePanel extends JPanel implements DropTargetListener, MouseListener {
    private final static String DROP_TEXT = "Drop Image Here";
    private DropTarget target;
    private boolean dragging = false;
    private BufferedImage image = null;
    private ArrayList<PictureChangedListener> mPictureChangedListeners;
    private ArrayList<ActionListener> mClickListeners;

    public DroppablePicturePanel() {
        super();
        target = new DropTarget(this, this);
        mPictureChangedListeners = new ArrayList<>();
        mClickListeners = new ArrayList<>();
        addMouseListener(this);
    }

    public void setImage(BufferedImage value) {
        image = value;
        repaint();
    }
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public void paint(Graphics g) {
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        g.clearRect(0, 0, panelWidth - 1, panelHeight - 1);

        if (image != null) {
            // Draw image
            g.drawImage(image, 0, 0, panelWidth, panelHeight, null);
        } else {
            // Draw drop text
            int textWidth = g.getFontMetrics().stringWidth(DROP_TEXT);
            int textHeight = g.getFontMetrics().getHeight();
            g.drawString(DROP_TEXT, (panelWidth - textWidth) / 2, (panelHeight + textHeight / 2)/2);
        }

        // Highlight the panel to show the user is dragging over it.
        if (dragging) {
            g.setColor(new Color(0, 0, 255, 64));
            g.fillRect(0, 0, panelWidth - 1, panelHeight - 1);
            g.setColor(Color.BLACK);
        }

        // Draw frame around panel
        g.drawRect(0, 0, panelWidth - 1, panelHeight - 1);
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        // System.out.println("Drag Enter");
        dragging = true;
        repaint();
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        // System.out.println("Drag Over");
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        // System.out.println("Drop Action Changed");
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        // System.out.println("Drag Exit");
        dragging = false;
        repaint();
    }

    private  void notifyPictureChangedListeners() {
        for (PictureChangedListener listener : mPictureChangedListeners) {
            listener.pictureChanged(this, image);
        }
    }

    private void loadFile(File file) {
        try {
            image = ImageIO.read(file);
            notifyPictureChangedListeners();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        dragging = false;
        System.out.println("Drop");
        Transferable tr = dtde.getTransferable();
        DataFlavor[] flavors = tr.getTransferDataFlavors();
        for (int i = 0; i < flavors.length; i++) {
            if (flavors[i].isFlavorJavaFileListType()) {
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

                // And add the list of file names to our text area
                java.util.List list = null;
                try {
                    list = (java.util.List)tr.getTransferData(flavors[i]);
                    if (list.size() > 0)
                        loadFile((File)list.get(0));
                } catch (UnsupportedFlavorException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // If we made it this far, everything worked.
                dtde.dropComplete(true);
                repaint();
                return;
            }
        }
        repaint();
    }

    public void addPictureChangedListener(PictureChangedListener listener) {
        mPictureChangedListeners.add(listener);
    }
    public void addActionListener(ActionListener listener) {
        mClickListeners.add(listener);
    }

    private void notifyClickListeners(MouseEvent evt) {
        ActionEvent e = new ActionEvent(
                evt.getSource(),
                ActionEvent.ACTION_PERFORMED,
                "Click",
                evt.getWhen(),
                evt.getModifiers());
        for (ActionListener listener : mClickListeners) {
            listener.actionPerformed(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        notifyClickListeners(e);
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

    public interface PictureChangedListener {
        void pictureChanged(DroppablePicturePanel droppablePicturePanel, BufferedImage image);
    }
}
