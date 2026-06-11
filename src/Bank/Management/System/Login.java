package Bank.Management.System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame  implements ActionListener{

    JLabel label1, label2, label3;
    JTextField cardText;
    JPasswordField pinText;
    JButton buttonSingUp ,buttonClear,buttonSignIn;
    Login() {
        // we use Supper keyword for Title 
        super("Bank Management System");

        // this is bank icon 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);

        // this is card icon
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image2 = new JLabel(ii3);
        image2.setBounds(600, 350, 100, 100);
        add(image2);

        // Greating label
        label1 = new JLabel("Welcome to ATM ");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AventGarde", Font.BOLD, 38));
        label1.setBounds(250, 125, 450, 40);
        add(label1);

        // Card number label
        label2 = new JLabel("Card no : ");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Arial", Font.BOLD, 20));
        label2.setBounds(100, 180, 200, 30);
        add(label2);

        // card  input text fild 
        cardText = new JTextField();
        cardText.setFont(new Font("Arial", Font.BOLD, 16));
        cardText.setBounds(250, 180, 400, 40);
        add(cardText);

        // pin number 
        label3 = new JLabel("Pin :");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        label3.setBounds(100, 240, 150, 30);
        add(label3);

        // pin fild setup
        pinText = new JPasswordField();
        label3.setFont(new Font("Arial", Font.BOLD, 20));
        pinText.setBounds(250, 240, 400, 40);
        add(pinText);
        // Sign up.
        buttonSingUp = new JButton("Sign Up ");
        buttonSingUp.setBackground(Color.BLACK);
        buttonSingUp.setForeground(Color.white);
        buttonSingUp.setFont(new Font("Arial",Font.BOLD,20));
        buttonSingUp.setBounds(250, 300,150,50);
        buttonSingUp.addActionListener(this);
        add(buttonSingUp);
        
        // Clear button 
        buttonClear = new JButton("Clear ");
        buttonClear.setBackground(Color.BLACK);
        buttonClear.setForeground(Color.white);
        buttonClear.setFont(new Font("Arial",Font.BOLD,20));
        buttonClear.setBounds(450,300,150,50);
        buttonClear.addActionListener(this);
        add(buttonClear);
        
         // sign in button 
        buttonSignIn = new JButton("Sign In ");
        buttonSignIn.setBackground(Color.BLACK);
        buttonSignIn.setForeground(Color.white);
        buttonSignIn.setFont(new Font("Arial",Font.BOLD,20));
        buttonSignIn.setBounds(350,370,150,50);
        buttonSignIn.addActionListener(this);
        add(buttonSignIn);
         
        // this is background
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 488, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel image3 = new JLabel(iii3);
        image3.setBounds(0, 0, 850, 488);
        add(image3);

        setLayout(null);
        setSize(850, 488);
        setLocation(200, 150);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    // override actionPerformed Method 
    @Override 
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==buttonSignIn){
                JOptionPane.showMessageDialog(null , "Sign in button clicked");
               String card = cardText.getText();
               

            }
            else if (e.getSource()==buttonClear){
                cardText.setText("");
                pinText.setText("");
                
            }
            else if (e.getSource()==buttonSingUp){
                new Signup();
                setVisible(false);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }

   
    
}
