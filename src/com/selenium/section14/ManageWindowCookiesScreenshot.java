package com.selenium.section14;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ManageWindowCookiesScreenshot {
    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.com/");


        //Screenshot

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File ("C:\\Users\\XPS 9370\\Desktop\\screenshot.png"));



    }

}
