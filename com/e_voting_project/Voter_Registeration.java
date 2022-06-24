package com.e_voting_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Voter_Registeration extends Registeration_Form{
	
	JFrame frame;
	
    JPanel left_panel;
    
    JLabel image_label;
    JLabel text_label;
    
    JPanel right_panel;
    
    JLabel first_name_label;
    JLabel last_name_label;
    JLabel cnic_label;
    JLabel password_label;
    JLabel confirm_password_label;
    
    ImageIcon voting_image;
    
    JTextField first_name;
    JTextField last_name;
    JTextField cnic;
    JPasswordField password;
    JPasswordField confirm_password;
    

    JButton registerButton;
    JButton backButton;
    
    ConnectionToDatabase voter_data;
    
   
    

	@Override
	public void displayRegistrationForm() {
		    
		frame = new JFrame("ELECTRONIC VOTING SYSTEM");
        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
            // ---------------------------- RIGHT PANEL OF THE SCREEN -------------
            
        first_name_label = new JLabel("First Name");
        first_name_label.setForeground(Color.WHITE);
        
        last_name_label = new JLabel("Last Name");
        last_name_label.setForeground(Color.WHITE);
        
        
        cnic_label = new JLabel("Cnic");
        cnic_label.setForeground(Color.WHITE);
        
        
        password_label = new JLabel("Password");
        password_label.setForeground(Color.WHITE);
        
        confirm_password_label = new JLabel("Confirm Password");
        confirm_password_label.setForeground(Color.WHITE);
        
        first_name_label.setBounds(650, 200, 100, 30);
        last_name_label.setBounds(650, 250, 100, 30);
        
        cnic_label.setBounds(650, 300, 100, 30);

        password_label.setBounds(650, 350, 100, 30);
        confirm_password_label.setBounds(650, 400, 120, 30);
            
            first_name = new JTextField();
            last_name = new JTextField();
            
            cnic = new JTextField();
           
            password = new JPasswordField();
            confirm_password = new JPasswordField();
            
            first_name.setBounds(800, 200, 200, 30);
            last_name.setBounds(800, 250, 200, 30);
           
            cnic.setBounds(800, 300, 200, 30);
            
            password.setBounds(800, 350, 200, 30);
            confirm_password.setBounds(800, 400, 200, 30);
            
            
            backButton = new JButton("Back");
            backButton.setFont(new Font("Raleway SemiBold", 0, 12));
            backButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new Main_Page();
                    
                }
            });
            registerButton = new JButton("Register");
            registerButton.setFont(new Font("Raleway SemiBold", 0, 12));
            registerButton.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                	checkRegistration();
                    
                }
            });
            

            backButton.setBounds(750, 500, 100, 40);
            backButton.setBackground(Color.WHITE);
            registerButton.setBounds(900, 500, 100, 40);
            registerButton.setBackground(Color.WHITE);
            
            


            right_panel = new JPanel();

            right_panel.setBackground(new Color(186, 79, 84));
            right_panel.setBounds(600, 0, 600, 700);



            //------------------------------- LEFT PANEL OF THE SCREEN ------------
            left_panel = new JPanel();
            
            text_label= new JLabel();
            text_label.setText("VOTER REGISTRATION");
            text_label.setFont(new Font("Raleway SemiBold", 0, 30));
            text_label.setForeground(Color.WHITE);
            text_label.setBounds(130, 300, 350, 100);
            
            voting_image = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\admin_image.png");
            image_label = new JLabel("",voting_image,JLabel.CENTER);

            image_label.setBounds(220, 200, 150, 150);

            
            
            left_panel.setBackground(new Color(49, 49, 49));
            left_panel.setBounds(0, 0, 600, 700);
            
            
            

            // ------------------------ ADDING PANELS TO FRAME --------------------
            
            frame.add(text_label);
            frame.add(image_label);
            
            frame.add(first_name);
            frame.add(last_name);
           
            frame.add(cnic);
            
            frame.add(password);
            frame.add(confirm_password);
            
            frame.add(first_name_label);
            frame.add(last_name_label);
            
            frame.add(cnic_label);
            
            frame.add(password_label);
            frame.add(confirm_password_label);
            
            frame.add(registerButton);
     
            frame.add(backButton);
            
            frame.add(left_panel);
            frame.add(right_panel);     
    }
	
	public ConnectionToDatabase addUserToDatabase(String f_name_data, String l_name_data, String cnic_data, String password_data) {
	    
    	String query = "INSERT INTO voter_registration (voter_first_name,voter_last_name,cnic,password)" + "VALUES (?,?,?,?)";
    	PreparedStatement statement;

    	
    	try {

    		statement = ConnectionToDatabase.registerUser().prepareStatement(query);
    		statement.setString(1, f_name_data);
    		statement.setString(2, l_name_data);
    		statement.setString(3, cnic_data);
    		statement.setString(4, password_data);
    		int addRows = statement.executeUpdate();
    		if(addRows > 0) {
    			JOptionPane.showMessageDialog(backButton, "Successfully registered","Successful",JOptionPane.PLAIN_MESSAGE);
    		}
    		statement.close();
    		ConnectionToDatabase.registerUser().close();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return new ConnectionToDatabase();
    	
    }
    
	@Override
    public void checkRegistration() {
		String f_name_data = first_name.getText();
        String l_name_data = last_name.getText();
        String cnic_data = cnic.getText();
		String password_data = String.valueOf(password.getPassword());
		String confirm_password_data = String.valueOf(password.getPassword());
    	
        if(first_name.getText().isEmpty() || last_name.getText().isEmpty() || cnic.getText().isEmpty() ||password_data.isEmpty() || confirm_password_data.isEmpty()) {
        	JOptionPane.showMessageDialog(backButton, "Please Enter all the Fields", "Try Again", JOptionPane.ERROR_MESSAGE);
        }
        else if(!String.valueOf(password.getPassword()).equals(String.valueOf(password.getPassword()))) {
        	JOptionPane.showMessageDialog(backButton, "Confirm Password is not same as Password", "Try Again", JOptionPane.ERROR_MESSAGE);
        }
        else {
        	voter_data = addUserToDatabase(f_name_data, l_name_data, cnic_data, password_data);
            if(voter_data != null) {
            	frame.dispose();
            }
            else {
            JOptionPane.showMessageDialog(backButton, "Failed To Register New Voter", "Try Again", JOptionPane.ERROR_MESSAGE);}
        }
        
        
    }


}
