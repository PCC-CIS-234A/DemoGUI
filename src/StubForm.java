import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by SYTC307u8365 on 10/10/2017.
 */
public class StubForm {
    private JButton startOverButton;
    private JPanel rootPanel;


    public JPanel getRootPanel() {
        return rootPanel;
    }

    public StubForm() {


        startOverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Main.setUser(new User(-1, "", "", ""));
                Main.showLogin();
            }
        });
    }
}
