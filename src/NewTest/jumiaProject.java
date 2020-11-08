package NewTest;


import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jumiaProject 
{
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		// Open Chrome Browser then maximize browser
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//Open Jumia Webpage
		driver.get("https://www.jumia.com.eg/");
		
		//Close Ads window
		driver.findElement(By.xpath("//*[@class='cls']")).click();
		
		//Press on Login Btn using mouse action
		WebElement logindrop = driver.findElement(By.xpath("//*[@class='trig -df -i-ctr -fs16']"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(logindrop).click().build().perform();
		
		// Select "Create an account"
		WebElement signUpBtn = driver.findElement(By.xpath("//a[@class='btn _def -mbm -mtl']"));
		signUpBtn.click();
		
		// Fill all Registration data
		System.out.println("Enter your First Name: ");
		Scanner s = new Scanner(System.in);
		String firstname = s.nextLine();
		
		driver.findElement(By.xpath("//*[@id='fi-firstName']")).sendKeys("autcust_" + firstname);
		Thread.sleep(2000);
		
		System.out.println("Enter your Last Name: ");
		String lastname = s.nextLine();
		driver.findElement(By.xpath("//*[@id='fi-lastName']")).sendKeys("autcust_" + lastname);	
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='fi-email']")).sendKeys("autcust_" + firstname + "@gmail.com");	
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='fi-password']")).sendKeys("12345678");		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@for='fi-terms']")).click();
		Thread.sleep(2000);
		
		// Scroll down till "Create Account" button appeared clearly
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,80)");

		Thread.sleep(1500);
		
		// Press on "Create Account" btn
        List <WebElement> btn = driver.findElements(By.xpath("//button[contains(text(),'CREATE ACCOUNT')]"));
		btn.get(0).click();
		
		// Close Ads window
		driver.findElement(By.xpath("//header/section[1]/div[1]/div[1]/a[1]/*[1]")).click();
		
		// Select Jumia HomePage
		driver.findElement(By.xpath("//body/div[@id='jm']/div[3]/button[1]/span[1]/*[1]")).click();
		
		// Select SuperMarket Category
		driver.findElement(By.xpath("//a[@class='itm']")).click();
		
		// Wait till new page loaded then scroll down till first item appeared clearly
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,150)");
        
        // Select first item "Rice"
        driver.findElement(By.xpath("//body/div[@id='jm']/main[1]/section[1]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]/img[1]")).click();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
        // Refresh new page then scroll down till first item in the page appeared clearly
        driver.navigate().refresh();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,250)");
        
        // Select first item "Aldoha Egyptain Rice"
        driver.findElement(By.xpath("//body/div[@id='jm']/main[1]/div[2]/div[2]/section[1]/div[1]/article[1]/a[1]/div[1]/img[1]")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(1500);
        
        // Press on "Add to cart" button
        driver.findElement(By.xpath("//body/div[@id='jm']/main[1]/div[2]/section[1]/div[1]/div[2]/div[3]/div[1]/form[1]/button[1]")).click();
        
        //isDisplayed() method returns boolean value either True or False
        // Check that "1 item added" sentence is appeared 
        Boolean Display = driver.findElement(By.xpath("//body/div[@id='jm']/main[1]/div[2]/section[1]/div[1]/div[2]/div[3]/div[1]/form[1]/p[1]")).isDisplayed();
        //To print the value
        System.out.println("Item added to cart successfully :"+Display);
        
        // Open Cart then check that right selected item "Egyptain Rice - 5KG" added successfully
        driver.findElement(By.xpath("//header/section[1]/div[1]/div[2]/a[1]")).click();
        Boolean d1 = driver.findElement(By.xpath("//a[contains(text(),'Egyptian Rice – 5 Kg')]")).isDisplayed();
        System.out.println("Cart has selected item:" +d1);
        
	}	
}
