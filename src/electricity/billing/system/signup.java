package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener {
    JButton create, backButton;
    Choice accountype;
    JTextField meter, userName, name, password;
    signup(){
        setSize(640, 350);
        setLocation(200, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel= new JPanel();
        panel.setBounds(5, 5, 600, 300);
        panel.setBorder(new TitledBorder(new LineBorder( new Color(175,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(175,216,230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(134,39,50));
        add(panel);


        JLabel heading = new JLabel("Create Account:");
        heading.setBounds(20,30,120,20);
        heading.setForeground(Color.DARK_GRAY);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);

        accountype = new Choice();
        accountype.add("Admin");
        accountype.add("Customer");
        accountype.setBounds(150,30,150,20); 
        panel.add(accountype);

        JLabel lblmeter = new JLabel("Meter Number:");
        lblmeter.setBounds(20,60,120,20);
        lblmeter.setForeground(Color.DARK_GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(150,60,150,20);
        panel.add(meter);

        JLabel lblusername = new JLabel("User Name:");
        lblusername.setBounds(20,90,120,20);
        lblusername.setForeground(Color.DARK_GRAY);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblusername);

        userName = new JTextField();
        userName.setBounds(150,90,150,20);
        panel.add(userName);
        setVisible(true);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(20,120,120,20);
        lblname.setForeground(Color.DARK_GRAY);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(150,120,150,20);
        panel.add(name);
        
        meter.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                    while(rs.next()) {
                        name.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20,150,120,20);
        lblPassword.setForeground(Color.DARK_GRAY);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblPassword);

        password = new JTextField();
        password.setBounds(150,150,150,20);
        panel.add(password);

          accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accountType.getSelectedItem();
                if (user.equals("Customer")) {
                    lblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                } else {
                    lblmeter.setVisible(false);
                    meter.setVisible(false);
                    name.setEditable(true);
                }
            }
        });
        
        create = new JButton("Create");
        create.setBounds(40, 190, 100,20);
        create.setBackground(Color.BLACK);
        create.setForeground(Color.CYAN);
        create.addActionListener(this);
        panel.add(create);

         backButton = new JButton("Back");
        backButton.setBounds(180, 190, 100,20);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.CYAN);
        backButton.addActionListener(this);
        panel.add(backButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 30, 250, 250);
        panel.add(image);
        

        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype= accountype.getSelectedItem();
            String suserName= userName.getText();
            String sname= name.getText();
            String spassword= password.getText();
            String smeter= meter.getText();

            try {
                conn db = new conn();
                String query = "insert into login values('"+smeter+"', '"+suserName+"', '"+sname+"', '"+spassword+"', '"+atype+"'))"; 
                db.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"done");

                setVisible(false);
                new Login();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == backButton) {
            setVisible(false);
            
            new Login();
        }
    }
            public static void main(String[] args) {
            new Signup();
    }
}
