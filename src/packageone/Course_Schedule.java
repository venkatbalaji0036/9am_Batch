package packageone;


import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Course_Schedule extends Globals{
	
	WebDriver driver = new FirefoxDriver();
	//WebDriver driver = new ChromeDriver();
/*	if(valufromExcel.equal("Chrome")) {
		WebDriver driver = new ChromeDriver();
	}else if(valufromExcel.equal("Firefox")) {
		WebDriver driver = new FirefoxDriver();
	}else if()*/
	
	By StudentNameObj = By.id("input_9_1");
	By StudentEmailObj = By.name("input_2");
	By StudentPhoneNumberObj = By.xpath("//input[@id='input_9_3']");
	By ModeOfTrainingObj = By.id("input_9_5");
	By StudentStateObj = By.name("input_16");
	By SubmitButtonObj = By.id("gform_submit_button_9");
	By HeaderErrorObj = By.className("validation_error");
	By FieldErrorObj = By.xpath("//div[@class='gfield_description validation_message']");
	By PopUpObj = By.xpath("//*[@class='snp-overlay snp-overlay-show']");
	
	@Test
	public void Student_Enrollement() throws InterruptedException {
		driver.findElement(StudentNameObj).sendKeys(MapData.get("Student_Name"));
		driver.findElement(StudentEmailObj).sendKeys(MapData.get("Student_Email_ID"));
	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(StudentPhoneNumberObj).sendKeys(MapData.get("Student_Phone_Number"));
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		//Thread.sleep(10000);
		WebElement Mode_Of_Training = driver.findElement(ModeOfTrainingObj);
		Select MOT = new Select(Mode_Of_Training);
		MOT.selectByVisibleText(MapData.get("Mode_Of_Training"));
		
		driver.findElement(StudentStateObj).sendKeys(MapData.get("Student_State"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Submit_Button = driver.findElement(SubmitButtonObj);
		js.executeScript("arguments[0].scrollIntoView();", Submit_Button);
		Thread.sleep(5000);
		
		
		WebElement PopUp = driver.findElement(PopUpObj);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PopUp);
		Thread.sleep(2000);
		
		//driver.findElement(By.id("gform_submit_button_9")).click();
		driver.findElement(SubmitButtonObj).sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		String Error_Header = driver.findElement(HeaderErrorObj).getText();
		System.out.println(Error_Header);
		if(Error_Header.equals("There was a problem with your submission. Errors have been highlighted below.")) {
			System.out.println("Error at header is as per the requirement");
		}else {
			System.out.println("Error at header is not as per the requirement");
		}
		Thread.sleep(3000);
		String Error_Field = driver.findElement(FieldErrorObj).getText();
		System.out.println(Error_Field);
		if(Error_Field.equals("This field is required.")) {
			System.out.println("Error at field is as per the requirement");
		}else {
			System.out.println("Error at field is not as per the requirement");
		}
		
	}
	
	@BeforeTest
	public void Navigate() throws InterruptedException {
		driver.get("https://nareshit.in/course-schedule/");
		//driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		//driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		//driver.navigate().to("http://dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/");
		//driver.get("https://nareshit.in/");
		//Thread.sleep(8000);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
	}
	
	public void ScreenShot() throws IOException {
		TakesScreenshot TSS = ((TakesScreenshot)driver);
		File Screen_shot =TSS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screen_shot, new File("C:\\Users\\Satish\\eclipse-workspace\\Sample_Project\\Screen_Shots\\NarwshIT.png"));
	}
	
	@AfterTest
	public void Close_WebPage() {
		driver.quit();
	}
	
	@Test
	public void WebTable() throws InterruptedException {
		
		driver.findElement(By.xpath("(//*[text()='Course'])[1]")).click();
		Thread.sleep(2000);
		WebElement Courses = driver.findElement(By.xpath("//th[text()='Course']"));
		Scroll(Courses);
		PopUp_Click();
		List<WebElement> All_Courses = driver.findElements(By.xpath("//table[@id='tablepress-37']/tbody/tr/td[1]/b/a"));
		LinkedList<String> Display_Courses = new LinkedList<String>();
		LinkedList<String> Sort_Using_Java = new LinkedList<String>();
		
		for(int i=0;i<All_Courses.size();i++) {
			//String Value = All_Courses.get(i).getText();
			Display_Courses.add(All_Courses.get(i).getText());
		}
		System.out.println(Display_Courses);
		Sort_Using_Java.addAll(Display_Courses);
		
		Collections.sort(Sort_Using_Java);
		System.out.println(Sort_Using_Java);
		boolean flag=true;
		for(int i=0;i<Display_Courses.size();i++) {
			if(Display_Courses.get(i).equals(Sort_Using_Java.get(i))){
				continue;
			}else {
				flag=false;
				break;
			}
		}
		if(flag==true) {
			System.out.println("Sort functionality is working fine");
		}else {
			System.out.println("Sort functionality is not working fine");
		}
		
		System.out.println("=================================================================");
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("CORE JAVA");
		
		List<WebElement> Faculty = driver.findElements(By.xpath("//*[@id=\"tablepress-37\"]/tbody/tr/td[2]"));
		LinkedList<String> Faculty_Name = new LinkedList<String>();
		
		for(int i=0;i<Faculty.size();i++) {
			Faculty_Name.add(Faculty.get(i).getText());
		}
		System.out.println(Faculty_Name);
/*		
		driver.findElement(By.xpath("//*[@id=\"tablepress-37\"]/tbody/tr[3]/td[2]/../td[1]/b/a")).click();
		Thread.sleep(8000);
		
		String Current_Window = driver.getWindowHandle();
		
		LinkedList<String> Windows = new LinkedList<String>();
		Windows.addAll(driver.getWindowHandles());
		
		driver.switchTo().window(Windows.get(1));
		String value = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		System.out.println(value);
		
		driver.close();
		
		driver.switchTo().window(Current_Window);
		
		driver.quit();
*/		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void	Mouse_Hover_Actions() throws InterruptedException{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//span[text()='New Batches']")));
		act.perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='New Batches – Hyderabad']")).click();
	}
	
	public void Drag_Drop() {
		WebElement From = driver.findElement(By.xpath("//h1[contains(text(),'Block 3')]"));
		WebElement To = driver.findElement(By.xpath("//h1[contains(text(),'Block 2')]"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(From, To);
		act.perform();
		
		
	}
	
	public void CheckBox() throws InterruptedException {
		
		Scroll(driver.findElement(By.xpath("//label[text()='Option 2']")));
		driver.findElement(By.xpath("//label[text()='Option 2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='Option 3']")).click();
		
		String Before_Click = driver.findElement(By.id("check1")).getAttribute("value");
		System.out.println(Before_Click);
		driver.findElement(By.id("check1")).click();
		
		String After_Click = driver.findElement(By.id("check1")).getAttribute("value");
		
		if(Before_Click.equals("Check All") && After_Click.equals("Uncheck All")) {
			System.out.println("The values are displayed correctly");
		}else {
			System.out.println("The values are not displayed correctly");
		}
	}
	
	public void Scroll(WebElement Element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//WebElement Submit_Button = element;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(5000);
	}
	
	public void RadioButton() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Submit_Button = driver.findElement(By.xpath("//div[@class='panel-body']//div//label[@class='radio-inline'][contains(text(),'Female')]"));
		js.executeScript("arguments[0].scrollIntoView();", Submit_Button);
		Thread.sleep(5000);
		
		WebElement Gender = driver.findElement(By.xpath("//div[@class='panel-body']//div//label[@class='radio-inline'][contains(text(),'Female')]"));
		String Gender_Value = Gender.getText();
		System.out.println(Gender_Value);
		
		driver.findElement(By.xpath("//div[@class='panel-body']//div//label[@class='radio-inline'][contains(text(),'Female')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[contains(text(),'0 to 5')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Get values')]")).click();
		
		String Value = driver.findElement(By.xpath("//p[@class='groupradiobutton']")).getText();
		
		if(Value.contains(Gender_Value)) {
			System.out.println("The gender is dispalyed correctly");
		}else {
			System.out.println("The gender is not displayed correctly");
		}
	}
	
	public void PopUp_Click() throws InterruptedException{
		WebElement PopUp = driver.findElement(By.xpath("//*[@class='snp-overlay snp-overlay-show']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PopUp);
		Thread.sleep(2000);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
