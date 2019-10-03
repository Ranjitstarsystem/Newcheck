package gitpackage;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

public class FrameworkFinal {
	public static WebDriver driver;
	public static String one;
	public static String value;
	public static String errflpath;
	public static String Location;
	
	public static void launchchrome(String url)
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	public static void launchfirefox(String url)
	{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public static void screenshot(String Value) 
	{
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try
	{
	FileUtils.copyFile(src,new File("./screenshot/"+Value+".png"));
	}
	catch(IOException e)
	{
	System.out.print(e.getMessage());
	}
	}

	public static void type(String xpath, String value)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).sendKeys(value);
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(value); 
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).sendKeys(value);
			 }
			 else
			 {
				 iwait();
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).sendKeys(value);
			 }
	}
	}
	
	public static void clear(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).clear();
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).clear(); 
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).clear();
			 }
			 else
			 {
				 iwait();
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).clear();
			 }
	}
	}
	
	public static void click(String option)
	{
		{
			 if(option.contains("$"))
			 {
				 iwait();
				 option = option.replace("$", "");
				 driver.findElement(By.name(option)).click();
				 
			 }
			 else if(option.contains("#"))
			 {
				 iwait();
				 option = option.replace("#", "");
				driver.findElement(By.id(option)).click(); 
			 }
			 else if(option.contains("~"))
			 {
				 iwait();
				 option = option.replace("~", "");
				 driver.findElement(By.className(option)).click();
			 }
			 else
			 {
				 iwait();
				 //option = option.replace("//", "");
				 driver.findElement(By.xpath(option)).click();
			 }
	}
	}
	public static void selectdropdown(String xpath, String value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.selectByVisibleText(value);
		iwait();
	}
	public static void selectdropdownvalue(String xpath, String value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.selectByValue(value);
		iwait();
	}
	public static void selectdropdownindex(String xpath, int value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.selectByIndex(value);
		iwait();
	}
	
	public static void deselectdropdown(String xpath, String value)
	{
		iwait();
		Select fcc = new Select(driver.findElement(By.xpath(xpath)));
		fcc.deselectByVisibleText(value);
		iwait();
	}
	
	public static void isdisplayed(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isDisplayed();
				
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isDisplayed(); 
				
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).isDisplayed();
				
			 }
			 else
			 {
				 iwait();
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isDisplayed();
				
			 }
         }
	}
	public static void isenabled(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isEnabled();
				
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isEnabled(); 
		
			 }
			 else if(xpath.contains("."))
			 {
				  xpath = xpath.replace(".", "");
				 driver.findElement(By.className(xpath)).isEnabled();
				
			 }
			 else
			 {
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isEnabled();
				
			 }
         }
	}
	public static void isselected(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).isSelected();
			
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).isSelected(); 
		
			 }
			 else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).isSelected();
				
			 }
			 else
			 {
				// xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isSelected();
			
			 }
         }
	}
	public static void getattribute(String xpath , String attributename, String value )
	
	{
		{
			 if(xpath.contains("$"))
			 {
				 xpath = xpath.replace("$", "");
				 String temp;
				 temp = driver.findElement(By.name(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
				 
			 }
			 else if(xpath.contains("#"))
			 {
				 xpath = xpath.replace("#", "");
				 String temp;
				 temp = driver.findElement(By.id(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
			 }else if(xpath.contains("~"))
			 {
				 xpath = xpath.replace("~", "");
				 String temp;
				 temp = driver.findElement(By.className(xpath)).getAttribute(attributename);
				 			 
				 if(temp.equals(value))
				 {
					 System.out.println("Value is Fine");
				 }else
				 {
					 System.out.println("Need to check the validation");
				 }
			 }else
			 {
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).isDisplayed();
				
			 }
        }
	}
	public static void framein(String value)
	{
		iwait();
		driver.switchTo().frame(value);
		iwait();
	}
	public static void frameout()
	{
		iwait();
		driver.switchTo().defaultContent();
		iwait();
	}
	
	
	public static String spreadsheet(String Location,int sheetvalue, int rowvalue,int cellvalue)
	{
		//Location = "D:\\Spreadsheet\\Welcome.xlsx";
	
		try
		{
			
			File src = new File(Location);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheetAt(sheetvalue);
			
			DataFormatter formattor = new DataFormatter();
			one = formattor.formatCellValue(sh.getRow(rowvalue).getCell(cellvalue));
		//	one = sh.getRow(rowvalue).getCell(cellvalue).getStringCellValue();
			//System.out.println(one);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return one;
}

	public static void typeenter(String xpath)
	{
		{
			 if(xpath.contains("$"))
			 {
				 iwait();
				 xpath = xpath.replace("$", "");
				 driver.findElement(By.name(xpath)).sendKeys(Keys.ENTER);
				 iwait();
			 }
			 else if(xpath.contains("#"))
			 {
				 iwait();
				 xpath = xpath.replace("#", "");
				driver.findElement(By.id(xpath)).sendKeys(Keys.ENTER); 
				iwait();
			 }
			 else if(xpath.contains("~"))
			 {
				 iwait();
				 xpath = xpath.replace("~", "");
				 driver.findElement(By.className(xpath)).sendKeys(Keys.ENTER);
				 iwait();
			 }
			 else
			 {
				 iwait();
				 //xpath = xpath.replace("//", "");
				 driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
			 }
	}
	}
	
	public static void iwait()
	{
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	public static void dclick(String xpath)
	{
		iwait();
		if(xpath.contains("$"))
		 {
			 xpath = xpath.replace("$", "");
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.name(xpath));
		actions.doubleClick(elementLocator).perform();
		iwait();
		 }
		else if(xpath.contains("#"))
		 {
			iwait();
			 xpath = xpath.replace("#", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.id(xpath));
				actions.doubleClick(elementLocator).perform(); 
		 }
		 else if(xpath.contains("~"))
		 {
			 xpath = xpath.replace("~", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.className(xpath));
				actions.doubleClick(elementLocator).perform();
		 }
		 else
		 {
			 //xpath = xpath.replace("//", "");
			 Actions actions = new Actions(driver);
				WebElement elementLocator = driver.findElement(By.xpath(xpath));
				actions.doubleClick(elementLocator).perform();
		 }
	}
		public static String geturl(String value)
		{
			value = driver.getCurrentUrl();
		
		return geturl(value);
		}

		public static void dd(String one, String two )
		{
			WebElement from = driver.findElement(By.xpath("+one+"));
			WebElement	To = driver.findElement(By.xpath("+two+"));
			
			Actions drag = new Actions(driver);
			drag.dragAndDrop(from,To).build().perform();
		}
		public static void tab(String windowHandle1)
		{
			windowHandle1 = driver.getWindowHandle();
			driver.switchTo().window(windowHandle1);
			
		}
		public static String capture(WebDriver driver) throws IOException 
		{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:/SS/" + System.currentTimeMillis()
		+ ".png");
//		errflpath = Dest.getAbsolutePath();
//		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}
		public static String sheetin(int sheetvalue, int rowvalue,int cellvalue)
		{
		try
			{
				
				File src = new File(Location);
				FileInputStream fis = new FileInputStream(src);
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sh = wb.getSheetAt(sheetvalue);
				
				DataFormatter formattor = new DataFormatter();
				one = formattor.formatCellValue(sh.getRow(rowvalue).getCell(cellvalue));
			//	one = sh.getRow(rowvalue).getCell(cellvalue).getStringCellValue();
				//System.out.println(one);
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			return one;
	}
		public static String sheetout(int sheetvalue, int rowvalue,int cellvalue, String message) throws IOException
		{
		try
			{
			File src = new File(Location);			 // Write data in the excel.
			FileInputStream fis = new FileInputStream(Location);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
		    
			// Specify the message needs to be written.
			
			XSSFSheet sheet = workbook.getSheetAt(sheetvalue);
			// Create cell where data needs to be written.
			sheet.getRow(rowvalue).createCell(cellvalue).setCellValue(message);
			 
			// Specify the file in which data needs to be written.
		    FileOutputStream fileOutput = new FileOutputStream(src);
		    
		    // finally write content
		    workbook.write(fileOutput);
		    // close the file
		            fileOutput.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
			return one;
		}
}
