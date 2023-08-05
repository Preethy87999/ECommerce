package com.simplilearn.ECommerceTest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Application {
	ChromeDriver driver;
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public void testEcommerce() throws InterruptedException  {
		driver.get("https://www.amazon.in/");
	    driver.findElement(By.partialLinkText("Ele")).click();
	    System.out.println("URL : "+driver.getCurrentUrl());
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iph");
	   Thread.sleep(2000);
		
	  List<WebElement> lineLists =  driver.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
	   for(WebElement linelist : lineLists) {
		   if(linelist.getText().equalsIgnoreCase("iphone 13")) {
			   linelist.click();
			    break;
		   } 
	   }
	   System.out.println(driver.getTitle());
	  
			 driver.findElement(By.xpath("//div/h2/a/span[@class='a-size-medium a-color-base a-text-normal']")).click();
			 String data =  driver.findElement(By.xpath("//div/h2/a/span")).getText();
			 System.out.println(data);
			  
			 Set<String> windows = driver.getWindowHandles();
			 Iterator<String>it = windows.iterator();
			 String parentId = it.next();
			 String childId = it.next();
			 
			 driver.switchTo().window(childId);
			 System.out.println("Child tab url : "+driver.getCurrentUrl());
			 System.out.println(driver.findElement(By.id("title")));
			 
	   JavascriptExecutor js = (JavascriptExecutor)driver; 
	   js.executeScript("window.scroll(0,5000)");
	   Thread.sleep(3000);
		
	   driver.switchTo().window(parentId);
	    List<WebElement> elements =  driver.findElements(By.xpath("//div/h2/a/span[@class='a-size-medium a-color-base a-text-normal']"));
	   int elementsCount = elements.size();
	   System.out.println("Total Products appear on the page :" +elementsCount);
	   System.out.println("Products Appear on Page  ");
	   for(int i =0;i<elementsCount;i++){
		   System.out.println(elements.get(i).getText());
		     }
	   JavascriptExecutor ja = (JavascriptExecutor)driver; 
	   ja.executeScript("window.scroll(0,5000)");
	   
	  Thread.sleep(2000);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}
