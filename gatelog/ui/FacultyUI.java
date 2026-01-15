// File: gatelog/ui/FacultyUI.java
package gatelog.ui;

import gatelog.Faculty;
import gatelog.StudentExit;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FacultyUI extends JFrame {

    private Faculty faculty = new Faculty();

    public FacultyUI() {
        setTitle("Faculty Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JButton addBtn = new JButton("Add Student Exit");
        addBtn.addActionListener(e -> addStudentExit());
        panel.add(addBtn);

        // 🔴 LOGOUT BUTTON (ADDED)
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to logout?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                this.dispose();        // close Faculty UI
                new LoginUI();         // reopen Login UI
            }
        });
        panel.add(logoutBtn);
        // 🔴 END LOGOUT

        add(panel);
        setVisible(true);
    }

    private void addStudentExit() {
        JTextField usnField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField deptField = new JTextField(10);
        JTextField yearField = new JTextField(10);
        JTextField reasonField = new JTextField(10);

        JPanel dialogPanel = new JPanel(new GridLayout(5, 2));
        dialogPanel.add(new JLabel("USN:"));
        dialogPanel.add(usnField);
        dialogPanel.add(new JLabel("Name:"));
        dialogPanel.add(nameField);
        dialogPanel.add(new JLabel("Department:"));
        dialogPanel.add(deptField);
        dialogPanel.add(new JLabel("Year:"));
        dialogPanel.add(yearField);
        dialogPanel.add(new JLabel("Reason:"));
        dialogPanel.add(reasonField);

        int result = JOptionPane.showConfirmDialog(
                this, dialogPanel, "Add Student Exit", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                StudentExit exit = new StudentExit(
                        usnField.getText(),
                        nameField.getText(),
                        deptField.getText(),
                        Integer.parseInt(yearField.getText()),
                        reasonField.getText(),
                        null
                );
                faculty.addStudentExit(exit);
                JOptionPane.showMessageDialog(this, "Success");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid year");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }
}
