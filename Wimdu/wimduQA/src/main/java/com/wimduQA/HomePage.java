package com.wimduQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private final WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;

		/* Wait wait = new FluentWait(driver)
	       .withTimeout(30, SECONDS)
	       .pollingEvery(2, SECONDS);

	     wait.until(ExpectedConditions.titleIs("")); */

	}
	
	
	public String getwelcomeMessage()
	{
		return driver.findElement(By.xpath("//*[@id='dashboard_show']/div[1]/div/div")).getText();
	}
	

}
