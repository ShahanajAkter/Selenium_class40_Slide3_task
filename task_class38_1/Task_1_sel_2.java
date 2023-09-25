package task_class38_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Task_1_sel_2 {
	static WebDriver dr;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");
		try {
			dr=new ChromeDriver();
			dr.manage().window().maximize();
			Thread.sleep(2000);
		
			dr.navigate().refresh();
			Thread.sleep(1000);
			
//go to url
			dr.get("https://www.amazon.com/");
			dr.navigate().back();
			Thread.sleep(1000);
			dr.navigate().forward();
			Thread.sleep(3000);
			String session_id= dr.getWindowHandle();
			System.out.println(session_id);
			dr.get("https://www.amazon.com/");
//verify url 
		String actual_url=	dr.getCurrentUrl();
		String expected_url="https://www.amazon.com/";
		System.out.println(actual_url+"this is actual url");
		if (actual_url.equals(expected_url)) {
			System.out.println("url match");
		}else {
			System.out.println("url doesn't match");
		}
//verify page title
		String actual_title= dr.getTitle();
		System.out.println("*******"+ actual_title+"******");
		String expected_title="Amazon.com. Spend less. Smile more.";
		if(actual_title.equals(expected_title)) {
			System.out.println("title match");
		}
		Thread.sleep(3000);
//hoverover account list
		WebElement ac_list= dr.findElement(By.xpath("//span[text()='Account & Lists']"));
		Actions act= new Actions(dr);
		act.moveToElement(ac_list).build().perform();
		Thread.sleep(3000);
		
		WebElement music_lib=  dr.findElement(By.xpath("//span[text()='Music Library']"));
		act.moveToElement(music_lib).click().build().perform();
		Thread.sleep(3000);
		
		String current_url=	dr.getCurrentUrl();
		String expected_currenturl="https://music.amazon.com/?ref=nav_youraccount_cldplyr";
		System.out.println(current_url+"this is actual url");
		if (current_url.equals(expected_currenturl)) {
			System.out.println("url match");
		}else {
			System.out.println("url doesn't match");
		}
		Thread.sleep(3000);
		try {
		WebElement library= dr.findElement(By.xpath("//*[contains(@id,'navbarMenuItem3')]"));
		act.moveToElement(library).click().build().perform();
		Thread.sleep(3000);
		WebElement music= dr.findElement(By.xpath("//*[@id=\"contextMenuOption1\"]//span[1]/div/span"));//problem in find locator
//act.moveToElement(music).click().build().perform();//10:20am for xpath,10:30am
		}                 //cntrl for new tab
		catch(Exception e) {
			System.out.println(" have to click manually");
			e.printStackTrace();
			
		}
		String currentp_url=	dr.getCurrentUrl();
		String expected_currentpurl="https://music.amazon.com/?ref=nav_youraccount_cldplyr";
		System.out.println(current_url+"this is actual url");
		if (currentp_url.equals(expected_currentpurl)) {
			System.out.println("url match");
		}else {
			System.out.println("url doesn't match");
		}
		Thread.sleep(3000);
		dr.navigate().back();
//************type an field***********
				WebElement search = dr.findElement(By.id("twotabsearchtextbox"));
				search.sendKeys("Phones");
				WebElement search_go = dr.findElement(By.id("nav-search-submit-button"));
				search_go.click();
				Thread.sleep(5000);
//get current url
				String current_page_url = dr.getCurrentUrl();
				System.out.println("This is current url***********" + current_page_url);
				Thread.sleep(2000);
				dr.navigate().back();
				
//select all drop down from Search bar
				WebElement all = dr.findElement(By.id("searchDropdownBox"));
				// all_dropdown.click();
				Thread.sleep(3000);
//Select amazon devices
				
				Select devices = new Select(all);
				devices.selectByIndex(2);
				//devices.selectByVisibleText("Amazon Devices");
				Thread.sleep(3000);
//select Amazon fresh---select by visible text
				Select amazon_fresh = new Select(all);
				amazon_fresh.selectByVisibleText("Amazon Fresh");
				Thread.sleep(3000);
//select appliances by value
				Select appliances = new Select(all);
				appliances.selectByValue("search-alias=appliances");
				Thread.sleep(3000);
				
		
	} 
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}finally {
				Thread.sleep(3000);
			
				dr.close();
			}

		}

		}