package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
   JButton loginin, signup, reset; 
    Login(){
        super("Login Menu");
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(300, 20, 100, 20);
        add(lblusername);

        JTextField userName = new JTextField();
        userName.setBounds(400, 20, 100, 20);
        add(userName);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(300, 60, 100, 20);
        add(lblpassword);

        JTextField password = new JTextField();
        password.setBounds(400, 60, 100, 20);
        add(password);

        JLabel lbllogin = new JLabel("Login as:");
        lbllogin.setBounds(300, 100, 100, 20);
        add(lbllogin);

        Choice logintype = new Choice();
        logintype.add("Admin");
        logintype.add("Customer");
        logintype.setBounds(400, 100, 100, 20);
        add(logintype);

         loginin = new JButton("Login");
        loginin.setBounds(320, 150,100, 20); 
        loginin.addActionListener(this);
        add(loginin);

         reset = new JButton("Reset");
        reset.setBounds(450, 150,100, 20); 
        reset.addActionListener(this);
        add(reset);

         signup = new JButton("Sign up");
        signup.setBounds(380, 190,100, 20); 
        signup.addActionListener(this);
        add(signup);

        setSize (640,350);
        setLocation(200,400);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(20, 20, 250, 250);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == loginin) {
            
        } else if (ae.getSource() == reset) {
            setVisible(false);
        } else if (ae.getSource() == signup) {
            setVisible(false);
            
            new signup();
        }
    } 
}
