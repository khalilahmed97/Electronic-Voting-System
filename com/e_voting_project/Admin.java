
package com.e_voting_project;

import javax.swing.*;



import option_screen.UserDashboardFacade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;


public class Admin extends User{
    

    JFrame frame;
    JPanel left_panel;
    JLabel image_label;
    JLabel text_label;
    
    JPanel right_panel;
    JLabel right_label1;
    JLabel right_label2;
    
    ImageIcon voting_image;
    ImageIcon image_right1;
    ImageIcon image_right2;
    
    JTextField username;
    JPasswordField password;

    JButton loginButton;
    JButton backButton;
	

	public void loginValidation() {
    	loginButton.addActionListener(new ActionListener(){        
			@Override
            public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				String pass = String.valueOf(password.getPassword());
				System.out.println(user+" "+ pass);
                if(user.equals("Khalil") && pass.equals("Ahmed Sharif" ) ) {
                	 JOptionPane.showMessageDialog(backButton, "You are Logged in");
                	 frame.dispose();
                	 UserDashboardFacade admin = new UserDashboardFacade();
                	 admin.showAdminDashboard("Khalil", "Ahmed Sharif");
                }
                else {
                	 JOptionPane.showMessageDialog(backButton, "You are not Logged in");
                 	 
                }
                
                
               
            }
        });
	}
    	
	@Override
	public void initializeFrame() {
		frame = new JFrame("ELECTRONIC VOTING SYSTEM");

        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        // ---------------------------- RIGHT PANEL OF THE SCREEN -------------
        image_right1 = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\user_field.png");
        image_right2 = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\password_field.png");
        right_label1 = new JLabel(image_right1, JLabel.CENTER);
        right_label2 = new JLabel(image_right2, JLabel.CENTER);

        right_label1.setBounds(
                700, 195, 100, 50);
        right_label2.setBounds(
                700, 245, 100, 50);
        
        username = new JTextField();
        password = new JPasswordField();
        
        
        username.setBounds(800, 210, 150, 20);
        password.setBounds(800, 260, 150, 20);

        
        
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
        
        
        
        right_panel = new JPanel();

        right_panel.setBackground(new Color(186, 79, 84));
        right_panel.setBounds(600, 0, 600, 700);



        //------------------------------- LEFT PANEL OF THE SCREEN ------------
        left_panel = new JPanel();
        
        text_label= new JLabel();
        text_label.setText("ADMIN LOGIN");
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
        
        frame.add(right_label1);
        frame.add(right_label2);
        
        frame.add(loginButton);
        frame.add(backButton);
        
        
        frame.add(left_panel);
        frame.add(right_panel);
		
	}
}
