// File: gatelog/ui/LoginUI.java
package gatelog.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class LoginUI extends JFrame {

    private JComboBox<String> roleCombo;
    private JTextField userField;
    private JPasswordField passField;

    public LoginUI() {
        setTitle("GateLog Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("Role:"));
        roleCombo = new JComboBox<>(new String[]{"Admin", "Faculty"});
        panel.add(roleCombo);

        panel.add(new JLabel("Username:"));
        userField = new JTextField();
        panel.add(userField);

        panel.add(new JLabel("Password:"));
        passField = new JPasswordField();
        panel.add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> login());
        panel.add(loginBtn);

        add(panel);

        // 🔴 THIS IS THE CRITICAL LINE (ADDED)
        setVisible(true);
    }

    private void login() {
        String role = (String) roleCombo.getSelectedItem();
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        boolean valid = false;

        if ("Admin".equals(role)) {
            if ("admin".equals(user) && "1234".equals(pass)) {
                valid = true;
                new AdminUI();
            }
        } else if ("Faculty".equals(role)) {
            if ("faculty".equals(user) && "abcd".equals(pass)) {
                valid = true;
                new FacultyUI();
            }
        }

        if (valid) {
            dispose();   // close login after successful login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials");
        }
    }
}
