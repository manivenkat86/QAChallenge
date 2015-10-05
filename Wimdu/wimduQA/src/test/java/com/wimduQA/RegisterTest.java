package com.wimduQA;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegisterTest {
public static WebDriver driver;
	
	@BeforeClass 
	public static void setupBrowser()
	{
		RegisterTest.driver=Browser.getDriver();
	}
	
	@AfterClass public static void afterAllIsSaidAndDone() {
		 driver.quit();
	 }
 
	@Test
	public void testSignUpFirstNameBlank()
	{
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.openUrl("https://brussels.staging.wimdu.com/users/register/sign_up");
		registerpage.failRegister("","white","apenhxfp@trashmail.com", "123456");
		assertTrue(registerpage.geterrorMessageFNameBlank().contains("Please fill in"));
	}
	@Test
	public void testSignUpExistingEmail()
	{
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.openUrl("https://brussels.staging.wimdu.com/users/register/sign_up");
		registerpage.failRegister("Walter","white","xipeswlh@trashmail.com", "123456");
		assertEquals("This email address is already taken, please enter another",registerpage.geterrorMessageEmailBlank());
	}
	
	@Test
	public void testSignUp()
	{
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.openUrl("https://brussels.staging.wimdu.com/users/register/sign_up");
		HomePage homepage=registerpage.registerAs("Walter","white","wptlolfw@trashmail.com", "123456");
		assertEquals("Welcome! You have signed up successfully.",homepage.getwelcomeMessage());
	}
	
	@Test
	public void testSignUpEmailBlank()
	{
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.openUrl("https://brussels.staging.wimdu.com/users/register/sign_up");
		registerpage.failRegister("Walter","white","", "123456");
		assertTrue(registerpage.geterrorMessageEmailBlank().contains("Please fill in"));
	}
	
}
