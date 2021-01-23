package com.herokuapp.theinternet.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PositiveLogInTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting logIn test");

		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		SecureAreaPage securePage = welcomePage.openPage()
												.clickFormAuthenticationLink()
												.logIn("tomsmith", "SuperSecretPassword!");
		// verifications
		Assert.assertEquals(securePage.getCurrentUrl(), securePage.getPageUrl());
		// log out button is visible
		Assert.assertTrue(securePage.isLogOutVisible(),"logOutButton is not visible.");
		// Successful log in message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = securePage.getSuccessMsg();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
	}
}
