package com.selenium.section6_7_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise2 {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();

        Select s1 = new Select(driver.findElement(By.cssSelector("#Adults")));
        s1.selectByIndex(3);

        Select s2 = new Select(driver.findElement(By.cssSelector("#Childrens")));
        s2.selectByIndex(2);

        driver.findElement(By.cssSelector("#DepartDate")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("MoreOptionsLink")).click();
        driver.findElement(By.cssSelector("#AirlineAutocomplete")).sendKeys("WizzAir");
        driver.findElement(By.cssSelector("#SearchBtn")).click();

        System.out.println(driver.findElement(By.cssSelector("#homeErrorMessage")).getText());


    }
}
