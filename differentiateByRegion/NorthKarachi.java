package differentiateByRegion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.e_voting_project.ConnectionToDatabase;

import nullPattern.RegisteredUser;
import nullPattern.UnRegistereduser;

public class NorthKarachi implements Region{

	ResultSet resultSet = null;
	String user, pass;
	
	NorthKarachi(String user, String pass){
		this.user = user;
		this.pass = pass;
	}

	@Override
	public void loginValidationForCandidate() {
		String query = "SELECT candidate_first_name, candidate_last_name, cnic, password FROM candidate_registeration WHERE cnic=? AND password=?";
      	PreparedStatement preparedstatement;
      	Statement state;
      	
      	try {
      		state = ConnectionToDatabase.registerUser().createStatement();
      		preparedstatement = ConnectionToDatabase.registerUser().prepareStatement(query);
      		preparedstatement.setString(1,user);
      		preparedstatement.setString(2, pass);

      		resultSet = preparedstatement.executeQuery();
      		
      		
      		if(resultSet.next()) {
      			String candidate_first_name = resultSet.getString("candidate_first_name");
    			String candidate_last_name = resultSet.getString("candidate_last_name");
    			RegisteredUser r1 = new RegisteredUser();
    		    r1.displayMessage("Candidate");
    			r1.candidateOptionScreen(candidate_first_name, candidate_last_name);
      		
      		}
      		else {
      			new UnRegistereduser().displayMessage("Candidate");
      			
      		}
      		state.close();
      		ConnectionToDatabase.registerUser().close();
      	}
      	catch(Exception exception) {
      		exception.printStackTrace();
      	}
		
	}

	@Override
	public void loginValidationForVoter() {
		String query = "SELECT voter_first_name,voter_last_name,cnic, password FROM voter_registration WHERE cnic=? AND password=?";
    	PreparedStatement preparedstatement;
    	Statement state;
    	
    	try {
    		state = ConnectionToDatabase.registerUser().createStatement();
    		preparedstatement = ConnectionToDatabase.registerUser().prepareStatement(query);
    		preparedstatement.setString(1,user);
    		preparedstatement.setString(2, pass);

    		resultSet = preparedstatement.executeQuery();
    		
    		
    		if(resultSet.next()) {
    			String voter_first_name = resultSet.getString("voter_first_name");
    			String voter_last_name = resultSet.getString("voter_last_name");
    			
    			RegisteredUser r1 = new RegisteredUser();
                        r1.displayMessage("Voter");
    			r1.voterOptionScreen(voter_first_name,voter_last_name);
    			   	
    		}
    		else {
    			new UnRegistereduser().displayMessage("Voter");
    		}
    		state.close();
    		ConnectionToDatabase.registerUser().close();
    	}
    	catch(Exception exception) {
    		exception.printStackTrace();
    	}
		
	}

}
