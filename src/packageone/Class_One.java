package packageone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class_One {
	WebDriver driver = new FirefoxDriver();
	//WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		Class_One obj = new Class_One();
		obj.Call();
	}
	
	public void Call() throws InterruptedException {
		driver.navigate().to("https://nareshit.in/course-schedule/");
		Thread.sleep(8000);
		driver.findElement(By.id("input_9_1")).sendKeys("Studentone");
		Thread.sleep(2000);

		driver.findElement(By.id("input_9_2")).sendKeys("studentone@gmail.com");
		driver.findElement(By.id("input_9_3")).sendKeys("9876543210");
		driver.findElement(By.id("input_9_16")).sendKeys("Telangana");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Submit_Button = driver.findElement(By.id("gform_submit_button_9"));
		js.executeScript("arguments[0].scrollIntoView();", Submit_Button);
		Thread.sleep(5000);
		
		
		WebElement PopUp = driver.findElement(By.xpath("//*[@class='snp-overlay snp-overlay-show']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PopUp);
		
		
		
/*		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.id("gform_submit_button_9")));
		
		
	//	WebElement PopUp = driver.findElement(By.xpath("//*[@class='bld-el snp-cursor-pointer']"));
		
		
		
		
		/*	WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='bld-el snp-cursor-pointer']")));
		PopUp.click();
		
/*		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", PopUp); 
		PopUp.click(); */
		
		Thread.sleep(2000);
		
		Submit_Button.click();
	}
}
