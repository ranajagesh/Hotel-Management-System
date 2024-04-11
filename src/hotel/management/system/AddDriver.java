package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDriver extends JFrame implements ActionListener {
    
    JTextField tfname,tfage,tfcompany,tfbrand,tflocation ;
    JComboBox gendercombo,typecombo,availablecombo;
    JButton cancel,add;
    
    AddDriver() {
        setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setBounds(150,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,70,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,110,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200,110,150,30);
        add(tfage);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,150,120,30);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        String genderOption [] = {"male","Female"};
        gendercombo = new JComboBox(genderOption);
        gendercombo.setBounds(200,150,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);
        
        JLabel lbcompany = new JLabel("Car Company");
        lbcompany.setBounds(60,190,120,30);
        lbcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200,190,150,30);
        add(tfcompany);
        
        JLabel lblbrand = new JLabel("Car Brand");
        lblbrand.setBounds(60,230,120,30);
        lblbrand.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblbrand);
        
        tfbrand = new JTextField();
        tfbrand.setBounds(200,230,150,30);
        add(tfbrand);
        
        JLabel lblavailable = new JLabel("Available");
        lblavailable.setBounds(60,270,120,30);
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblavailable);
        
        String driverOption [] = {"Available","Busy"};
        availablecombo = new JComboBox(driverOption);
        availablecombo.setBounds(200,270,150,30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setBounds(60,310,120,30);
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200,310,150,30);
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(60,370,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(220,370,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(300,200,980,470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==add) {
            
            String name = tfname.getText();       
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand = tfbrand.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            try {
                
                Conn conn = new Conn();
                
                String query = "insert into driver values('"+name+"', '"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Room added successfully!");
                
                setVisible(false);

            } catch(Exception e) {
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
        }
               
        
    }
    
    public static void main(String args[]) {
        new AddDriver();
    }
    
    
}

