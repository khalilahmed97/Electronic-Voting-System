package com.e_voting_project;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Candidate_Registeration extends Registeration_Form{
JFrame frame;
	
    JPanel left_panel;
    
    JLabel image_label;
    JLabel text_label;
    
    JPanel right_panel;
    
    JLabel first_name_label;
    JLabel last_name_label;
    JLabel father_name_label;
    JLabel cnic_label;
    JLabel date_of_birth_label;
    JLabel symbol_label;
    JLabel religion_label;
    JLabel phone_number_label;
    JLabel password_label;
    JLabel confirm_password_label;
    
    ImageIcon voting_image;
    
    JTextField first_name;
    JTextField last_name;
    JTextField father_name;
    JTextField cnic;
    JTextField date_of_birth;
    JTextField religion;
    JTextField symbol;
    JTextField phone_number;
    JTextField email_id;
    JPasswordField password;
    JPasswordField confirm_password;
    

    JButton registerButton;
    JButton backButton;
    
    ConnectionToDatabase voter_data;
    
    JLabel parties;
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
        
        
        parties = new JLabel("Bat = 1, Kite = 2, Lion = 3, Crane = 4, Dolphin = 5");
        parties.setForeground(Color.WHITE);
        parties.setFont(new Font("Raleway SemiBold", 0, 20));
        last_name_label = new JLabel("Last Name");
        last_name_label.setForeground(Color.WHITE);
        
        father_name_label = new JLabel("Father Name");
        father_name_label.setForeground(Color.WHITE);
        
        cnic_label = new JLabel("Cnic");
        cnic_label.setForeground(Color.WHITE);
        
        date_of_birth_label = new JLabel("Date Of Birth");
        date_of_birth_label.setForeground(Color.WHITE);
        
        religion_label = new JLabel("Religion");
        religion_label.setForeground(Color.WHITE);
        
        symbol_label = new JLabel("Symbol");
        symbol_label.setForeground(Color.WHITE);
        
        phone_number_label = new JLabel("Phone Number");
        phone_number_label.setForeground(Color.WHITE);
        
        password_label = new JLabel("Password");
        password_label.setForeground(Color.WHITE);
        
        confirm_password_label = new JLabel("Confirm Password");
        confirm_password_label.setForeground(Color.WHITE);
        
        first_name_label.setBounds(650, 100, 100, 20);
        last_name_label.setBounds(650, 150, 100, 20);
        father_name_label.setBounds(650, 200, 100, 20);
        cnic_label.setBounds(650, 250, 100, 20);
        date_of_birth_label.setBounds(650,300, 100, 20);
        religion_label.setBounds(650, 400, 100, 20);
        symbol_label.setBounds(650,350, 100, 20);
        phone_number_label.setBounds(650, 450, 100, 20);
        password_label.setBounds(650, 500, 100, 20);
        confirm_password_label.setBounds(650, 550, 120, 20);
        
        parties.setBounds(50, 400, 450, 100);
            
            first_name = new JTextField();
            last_name = new JTextField();
            father_name = new JTextField();
            cnic = new JTextField();
            religion = new JTextField();
            symbol = new JTextField();
            date_of_birth = new JTextField();
            phone_number = new JTextField();
            password = new JPasswordField();
            confirm_password = new JPasswordField();
            
            first_name.setBounds(800, 100, 200, 20);
            last_name.setBounds(800, 150, 200, 20);
            father_name.setBounds(800, 200, 200, 20);
            cnic.setBounds(800, 250, 200, 20);
            date_of_birth.setBounds(800, 300, 200, 20);
            religion.setBounds(800, 400, 200, 20);
            symbol.setBounds(800, 350, 200, 20);
            phone_number.setBounds(800, 450, 200, 20);
            password.setBounds(800, 500, 200, 20);
            confirm_password.setBounds(800, 550, 200, 20);
            
            
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
            

            backButton.setBounds(750, 600, 100, 40);
            backButton.setBackground(Color.WHITE);
            registerButton.setBounds(900, 600, 100, 40);
            registerButton.setBackground(Color.WHITE);
            
            


            right_panel = new JPanel();

            right_panel.setBackground(new Color(186, 79, 84));
            right_panel.setBounds(600, 0, 600, 700);



            //------------------------------- LEFT PANEL OF THE SCREEN ------------
            left_panel = new JPanel();
            
            text_label= new JLabel();
            text_label.setText("CANDIDATE REGISTRATION");
            text_label.setFont(new Font("Raleway SemiBold", 0, 30));
            text_label.setForeground(Color.WHITE);
            text_label.setBounds(70, 300, 450, 100);
            
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
            frame.add(father_name);
            frame.add(cnic);
            frame.add(symbol);
            frame.add(religion);
            frame.add(date_of_birth);
            frame.add(phone_number);
            frame.add(password);
            frame.add(confirm_password);
            
            frame.add(first_name_label);
            frame.add(last_name_label);
            frame.add(father_name_label);
            frame.add(cnic_label);
            frame.add(religion_label);
            frame.add(symbol_label);
            frame.add(date_of_birth_label);
            frame.add(phone_number_label);
            frame.add(password_label);
            frame.add(confirm_password_label);
            
            frame.add(registerButton);
     
            frame.add(backButton);
            frame.add(parties);
            
            frame.add(left_panel);
            frame.add(right_panel);     
    }
	public ConnectionToDatabase addUserToDatabase(String f_name_data, String l_name_data, String father_name_data, String cnic_data, String date_of_birth_data, String religion_data, String symbol_data, String phone_number_data, String password_data) {
        
    	String query = "INSERT INTO candidate_registeration (candidate_first_name, candidate_last_name, candidate_father_name, cnic, date_of_birth, religion, symbol, phone_number, password)" +"VALUES (?,?,?,?,?,?,?,?,?)";
    	PreparedStatement statement;
    	
    	
    	try {

    		statement = ConnectionToDatabase.registerUser().prepareStatement(query);
    		statement.setString(1, f_name_data);
    		statement.setString(2, l_name_data);
    		statement.setString(3, father_name_data);
    		statement.setString(4, cnic_data);
    		statement.setString(5, date_of_birth_data);
    		statement.setString(6, religion_data);
    		statement.setString(7, symbol_data);
    		statement.setString(8, phone_number_data);
    		statement.setString(9, password_data);
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
    public void checkRegistration() {
    	String f_name_data = first_name.getText();
        String l_name_data = last_name.getText();
        String father_name_data = father_name.getText();
        String cnic_data = cnic.getText();
        String religion_data = religion.getText();
        String symbol_data = symbol.getText();
        String date_of_birth_data = date_of_birth.getText();
        String phone_number_data = phone_number.getText();
        String password_data = String.valueOf(password.getPassword());
        String confirm_password_data = String.valueOf(confirm_password.getPassword());
        
        if(f_name_data.isEmpty() || l_name_data.isEmpty() || father_name_data.isEmpty() || cnic_data.isEmpty() || religion_data.isEmpty() || symbol_data.isEmpty()
        		|| date_of_birth_data.isEmpty() || phone_number_data.isEmpty() || password_data.isEmpty() || confirm_password_data.isEmpty()) {
        	JOptionPane.showMessageDialog(backButton, "Please Enter all the Fields", "Try Again", JOptionPane.ERROR_MESSAGE);
        }
        else if(!password_data.equals(confirm_password_data)) {
        	JOptionPane.showMessageDialog(backButton, "Confirm Password is not same as Password", "Try Again", JOptionPane.ERROR_MESSAGE);
        }
        else {
        	voter_data = addUserToDatabase(f_name_data,l_name_data,father_name_data,cnic_data,date_of_birth_data,religion_data, symbol_data,phone_number_data, password_data);
           
            if(voter_data == null) {
            	JOptionPane.showMessageDialog(backButton, "Failed To Register New Candidate", "Try Again", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }
}
