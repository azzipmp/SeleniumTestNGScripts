package TestNGPackage;

import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider; 
import org.testng.annotations.Test; 

public class TestNGDataProviderTest {
	
	public class Sample_Login
	{
		WebDriver driver ; 
		
		
		@BeforeTest 
		public void openapplication() throws Exception
		{
			System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
	 	 	 driver = new FirefoxDriver();
			driver.manage().window().maximize(); 
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("http://newtours.demoaut.com/");
			}
		
		//This method will return two dimensional array.
		//This method behaves as data provider for LogIn_Test method.
		@DataProvider
		public Object[][] datavalues()
		{
			//Created two dimensional array with 4 rows and 2 columns. //4 rows represents test has to run 4 times. //2 columns represents 2 data parameters. 
			Object[][] Cred = new Object[4][2]; 
			Cred[0][0] = "UserId1"; 
			Cred[0][1] = "Pass1"; 
			Cred[1][0] = "UserId2";
			Cred[1][1] = "Pass2"; 
			Cred[2][0] = "UserId3";
			Cred[2][1] = "Pass3"; 
			Cred[3][0] = "UserId4"; 
			Cred[3][1] = "Pass4";
			return Cred; //Returned Cred 
			}
		
		@Test(dataProvider="datavalues") 
		public void LogIn_Test(String userid, String password) throws InterruptedException
		{
			driver.findElement(By.linkText("REGISTER")).click();
	 	  	Thread.sleep(2000);
			  driver.findElement(By.name("email")).sendKeys(userid);
		 	    driver.findElement(By.name("password")).sendKeys(password);
		 	    driver.findElement(By.name("confirmPassword")).sendKeys(password);
		 	    driver.findElement(By.name("register")).click();
		 	    Thread.sleep(2000);
		 	   driver.findElement(By.linkText("SIGN-OFF")).click();
			}
		
		@AfterTest 
		public void tearDown() throws Exception 
		{
			driver.quit(); 
			}
	}		

}
	
	