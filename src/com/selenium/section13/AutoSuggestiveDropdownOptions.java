package com.selenium.section13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdownOptions {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://ksrtc.in/oprs-web/");
        driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
        Thread.sleep(2000);

        // Javascript DOM(document object model) can extract hidden elements
        // Selenium cannot identify hidden elements - (Ajax implementation)
        // investigate the properties of object if it have any hidden text

        //JavascriptExecutor

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById('fromPlaceName').value;";
        String text = (String) js.executeScript(script);


        int i = 0;
        while (!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
            i++;
            driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
            text = (String) js.executeScript(script);

            System.out.println(text);

            if (i > 10) {
                break;
            }
        }
        if (i > 10) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found");
        }

    }

}