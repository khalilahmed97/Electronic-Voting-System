package option_screen;

public class CandidateList {
	private String candidate_first_name, candidate_last_name, cnic, party_symbol;
	public CandidateList(String candidate_first_name, String candidate_last_name, String cnic, String party_symbol) {
		this.candidate_first_name = candidate_first_name;
		this.candidate_last_name = candidate_last_name;
		this.cnic = cnic;
		this.party_symbol = party_symbol;
	}
	public String getCandidateFirstName() {
		return candidate_first_name;
	}
	public String getCandidateLastName() {
		return candidate_last_name;
	}
	public String getCnic() {
		return cnic;
	}
	public String getPartySymbol() {
		return party_symbol;
	}
}
