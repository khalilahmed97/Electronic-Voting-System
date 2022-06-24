package option_screen;
import VotesCalculationAndNotify.Stats;
import leadingCandidates.LeadingCandidates;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.e_voting_project.Main_Page;
import leadingCandidates.Update;

public class DisplayAdminScreen{
     JFrame frame;
    JPanel left_panel;
    JLabel image_label;
    JLabel text_label;
    
    JPanel right_panel;
 
    
    ImageIcon voting_image;
   
    
    JButton statsButton;
    JButton showCandidateButton;
    JButton backButton;
  
    JButton updateButton;
    
    public void displayAdminDashboardScreen(String admin_first_name, String admin_last_name) {
        frame = new JFrame("ELECTRONIC VOTING SYSTEM");

        frame.setSize(800, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        // ---------------------------- RIGHT PANEL OF THE SCREEN -------------
        
        
        
        backButton = new JButton("Back");
        backButton.setBounds(500, 380, 200, 40);
        backButton.setBackground(Color.WHITE);
        backButton.setFont(new Font("Raleway SemiBold", 0, 12));
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                 new Main_Page();
                
            }
        });
        
        
        
        statsButton = new JButton("Statistics");
        statsButton.setFont(new Font("Raleway SemiBold", 0, 12));
        statsButton.setBounds(520, 100, 150, 40);
        statsButton.setBackground(Color.WHITE);
        statsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	 
                 new Stats().showStats();
                
            }
        });
        
        showCandidateButton = new JButton("Show Candidates");
        showCandidateButton.setFont(new Font("Raleway SemiBold", 0, 12));
        showCandidateButton.setBackground(Color.WHITE);
        showCandidateButton.setBounds(520, 170, 150, 40);
        showCandidateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new AppliedCandidates().setVisible(true);
                
                
            }
        });
        
      
        
        updateButton = new JButton("Update Candidates");
        updateButton.setFont(new Font("Raleway SemiBold", 0, 12));
        updateButton.setBackground(Color.WHITE);
        updateButton.setBounds(520, 310, 150, 40);
        updateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update().setVisible(true);
                
                
            }
        });
        
        
        
        
        
        right_panel = new JPanel();
        right_panel.setBackground(new Color(186, 79, 84));
        right_panel.setBounds(400, 0, 400, 500);

        //------------------------------- LEFT PANEL OF THE SCREEN ------------
        left_panel = new JPanel();
        left_panel.setBackground(new Color(49, 49, 49));
        left_panel.setBounds(0, 0, 400, 500);
        
        text_label= new JLabel();
        text_label.setText(admin_first_name+" "+admin_last_name);
        text_label.setFont(new Font("Raleway SemiBold", 0, 30));
        text_label.setForeground(Color.WHITE);
        text_label.setBounds(70, 250, 300, 50);
        
        voting_image = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\option.png");
        image_label = new JLabel("",voting_image,JLabel.CENTER);

        image_label.setBounds(150, 120, 100, 100);

       
        

        // ------------------------ ADDING PANELS TO FRAME --------------------
        
        frame.add(text_label);
        frame.add(image_label);
        
        frame.add(showCandidateButton);

        frame.add(backButton);
        frame.add(statsButton);
      
        frame.add(updateButton);
        
        
        frame.add(left_panel);
        frame.add(right_panel); 
 
     
     }
	
}
