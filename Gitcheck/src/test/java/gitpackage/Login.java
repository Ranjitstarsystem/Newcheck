package gitpackage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Login extends FrameworkFinal {

	public static String customerurl;
	public static String joburl;
	public static String workaddress;
	public static String wjoburl;
	public static String supplier;
	public static String dashboard;
	public static String companyurl;
	public static int supinvoice = 70;
	public static ExtentHtmlReporter report ;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ITestResult results;
	
	@BeforeClass
	public static void startTest()
	{
		report = new ExtentHtmlReporter("D:/Reports/SmokeTest.html");
		extent = new ExtentReports();
		extent.attachReporter(report);
		logger = extent.createTest("Result");
		 report = new ExtentHtmlReporter("D:/Reports/SmokeTest.html");
		 extent = new ExtentReports();	
		 extent.attachReporter(report);
		logger= extent.createTest("Smoke Test");

	}
	@AfterClass
	public static void endTest()
	{
		extent.flush();
	}
	
	@AfterMethod
	public static void elogin(ITestResult result)
	{
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	logger.log(Status.FAIL,logger.addScreenCaptureFromPath( capture(driver)) +"  Method Name:- " + result.getName());
	System.out.println("Error Occurs in The Method:- " +result.getName());
	} 
	catch (Exception e)
	{
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	if(ITestResult.SUCCESS == result.getStatus())
	{
		logger.log(Status.PASS,"Method been executed successfully Method Name:- " +result.getName());
		System.out.println("Method been executed successfully Method Name:- " +result.getName());
		
	}
	}
	
	
	@Test(priority = 0)
	public static void login() throws InterruptedException, IOException 
	{
		//Login
		launchchrome("https://stage.commusoft.net");
		iwait();
		type("#logintype_clientid","17845");
		type("#logintype_username","ranjit");
		type("#logintype_password","welcome123");
		iwait();
		click("//span[@ng-hide='saving']");
		Thread.sleep(4000);
		dashboard = driver.getCurrentUrl();
		Thread.sleep(4000); 
//		test.log(LogStatus.PASS, "Logged in Successfully on stage");
//		test.log(LogStatus.INFO, "LOgIn INFO:- 16833 user Ranjit/welcome123");
		
	}

	
	@Test(priority = 1)
	public static void Create_customer() throws InterruptedException
	{
		//Create Customer
				iwait();
				click("#customertypecustomer");
				selectdropdown("//select[@id='customertype_contacts_settingsTitlesid']","Mr");
				type("#customertype_contacts_name","Roman");
				type("#customertype_contacts_surname","Regins");
				type("#customertype_contacts_contactstelephone_1_telephonenumber","9856325698");
				type("#customertype_contacts_contactstelephone_0_telephonenumber","9856326598");
				type("#customertype_contacts_contactsemail_emailaddress","checkingvalidation");
				iwait();
				isdisplayed("//span[text()='Invaild email format ex: demo@gmail.com']/..");
				clear("#customertype_contacts_contactsemail_emailaddress");
				iwait();
				type("#customertype_contacts_contactsemail_emailaddress","ranjit@commusoft.co.uk");
				type("#customertype_addressline1","Madurai One");
				type("#customertype_addressline2","Madurai2");
				type("#customertype_town","Madurai JILLA");
			//	type("#customertype_county","Madurai");
				click("//span[@ng-hide='saving']");
				Thread.sleep(9000);
				customerurl = driver.getCurrentUrl();
				Thread.sleep(4000);
//				test.log(LogStatus.PASS, "Customer Created Successfully");
//				test.log(LogStatus.INFO, "Customer URL:-" + customerurl);
//				
	}
}
