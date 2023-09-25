package Task_class40_3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commom_methods {
	
	static String user_direc=System.getProperty("user.dir");
	public  void ibrowser(  WebDriver driver, String browserName,String url){//browser methods	
		
		System.out.println(user_direc);
		if(browserName.equalsIgnoreCase("chrome")) {
			
	System.setProperty("webdriver.chrome.driver", user_direc+"\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
			
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", user_direc+"Drivers\\msedgedriver.exe");
			driver= new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			
		}
	}
	public  void screenshots(WebDriver driver) throws IOException {
		Date date_time=new Date();
	String time_d=	date_time.toString().replace(" ", "_").replace(":", "_");
		File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File(user_direc+"\\Pictures\\"+time_d+"home.jpg"));
	}
	public  void multiple_window_switch(WebDriver driver) {//for new window shift+click
		//for new tab ctrl+click
		//for new window
	WebElement alexa=	driver.findElement(By.linkText("Works with Alexa"));
	Actions act=new Actions(driver);
	act.keyDown(Keys.SHIFT).build().perform();
	alexa.click();
	act.keyUp(Keys.SHIFT).build().perform();
	//for new tab
	WebElement back_to_sc= driver.findElement(By.linkText("Back to School"));
	act.keyDown(Keys.CONTROL).build().perform();
	back_to_sc.click();
	act.keyUp(Keys.CONTROL).build().perform();
	//Handling child window
	driver.getWindowHandle();//its give single session id for single window
	//for parent window only
	driver.getWindowHandles();//its return sets of window in a single session
	//for every windows in single session
	Set<String> multi_win=driver.getWindowHandles();
Iterator<String> windows=	multi_win.iterator();
  String parent_win_sess_id= windows.next();
 String child_session_id=windows.next();
 
 
 //clearly
String parent=driver.getWindowHandle();
act.keyDown(Keys.CONTROL).click(alexa).build().perform();
act.keyUp(Keys.CONTROL).build().perform();
switch_to_windows(driver, parent);//call method for window handle
	
	
	
	}
 public  void switch_to_windows(WebDriver driver,String parent) {
	Set<String>window_handales= driver.getWindowHandles();
	for(String sesid:window_handales) {
		if(sesid!=parent) {
			driver.switchTo().window(sesid);
			System.out.println(sesid);
			System.out.println(parent);
		}	
	 
 }
 }
	public static void explecit_wait(WebDriver driver, WebElement elementname) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));//create the object of WebDriverWait
		//class with passing driver and giving the duration of wait for the element
		wait.until(ExpectedConditions.elementToBeClickable(elementname));
	
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Works with Alexa")));
		
		
		
		
		
	}
	
	
	
		
		
	}


