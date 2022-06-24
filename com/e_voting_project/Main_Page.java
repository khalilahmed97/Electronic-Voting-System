package com.e_voting_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main_Page {

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

    JButton voterButton;
    JButton adminButton;
    JButton candidateButton;
    
    

    public Main_Page() {
        
        //----------------------------- FRAME ----------------------------------
        frame = new JFrame("ELECTRONIC VOTING SYSTEM");

        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);

        // ---------------------------- RIGHT PANEL OF THE SCREEN -------------
        image_right1 = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\main_page_icon1.png");
        image_right2 = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\main_page_icon2.png");
        right_label1 = new JLabel(image_right1, JLabel.CENTER);
        right_label2 = new JLabel(image_right2, JLabel.CENTER);
        right_label3 = new JLabel(image_right1, JLabel.CENTER);

        right_label1.setBounds(
                700, 195, 50, 50);
        right_label2.setBounds(
                700, 295, 50, 50);
        
        right_label3.setBounds(
                700, 395, 50, 50);

        adminButton = new JButton("Proceed As Admin");
        adminButton.setFont(new Font("Raleway SemiBold", 0, 12));
        adminButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Admin().buildFrame();
                
            }
        });
        voterButton = new JButton("Proceed As Voter");
        voterButton.setFont(new Font("Raleway SemiBold", 0, 12));
        voterButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Voter().buildFrame();
                
            }
        });
        
        candidateButton = new JButton("Proceed As Candidate");
        candidateButton.setFont(new Font("Raleway SemiBold", 0, 12));
        candidateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Candidate().buildFrame();
                
            }
        });

        adminButton.setBounds(800, 200, 200, 40);
        adminButton.setBackground(Color.WHITE);
        
        voterButton.setBounds( 800, 300, 200, 40);
        voterButton.setBackground(Color.WHITE);
        
        candidateButton.setBounds(800, 400, 200, 40);
        candidateButton.setBackground(Color.WHITE);

        right_panel = new JPanel();

        right_panel.setBackground(new Color(186, 79, 84));
        right_panel.setBounds(600, 0, 600, 700);

        
        text_label= new JLabel();
        text_label.setText("VOTING SYSTEM");
        text_label.setFont(new Font("Raleway SemiBold", 0, 30));
        text_label.setForeground(Color.WHITE);
        text_label.setBounds(170, 300, 250, 100);
        
        voting_image = new ImageIcon("C:\\Users\\Khalil\\Documents\\NetBeansProjects\\Electronic_Voting_Project\\src\\images\\main_page.png");
        image_label = new JLabel("",voting_image,JLabel.CENTER);

        image_label.setBounds(220, 200, 150, 150);

        
        left_panel = new JPanel();
        left_panel.setBackground(new Color(49, 49, 49));
        left_panel.setBounds(0, 0, 600, 700);
        
        
        

        // ------------------------ ADDING PANELS TO FRAME --------------------
        
        frame.add(text_label);
        frame.add(image_label);
        
        frame.add(right_label1);
        frame.add(right_label2);
        frame.add(right_label3);
        frame.add(adminButton);
        frame.add(voterButton);
        frame.add(candidateButton);
        
        frame.add(left_panel);
        frame.add(right_panel);
        
    }

}
