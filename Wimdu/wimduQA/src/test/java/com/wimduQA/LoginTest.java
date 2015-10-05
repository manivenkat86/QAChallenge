package com.wimduQA;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginTest {
	public static WebDriver driver;
	
	@BeforeClass 
	public static void setupBrowser()
	{
		LoginTest.driver=Browser.getDriver();
	}
	
	@AfterClass public static void afterAllIsSaidAndDone() {
		 driver.quit();
	 }
	
	@Test
	public void testsuccessfulLogin()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.openUrl("https://brussels.staging.wimdu.com/users/login");
		HomePage homepage=loginpage.loginAs("xipeswlh@trashmail.com", "123456");
		assertTrue(homepage.getwelcomeMessage().contains("Signed in successfully."));
	}
	
	@Test
	public void testFailedLogin() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.openUrl("https://brussels.staging.wimdu.com/users/login");
		loginPage.failLoginAs("xipeswlh@trashmail.com", "12345");
		assertTrue(loginPage.geterrorMessage().contains("Invalid email or password."));
	}

}
