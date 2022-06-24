package com.e_voting_project;

import java.awt.*;



import java.awt.event.*;
import javax.swing.*;

import differentiateByRegion.RegionFactory;


public class Voter extends User {
	JFrame frame;
    JPanel left_panel;
    JLabel image_label;
    JLabel text_label;
    
    JPanel right_panel;
    JLabel right_label1;
    JLabel right_label2;
    JLabel right_label3;
    
    ImageIcon voting_image;
    ImageIcon image_right1;
    ImageIcon image_right2;
    
    JTextField username;
    JPasswordField password;

    JButton loginButton;
    JButton backButton;
    
    JLabel registerationLink;
    
    JComboBox<String> region;
    
	String user;
	String pass;
	String comboBoxVal;
	

	@Override
	public void loginValidation() {
		
		loginButton.addActionListener(new ActionListener(){
	          
			@Override
            public void actionPerformed(ActionEvent e) {
                            user = username.getText();
			    pass = String.valueOf(password.getPassword());
			    comboBoxVal =  (String) region.getSelectedItem();
			    System.out.println(comboBoxVal);
			    new RegionFactory().getInstance(user, pass, comboBoxVal, "Voter");
                frame.dispose();
               
            }
        });		
	}
	@Override
	public void initializeFrame() {
		frame = new JFrame("ELECTRONIC VOTING SYSTEM");
		String [] regionOfVoters = {"North Karachi", "Gulshan-e-Iqbal", "Maleer", "Saddar","SITE Area"};

        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        // ---------------------------- RIGHT PANEL OF THE SCREEN -------------
        image_right1 = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\user_field.png");
        image_right2 = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\password_field.png");
        right_label1 = new JLabel(image_right1, JLabel.CENTER);
        right_label2 = new JLabel(image_right2, JLabel.CENTER);
        right_label3 = new JLabel("Select Region");

        right_label1.setBounds(
                700, 195, 100, 50);
        right_label2.setBounds(
                700, 245, 100, 50);
        right_label3.setBounds(700, 310, 150, 20);
        right_label3.setForeground(Color.WHITE);
        
        username = new JTextField();
        password = new JPasswordField();
        
        region = new JComboBox<String>(regionOfVoters);
        region.setBackground(Color.WHITE);
//        region.setBorder(new EmptyBorder(15,3,5,3));
        
        
        username.setBounds(800, 210, 150, 20);
        password.setBounds(800, 260, 150, 20);
        region.setBounds(800, 310, 150, 20);
        
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Raleway SemiBold", 0, 12));
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                 new Main_Page();
                
            }
        });
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Raleway SemiBold", 0, 12));
        

        backButton.setBounds(750, 400, 100, 40);
        backButton.setBackground(Color.WHITE);
        loginButton.setBounds(900, 400, 100, 40);
        loginButton.setBackground(Color.WHITE);
        
        
        registerationLink = new JLabel("<html><u>Register Now!</u>");
        registerationLink.setForeground(Color.BLUE);
        registerationLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerationLink.setFont(new Font("Raleway SemiBold", 0, 18));
        registerationLink.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                new Voter_Registeration().userRegisteration();
                
            }
        });
        
        registerationLink.setBounds(815, 500, 150, 40);
        registerationLink.setForeground(Color.WHITE);
        
        
        right_panel = new JPanel();

        right_panel.setBackground(new Color(186, 79, 84));
        right_panel.setBounds(600, 0, 600, 700);



        //------------------------------- LEFT PANEL OF THE SCREEN ------------
        left_panel = new JPanel();
        
        text_label= new JLabel();
        text_label.setText("VOTER LOGIN");
        text_label.setFont(new Font("Raleway SemiBold", 0, 30));
        text_label.setForeground(Color.WHITE);
        text_label.setBounds(200, 300, 300, 100);
        
        voting_image = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\admin_image.png");
        image_label = new JLabel("",voting_image,JLabel.CENTER);

        image_label.setBounds(220, 200, 150, 150);

        left_panel.setBackground(new Color(49, 49, 49));
        left_panel.setBounds(0, 0, 600, 700);
        

        // ------------------------ ADDING PANELS TO FRAME --------------------
        
        frame.add(text_label);
        frame.add(image_label);
        
        frame.add(username);
        frame.add(password);
        frame.add(region);
        
        frame.add(right_label1);
        frame.add(right_label2);
        frame.add(right_label3);
        
        frame.add(loginButton);
        frame.add(backButton);
        frame.add(registerationLink);
        
        
        frame.add(left_panel);
        frame.add(right_panel);
		
        
	}

}
