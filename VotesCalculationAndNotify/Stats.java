
package VotesCalculationAndNotify;

import com.e_voting_project.ConnectionToDatabase;
import com.e_voting_project.Main_Page;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Stats {
    JFrame frame;
   JLabel text;
   JComboBox<String> parties;
   JButton select;
   JButton back;
   JPanel panel;
    
    
    public void showStats(){
        frame = new JFrame("ELECTRONIC VOTING SYSTEM");
        panel = new JPanel();
        panel.setBounds(0, 0, 500, 500);
        
        text = new JLabel("STATISTICS");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway SemiBold", 0, 25));
        text.setBounds(150, 100, 200, 20);  

   
        panel.setBackground(new Color(186, 79, 84));
        parties = new JComboBox();
        parties.setBounds(150, 200, 150, 20);
        
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        back = new JButton("Back");
        back.setBounds(170, 300, 100, 20);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Raleway SemiBold", 0, 12));
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main_Page();
            }
        });   
        select = new JButton("Select");
        select.setBounds(170, 250, 100, 20);
        select.setBackground(Color.WHITE);
        select.setFont(new Font("Raleway SemiBold", 0, 12));    
        String query = "SELECT DISTINCT symbol from votes";
        ResultSet resultSet;
        Statement state;
            try {
                   state = ConnectionToDatabase.registerUser().createStatement();
        		   resultSet = state.executeQuery(query);
                   while(resultSet.next()) {
                        String name = resultSet.getString("symbol");
                        parties.addItem(name);
                   }
                   
                   state.close();
                   ConnectionToDatabase.registerUser().close();
            }
            catch(Exception exc) {
          	  exc.printStackTrace();
            }
            select.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                ResultSet resultSet;
                String symbol_new = (String) parties.getSelectedItem();
                int votingNum = 0;
                String query2 = "SELECT count(symbol) from votes WHERE symbol = ?";
                PreparedStatement preparedstatement;
                try {
                        preparedstatement = ConnectionToDatabase.registerUser().prepareStatement(query2);
                        preparedstatement.setString(1,symbol_new);
                        resultSet = preparedstatement.executeQuery();
                        
                        while(resultSet.next()) {
                            votingNum=resultSet.getInt(1);
                            JOptionPane.showMessageDialog(back, votingNum);
                        }
                        resultSet.close();
                        ConnectionToDatabase.registerUser().close();
                }
              catch(Exception es) {
            	  es.printStackTrace();
              }      
            }
        });
        frame.add(back);
        frame.add(select);
        frame.add(text);
      
        frame.add(parties);
        frame.add(panel);
        
    }
    
}
