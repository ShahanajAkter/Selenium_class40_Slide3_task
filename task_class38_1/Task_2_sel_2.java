package task_class38_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task_2_sel_2 {
	static WebDriver dr;

	public static void main(String[] args) {
		System.setProperty("webdrivwe.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");

		try {
			dr = new ChromeDriver();
			dr.manage().window().maximize();
            Thread.sleep(2000);
            dr.navigate().refresh();
            dr.get("https://www.facebook.com/");//goto url
            Thread.sleep(2000);
            dr.navigate().back();//navigate back
            Thread.sleep(500);
            dr.navigate().forward();
            Thread.sleep(500);
          //compare URL/verify***********
    		String actualURL = dr.getCurrentUrl();
    		System.out.println("*********" + actualURL + "******");
    		String expectedURL = "https://www.facebook.com/";

    		if (actualURL.equalsIgnoreCase(expectedURL)) {
    			System.out.println("URL match");
    		} else {
    			System.out.println("URL doesn't match");
    			System.out.println("This is expected URL " + expectedURL);
    			System.out.println("This is actual URL " + actualURL);
    		}
    		// get page title
    		String page_title = dr.getTitle();
    		System.out.println("this is tile of page **********" + page_title);
    		Thread.sleep(2000);
    		// compare title*****

    		String expectedTitle = "Facebook - log in or sign up";
    		String currentTitle = dr.getTitle();
    		System.out.println("********" + currentTitle + "******");
    		if (currentTitle.equalsIgnoreCase(expectedTitle)) {
    			System.out.println("Tittle match");
    		} else {
    			System.out.println("Tittle doesn't match");
    			System.out.println("This is expected Tittle " + expectedTitle);
    			System.out.println("This is actual Tittle " + currentTitle);
    		}
    		Thread.sleep(2000);
    	WebElement create_account=dr.findElement(By.xpath("//*[text()='Create new account']"));
            
            create_account.click();
            Thread.sleep(2000);
            
          //type an field
			//WebElement first_name = dr.findElement(By.xpath("//input[starts-with(@id,'u_2_b_' )]"));
			WebElement first_name = dr.findElement(By.xpath("//input[@name='firstname' and @placeholder='First name']"));
			first_name.clear();
			first_name.sendKeys("Shahanaj");
			Thread.sleep(300);
			WebElement last_name = dr.findElement(By.xpath("//input[contains(@name,'lastname')]"));
			

			last_name.sendKeys("shanu");
			Thread.sleep(300);
			WebElement email = dr.findElement(By.xpath("//input[contains(@name,'reg_email__')]"));
			
			email.sendKeys("shanusaafir@gmail.com");
			Thread.sleep(1000);
			WebElement password = dr.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]"));
			
			password.sendKeys("absdf123");
			Thread.sleep(1000);
// month select by index
			WebElement birthday_month = dr.findElement(By.xpath("//select[contains(@id,'month')]"));

			Select month = new Select(birthday_month);
			month.selectByIndex(9);
			Thread.sleep(1000);
// day select by visible text
			WebElement birthday_Day = dr.findElement(By.xpath("//select[contains(@name,'birthday_day')]"));
			Select Day = new Select(birthday_Day);
			Day.selectByVisibleText("17");
			Thread.sleep(1000);
			WebElement birthday_year = dr.findElement(By.name("birthday_year"));
//year select by value
			Select year = new Select(birthday_year);
			year.selectByValue("1990");
			Thread.sleep(1000);
//redio button female
			WebElement radio_btn_female = dr.findElement(By.xpath("//label[contains(text(),'Female')]"));
			radio_btn_female.click();
			Thread.sleep(1000);
//WebElement radio_btn_male= dr.findElement(By.xpath("//label[contains(text(),'Male')]"));

//WebElement radio_btn_custom= dr.findElement(By.xpath("//label[contains(text(),'Custom')]"));

//click signup
			WebElement signup = dr.findElement(By.xpath("//button[@name='websubmit' and text()='Sign Up']"));
			signup.click();
			Thread.sleep(1000);
//re-enter password
		WebElement re_enter_pass=dr.findElement(By.xpath("//input[contains(@name,'reg_email_confirmation__')]"));
		re_enter_pass.sendKeys("absdf123");
		Thread.sleep(1000);
		signup.click();
		Thread.sleep(1000);
		dr.navigate().back();
	String session_id=	dr.getWindowHandle();
	System.out.println(session_id);
	Thread.sleep(1000);
	dr.navigate().refresh();
String current_page_title=	dr.getTitle();
System.out.println(current_page_title);
Thread.sleep(1000);
dr.navigate().forward();

		}
		

		catch (InterruptedException e) {
			System.out.println("problem in try block");
			e.printStackTrace();
		}
		finally {
			dr.close();
		}
	}

}
