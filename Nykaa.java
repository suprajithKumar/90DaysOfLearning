package testCasesFirst15;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa {
	
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		
		//LAUNCHING BROWSER
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disableNotifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//MOUSE HOVER BRANDS & POPULAR
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		Actions action = new Actions(driver);
		action.moveToElement(brands).perform();
		action.moveToElement(driver.findElementByXPath("//a[text()='Popular']")).perform();
		
		
		//CLICK ON L'OREAL PARIS
		driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']").click();
		
		
		//WINDOW SWITCH & TITLE CHECK
		Set<String> winset = driver.getWindowHandles();
		ArrayList<String> winlist = new ArrayList <String>(winset);
		driver.switchTo().window(winlist.get(1));
		
		String title = driver.getTitle();
		if (title.contains("Paris")) {
			System.out.println("title is correct");
		}else {
			System.out.println("title is incorrect");
		}
		
		
		//CLICK ON SORT
		driver.findElementByXPath("//span[text()='Sort By : ']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
			
		
		
		//CLICK CATEGORY & SHAMPOO
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Category']"))).click();
		/*
		 * driver.findElementByXPath("//button[text()='Maybe later']").click();
		 * driver.findElementByXPath("//div[text()='Category']").click();
		 */
		driver.findElementByXPath("//span[text()='Shampoo (16)']/following::label[19]").click();
		
		
		//CHECK FILTER IS APPLIED
		String text = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']/li").getText();
		if (text.contains("Shampoo")) {
			System.out.println("filter is applied with Shampoo");
		}else {
			System.out.println("filter is not applied with Shampoo");
		}
		
		
		//CLICK ON MENTIONED SHAMPOO
		driver.findElementByXPath("(//div[@class='product-list-box card desktop-cart'])[2]").click();
		Set<String> windowHandling1 = driver.getWindowHandles();
		ArrayList<String> windowList = new ArrayList<String> (windowHandling1);
		driver.switchTo().window(windowList.get(2));
		
		
		//CLICK ON 175ml 
		driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();
		String price = driver.findElementByXPath("(//div[@class='clearfix m-content__product-list__price'])[1]").getText().replaceAll("\\D","");
		System.out.println("MRP  " +price);
		
		
		//CLICK ON ADD TO BAG
		driver.findElementByXPath("(//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  '])[1]").click();
		
		
		//CLICK ON SHOPPING BAG
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		
		
		//PRINT GRAND TOTAL
		String grandTotal = driver.findElementByXPath("(//div[@class='value'])[4]").getText().replaceAll("\\D","");
		System.out.println("grandtotal  "+grandTotal);
		
		//CLICK ON PROCEED
		driver.findElementByXPath("//span[text()='Proceed']").click();
		
		
		//CLICK ON CONTINUE AS GUEST
		driver.findElementByXPath("(//button[@type='button'])[2]").click();
		
		
		//PRINT WARNING MESSAGE
		String warningMessage = driver.findElementByXPath("//div[@class='message']").getText();
		System.out.println(warningMessage);
		
		
		//CLOSING ALL WINDOWS
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
