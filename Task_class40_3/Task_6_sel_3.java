package Task_class40_3;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

public class Task_6_sel_3 {
	

	static WebDriver dr;

	public static void main(String[] args) throws InterruptedException {
		browser("Edge");
		part_Work();
		
	}
	//task--a--setup multiple browser
	public static void browser(String browsername) throws InterruptedException {
		String user_directory=	System.getProperty("user.dir");
		System.out.println(user_directory);
		if(browsername.equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");
			dr = new ChromeDriver();
			dr.manage().window().maximize();
			Thread.sleep(5000);
			dr.navigate().refresh();
			Thread.sleep(3000);
			
		}
		else if(browsername.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver",
					"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\msedgedriver.exe");
				dr = new EdgeDriver();
				dr.manage().window().maximize();
				Thread.sleep(5000);
				dr.navigate().refresh();
				Thread.sleep(3000);
				
		}
		}

		public static void part_Work() throws InterruptedException{
		//Task-b--goto url
			dr.get("https://www.amazon.com/");
			dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//Task c verify url 
			String actual_url=	dr.getCurrentUrl();
			String expected_url="https://www.amazon.com/";
			System.out.println(actual_url+"this is actual url");
			if (actual_url.equals(expected_url)) {
				System.out.println("url match");
			}else {
				System.out.println("url doesn't match");
			}
			//Task--c ---get page title
		String page_title=	dr.getTitle();
		System.out.println(page_title);
	String	expected_title="";
	String actual_title= dr.getTitle();
	if(actual_title.equalsIgnoreCase(expected_title)) {
		System.out.println("page title match");
	}else {
		System.out.println("page title doesn't match");
		System.out.println(actual_title);
	}
			//Task d--hoverover account list
			WebElement ac_list= dr.findElement(By.xpath("//span[text()='Account & Lists']"));
			Actions act= new Actions(dr);
			act.moveToElement(ac_list).build().perform();
			Thread.sleep(3000);
			
			WebElement start_selling=  dr.findElement(By.xpath("//a[contains(@class,'nav-link nav-item')]/child::span[text()='Start a Selling Account']"));
			act.moveToElement(start_selling).click().build().perform();
			Thread.sleep(3000);
			//Task--e 
			
			String currentp_url=	dr.getCurrentUrl();
			String expected_currentp_url="https://music.amazon.com/?ref=nav_youraccount_cldplyr";
			System.out.println(currentp_url+"this is actual url");
			if (currentp_url.equalsIgnoreCase(expected_currentp_url)) {
				System.out.println("url match");
			}else {
				System.out.println("url doesn't match");
			}
			Thread.sleep(3000);
			String current_page_title=	dr.getTitle();
			System.out.println(current_page_title);
		String	current_expected_title="";
		
		if(current_page_title.equalsIgnoreCase(expected_title)) {
			System.out.println("page title match");
		}else {
			System.out.println("page title doesn't match");
			System.out.println(actual_title);
			dr.navigate().back();
	//Task--f//type an field***********
					WebElement search = dr.findElement(By.xpath("//form[@id='nav-search-bar-form']/descendant::input[@id='twotabsearchtextbox']"));
					search.sendKeys("Phones");
					//Task g---
					act.keyDown(Keys.CONTROL).sendKeys("c").build().perform();	//task--h
					WebElement search_go = dr.findElement(By.xpath("//form[@id='nav-search-bar-form']/descendant::input[@id='nav-search-submit-button']"));
					search_go.click();
					
		}
		}
					//Take screenshots
				public static void screenshot() throws IOException, InterruptedException {
					Date time= new Date();
					System.out.println(time);
					String dtime=time.toString().replace(" ", "_").replace(":", "_");
					
					System.out.println(dtime);
					
					File ss=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(ss, new File("C:\\Eclipse workspace\\gitpush\\Task_selenium\\Pictures\\"+ dtime+"home.jpg"));
					
		}
			
			
	
		       


}
