package com.selenium.script.test_addressbook_selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException 
    {
        System.out.println( "Hello World!" );
        
        
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
        
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--remote-allow-origins=*");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        System.out.println("Scripted Started");
        
        driver.get("http://52.62.172.9:8081/addressbook2.0/");
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.className("v-button")).click();
        driver.findElement(By.id("gwt-uid-5")).sendKeys("asta");
        driver.findElement(By.id("gwt-uid-7")).sendKeys("yuno");
        driver.findElement(By.id("gwt-uid-9")).sendKeys("222222222200");
        driver.findElement(By.id("gwt-uid-11")).sendKeys("asta@gmail.com");
        driver.findElement(By.id("gwt-uid-13")).sendKeys("12/12/2001,");
        driver.findElement(By.className("v-button-primary")).click();
        
        Thread.sleep(3000);
        
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        
        File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
        
        File destFile = new File("screenshot.png");
        
        FileUtils.copyFile(screenShot, destFile);
        
      
        Thread.sleep(3000);
        
        
        System.out.println("reports stored at : " + destFile.getAbsolutePath().toString());                  
        
        driver.quit();
        
        System.out.println("Script executed successfully");
        
        
        
        
    }
}
