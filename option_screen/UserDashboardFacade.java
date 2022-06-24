package option_screen;

public class UserDashboardFacade {
		DisplayVoterScreen displayVoterScreen;
	 	DisplayCandidateScreen displayCandidateScreen;
	 	DisplayAdminScreen displayAdminScreen;
	 
	    AllowCandidates allowCandidates;
	    
	    
	    public UserDashboardFacade(){
	        displayVoterScreen = new DisplayVoterScreen();
	        displayAdminScreen = new DisplayAdminScreen();
	        displayCandidateScreen = new DisplayCandidateScreen();
	       
	        
	    }
	    
	    public void showAdminDashboard(String admin_first_name, String admin_last_name){
	    	displayAdminScreen.displayAdminDashboardScreen(admin_first_name, admin_last_name);
	    }
	    public void showCandidateDashboard(String candidate_first_name, String candidate_last_name){
	    	displayCandidateScreen.displayCandidateDashboardScreen(candidate_first_name, candidate_last_name);
	    }
	    public void showVoterDashboard(String voter_first_name,  String voter_last_name){
	    	displayVoterScreen.displayVoterScreen(voter_first_name, voter_last_name);
	    }
}
