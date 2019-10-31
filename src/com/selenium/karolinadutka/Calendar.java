package com.selenium.karolinadutka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar {


    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com");
        driver.manage().window().maximize();


        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='BLR']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //select current date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();


        // If 'isEnable' method works we can check elements if it is enabled:

        /*System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
         */


        // If above method doesn't work we have to use other way - check which attribute is changing and use it:

        System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
        driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));

        if (driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("1")){

            System.out.println("It is enable");
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

    }

    }
