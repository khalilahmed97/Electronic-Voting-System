package VotesCalculationAndNotify;
import com.e_voting_project.ConnectionToDatabase;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.e_voting_project.Main_Page;
import com.e_voting_project.Voter_Registeration;
import java.sql.*;

public class Votes {

    JFrame frame;
    JPanel left_panel;
    JLabel image_label;
    JLabel text_label;
    JLabel right_label1;
   
    
    JPanel right_panel;

    
    ImageIcon voting_image;

    
    JTextField username;
   

    JButton voteButton;
    JButton backButton;
    JButton selectButton;
    JLabel text;
    
    JComboBox<String> region;
    boolean isVoted = false;
  
        
	public void voteScreen() {
            
		frame = new JFrame("ELECTRONIC VOTING SYSTEM");

        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // ---------------------------- RIGHT PANEL OF THE SCREEN -------------
        
        text = new JLabel("Bat = 1, Kite = 2, Lion = 3, Crane = 4, Dolphin = 5");
        text.setBounds(100, 400, 450, 50);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway SemiBold", 0, 15));
        
        right_label1 = new JLabel("Cnic");
        right_label1.setFont(new Font("Raleway SemiBold", 0, 12));
        right_label1.setForeground(Color.WHITE);
        right_label1.setBounds(750, 210, 300, 20);
        username = new JTextField();
        username.setBounds(800, 210, 150, 20);
        
        region = new JComboBox();
        region.setBounds(800, 310, 150, 20);
        
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Raleway SemiBold", 0, 12));
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main_Page();
            }
        });
        
        selectButton = new JButton("Select");
        selectButton.setBounds(650, 310, 100, 20);
        selectButton.setBackground(Color.WHITE);
        selectButton.setFont(new Font("Raleway SemiBold", 0, 12));
        selectButton.addActionListener(new ActionListener(){
     	
           @Override
            public void actionPerformed(ActionEvent e) {
            String query = "SELECT symbol from candidate_registeration";
            ResultSet statement;
            Statement state;
            try {
                   state = ConnectionToDatabase.registerUser().createStatement();
        		   statement = state.executeQuery(query);
                   while(statement.next()) {
                        String name = statement.getString("symbol");
                        region.addItem(name);
                   }
                   state.close();
                    ConnectionToDatabase.registerUser().close();
            }
          catch(Exception es) {
        		es.printStackTrace();
           }        
            }
      });
        
        voteButton = new JButton("Vote");
        voteButton.setFont(new Font("Raleway SemiBold", 0, 12));
        voteButton.setBackground(Color.WHITE);
        voteButton.setFont(new Font("Raleway SemiBold", 0, 12));
        voteButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!isVoted) {
            		if(username.getText().isEmpty()) {
                    	JOptionPane.showMessageDialog(backButton, "Please Enter Cnic", "Try Again", JOptionPane.ERROR_MESSAGE);
                    }
                	else {
    	                String user = username.getText();
    	                String comboBoxVal =  (String) region.getSelectedItem();
    	                
    	                String query = "INSERT INTO votes (voter_cnic,symbol)" + " VALUES (?,?)";
    	                PreparedStatement statement;
    	                Statement state;
    	    
    	                try {
    	                        
    	                        statement = ConnectionToDatabase.registerUser().prepareStatement(query);
    	                        statement.setString(1, user);
    	                        statement.setString(2, comboBoxVal);
    	                        
    	                       
    	                        int addRows = statement.executeUpdate();
    	                        if(addRows > 0) {
    	                                JOptionPane.showMessageDialog(backButton, "Successfully Voted","Successful",JOptionPane.PLAIN_MESSAGE);
    	                        }
    	                        else{
    	                            JOptionPane.showMessageDialog(backButton, "Error Occured","Error",JOptionPane.ERROR_MESSAGE);
    	                        }
    	                        statement.close();
    	                        ConnectionToDatabase.registerUser().close();
    	                        isVoted = true;
    	                }
    	                catch(Exception es) {
    	                        es.printStackTrace();
    	                }
                	}
                }
            	else if(isVoted){
            		JOptionPane.showMessageDialog(backButton, "Cannot Vote Twice","Error",JOptionPane.ERROR_MESSAGE);
            		}
	             
        
            }
        });
        

        backButton.setBounds(750, 400, 100, 40);
        backButton.setBackground(Color.WHITE);
        voteButton.setBounds(900, 400, 100, 40);
        voteButton.setBackground(Color.WHITE);
        
        
        
        right_panel = new JPanel();

        right_panel.setBackground(new Color(186, 79, 84));
        right_panel.setBounds(600, 0, 600, 700);



        //------------------------------- LEFT PANEL OF THE SCREEN ------------
        left_panel = new JPanel();
        
        text_label= new JLabel();
        text_label.setText("VOTE CANDIDATE");
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
        frame.add(text);
        
        frame.add(username);
 
        frame.add(region);
        frame.add(right_label1);
        
        
        frame.add(voteButton);
        frame.add(backButton);
        frame.add(selectButton);
        
        
        frame.add(left_panel);
        frame.add(right_panel);
     
		


	}
}
