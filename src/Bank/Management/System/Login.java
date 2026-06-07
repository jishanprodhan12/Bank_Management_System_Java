package Bank.Management.System;
import java.awt.*;
import javax.swing.*;
public class Login extends JFrame{
    JLabel label1 ;
    Login(){
        // we use Supper keyword for Title 
        super("Bank Management System");
        
        // this is bank icon 
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);
        
        // this is card icon
        ImageIcon ii1 =new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image2 = new JLabel(ii3);
        image2.setBounds(600,350,100,100);
        add(image2);
        
        // Greating label
        label1 = new JLabel("Welcome to ATM ");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AventGarde", Font.BOLD, 38));
        label1.setBounds(250,125,450 ,40);
        add(label1);
        
        
         // this is background
        ImageIcon iii1 =new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 488, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel image3 = new JLabel(iii3);
        image3.setBounds(0,0,850,488);
        add(image3);
        
        setLayout(null);
        setSize(850,488);
        setLocation(200,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        Login l =new Login();
    }
}
