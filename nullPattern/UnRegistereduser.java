package nullPattern;
import javax.swing.*;
import com.e_voting_project.Candidate;
import com.e_voting_project.Voter;
import java.awt.event.*;
public class UnRegistereduser extends AbstractUser {
	@Override
	public void candidateOptionScreen(String candidate_first_name,  String candidate_last_name) {
	}
	@Override
	public void voterOptionScreen(String voter_first_name,  String voter_last_name) {	
	}
	@Override
	public void displayMessage(String user) {
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(user=="Candidate") {
            		new Candidate().buildFrame();
            	}
            	else {
            		new Voter().buildFrame();
            	}  
            }
        });
		JOptionPane.showMessageDialog(backButton, "Error Occured while Login the "+ user,"Error",JOptionPane.ERROR_MESSAGE);
	}
}
