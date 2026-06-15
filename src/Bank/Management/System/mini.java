package Bank.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mini extends JFrame {

    String pin;

    mini(String pin) {
        this.pin = pin;

        setTitle("Mini Statement");
        setSize(530, 650);
        setLocation(300, 15);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        // this is card icon
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image2 = new JLabel(ii3);
        image2.setBounds(400, 15, 75, 75);
        add(image2);

        // BANK NAME
        JLabel bank = new JLabel("JF BANK PLC");
        bank.setFont(new Font("Arial", Font.BOLD, 22));
        bank.setBounds(200, 10, 250, 30);
        add(bank);

        // CARD INFO
        JLabel cardLabel = new JLabel();
        cardLabel.setBounds(20, 50, 500, 20);
        add(cardLabel);

        // TABLE
        String[] columns = {"Date", "Time", "Type", "Amount"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);

        // Fix: Disable auto resize
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Fix: Column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        // Fix: Center alignment
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        center.setVerticalAlignment(JLabel.CENTER);

        for (int i = 0; i < 4; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 90, 490, 380);
        add(scroll);

        // BALANCE LABEL
        JLabel balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setBounds(20, 480, 400, 30);
        add(balanceLabel);

        // DELETE TRANSACTION BUTTON
        JButton deleteTransBtn = new JButton("Delete Transaction");
        deleteTransBtn.setBackground(new Color(220, 53, 69));
        deleteTransBtn.setForeground(Color.WHITE);
        deleteTransBtn.setFont(new Font("Arial", Font.BOLD, 12));
        deleteTransBtn.setBounds(20, 530, 150, 30);
        deleteTransBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a transaction to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            String date = (String) table.getValueAt(selectedRow, 0);
            String time = (String) table.getValueAt(selectedRow, 1);
            String type = (String) table.getValueAt(selectedRow, 2);
            String amount = (String) table.getValueAt(selectedRow, 3);
            
            int confirm = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to delete this transaction?\n\n" +
                "Date: " + date + "\n" +
                "Time: " + time + "\n" +
                "Type: " + type + "\n" +
                "Amount: " + amount + " TK\n\n" +
                "⚠️ This action cannot be undone!",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Conn c = new Conn();
                    
                    // Improved deletion query with more precise matching
                    String deleteQuery = "DELETE FROM bank WHERE pin = ? AND DATE(date) = ? AND TIME(date) LIKE ? AND type = ? AND amount = ? LIMIT 1";
                    PreparedStatement ps = c.connection.prepareStatement(deleteQuery);
                    ps.setString(1, pin);
                    ps.setString(2, date);
                    ps.setString(3, time.split(" ")[0] + "%");
                    ps.setString(4, type);
                    ps.setString(5, amount);
                    
                    int deleted = ps.executeUpdate();
                    if (deleted > 0) {
                        JOptionPane.showMessageDialog(null, "Transaction deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        new mini(pin);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete transaction.\nPlease try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error deleting transaction: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(deleteTransBtn);

        // DELETE ALL TRANSACTIONS BUTTON (Optional feature)
        JButton deleteAllBtn = new JButton("Delete All");
        deleteAllBtn.setBackground(new Color(108, 117, 125));
        deleteAllBtn.setForeground(Color.WHITE);
        deleteAllBtn.setFont(new Font("Arial", Font.BOLD, 12));
        deleteAllBtn.setBounds(190, 530, 120, 30);
        deleteAllBtn.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, 
                "⚠️ DANGER: This will delete ALL your transaction history!\n\n" +
                "This action cannot be undone.\n" +
                "Your account balance will be reset to 0.\n\n" +
                "Are you absolutely sure?",
                "Delete All Transactions",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                String secondConfirm = JOptionPane.showInputDialog(null, 
                    "Type 'DELETE ALL' to confirm:",
                    "Final Confirmation",
                    JOptionPane.WARNING_MESSAGE);
                
                if (secondConfirm != null && secondConfirm.equals("DELETE ALL")) {
                    try {
                        Conn c = new Conn();
                        String deleteAllQuery = "DELETE FROM bank WHERE pin = ?";
                        PreparedStatement ps = c.connection.prepareStatement(deleteAllQuery);
                        ps.setString(1, pin);
                        
                        int deleted = ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, deleted + " transactions deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        setVisible(false);
                        new mini(pin);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error deleting transactions: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Deletion cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(deleteAllBtn);

        // REFRESH BUTTON
        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBackground(new Color(40, 167, 69));
        refreshBtn.setForeground(Color.WHITE);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 12));
        refreshBtn.setBounds(330, 530, 100, 30);
        refreshBtn.addActionListener(e -> {
            setVisible(false);
            new mini(pin);
        });
        add(refreshBtn);

        // EXIT BUTTON
        JButton exit = new JButton("Exit");
        exit.setBackground(new Color(23, 162, 184));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Arial", Font.BOLD, 12));
        exit.setBounds(20, 580, 480, 30);
        exit.addActionListener(e -> {
            setVisible(false);
            new main_Class(pin);
        });
        add(exit);

        // ---------------- DATABASE LOAD -----------------
        try {
            Conn c = new Conn();

            // CARD INFO
            ResultSet rs1 = c.statement.executeQuery(
                    "SELECT * FROM login WHERE pin='" + pin + "'");

            if (rs1.next()) {
                String cardNo = rs1.getString("card_number");
                String maskedCard = cardNo.substring(0, 4) + " XXXX XXXX " + cardNo.substring(12);
                cardLabel.setText("Card: " + maskedCard);
            }

            // TRANSACTIONS
            ResultSet rs2 = c.statement.executeQuery(
                    "SELECT * FROM bank WHERE pin='" + pin + "' ORDER BY date DESC");

            int balance = 0;

            while (rs2.next()) {

                String rawDate = rs2.getString("date");

                // DATE + TIME SPLIT
                String date = rawDate.substring(0, 10);
                String time = rawDate.substring(11, 16);

                // 24h → 12h conversion
                int hour = Integer.parseInt(time.substring(0, 2));
                String minute = time.substring(3, 5);

                String ampm = "AM";
                if (hour >= 12) {
                    ampm = "PM";
                    if (hour > 12) {
                        hour -= 12;
                    }
                }
                if (hour == 0) {
                    hour = 12;
                }

                String shortTime = hour + ":" + minute + " " + ampm;

                String type = rs2.getString("type");
                String amount = rs2.getString("amount");

                // ADD TO TABLE
                model.addRow(new Object[]{date, shortTime, type, amount + " TK"});

                // BALANCE CALCULATION
                if (type.equals("Deposit") || type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else if (type.equals("Withdrawl") || type.equals("withdrawl")) {
                    balance -= Integer.parseInt(amount);
                }
            }

            balanceLabel.setText("Total Balance: " + balance + " TK");

            // If no transactions, show message
            if (model.getRowCount() == 0) {
                model.addRow(new Object[]{"No", "transactions", "found", ""});
                balanceLabel.setText("Total Balance: 0 TK");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading transactions: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new mini("");
    }
}