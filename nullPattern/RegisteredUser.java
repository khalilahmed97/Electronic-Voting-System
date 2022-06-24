package nullPattern;

import javax.swing.JButton;


import javax.swing.JOptionPane;

import option_screen.UserDashboardFacade;

public class RegisteredUser extends AbstractUser{
	@Override
	public void candidateOptionScreen(String candidate_first_name, String candidate_last_name) {
		new UserDashboardFacade().showCandidateDashboard(candidate_first_name, candidate_last_name);
		
	}

	@Override
	public void voterOptionScreen(String voter_first_name,  String voter_last_name) {
		new UserDashboardFacade().showVoterDashboard(voter_first_name, voter_last_name);
		
	}

	@Override
	public void displayMessage(String user) {
		JButton backButton = new JButton("Back");
		JOptionPane.showMessageDialog(backButton,"Successfully Logged in "+user,"Successful",JOptionPane.INFORMATION_MESSAGE);
	}

}
