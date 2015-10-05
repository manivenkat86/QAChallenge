package com.wimduQA;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	
	public static WebDriver getDriver() {

        String driverToUse = System.getProperty("browser");

        if(StringUtils.isEmpty(driverToUse)) {
            return new FirefoxDriver();
        }

        if (driverToUse.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (driverToUse.equalsIgnoreCase("ie"))
            return new InternetExplorerDriver();
        else if (driverToUse.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else
            return new FirefoxDriver();
    }
}
