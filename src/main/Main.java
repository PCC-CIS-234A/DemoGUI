package main;

import demogui.bigPicture.BigPicture;
import logic.User;
import demogui.login.LoginForm;
import demogui.login.RegisterForm;
import demogui.stub.StubForm;

import javax.swing.*;

import static javax.swing.SwingUtilities.invokeLater;

/**
 * Created by SYTC307u8365 on 10/5/2017.
 */
// import javax.swing.*;

public class Main {
    private static User mUser = new User(-1, "", "", "", null);
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
        mFrame.getContentPane().add(new StubForm(mUser).getRootPanel());
        mFrame.pack();
        mFrame.setLocationRelativeTo(null);
        mFrame.setVisible(true);
    }

    public static void showBigPicture() {
        JFrame frame = new JFrame("The Big Picture");
        frame.getContentPane().removeAll();
        frame.getContentPane().add(new BigPicture(mUser).getRootPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
