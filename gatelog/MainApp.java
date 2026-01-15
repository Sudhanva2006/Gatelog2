// File: gatelog/MainApp.java
package gatelog;

import gatelog.ui.LoginUI;

import javax.swing.SwingUtilities;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI().setVisible(true));
    }
}