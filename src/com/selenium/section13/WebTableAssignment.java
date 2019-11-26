package com.selenium.section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableAssignment {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");

        WebElement table = driver.findElement(By.id("product"));
        System.out.println("Number of rows: " + table.findElements(By.tagName("tr")).size());
        System.out.println("Number of columns: " + table.findElements(By.xpath("//tr[1]/th")).size());
        System.out.println(table.findElement(By.xpath("//tr[3]")).getText());
    }
}