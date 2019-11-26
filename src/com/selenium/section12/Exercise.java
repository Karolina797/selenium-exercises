package com.selenium.section12;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Exercise {

    public static void main(String[] args)  {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.qaclickacademy.com/practice.php");

        driver.findElement(By.id("checkBoxOption1")).click();
        String text = driver.findElement(By.cssSelector("label[for='bmw']")).getText();

        Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
        s.selectByVisibleText(text);

        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        if(alertText.contains(text)){
            System.out.println("Good job!");
        } else{
            System.out.println("Something went wrong... :( ");
        }
    }
}
