package com.selenium.section6_7_8;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.makemytrip.com");

        driver.findElement(By.id("fromCity")).click();

        /* Instead of repeating code:
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mum");
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.ENTER);

        We can create Web Element:
         */

        WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));
        source.sendKeys("mum");
        Thread.sleep(2000);
        source.sendKeys(Keys.ARROW_DOWN);
        source.sendKeys(Keys.ENTER);

        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
        destination.sendKeys("de");
        Thread.sleep(2000);

        int i = 0;
        while(i<4) {
            destination.sendKeys(Keys.ARROW_DOWN);
            i++;
        }

        destination.sendKeys(Keys.ENTER);

    }
}
