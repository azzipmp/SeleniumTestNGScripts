package TestNGPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.Reporter;

import org.openqa.selenium.*;



public class TestNGFirstProgram {
 
	//public WebDriver driver = new FirefoxDriver();
	 	 
	public  WebDriver driver;
    public String baseUrl = "http://newtours.demoaut.com";
   
//     public String actual;
   //  public WebDriver driver = new FirefoxDriver();
    
   @BeforeTest
   //@Test(groups={"smoketest"})
    public void openApplication() throws InterruptedException 
    {
    //	System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
    	// 	driver = new ChromeDriver();
    	 	
    	 	
    	 	//***********************************RUNNING IN FIREFOX *************************************************
    	 		   
    	 		   
    	 		System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
    	 	 	 driver = new FirefoxDriver();
    	 		
    	 	//***********************************************************
    	 driver.get(baseUrl);
       	  Thread.sleep(5000);
    }
 
  // @Test(dependsOnMethods={"dependtest"})
   // @Test(enabled=false)
    // @Test(dependsOnMethods={"openApplication"},alwaysRun=true)
  // @Test(timeOut=5000)
   @Test(groups={"smoketest"})
   
  //@Test(priority=0)
     public void FirstTestverifyRegisterLink() throws InterruptedException 
    {
	   String expected = "Register: Mercury Tours1";
    	
    	  driver.findElement(By.linkText("REGISTER")).click();
    	
      	
    	Thread.sleep(5000);
      	  String actual = driver.getTitle();
      	  System.out.println("actual value:"+actual);
      	// Reporter.log("Testing the Register link test case ");
      	 Assert.assertEquals(actual, expected);
     	Reporter.log("Testing the Register link test case sucessfully passed");
	}
     /* 
      	 if (actual.equals(expected))
      	 {
      		 System.out.println("Testcase pass");
      	 }
      	 else
      	 {
      		
      		 System.out.println("Testcase fail");
      	 }
   	 */ 
    
    
    @AfterTest
    public void closeApplication()
    {
    	driver.close();
    	driver.quit();
    }
   	  //String expectedTitle = "Register: Mercury Tours";
   	  //String actualTitle = driver.getTitle();
   	  //Assert.assertEquals(actualTitle, expectedTitle);
	
}
