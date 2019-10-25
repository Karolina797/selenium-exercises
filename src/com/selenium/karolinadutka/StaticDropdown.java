package com.selenium.karolinadutka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#divpaxinfo")).click();
        Select s = new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Adult")));
        s.selectByValue("2");
        s.selectByIndex(6);
        s.selectByVisibleText("5");

        // How to click few times on some element? --> create a loop

        driver.findElement(By.xpath("//div[@id='flightSearchContainer']/div[4]/button[1]")).click();

        int i = 1;
        while(i<5){
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            i++;
        }

        System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());


    }


}
