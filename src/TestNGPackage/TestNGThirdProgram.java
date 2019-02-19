package TestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGThirdProgram {
	public WebDriver driver;
    public String baseUrl = "http://newtours.demoaut.com";
    public String regexpected = "Register: Mercury Tours";
     public String actual;
     public String userexpected = "Your user name is Test@test.com.";  
     
    @BeforeTest
    public void openApplication() throws InterruptedException
    {
    	 System.out.println( "Before Test");
    	//***********************************RUNNING IN FIREFOX *************************************************
		   
		   
	 		System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
	 	 	 driver = new FirefoxDriver();
	 		
	 	//***********************************************************
	 driver.get(baseUrl);
	  Thread.sleep(5000);
    	 
    }    
    
  //    @Test(dependsOnMethods={"openApplication"})
    //@Test(enabled=false)
    // @Test(dependsOnMethods={"openApplication"},alwaysRun=true)
    //@Test(timeOut=5000)
    //@Test(groups={"smoketest"})
    
    @BeforeMethod
    public void executebeforecallingmethod()
    {
    	System.out.println( "Before method");
    //	driver.findElement(By.linkText("Home")).click();
    }
    
    
    @AfterMethod
    public void executeaftercallingmethod()
    {
    	System.out.println( "After method");
    	
    }
   
    @Test(priority=0)
  // @Test(groups={"smoketest"})
    // VERIFYING THE REGISTER LINK
     public void verifyRegisterLink() throws InterruptedException
    {
    	System.out.println( "Test 1: Verify register link test");
    	  driver.findElement(By.linkText("REGISTER")).click();
      	   Thread.sleep(5000);
      	   actual = driver.getTitle();
      	 Assert.assertEquals(actual, regexpected);
      	  Thread.sleep(5000);
   	  //return actual;
    }
    
    
     
    @Test(groups={"smoketest"})
   // @Test(priority=1)
    // VERIFYING THE USER REGISTRATION
    public void userRegistration() throws InterruptedException 
    {
    	 System.out.println( "Test 2: verify user registration test");
    	   driver.findElement(By.linkText("REGISTER")).click();    
    	   driver.findElement(By.name("firstName")).sendKeys("Testfirstname");
	 	  	driver.findElement(By.name("lastName")).sendKeys("Testlastname");
	 	  	driver.findElement(By.name("phone")).sendKeys("8888888889");
	 	  	driver.findElement(By.name("userName")).sendKeys("testusername");
	 	  	driver.findElement(By.name("address1")).sendKeys("testaddress");
	 	  	driver.findElement(By.name("address2")).sendKeys("testaddress2");
	 	  	driver.findElement(By.name("city")).sendKeys("Herndon");
	 	  	driver.findElement(By.name("state")).sendKeys("Va");
	 	  	driver.findElement(By.name("postalCode")).sendKeys("23456");
	 	  	Select drpcountry = new Select(driver.findElement(By.name("country")));
	 	    drpcountry.selectByVisibleText("UNITED STATES");
	 	   driver.findElement(By.name("email")).sendKeys("Test@test.com");
	 	   driver.findElement(By.name("password")).sendKeys("Test1234$");
	 	   driver.findElement(By.name("confirmPassword")).sendKeys("Test1234$");
	 	   driver.findElement(By.name("register")).click();
	 	   Thread.sleep(2000);
	 	 String  sActualValue=driver.findElement(By.tagName("Body")).getText();
	 	System.out.println( "check the actual value:"+sActualValue);
	 	  // System.out.println( "check user registrion:"+sActualValue.contains(sExpected));
	// 	  Assert.assertTrue( sActualValue.contains(sExpected), "Checking the User Registration");
	 	   Assert.assertTrue(sActualValue.contains(userexpected));   
	 	 
    }      
    
    @AfterTest
    public void closeApplication()
    {
    	System.out.println( "After Test");
    	driver.close();
    	driver.quit();
    	
    }
   	  //String expectedTitle = "Register: Mercury Tours";
   	  //String actualTitle = driver.getTitle();
   	  //Assert.assertEquals(actualTitle, expectedTitle);
    
    
}