package com.e_voting_project;

public abstract class User {    
	public final void buildFrame() {
		initializeFrame(); // gui
		loginValidation(); // data to fac

	}
	public abstract void initializeFrame();     
	public abstract void loginValidation();
}
