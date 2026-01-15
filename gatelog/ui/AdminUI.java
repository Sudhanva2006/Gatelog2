// File: gatelog/ui/AdminUI.java
package gatelog.ui;

import gatelog.Admin;
import gatelog.StudentExit;
import gatelog.Visitor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AdminUI extends JFrame {

    private Admin admin = new Admin();
    private JTable table;

    public AdminUI() {
        setTitle("Admin Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();

        JButton addVisitorBtn = new JButton("Add Visitor");
        addVisitorBtn.addActionListener(e -> addVisitor());
        buttonPanel.add(addVisitorBtn);

        JButton viewVisitorsBtn = new JButton("View Visitors");
        viewVisitorsBtn.addActionListener(e -> viewVisitors());
        buttonPanel.add(viewVisitorsBtn);

        JButton verifyBtn = new JButton("Verify Student Exit");
        verifyBtn.addActionListener(e -> verifyStudentExit());
        buttonPanel.add(verifyBtn);

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
                this.dispose();               // close Admin UI
                new LoginUI();                // reopen Login UI
            }
        });
        buttonPanel.add(logoutBtn);
        // 🔴 END LOGOUT

        add(buttonPanel, BorderLayout.NORTH);

        table = new JTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        setVisible(true);
    }

    private void addVisitor() {
        JTextField nameField = new JTextField(10);
        JTextField phoneField = new JTextField(10);
        JTextField purposeField = new JTextField(10);
        JTextField inTimeField = new JTextField(10);
        JTextField outTimeField = new JTextField(10);

        JPanel dialogPanel = new JPanel(new GridLayout(5, 2));
        dialogPanel.add(new JLabel("Name:"));
        dialogPanel.add(nameField);
        dialogPanel.add(new JLabel("Phone:"));
        dialogPanel.add(phoneField);
        dialogPanel.add(new JLabel("Purpose:"));
        dialogPanel.add(purposeField);
        dialogPanel.add(new JLabel("In Time:"));
        dialogPanel.add(inTimeField);
        dialogPanel.add(new JLabel("Out Time:"));
        dialogPanel.add(outTimeField);

        int result = JOptionPane.showConfirmDialog(
                this, dialogPanel, "Add Visitor", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                Visitor visitor = new Visitor(
                        nameField.getText(),
                        phoneField.getText(),
                        purposeField.getText(),
                        inTimeField.getText(),
                        outTimeField.getText()
                );
                admin.addVisitor(visitor);
                JOptionPane.showMessageDialog(this, "Success");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    private void viewVisitors() {
        try {
            List<Visitor> visitors = admin.getAllVisitors();
            String[] columns = {"ID", "Name", "Phone", "Purpose", "In Time", "Out Time"};
            Object[][] data = new Object[visitors.size()][6];

            for (int i = 0; i < visitors.size(); i++) {
                Visitor v = visitors.get(i);
                data[i][0] = v.getId();
                data[i][1] = v.getName();
                data[i][2] = v.getPhone();
                data[i][3] = v.getPurpose();
                data[i][4] = v.getInTime();
                data[i][5] = v.getOutTime();
            }

            table.setModel(new DefaultTableModel(data, columns));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }

    private void verifyStudentExit() {
        String usn = JOptionPane.showInputDialog(this, "Enter USN:");
        if (usn != null) {
            try {
                StudentExit exit = admin.verifyStudentExit(usn);
                if (exit != null) {
                    String details =
                            "USN: " + exit.getUsn() + "\n" +
                            "Name: " + exit.getStudentName() + "\n" +
                            "Department: " + exit.getDepartment() + "\n" +
                            "Year: " + exit.getYear() + "\n" +
                            "Reason: " + exit.getReason() + "\n" +
                            "Approved By: " + exit.getApprovedBy();
                    JOptionPane.showMessageDialog(this, details);
                } else {
                    JOptionPane.showMessageDialog(this, "No record found");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
            }
        }
    }
}
