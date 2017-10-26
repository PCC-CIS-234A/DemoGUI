package demogui.main;

import demogui.logic.User;
import demogui.ui.login.LoginForm;
import demogui.ui.login.RegisterForm;
import demogui.ui.stub.StubForm;

import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by SYTC307u8365 on 10/5/2017.
 */
// import javax.swing.*;

public class Main {
    private static User mUser = new User(-1, "", "", "");
    private static JFrame mFrame = null;

    public static void createGUI() {
        mFrame = new JFrame();
        mFrame.setDefaultCloseOperation(mFrame.EXIT_ON_CLOSE);
        showLogin();
    }

    public static void showLogin() {
        mFrame.getContentPane().removeAll();
        mFrame.getContentPane().add(new LoginForm(mUser).getRootPanel());
        mFrame.pack();
        mFrame.setLocationRelativeTo(null);
        mFrame.setVisible(true);
    }

    public static void showRegister() {
        mFrame.getContentPane().removeAll();
        mFrame.getContentPane().add(new RegisterForm(mUser).getRootPanel());
        mFrame.pack();
        mFrame.setLocationRelativeTo(null);
        mFrame.setVisible(true);
    }

    public static void showStub() {
        mFrame.getContentPane().removeAll();
        mFrame.getContentPane().add(new StubForm().getRootPanel());
        mFrame.pack();
        mFrame.setLocationRelativeTo(null);
        mFrame.setVisible(true);
    }

    public static void setUser(User user) {
        mUser = user;
    }

    public static void login() {
        showStub();
    }

    public static void main(String[] args) {
        invokeLater(new Runnable() {
           public void run() {
               createGUI();
           }
        });
    }
}
