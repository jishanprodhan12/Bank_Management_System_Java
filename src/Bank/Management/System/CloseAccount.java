package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CloseAccount extends JFrame implements ActionListener {

    JButton b1, b2;
    JPasswordField pinField;
    JTextField cardField;
    String pin;
    JLabel confirmLabel;

    CloseAccount(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("ACCOUNT CLOSURE");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(500, 180, 400, 35);
        l3.add(label1);

        JLabel label2 = new JLabel("WARNING: This action is irreversible!");
        label2.setForeground(Color.RED);
        label2.setFont(new Font("System", Font.BOLD, 14));
        label2.setBounds(480, 220, 400, 35);
        l3.add(label2);

        JLabel cardLabel = new JLabel("Card Number:");
        cardLabel.setForeground(Color.WHITE);
        cardLabel.setFont(new Font("System", Font.BOLD, 16));
        cardLabel.setBounds(430, 270, 150, 35);
        l3.add(cardLabel);

        cardField = new JTextField();
        cardField.setBackground(new Color(65, 125, 128));
        cardField.setForeground(Color.WHITE);
        cardField.setBounds(600, 270, 200, 30);
        cardField.setFont(new Font("Raleway", Font.BOLD, 16));
        l3.add(cardField);

        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setForeground(Color.WHITE);
        pinLabel.setFont(new Font("System", Font.BOLD, 16));
        pinLabel.setBounds(430, 320, 150, 35);
        l3.add(pinLabel);

        pinField = new JPasswordField();
        pinField.setBackground(new Color(65, 125, 128));
        pinField.setForeground(Color.WHITE);
        pinField.setBounds(600, 320, 200, 30);
        pinField.setFont(new Font("Raleway", Font.BOLD, 16));
        l3.add(pinField);

        confirmLabel = new JLabel("Type 'CONFIRM' to delete account:");
        confirmLabel.setForeground(Color.WHITE);
        confirmLabel.setFont(new Font("System", Font.BOLD, 14));
        confirmLabel.setBounds(430, 370, 250, 35);
        l3.add(confirmLabel);

        JTextField confirmField = new JTextField();
        confirmField.setBackground(new Color(65, 125, 128));
        confirmField.setForeground(Color.WHITE);
        confirmField.setBounds(680, 370, 150, 30);
        confirmField.setFont(new Font("Raleway", Font.BOLD, 14));
        l3.add(confirmField);

        b1 = new JButton("DELETE ACCOUNT");
        b1.setBounds(420, 410, 180, 35);
        b1.setBackground(Color.RED);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(e -> {
            String enteredCard = cardField.getText();
            String enteredPin = new String(pinField.getPassword());
            String confirmText = confirmField.getText();

            if (enteredCard.equals("") || enteredPin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter Card Number and PIN");
                return;
            }

            if (!confirmText.equals("CONFIRM")) {
                JOptionPane.showMessageDialog(null, "Please type 'CONFIRM' to delete account");
                return;
            }

            try {
                Conn c = new Conn();
                
                // Verify credentials
                String verifyQuery = "SELECT * FROM login WHERE card_number = ? AND pin = ?";
                PreparedStatement psVerify = c.connection.prepareStatement(verifyQuery);
                psVerify.setString(1, enteredCard);
                psVerify.setString(2, enteredPin);
                ResultSet rs = psVerify.executeQuery();
                
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                    return;
                }
                
                // Get form number
                String formno = rs.getString("formno");
                
                int confirm = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to DELETE your account?\nThis action cannot be undone!",
                    "Confirm Account Deletion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    // Delete in correct order (due to foreign key constraints)
                    
                    // 1. Delete from bank table (transactions)
                    String deleteBank = "DELETE FROM bank WHERE pin = ?";
                    PreparedStatement psBank = c.connection.prepareStatement(deleteBank);
                    psBank.setString(1, enteredPin);
                    psBank.executeUpdate();
                    
                    // 2. Delete from login table
                    String deleteLogin = "DELETE FROM login WHERE card_number = ?";
                    PreparedStatement psLogin = c.connection.prepareStatement(deleteLogin);
                    psLogin.setString(1, enteredCard);
                    psLogin.executeUpdate();
                    
                    // 3. Delete from signupthree table
                    String deleteSignup3 = "DELETE FROM signupthree WHERE pin = ?";
                    PreparedStatement psSignup3 = c.connection.prepareStatement(deleteSignup3);
                    psSignup3.setString(1, enteredPin);
                    psSignup3.executeUpdate();
                    
                    // 4. Delete from signuptwo table
                    String deleteSignup2 = "DELETE FROM signuptwo WHERE formno = ?";
                    PreparedStatement psSignup2 = c.connection.prepareStatement(deleteSignup2);
                    psSignup2.setString(1, formno);
                    psSignup2.executeUpdate();
                    
                    // 5. Delete from signup table
                    String deleteSignup = "DELETE FROM signup WHERE formno = ?";
                    PreparedStatement psSignup = c.connection.prepareStatement(deleteSignup);
                    psSignup.setString(1, formno);
                    psSignup.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Account Deleted Successfully!\nThank you for banking with us.");
                    setVisible(false);
                    new Login();
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error deleting account: " + ex.getMessage());
            }
        });
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(650, 410, 180, 35);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(e -> {
            setVisible(false);
            new main_Class(pin);
        });
        l3.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handled by lambda expressions above
    }

    public static void main(String[] args) {
        new CloseAccount("");
    }
}