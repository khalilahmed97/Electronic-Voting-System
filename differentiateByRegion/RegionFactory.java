package differentiateByRegion;
public class RegionFactory {
	public void getInstance(String user, String pass,String selectedRegion, String userType) {
		if(selectedRegion.equals("North Karachi") && userType.equals("Voter")) {
			new NorthKarachi(user, pass).loginValidationForVoter();
		}
		else if(selectedRegion.equals("North Karachi") && userType.equals("Candidate")) {
			new NorthKarachi(user, pass).loginValidationForCandidate();
		}
		else if(selectedRegion.equals("Gulshan-e-Iqbal") && userType.equals("Voter")) {
			new Gulshan_Iqbal(user, pass).loginValidationForVoter();
		}
		else if(selectedRegion.equals("Gulshan-e-Iqbal") && userType.equals("Candidate")) {
			new Gulshan_Iqbal(user, pass).loginValidationForCandidate();
		}
		else if(selectedRegion.equals("Maleer")&& userType.equals("Voter")) {
			new Maleer(user, pass).loginValidationForVoter();
		}
		else if(selectedRegion.equals("Maleer")&& userType.equals("Candidate")) {
			new Maleer(user, pass).loginValidationForCandidate();
		}
		else if(selectedRegion.equals("Saddar")&& userType.equals("Voter")) {
			new Saddar(user, pass).loginValidationForVoter();
		}
		else if(selectedRegion.equals("Saddar")&& userType.equals("Candidate")) {
			new Saddar(user, pass).loginValidationForCandidate();
		}
		else if(selectedRegion.equals("SITE Area")&& userType.equals("Voter")) {
			new SITE_Area(user, pass).loginValidationForVoter();
		}
		else if(selectedRegion.equals("SITE Area")&& userType.equals("Candidate")) {
			new SITE_Area(user, pass).loginValidationForCandidate();
		}
	}

}
