package com.bd;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WebAutomation extends BaseDriver {
	static String loopUrl = "https://loop-dashboard.p-stageenv.xyz/";
	//static String loopUrl = "http://localhost:8080/campaigns/list";

	@Test(priority = 0)
	public void openUrl() throws InterruptedException {
		driver.get(loopUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000); // 1000=1s
	}

	
	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public static void token() {
        String tokenEndpoint = "https://loop-bff.p-stageenv.xyz/api/auth/test_login";
        String payload = "{\"email\": \"alvi.aveen@pathao.com\"}";

        try {
            URL url = new URL(tokenEndpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", Integer.toString(payload.getBytes().length));
            connection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(payload);
            wr.flush();
            wr.close();

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response
            System.out.println(response.toString());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("localStorage.setItem(arguments[0],arguments[1])","pathaoInternal:auth", response.toString());

            connection.disconnect();
            
         // Refresh the page to login
            driver.navigate().refresh();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	String randomName = generateRandomName();


	// Method to generate a random name
	private String generateRandomName() {
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    int length = 10; // adjust the length of the random name as needed
	    for (int i = 0; i < length; i++) {
	        int index = random.nextInt(characters.length());
	        sb.append(characters.charAt(index));
	    }
	    return sb.toString();
	}
	
	
	@Test(priority = 2)
	public void testLocators() throws InterruptedException {
//		driver.navigate().refresh(); // refresh the page
//		WebElement Dismiss = driver.findElement(By.xpath("//body/aside[1]/div[2]/div[1]/div[1]/button[1]/div[3]"));
//		Dismiss.click();
//		Thread.sleep(2000);

		// Find the shadow host element
//        WebElement shadowHost = driver.findElement(By.tagName("your_shadow_host_tag_name"));
//
//        // Execute JavaScript to access the shadow root
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
//
//        // Find the element within the shadow DOM
//        WebElement emailInput = shadowRoot.findElement(By.cssSelector("#identifierId"));
//		WebElement email = driver.findElement(By.xpath("//input[@id='identifierId']"));
//		email.sendKeys("alvi.aveen@pathao.com");
//		Thread.sleep(2000); // 1000=1s

		// Waiting Functionality
//		Duration timeoutSeconds = Duration.ofSeconds(20);
//		WebDriverWait wait = new WebDriverWait(driver, timeoutSeconds); // Adjust the timeout as needed
//		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
//		email.sendKeys("alvi.aveen@pathao.com");

//		WebElement Next = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
//		Next.click();
//		Thread.sleep(2000);
//
//		WebElement pass = driver.findElement(By.xpath(
//				"//body/div[1]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
//		pass.sendKeys("pathao@QA123");
//		Thread.sleep(2000); // 1000=1s
//
//		WebElement Next2 = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
//		Next2.click();
//		Thread.sleep(2000);
//
//		WebElement country = driver.findElement(By.xpath(
//				"//body/div[1]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
//		country.click();
//		Thread.sleep(2000);
//
//		WebElement country2 = driver.findElement(By.xpath(
//				"//body/div[1]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[20]"));
//		country2.click();
//		Thread.sleep(2000);
//
//		WebElement phonenumber = driver.findElement(By.xpath("//input[@id='phoneNumberId']"));
//		phonenumber.sendKeys("1779303434");
//		Thread.sleep(2000); // 1000=1s
//
//		WebElement send = driver.findElement(By.xpath("//span[contains(text(),'Send')]"));
//		send.click();
//		Thread.sleep(2000);
		
		//Create a Loop
		
		WebElement createLoop = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]"));
		createLoop.click();
		Thread.sleep(1000);

		WebElement loopName = driver.findElement(By.xpath("//input[@id='campaignName']"));
		loopName.click();
		loopName.sendKeys(generateRandomName());
		Thread.sleep(1000);
		
		
		WebElement productType = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]"));
		productType.click();
		Thread.sleep(1000);
		
		WebElement selectPType = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/ul[1]/li[4]/span[1]"));
		selectPType.click();
		Thread.sleep(1000);
		
		WebElement subjectType = driver.findElement(By.xpath("//span[contains(text(),'Select Option')]"));
		subjectType.click();
		Thread.sleep(1000);
		
		WebElement selectSType = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[2]/div[2]/div/div/div[3]/ul/li[1]/span"));
		selectSType.click();
		Thread.sleep(1000);
		
		WebElement maxEC = driver.findElement(By.xpath("//input[@id='maxIteration']"));
		maxEC.click();
		maxEC.sendKeys("1");
		Thread.sleep(1000);
		
		WebElement iG = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div[2]/span"));
		iG.click();
		Thread.sleep(1000);
		
		WebElement selectIG = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[3]/div[2]/div/div/div[1]/div[3]/ul/li[2]/span"));
		selectIG.click();
		Thread.sleep(1000);
		
		WebElement controlGP = driver.findElement(By.xpath("//input[@id='controlGroup']"));
		// Doubleclick 
		Actions actions = new Actions(driver);
		actions.doubleClick(controlGP).perform();
		controlGP.sendKeys("1");
		Thread.sleep(1000);
		
		WebElement startDate = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		startDate.click();
		Thread.sleep(1000);
		
		WebElement selectstartDate = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[1]/div/div/div[1]/div/div[2]/div/span[38]"));
		selectstartDate.click();
		Thread.sleep(1000);
		
		WebElement startTime = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[1]/div/div/span/input"));
		startTime.click();
		Thread.sleep(1000);
		WebElement startTime2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[1]/div/div/span/div[3]/div/ul[1]/li[2]"));
		startTime2.click();
		Thread.sleep(1000);
		WebElement startTime3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div"));
		startTime3.click();
		Thread.sleep(1000);

		
		WebElement endDate = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		endDate.click();
		Thread.sleep(1000);
		WebElement endDateNext1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div/div[1]/div/div[2]/header/span[3]"));
		endDateNext1.click();
		Thread.sleep(1000);
		WebElement endDateNext2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div/div[1]/div/div[2]/header/span[3]"));
		endDateNext2.click();
		Thread.sleep(1000);
		WebElement endDateNext3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div/div[1]/div/div[2]/header/span[3]"));
		endDateNext3.click();
		Thread.sleep(1000);
		WebElement endDateNext4 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div/div[1]/div/div[2]/header/span[3]"));
		endDateNext4.click();
		Thread.sleep(1000);
		WebElement selectendDate = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div/div[1]/div/div[2]/div/span[39]"));
		selectendDate.click();
		Thread.sleep(1000);
		
		WebElement endTime1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div/span/input"));
		endTime1.click();
		Thread.sleep(1000);	
		WebElement endTime2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[4]/div[2]/div/div/span/div[3]/div/ul[1]/li[3]"));
		endTime2.click();
		Thread.sleep(1000);		
		WebElement endTime3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div"));
		endTime3.click();
		Thread.sleep(1000);
		
		WebElement country = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[5]/div[1]/div/div/div[1]"));
		country.click();
		Thread.sleep(1000);
		
		WebElement selectCountry = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[5]/div[1]/div/div/div[3]/ul/li[1]/span"));
		selectCountry.click();
		Thread.sleep(1000);
		
		WebElement city = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[5]/div[2]/div/div/div[1]"));
		city.click();
		Thread.sleep(1000);
		
		WebElement selectCity = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[5]/div[2]/div/div/div[3]/ul/li[1]/span"));
		selectCity.click();
		Thread.sleep(1000);
		
		WebElement dryMode = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/div[5]/div[3]/label/span[2]"));
		dryMode.click();
		Thread.sleep(1000);
		
		WebElement create = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div[2]/div/button"));
		create.click();
		Thread.sleep(1000);
		
		
		//View Flowchart
		WebElement viewMenu1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div[9]/div/div[2]"));
		viewMenu1.click();
		Thread.sleep(2000);
		WebElement viewFlowchart = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div[9]/div/div[2]/div/div[1]"));
		viewFlowchart.click();
		Thread.sleep(2000);
		
		//Create Entry Phase
		WebElement createPhase = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/div[1]/div"));
		createPhase.click();
		Thread.sleep(2000);
		
		WebElement createPhaseName = driver.findElement(By.xpath("//input[@id='phaseName']"));
		createPhaseName.click();
		createPhaseName.sendKeys("Start");
		Thread.sleep(1000);
		
		WebElement phaseType = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[1]"));
		phaseType.click();
		Thread.sleep(1000);
		
//		WebElement selectPhaseTypeBasic = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[3]/ul/li[1]/span"));
//		selectPhaseTypeBasic.click();
//		Thread.sleep(1000);
		
		WebElement selectPhaseTypeRealTime = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[3]/ul/li[2]/span"));
		selectPhaseTypeRealTime.click();
		Thread.sleep(1000);
		
		WebElement transitionMode = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]"));
		transitionMode.click();
		Thread.sleep(1000);
		
		WebElement transitionModeTargetAchieved = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div/div[3]/ul/li[2]/span/div/span"));
		transitionModeTargetAchieved.click();
		Thread.sleep(1000);
		
//		WebElement deadlineReached = driver.findElement(By.xpath(
//				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div/div[3]/ul/li[1]/span"));
//		deadlineReached.click();
//		Thread.sleep(1000);
		
		//For Basic Phase Type
//		WebElement duration = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input"));
//		Actions actions = new Actions(driver);
//		actions.doubleClick(duration).perform();
//		duration.sendKeys("1");
		
		
		//For Real Time Phase Type
		WebElement duration = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div[1]"));
		duration.click();
		Thread.sleep(1000);
		
		WebElement selectDuration = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div[3]/ul/li[2]/span/span"));
		selectDuration.click();
		Thread.sleep(1000);
		
		WebElement time = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[1]"));
		time.click();
		Thread.sleep(1000);
		
//		WebElement selectDHours = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/ul/li[2]/span"));
//		selectDHours.click();
//		Thread.sleep(1000);
//		
		WebElement selectDDays = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/ul/li[3]/span/span"));
		selectDDays.click();
		Thread.sleep(1000);
		
		WebElement checkInterval = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div/div/div[2]/div[1]"));
		checkInterval.click();
		Thread.sleep(1000);

		WebElement checkIntervalHours = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div/div/div[2]/div[3]/ul/li[2]/span/span"));
		checkIntervalHours.click();
		Thread.sleep(1000);
		
		WebElement entryPoint = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/span[2]"));
		entryPoint.click();
		Thread.sleep(1000);
		
		WebElement pauseDisabled = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/label[2]/span[2]"));
		pauseDisabled.click();
		Thread.sleep(1000);
		
		//Entry Criteria
		WebElement ECcondition1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[1]/div/div/div/div/div[2]/div[1]/div[1]"));
		ECcondition1.click();
		Thread.sleep(1000);
		
//		WebElement rideCreated = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[1]/div/div/div/div/div[2]/div[1]/div[3]/ul/li[1]/span"));
//		rideCreated.click();
//		Thread.sleep(1000);
		
		WebElement rideFareEstimated = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[1]/div/div/div/div/div[2]/div[1]/div[3]/ul/li[2]/span/span"));
		rideFareEstimated.click();
		Thread.sleep(1000);
		
		WebElement ECequation = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[1]/div/div/div/div/div[2]/div[2]/div[1]"));
		ECequation.click();
		Thread.sleep(1000);
		
		WebElement ECequation3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[1]/div/div/div/div/div[2]/div[2]/div[3]/ul/li[3]/span"));
		ECequation3.click();
		Thread.sleep(1000);

		WebElement estimationCount = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[1]/div/div/div/div/div[2]/div[3]/input"));
		estimationCount.click();
		estimationCount.sendKeys("1");
		Thread.sleep(1000);
		
		WebElement dropHours = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[2]/div/div/div/div[2]/div[1]"));
		dropHours.click();
		Thread.sleep(1000);
		
		WebElement condition1Hours = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[2]/div/div/div/div[2]/div[3]/ul/li[2]/span"));
		condition1Hours.click();
		Thread.sleep(1000);
		
		WebElement dropCount = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[2]/div/div/div/div[1]/div[1]"));
		dropCount.click();
		Thread.sleep(1000);
		
		WebElement condition1Duration = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[3]/div[2]/div/div/div/div[1]/div[3]/ul/li[2]/span"));
		condition1Duration.click();
		Thread.sleep(1000);
		
		//Success Criteria
		WebElement SCcondition = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[4]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]"));
		SCcondition.click();
		Thread.sleep(1000);
		
		WebElement rideCreated = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[4]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[3]/ul/li[1]/span"));
		rideCreated.click();
		Thread.sleep(1000);
		
		WebElement SCequation = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[4]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]"));
		SCequation.click();
		Thread.sleep(1000);
		
		WebElement SCequation1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[4]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[3]/ul/li[1]/span"));
		SCequation1.click();
		Thread.sleep(1000);
		
		WebElement ridecreationCount = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[4]/div[2]/div[1]/div/div/div/div/div[2]/div[3]/input"));
		ridecreationCount.click();
		ridecreationCount.sendKeys("1");
		Thread.sleep(1000);
		
		WebElement validate = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]"));
		validate.click();
		Thread.sleep(1000);
		
		WebElement saveEntryPhase = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[5]/button[1]"));
		saveEntryPhase.click();
		Thread.sleep(1000);
		
		
		// Create Phase1
		WebElement createPhase1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/div[1]/div"));
		createPhase1.click();
		Thread.sleep(2000);

		WebElement createPhaseName1 = driver.findElement(By.xpath("//input[@id='phaseName']"));
		createPhaseName1.click();
		createPhaseName1.sendKeys("Target Achieved");
		Thread.sleep(1000);

		WebElement phaseType1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[1]"));
		phaseType1.click();
		Thread.sleep(1000);

//				WebElement selectPhaseTypeBasic1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[3]/ul/li[1]/span"));
//				selectPhaseTypeBasic1.click();
//				Thread.sleep(1000);

		WebElement selectPhaseType1RealTime1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[3]/ul/li[2]/span"));
		selectPhaseType1RealTime1.click();
		Thread.sleep(1000);

		WebElement transitionMode1 = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]"));
		transitionMode1.click();
		Thread.sleep(1000);

		WebElement transitionModeTargetAchieved1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div/div[3]/ul/li[2]/span/div/span"));
		transitionModeTargetAchieved1.click();
		Thread.sleep(1000);
		
//		WebElement deadlineReached1 = driver.findElement(By.xpath(
//				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div/div[3]/ul/li[1]/span"));
//		deadlineReached1.click();
//		Thread.sleep(1000);

		// For Basic Phase Type
//				WebElement duration = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input"));
//				Actions actions = new Actions(driver);
//				actions.doubleClick(duration).perform();
//				duration.sendKeys("1");

		// For Real Time Phase Type
		WebElement duration1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div[1]"));
		duration1.click();
		Thread.sleep(1000);

		WebElement selectDuration1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div[3]/ul/li[2]/span/span"));
		selectDuration1.click();
		Thread.sleep(1000);

		WebElement time1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[1]"));
		time1.click();
		Thread.sleep(1000);

//				WebElement selectDHours = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/ul/li[2]/span"));
//				selectDHours.click();
//				Thread.sleep(1000);
//				
		WebElement selectDDays1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/ul/li[3]/span/span"));
		selectDDays1.click();
		Thread.sleep(1000);

		WebElement checkInterval1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div/div/div[2]/div[1]"));
		checkInterval1.click();
		Thread.sleep(1000);

		WebElement checkIntervalHours1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div/div/div[2]/div[3]/ul/li[2]/span/span"));
		checkIntervalHours1.click();
		Thread.sleep(1000);

		WebElement pauseDisabled1 = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/label[2]/span[2]"));
		pauseDisabled1.click();
		Thread.sleep(1000);
		
		
		// Success Criteria
		WebElement SCcondition1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]"));
		SCcondition1.click();
		Thread.sleep(1000);

		WebElement rideCreated1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[3]/ul/li[1]/span"));
		rideCreated1.click();
		Thread.sleep(1000);

		WebElement SCeqution1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]"));
		SCeqution1.click();
		Thread.sleep(1000);

		WebElement SCequation11 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[3]/ul/li[2]/span"));
		SCequation11.click();
		Thread.sleep(1000);

		WebElement ridecreationCount1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[3]/input"));
		ridecreationCount1.click();
		ridecreationCount1.sendKeys("1");
		Thread.sleep(1000);

		WebElement validate1 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/div"));
		validate1.click();
		Thread.sleep(1000);

		WebElement saveEntryPhase1 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[4]/button[1]"));
		saveEntryPhase1.click();
		Thread.sleep(1000);

		// Create Phase2
		WebElement createPhase2 = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/div[1]/div"));
		createPhase2.click();
		Thread.sleep(2000);

		WebElement createPhaseName2 = driver.findElement(By.xpath("//input[@id='phaseName']"));
		createPhaseName2.click();
		createPhaseName2.sendKeys("Deadline Reached");
		Thread.sleep(1000);

		WebElement phaseType2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[1]"));
		phaseType2.click();
		Thread.sleep(1000);

//				WebElement selectPhaseTypeBasic2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[3]/ul/li[1]/span"));
//				selectPhaseTypeBasic2.click();
//				Thread.sleep(1000);

		WebElement selectPhaseTypeRealTime2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[2]/div/div/div[3]/ul/li[2]/span"));
		selectPhaseTypeRealTime2.click();
		Thread.sleep(1000);

		WebElement transitionMode2 = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]"));
		transitionMode2.click();
		Thread.sleep(1000);

//		WebElement transitionModeTargetAchieved2 = driver.findElement(By.xpath(
//				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div/div[3]/ul/li[2]/span/div/span"));
//		transitionModeTargetAchieved2.click();
//		Thread.sleep(1000);
		
		WebElement deadlineReached2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div[3]/div/div/div[3]/ul/li[1]/span"));
		deadlineReached2.click();
		Thread.sleep(1000);

		// For Basic Phase Type
//				WebElement duration = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/input"));
//				Actions actions = new Actions(driver);
//				actions.doubleClick(duration).perform();
//				duration.sendKeys("1");

		// For Real Time Phase Type
		WebElement duration2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div[1]"));
		duration2.click();
		Thread.sleep(1000);

		WebElement selectDuration2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div[3]/ul/li[2]/span/span"));
		selectDuration2.click();
		Thread.sleep(1000);

		WebElement time2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[1]"));
		time2.click();
		Thread.sleep(1000);

//				WebElement selectDHours2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/ul/li[2]/span"));
//				selectDHours.click();
//				Thread.sleep(1000);
//				
		WebElement selectDDays2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[3]/ul/li[3]/span/span"));
		selectDDays2.click();
		Thread.sleep(1000);

		WebElement checkInterval2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div/div/div[2]/div[1]"));
		checkInterval2.click();
		Thread.sleep(1000);

		WebElement checkIntervalHours2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[2]/div[3]/div/div/div[2]/div[3]/ul/li[2]/span/span"));
		checkIntervalHours2.click();
		Thread.sleep(1000);

		WebElement pauseDisabled2 = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/label[2]/span[2]"));
		pauseDisabled2.click();
		Thread.sleep(1000);

		// Success Criteria2
		WebElement SCcondition2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[1]"));
		SCcondition2.click();
		Thread.sleep(1000);

		WebElement rideCreated2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[1]/div[3]/ul/li[5]/span/span"));
		rideCreated2.click();
		Thread.sleep(1000);

		WebElement SCequation2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[1]"));
		SCequation2.click();
		Thread.sleep(1000);

		WebElement SCequation12 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[2]/div[3]/ul/li[2]/span"));
		SCequation12.click();
		Thread.sleep(1000);

		WebElement ridecreationCount2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[1]/div/div/div/div/div[2]/div[3]/input"));
		ridecreationCount2.click();
		ridecreationCount2.sendKeys("10");
		Thread.sleep(1000);

		WebElement validate2 = driver.findElement(By.xpath(
				"//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[3]/div[2]/div[2]/div"));
		validate2.click();
		Thread.sleep(1000);

		WebElement saveEntryPhase2 = driver.findElement(
				By.xpath("//*[@id=\"app\"]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[4]/button[1]"));
		saveEntryPhase2.click();
		Thread.sleep(1000);
		
		
		//Edit Links
		WebElement editLinks = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[2]"));
		editLinks.click();
		Thread.sleep(1000);
		
		WebElement startSuccess = driver.findElement(By.cssSelector("div.h-screen.bg-grey-lightest.flex.flex-col div.flex.flex-col.flex-1.overflow-y-hidden div.main-container.flex.flex-col.flex-1.overflow-y-hidden div.flex-1.flex.flex-col.overflow-y-hidden div.relative.w-full.flex.flex-1.overflow-y-hidden:nth-child(2) div.bg-white.right-0.mr-6.my-6.border.border-grey.rounded-lg.p-6.overflow-y-scroll div.mt-4:nth-child(2) div.border-4.rounded-lg.bg-white.cursor-pointer.border-blue.mini-phase-container div.flex.flex-row.gap-4.p-4.justify-around div:nth-child(1) div.flex.justify-between.items-center.gap-2.bg-green-lightest.rounded-md.py-2.px-4.text-green.cursor-pointer > div.text-sm.font-medium"));
		startSuccess.click();
		Thread.sleep(1000);
		
		WebElement targetAchieved = driver.findElement(By.cssSelector("div.h-screen.bg-grey-lightest.flex.flex-col div.flex.flex-col.flex-1.overflow-y-hidden div.main-container.flex.flex-col.flex-1.overflow-y-hidden div.flex-1.flex.flex-col.overflow-y-hidden div.relative.w-full.flex.flex-1.overflow-y-hidden:nth-child(2) div.bg-white.right-0.mr-6.my-6.border.border-grey.rounded-lg.p-6.overflow-y-scroll div.mt-4:nth-child(3) div.border-4.rounded-lg.bg-white.cursor-pointer.border-primary.mini-phase-container div.py-2.px-4.flex.justify-between.items-center.bg-primary > div.flex-1.flex.flex-row.items-center"));
		targetAchieved.click();
		Thread.sleep(1000);
		
		WebElement startFailure = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > svg:nth-child(2) > g:nth-child(2) > foreignobject:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(1) > div:nth-child(1)"));
		startFailure.click();
		Thread.sleep(1000);
		
		WebElement deadlineReached = driver.findElement(By.xpath("//body/div/div/div/div/div/div/div/div[2]/div[1]/div[1]"));
		deadlineReached.click();
		Thread.sleep(1000);
		
		WebElement saveLinks = driver.findElement(By.xpath("//body/div/div/div/div/div/div/div[1]/div[2]"));
		saveLinks.click();
		Thread.sleep(1000);
		
		WebElement dashBoard = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div[1]/a/img"));
		dashBoard.click();
		Thread.sleep(1000);
		
		WebElement markasReady = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[2]/div[1]/div/div[9]/div/div[1]/div[1]"));
		markasReady.click();
		Thread.sleep(1000);
		
		WebElement Confirmation = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
		Confirmation.click();
		Thread.sleep(1000);
		
		
//		//Edit Loop
//		WebElement viewMenu2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div[9]/div/div[2]/i"));
//		viewMenu2.click();
//		Thread.sleep(2000);
//		WebElement editLoop = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div[9]/div/div[2]/div/div[2]"));
//		editLoop.click();
//		Thread.sleep(2000);
		
//		//Duplicate Campaign
//		WebElement viewMenu3 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div[9]/div/div[2]/i"));
//		viewMenu3.click();
//		Thread.sleep(2000);
//		WebElement duplicateCampaign = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div[9]/div/div[2]/div/div[3]"));
//		duplicateCampaign.click();
//		Thread.sleep(2000);
//		
//		//Mark as Ready
//		WebElement markasReady = driver.findElement(By.xpath(""));
//		markasReady.click();
//		Thread.sleep(2000);
//		
//		//Cancel Loop
//		WebElement cancelLoop = driver.findElement(By.xpath(""));
//		cancelLoop.click();
//		Thread.sleep(2000);
		
//		// Subjects
//		WebElement viewSubject = driver.findElement(By.xpath("//header/div[1]/div[1]/a[2]/div[1]/span[2]/span[1]"));
//		viewSubject.click();
//		Thread.sleep(2000);
//		
//		//Appeals
//		WebElement viewAppeals = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/header/div[1]/div[1]/a[3]/div/span[2]/span"));
//		viewAppeals.click();
//		Thread.sleep(2000);
		
		
	}
}

//
//WebElement  = driver.findElement(By.xpath(""));
//.click();
//Thread.sleep(1000);




