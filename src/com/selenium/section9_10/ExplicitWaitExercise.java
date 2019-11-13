package com.selenium.section9_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExercise {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait w = new WebDriverWait(driver,5);

        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@id='content']/a[2]")).click();
       // w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#results"))); --> not printing in a consol
        w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#results")));
        System.out.println(driver.findElement(By.cssSelector("#results")).getText());

    }
}
