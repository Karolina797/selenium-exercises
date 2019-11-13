package com.selenium.section6_7_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AaaSpiceJetEverythingTogether {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com");
        driver.manage().window().maximize();


        //1. Select trip from Bengaluru to Chennai
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='BLR']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //2. Select current date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        //3. Check if return date box is disabled

        if (driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("1")) {

            System.out.println("It is enable - shouldn't be");
            Assert.assertTrue(false);
        } else {
            System.out.println("Return date box is disabled - perfect!");
            Assert.assertTrue(true);
        }

        //4. Select Family and Friends checkbox and check if it is selected
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        Thread.sleep(3000);

        //5. Select 5 Adult
        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Select s = new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Adult")));
        s.selectByIndex(4);
        Assert.assertEquals(driver.findElement(By.cssSelector("#divpaxinfo")).getText(), "5 Adult");
        Thread.sleep(3000);

        //6. Click on 'Search'
        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();


    }
}
