package option_screen;
import VotesCalculationAndNotify.Stats;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.e_voting_project.Candidate;
import com.e_voting_project.Main_Page;

public class DisplayCandidateScreen{
	
	JFrame frame;
    JPanel left_panel;
    JLabel image_label;
    JLabel text_label;
    
    JPanel right_panel;
    JLabel right_label1;

    
    ImageIcon voting_image;
    ImageIcon image_right1;

   
    
 
    JButton statsButton;

    JButton backButton;
    
	public void displayCandidateDashboardScreen(String admin_first_name, String admin_last_name) {
		frame = new JFrame("ELECTRONIC VOTING SYSTEM");

        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        // ---------------------------- RIGHT PANEL OF THE SCREEN -------------
        image_right1 = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\stats_icon.png");
  
        
        right_label1 = new JLabel(image_right1, JLabel.CENTER);


        right_label1.setBounds(375, 100, 40, 40);
        
        
        backButton = new JButton("Back");
        backButton.setFont(new Font("Raleway SemiBold", 0, 12));
        backButton.setBounds(450, 300, 150, 40);
        backButton.setBackground(Color.WHITE);
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Candidate().buildFrame();
                
            }
        });
        statsButton = new JButton("Statistics");
        statsButton.setFont(new Font("Raleway SemiBold", 0, 12));
        statsButton.setBounds(450, 100, 150, 40);
        statsButton.setBackground(Color.WHITE);
        statsButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                  new Stats().showStats();
                
            }
        });
        
        right_panel = new JPanel();

        right_panel.setBackground(new Color(186, 79, 84));
        right_panel.setBounds(350, 0, 350, 500);



        //------------------------------- LEFT PANEL OF THE SCREEN ------------
        left_panel = new JPanel();
        
        text_label= new JLabel();
        text_label.setText(admin_first_name+" "+admin_last_name);
        text_label.setFont(new Font("Raleway SemiBold", 0, 30));
        text_label.setForeground(Color.WHITE);
        text_label.setBounds(30, 250, 300, 50);
        
        voting_image = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\option.png");
        image_label = new JLabel("",voting_image,JLabel.CENTER);

        image_label.setBounds(120, 120, 100, 100);

        left_panel.setBackground(new Color(49, 49, 49));
        left_panel.setBounds(0, 0, 350, 500);
        

        // ------------------------ ADDING PANELS TO FRAME --------------------
        
        frame.add(text_label);
        frame.add(image_label);
        
        frame.add(right_label1);
        
        frame.add(backButton);
        frame.add(statsButton);
        
        
        frame.add(left_panel);
        frame.add(right_panel); 
 
     
     }
	
}
