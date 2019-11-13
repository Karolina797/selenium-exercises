package com.selenium.section9_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCart {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        System.out.println(itemsNeeded.length);

        addItem(driver,itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Explicit wait
        WebDriverWait w = new WebDriverWait(driver,5);
        w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }


    public static void addItem(WebDriver driver, String[] itemsNeeded){

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        //convert array into array list:
        List itemsNeededList = Arrays.asList(itemsNeeded);


        for (int i = 0; i < products.size(); i++) {

            //format name to get actual vegetable name
            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            System.out.println(formattedName);

            if (itemsNeededList.contains(formattedName)) {
                //click on Add To Cart
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                j++;

                if (j == itemsNeeded.length)
                    break;
            }
        }
    }
}
