package com.selenium.section13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownAssignment {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("pol");
        Thread.sleep(6000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String script = "return document.getElementById('autocomplete').value";

        String text = (String) js.executeScript(script);


        while(!text.equalsIgnoreCase("poland")){

            driver.findElement(By.cssSelector("#autocomplete")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);

            System.out.println(text);
        }


    }
}
