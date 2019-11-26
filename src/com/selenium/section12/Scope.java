package com.selenium.section12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");


        System.out.println(driver.findElements(By.cssSelector("a")).size());

        System.out.println(driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size());
        WebElement footerSection = driver.findElement(By.cssSelector("div[id='gf-BIG']"));
        System.out.println(footerSection.findElements(By.cssSelector("a")).size());

        System.out.println(driver.findElements(By.xpath("//td[1]//ul[1]//a")).size());
        WebElement couponsSection = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(couponsSection.findElements(By.cssSelector("a")).size());


        for (int i = 1; i < couponsSection.findElements(By.cssSelector("a")).size(); i++) {
            String pressCtrlAndEnter = Keys.chord(Keys.CONTROL, Keys.ENTER);
            couponsSection.findElements(By.cssSelector("a")).get(i).sendKeys(pressCtrlAndEnter);

        }
        Set<String> windowsIds = driver.getWindowHandles();
        Iterator<String> it = windowsIds.iterator();

        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

    }
}
