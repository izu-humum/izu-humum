package com.bd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	// static String loopUrl = "https://loop-dashboard.p-stageenv.xyz/";
	// static String signUrl =
	// "https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Faccounts.google.com%2Fgsi%2Fselect%3Fclient_id%3D368045453645-3a9j148dre11hgdr56t22tp8dfssca5c.apps.googleusercontent.com%26ux_mode%3Dpopup%26ui_mode%3Dcard%26as%3D8C07UPYWae2jJclO8YUB3Q%26channel_id%3Dec2bcc0fb41ae1a7562df3d0c64f6eaf721c9077bb1be83e2a274551d8569a2c%26origin%3Dhttps%3A%2F%2Floop-dashboard.p-stageenv.xyz&faa=1&ifkv=ATuJsjxrqMWpCOztkYt2Enc3wgWL00JaIjRN9NzVfozs6QeeqUbZ8O9kynIjUfASomnNJHfY2aBE&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S1275929587%3A1707903721253600&theme=glif";
	static WebDriver driver;

	@BeforeSuite
	public void start() throws InterruptedException {

		String browser = System.getProperty("browser", "chrome");

		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		Thread.sleep(3000);
	
	}

	@AfterSuite
	public void end() {
		// driver.quit();
	}
}
