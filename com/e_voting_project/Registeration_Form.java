package com.e_voting_project;
public abstract class Registeration_Form {
	public final void userRegisteration() {
		displayRegistrationForm();
		checkRegistration();
	} 
    public abstract void displayRegistrationForm();
    public abstract void checkRegistration();
}
