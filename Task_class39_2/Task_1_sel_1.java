package Task_class39_2;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Task_1_sel_1 {
	static WebDriver dr;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse workspace\\gitpush\\Task_selenium\\Drivers\\chromedriver.exe");
		dr = new ChromeDriver();
		
		dr.manage().window().maximize();
		dr.navigate().refresh();
		Thread.sleep(3000);
//goto url
		dr.get("https://www.amazon.com");
		dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		dr.navigate().back();
		//Thread.sleep(3000);
		dr.navigate().forward();
		String sessionId = dr.getWindowHandle();
		System.out.println(sessionId);
//compare URL/verify***********
		String actualURL = dr.getCurrentUrl();
		System.out.println("*********" + actualURL + "******");
		String expectedURL = "https://www.amazon.com/";

		if (actualURL.equalsIgnoreCase(expectedURL)) {
			System.out.println("URL match");
		} else {
			System.out.println("URL doesn't match");
			System.out.println("This is expected URL " + expectedURL);
			System.out.println("This is actual URL " + actualURL);
		}
//************click an element********
		WebElement bestseller = dr.findElement(By.linkText("Best Sellers"));
		bestseller.click();
		//Thread.sleep(2000);

//get current url & print
		String current_url = dr.getCurrentUrl();
		System.out.println("This is current url***********" + current_url);
		//Thread.sleep(2000);
//click on new realeses
		WebElement new_realeses = dr.findElement(By.linkText("New Releases"));
		new_realeses.click();
		//Thread.sleep(2000);

// get page title
		String page_title = dr.getTitle();
		System.out.println("this is tile of page **********" + page_title);
		//Thread.sleep(2000);
		// compare title*****

		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		String currentTitle = dr.getTitle();
		System.out.println("********" + currentTitle + "******");
		if (currentTitle.equals(expectedTitle)) {
			System.out.println("Tittle match");
		} else {
			System.out.println("Tittle doesn't match");
			System.out.println("This is expected Tittle " + expectedTitle);
			System.out.println("This is actual Tittle " + currentTitle);
		}
		//Thread.sleep(2000);
//************type an field***********
		WebElement search = dr.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("Phones");
		WebElement search_go = dr.findElement(By.id("nav-search-submit-button"));
		search_go.click();
		//Thread.sleep(5000);
//get current url
		String current_page_url = dr.getCurrentUrl();
		System.out.println("This is current url***********" + current_page_url);
		//Thread.sleep(2000);
//press back button
		dr.navigate().back();
		//Thread.sleep(2000);
//select all drop down from Search bar
		WebElement all_dropdown = dr.findElement(By.id("searchDropdownBox"));
		// all_dropdown.click();
		//Thread.sleep(3000);
//select alexa-skills---select by index
		Select alexa = new Select(all_dropdown);
		alexa.selectByIndex(1);
		//Thread.sleep(3000);
//Select amazon devices
		WebElement all_dr_AmazonD = dr.findElement(By.id("searchDropdownBox"));
		Select devices = new Select(all_dr_AmazonD);
		devices.selectByVisibleText("Amazon Devices");
		//Thread.sleep(3000);
//select amazon pharmacy
		WebElement all_d_Amazon_par = dr.findElement(By.id("searchDropdownBox"));
		Select pharmacy = new Select(all_d_Amazon_par);
		pharmacy.selectByValue("search-alias=amazon-pharmacy");
		//Thread.sleep(3000);
		screenshot();
		//Thread.sleep(3000);
		screenshot();
	}
		//Take screenshots
	public static void screenshot() throws IOException, InterruptedException {
		Date time= new Date();
		System.out.println(time);
		String dtime=time.toString().replace(" ", "_").replace(":", "_");
		
		
		System.out.println(dtime);
		
		
		File ss=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss, new File("C:\\Eclipse workspace\\gitpush\\Task_selenium\\Pictures\\"+ dtime+"home.jpg"));
		//Thread.sleep(3000);
//current window close
		dr.close();

	}
}