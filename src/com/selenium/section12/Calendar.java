package com.selenium.section12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.id("travel_date")).click();

        //Select month - April

        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("April")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        //Select day - 23

        List<WebElement> dates = driver.findElements(By.className("day"));

        int count = dates.size();

        for (int i = 0; i < count; i++) {

            String text = dates.get(i).getText();

            if (text.equalsIgnoreCase("23")) {
                dates.get(i).click();
                break;
            }
        }
    }
}
