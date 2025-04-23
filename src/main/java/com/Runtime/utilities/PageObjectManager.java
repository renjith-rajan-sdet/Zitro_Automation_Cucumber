package com.Runtime.utilities;


import test.pages.*;

public class PageObjectManager {

	private final RuntimeEnvironment runtime;
	public PageObjectManager(RuntimeEnvironment runtime) {
		this.runtime = runtime;
	}
	HomePage homePage;

	public HomePage getHomePage()
	{
		if(homePage==null) {homePage = new HomePage(runtime);return homePage;}return homePage;
	}

	Registration_Page registrationPage;

	public Registration_Page getRegistrationPage()
	{
		if(registrationPage==null) {registrationPage = new Registration_Page(runtime);return registrationPage;}return registrationPage;
	}

	Registration_ConfirmationPage regConfirmation;

	public Registration_ConfirmationPage getRegistrationConfirmationPage()
	{
		if(regConfirmation==null) {regConfirmation = new Registration_ConfirmationPage(runtime);return regConfirmation;}return regConfirmation;
	}

	LoginScreen loginScreen;

	public LoginScreen getLoginScreenPage()
	{
		if(loginScreen==null) {loginScreen = new LoginScreen(runtime);return loginScreen;}return loginScreen;
	}

	LogedIn_homeScreen loggedInScreen;
	public LogedIn_homeScreen getloggedInScreenPage()
	{
		if(loggedInScreen==null) {loggedInScreen = new LogedIn_homeScreen(runtime);return loggedInScreen;}return loggedInScreen;
	}

	PersonalSettings personalSettings;
	public PersonalSettings getpersonalSettings()
	{
		if(personalSettings==null) {personalSettings = new PersonalSettings(runtime);return personalSettings;}return personalSettings;
	}

	ChangeNewsLetter changeNewsLetter;
	public ChangeNewsLetter getchangeNewsLetter()
	{
		if(changeNewsLetter==null) {changeNewsLetter = new ChangeNewsLetter(runtime);return changeNewsLetter;}return changeNewsLetter;
	}

	ChangeSecurityQuestion changeSecurityQuestion;
	public ChangeSecurityQuestion getChangeSecurityQuestion()
	{
		if(changeSecurityQuestion==null) {changeSecurityQuestion = new ChangeSecurityQuestion(runtime);return changeSecurityQuestion;}return changeSecurityQuestion;
	}

}
