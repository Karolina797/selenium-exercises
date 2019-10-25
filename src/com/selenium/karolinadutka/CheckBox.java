package com.selenium.karolinadutka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.spicejet.com");

        // To check if box is selected (shouldn't be):
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

        // To check again if box is selected (should be):

        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

        // Count the number of check boxes ---> find common locator
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());




    }
}
