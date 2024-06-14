package org.sample.taskj;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	WebDriver driver = new ChromeDriver();
    	
    	// task 1 open the URL
        driver.get("https://www.booking.com/");
         
        
        //maximize window
        driver.manage().window().maximize();
        Thread.sleep(1000);
        
        
        // task 2 Assert the text is displayed
        String text = driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[1]/div/div/div/div/header/h1/span")).getText();
        System.out.println(text);
        Thread.sleep(100);
        
        
        // task 3 select Aqaba/ Jordan
        //click on field
        driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[1]/div")).click();
        //select Aqaba/ Jordan
        driver.findElement(By.xpath("//*[@id=\"autocomplete-result-1\"]/div/div/div/div[2]")).click();
        Thread.sleep(100);
      
        // task 4 Check-in Date
        driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/button")).click();
        //loop click to December months
        for (int i = 1; i < 6; i++)
            {
        	
        Thread.sleep(100);
        driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/button[2]")).click(); 
        
             }
        //select 24.December.2024
        driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/table/tbody/tr[4]/td[3]/span")).click(); 
        Thread.sleep(100);
        //select 29.December.2024
        driver.findElement(By.xpath("//*[@id=\"calendar-searchboxdatepicker\"]/div/div[1]/div/div[1]/table/tbody/tr[5]/td[1]/span")).click(); 
        Thread.sleep(100);
        
        
        //Task 5 select passengers
        //click on field
        driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[3]/div/button")).click();
        //decrease the number of adults
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[1]")).click();
        //increase the number of rooms
        Thread.sleep(100);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/div/div/div[3]/div[2]/button[2]")).click();
        Thread.sleep(100);
        //click done
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/div[1]/div[3]/div/div/div/button")).click();
        Thread.sleep(100);
        
        
        //Task 6 Hit the search button
        driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[4]/button")).click();
        Thread.sleep(5000);
        
        
       //close register popup
        driver.findElement(By.xpath("/html/body/div[45]/div/div/div/div[1]/div[1]/div/button")).click();
        Thread.sleep(3000);
        
        
        //Task 7 Print the number of properties found 
        String text1 = driver.findElement(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[2]/div/div[2]/div[3]/div[2]/div[1]/h1")).getText();
        System.out.println(text1);
        
        
        //Task 8 Scroll down in the search results page using Javascript executer until property #10 is displayed
        Thread.sleep(2000);
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        WebElement flag=driver.findElement(By.xpath("//*[@id=\"bodyconstraint-inner\"]/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[3]/div[22]"));
        scroll.executeScript("arguments[0].scrollIntoView();",flag);
        Thread.sleep(6000);
        
        
        //Task 9 Get the property name and print it.
        String propertyname = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[3]/div[22]/div[1]/div[2]/div/div[1]/div[1]/div/div[1]/div")).getText();
        System.out.println(propertyname);
        Thread.sleep(1000);
        
        
        //Task 10 Press on the heart icon on the picture to save the property
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/div[2]/div[2]/div[3]/div[22]/div[1]/div[1]/div/div/span/span/button")).click();
        Thread.sleep(500);
       
        
        //Task 11 When the “Saved to” popup is displayed >> press on the hyperlink “My next trip”
        driver.findElement(By.xpath("/html/body/div[45]/div/div/div/div/div/div[1]/a/span/span")).click();
        Thread.sleep(500);
        
        //change between windows
        Set<String> handel = driver.getWindowHandles();
        Iterator it = handel.iterator();
        String parentid = (String) it.next();
        String chadild = (String) it.next(); 
        driver.switchTo().window(chadild);
        
        //scroll to price
        Thread.sleep(2000);
        scroll.executeScript("window.scrollBy(0,400)","");
        Thread.sleep(900);
        
        
        //Task 12 Assert that the price is lower than 700 JOD
        String text3 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/div/ul/li/div/div[2]/div[3]/div/div/div[2]/div/div/span")).getText(); 
        System.out.println("the price is :" + text3);
        
        
        //Task 13  Press on “View Property” button
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div[3]/div/ul/li/div/div[2]/div[4]/a")).click(); 
        Thread.sleep(1000);
       
        
        //change between windows
        Set<String> hande2 = driver.getWindowHandles();
        Iterator it2 = hande2.iterator();
        String parentid1 = (String) it2.next();
        String chadild1 = (String) it2.next();
        String chadild2 = (String) it2.next();
        driver.switchTo().window(chadild2);
        
        
        //Task 14 Navigate to the opened window and press “Reserve” button
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"hp_book_now_button\"]")).click(); 
        
        
        //Task 15  select the 3rd option by its index
        Thread.sleep(1000);
        WebElement ddrop =driver.findElement(By.xpath("//select[@class='hprt-nos-select js-hprt-nos-select' and @name='nr_rooms_400698601_123670301_2_2_0' and @data-testid='select-room-trigger']"));
        Select select = new Select(ddrop);
        select.selectByIndex(3);
        
        
        //Task 16 Press “I’ll reserve” button
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"hprt-form\"]/div[23]/div[2]/div[2]/div[6]")).click();
        Thread.sleep(5000);
      
       
    }

	
		
	
}