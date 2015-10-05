package com.wimduQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {
	private final WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;

		/*Wait wait = new FluentWait(driver)
	       .withTimeout(30, SECONDS)
	       .pollingEvery(2, SECONDS);

	     wait.until(ExpectedConditions.titleIs("Login"));*/
	}

	public HomePage loginAs(String email, String password)
	{
		executeLogin(email,password);
		return new HomePage(driver);
	}
	
	public void failLoginAs(String email, String password) {
		executeLogin(email, password);
	}
	
	private void executeLogin(String email,String password)
	{
		driver.findElement(By.id("user_email")).sendKeys(email);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.name("commit")).click();
	}
	
	public void openUrl(String url){
        driver.get(url);
    }
	
	public String geterrorMessage()
	{
		return driver.findElement(By.xpath("//*[@id='new_user']/div[3]/div[2]")).getText();
	}
}
