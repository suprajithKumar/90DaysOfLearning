package testCasesFirst15;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		//LAUNCH BROWSER
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//FETCH URL
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//MOUSE HOVER ON WOMEN
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElementByLinkText("Women")).perform();
		Thread.sleep(5000);
		//CLICK ON JACKETS & COATS CUM TOTAL COUNTS
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
		String str = driver.findElementByClassName("title-count").getText(); 
		String text = str.replaceAll("\\D","");
		int totalCount = Integer.parseInt(text);
		System.out.println(totalCount);
		String jacket = driver.findElementByXPath("//label[text()='Jackets']").getText();
		String jacketCount = jacket.replaceAll("\\D","");
		int totalJacketCounts = Integer.parseInt(text);
		System.out.println(totalJacketCounts);
		String coat = driver.findElement(By.xpath("//label[text()='Coats']")).getText();
		String coatCount = coat.replaceAll("\\D","");
		int totalCoatCounts = Integer.parseInt(text);
		System.out.println(totalCoatCounts);
		//VALIDATION
		if ((totalJacketCounts+totalCoatCounts)== totalCount) {
			System.out.println("Verify total count of items are equal");
			}
		//CHECK COATS
		driver.findElement(By.xpath("//label[text()='Coats']")).click();
		//CLICK MORE OPTION & SELECTING PARTICULAR BRAND
		driver.findElement(By.xpath("//div[text()='59']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("MANGO");
		Thread.sleep(3000);
		//POPUP CLOSE
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div[1]")).click();
		//ALL COATS ARE PARTICULAR BRAND
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite FilterDirectory-close')]")).click();
		List<WebElement> brandName = driver.findElementsByXPath("(//span[@class='vertical-filters-header'])[2]");
		for (WebElement name : brandName) {
			String nameMango = name.getText();
		if (nameMango.equalsIgnoreCase("MANGO")) {
			System.out.println("brand name is MANGO");
		}	
		}
		//SORTING BY BETTER DISCOUNT
		action.moveToElement(driver.findElement(By.className("sort-sortBy"))).perform();
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		//TO FIND PRICE OF FIRST DISPLAYED
		List<WebElement> firstItem = driver.findElementsByXPath("(//img[@alt='MANGO Women Orange Solid Double-Breasted Longline Overcoat'])[2]");
		String firstitemprice = firstItem.get(0).getText();
		System.out.println("Price of first displayed coat is: " + firstitemprice);
		//MOUSEHOVER ON FIRST ITEM 
		action.moveToElement(driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]")).perform();
		driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']").click();
		//CLOSING BROWSER
		driver.close();
			
		}
		
		

		
	}


