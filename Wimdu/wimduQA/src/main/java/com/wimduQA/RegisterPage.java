package com.wimduQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	private final WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		super();
		this.driver = driver;

		/*Wait wait = new FluentWait(driver)
	       .withTimeout(30, SECONDS)
	       .pollingEvery(2, SECONDS);

	     wait.until(ExpectedConditions.titleIs("Login"));*/
	}
	
	public void failRegister(String firstname,String lastname,String email, String password) {
		executeSignUp(firstname,lastname,email, password);
	}
	public HomePage registerAs(String firstname,String lastname,String email, String password) {
		executeSignUp(firstname,lastname,email, password);
		return new HomePage(driver);
	}


	private void executeSignUp(String firstname,String lastname,String email,String password)
	{
		driver.findElement(By.id("user_firstname")).sendKeys(firstname);
		driver.findElement(By.id("user_lastname")).sendKeys(lastname);
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
	}

	public void openUrl(String url){
        driver.get(url);
    }
	public String geterrorMessageFNameBlank()
	{
		return driver.findElement(By.xpath("//*[@id='new_user']/div[2]/div[2]")).getText();
	}
	public String geterrorMessageEmailBlank()
	{
		
		return driver.findElement(By.xpath("//*[@id='new_user']/div[4]/div[2]")).getText();
	}
	public String geterrorMessagLNameBlank()
	{
		return driver.findElement(By.xpath("//*[@id='new_user']/div[3]/div[2]")).getText();
	}
	public String geterrorMessagePassBlank()
	
	{
		return driver.findElement(By.xpath("//*[@id='new_user']/div[5]/div[2]")).getText();
	}
	
}
