package com.selenium.karolinadutka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Template {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(""); // URL in the browser

        //actions

    }
}
