package Utils;
import java.util.*;  
import java.io.*;


import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;

public class Logic_Utils extends HomePage {
	Logic_Utils utils_obj=new Logic_Utils();
	HomePage page= new HomePage();
	WebDriver driver=null;
	String path;
	String chromedriver;
	String driver_path;
	String url;
	String browser;
	public void read_properties(String pro_name)throws Exception{  
		path=System.getProperty("user.dir");
		FileReader reader=new FileReader(path+"/src/test/resources/Properties/config.properties"); 	      
		Properties p=new Properties();  
		p.load(reader);  	      
		url=p.getProperty("url");
		browser=p.getProperty("browser");
		chromedriver=p.getProperty("chromedriver");
		driver_path=p.getProperty("driver_path");


	}  
	public void open_browser(String browsertype) {
		try {
			if(browser.equals(browsertype)) {
				System.setProperty(chromedriver, path+driver_path);
				driver= new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
		} catch (Exception e) {
			utils_obj.takeScreenShot("open_browser");
			e.printStackTrace();
		}
	}

	public void navigate_url() {
		try {
			driver.navigate().to(url);
			if(driver.getCurrentUrl().equals(url)) {
				assert true;
			}
			else {
				utils_obj.takeScreenShot("navigate_url");
				assert false;
			}
		} catch (Exception e) {
			utils_obj.takeScreenShot("navigate_url");
			e.printStackTrace();
		}
	}

	public void send_value( By id,String value) {
		try {
			driver.findElement(id).sendKeys(value);
		} catch (Exception e) {
			utils_obj.takeScreenShot("send_value");
			e.printStackTrace();
		}
	}

	public String get_value( By id) {
		String value="";
		try {
			value=driver.findElement(id).getText();
		} catch (Exception e) {
			utils_obj.takeScreenShot("get_value");
			e.printStackTrace();
		}
		return value;


	}

	public void verify_currency_value_isNot_zero(String expected_value) {
		try {
			List<WebElement> li=driver.findElements(By.xpath(page.getValue_xpath()));
			int count=li.size();
			for(int i=0;i<=count;i++) {			
				String actual_value=driver.findElement(By.xpath(page.getValue_xpath()+"["+i+"]")).getText();
				if(actual_value.length()>(expected_value.length())) {
					assert true;
				}
				else 
				{
					utils_obj.takeScreenShot("verify_currency_value_isNot_zero");
					assert false;
				}
			}
		} catch (Exception e) {
			utils_obj.takeScreenShot("verify_currency_value_isNot_zero");
			e.printStackTrace();
		}


	}
	public void verify_currency_format() {
		try {
			List<WebElement> li=driver.findElements(By.xpath(page.getValue_xpath()));
			int count=li.size();
			String right_value;
			for(int i=0;i<=count;i++) {			
				right_value=driver.findElement(By.xpath(page.getValue_xpath()+"["+i+"]")).getText();
				if(right_value.contains("$")) {
					assert true;
				}
				else 
				{
					utils_obj.takeScreenShot("verify_currency_format");
					assert false;
				}
			}
		} catch (Exception e) {
			utils_obj.takeScreenShot("verify_currency_format");
			e.printStackTrace();
		}
	}

	public void verify_count_of_values(int actual_value) {
		try {
			List<WebElement> li=driver.findElements(page.getTxt_ttl_values());
			if(li.size()==actual_value) {
				assert true;

			}
			else {
				utils_obj.takeScreenShot("verify_count_of_values");
				assert false;
			}
		} catch (Exception e) {
			utils_obj.takeScreenShot("verify_count_of_values");
			e.printStackTrace();
		}
	}
	public void verify_value(By id,String expected_value) {
		try {
			String actual_value=utils_obj.get_value(id);
			if(actual_value.length() > expected_value.length()) {
				assert true;
			}
			else 
			{
				utils_obj.takeScreenShot("verify_value");
				assert false;
			}
		} catch (Exception e) {
			utils_obj.takeScreenShot("verify_value");
			e.printStackTrace();
		}
	}
	public String sum_of_values() {
		String return_value="";
		try {
			List<WebElement> li=driver.findElements(By.xpath(page.getValue_xpath()));
			int count=li.size();
			String sum="";
			for(int i=0;i<=count;i++) {			
				String right_value=driver.findElement(By.xpath(page.getValue_xpath()+"["+i+"]")).getText();
				String[] value=right_value.split("$");
				sum=sum+value[0];
			}
			return_value=sum+"$";
		} catch (Exception e) {
			utils_obj.takeScreenShot("sum_of_values");
			e.printStackTrace();
		}
		return return_value;

	}

	public void verify_sumValues_with_TotalBalance() {
		try {
			String totalBalnce_value=utils_obj.get_value(page.getTxt_lbl_ttl_val());
			String sum_of_values=utils_obj.sum_of_values();
			if(totalBalnce_value.equals(sum_of_values)) {
				assert true;
			}
			else {
				utils_obj.takeScreenShot("verify_sumValues_with_TotalBalance");
				assert false;
			}

		} catch (Exception e) {
			utils_obj.takeScreenShot("verify_sumValues_with_TotalBalance");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void takeScreenShot(String screenShotName) {
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("./ScreenShot/"+screenShotName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
