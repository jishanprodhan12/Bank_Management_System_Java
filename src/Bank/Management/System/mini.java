package Bank.Management.System;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.ResultSet;

public class mini extends JFrame {

    String pin;

    mini(String pin) {
        this.pin = pin;

        setTitle("Mini Statement");
        setSize(550, 650);
        setLocation(300, 50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // this is bank icon 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30, 10, 75, 75);
        add(image);
        
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

        // FIX: Disable auto resize
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // FIX: Column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);

        // FIX: Center alignment
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);

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

        // EXIT BUTTON
        JButton exit = new JButton("Exit");
        exit.setBounds(400, 530, 100, 30);
        add(exit);

        exit.addActionListener(e -> setVisible(false));

        // ---------------- DATABASE ----------------
        try {
            Conn c = new Conn();

            // CARD INFO
            ResultSet rs1 = c.statement.executeQuery(
                    "SELECT * FROM login WHERE pin='" + pin + "'");

            if (rs1.next()) {
                String cardNo = rs1.getString("card_number");
                cardLabel.setText("Card: "
                        + cardNo.substring(0, 4) + "XXXXXXXX"
                        + cardNo.substring(12));
            }

            // TRANSACTIONS
            ResultSet rs2 = c.statement.executeQuery(
                    "SELECT * FROM bank WHERE pin='" + pin + "'");

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
                model.addRow(new Object[]{date, shortTime, type, amount});

                // BALANCE CALCULATION
                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else {
                    balance -= Integer.parseInt(amount);
                }
            }

            balanceLabel.setText("Total Balance: Rs " + balance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
