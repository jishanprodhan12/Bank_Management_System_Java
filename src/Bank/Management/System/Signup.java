package Bank.Management.System;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import Bank.Management.System.Singup2;

public class Signup extends JFrame implements ActionListener {

    JLabel label1;
    JRadioButton r1, r2, m1, m2, m3;
    JButton next;
    JDateChooser dateChooser;
    JTextField textName, textFname, textEmail, textAdd, textcity, textState, textPin;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 4000l) + 1000l;
    String first = " " + Math.abs(first4);

    JTextField cardText;

    Signup() {
        super("Application From");

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image icon2 = icon.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(30, 20, 80, 80);
        add(image);

        JLabel label1 = new JLabel("Application From no. " + first);
        label1.setFont(new Font("Raleway", Font.BOLD, 26));
        label1.setBounds(280, 20, 400, 30);
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway", Font.BOLD, 22));
        label2.setBounds(330, 50, 600, 30);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        label3.setBounds(290, 80, 600, 30);
        add(label3);
        //  your name 
        JLabel labelName = new JLabel("Name :");
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelName.setBounds(100, 140, 100, 30);
        add(labelName);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 140, 400, 30);
        add(textName);

        // fathers name 
        JLabel labelfName = new JLabel("Father's Name :");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelfName.setBounds(100, 190, 200, 30);
        add(labelfName);

        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.BOLD, 14));
        textFname.setBounds(300, 190, 400, 30);
        add(textFname);

        // Date of Brith 
        JLabel DOB = new JLabel("Date of Birth");
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        DOB.setBounds(100, 240, 200, 30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);
        // Gander
        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 290, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(222, 255, 228));
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBounds(450, 290, 90, 30);
        add(r2);

        ButtonGroup btngp = new ButtonGroup();
        btngp.add(r1);
        btngp.add(r2);

        //  Email fild & label
        JLabel labelEmail = new JLabel("Email address :");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100, 340, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textEmail.setBounds(300, 340, 400, 30);
        add(textEmail);

        //  Marital status 
        JLabel labelMs = new JLabel("Marital Status :");
        labelMs.setFont(new Font("Raleway", Font.BOLD, 20));
        labelMs.setBounds(100, 390, 200, 30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setBounds(300, 390, 100, 30);
        m1.setBackground(new Color(222, 255, 228));
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBackground(new Color(222, 255, 228));
        m2.setBounds(450, 390, 100, 30);
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m2);

        m3 = new JRadioButton("Other");
        m3.setBackground(new Color(222, 255, 228));
        m3.setBounds(635, 390, 100, 30);
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        add(m3);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        buttonGroup1.add(m3);

        //  address 
        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100, 440, 200, 30);
        add(labelAdd);

        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdd.setBounds(300, 440, 400, 30);
        add(textAdd);

        // City 
        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100, 490, 200, 30);
        add(labelCity);

        textcity = new JTextField();
        textcity.setFont(new Font("Raleway", Font.BOLD, 14));
        textcity.setBounds(300, 490, 400, 30);
        add(textcity);

        //  post code  variable name pin
        JLabel labelPin = new JLabel("Post Code :");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100, 540, 200, 30);
        add(labelPin);

        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        textPin.setBounds(300, 540, 400, 30);
        add(textPin);

        // state 
        JLabel labelstate = new JLabel("State :");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(100, 590, 200, 30);
        add(labelstate);

        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(300, 590, 400, 30);
        add(textState);

        // next button
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(730, 600, 80, 30);
        next.addActionListener(this);
        add(next);

        // Frame 
        getContentPane().setBackground(new Color(222, 250, 217));
        setLayout(null);
        setSize(850, 680);
        setLocation(250, 10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

     @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        }else if (r2.isSelected()){
            gender = "Female";
        }
        String email = textEmail.getText();
        String marital =null;
        if (m1.isSelected()){
            marital = "Married";
        } else if (m2.isSelected()) {
            marital = "Unmarried";
        } else if (m3.isSelected()) {
            marital = "Other";
        }

        String address = textAdd.getText();
        String city = textcity.getText();
        String pincode = textPin.getText();
        String state = textState.getText();

        try{
            if (textName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            }else {
                Conn c = new Conn();
                String q = "insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"', '"+address+"', '"+city+"','"+pincode+"','"+state+"' )";
                c.statement.executeUpdate(q); 
                new Singup2(formno);
                setVisible(false);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] argus) {
        new Signup();
    }

}
