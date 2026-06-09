
package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random ;
public class Signup  extends JFrame implements  ActionListener{
    JLabel label1 ;
    Random ran = new Random();
    long first4 = (ran.nextLong()%4000l)+1000l ;
    String first = " " +Math.abs(first4);
            
    Signup(){
        super("Application From");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image icon2 = icon.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(30,20,80,80);
        add(image);
        
        JLabel label1 = new JLabel("Application From no. "+first);
        label1.setFont(new Font("Raleway",Font.BOLD,26));
        label1.setBounds(280,30,400,30);
        add(label1);
        
        getContentPane().setBackground(new Color(222,250,217));
        setLayout(null);
        setSize(850,680);
        setLocation(250,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
           
       }catch(Exception E){
           E.printStackTrace();
       }
    }
    public static void main(String[] argus){
        new Signup();
    }
   
}
