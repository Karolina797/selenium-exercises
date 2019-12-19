package com.selenium.section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortedValues {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr/th[2]")).click();
        driver.findElement(By.xpath("//tr/th[2]")).click();
        List<WebElement> vegList = driver.findElements(By.cssSelector("tr td:nth-child(2)"));

        ArrayList<String> originalList = new ArrayList<>();

        for(int i=0; i<vegList.size(); i++){
            originalList.add(vegList.get(i).getText());
        }

        for (String s :originalList) {
            System.out.println(s);
        }

        System.out.println("****************");

       ArrayList<String> sortedList = new ArrayList<>();

        for(int i=0; i<vegList.size(); i++){
            sortedList.add(originalList.get(i));
        }

        Collections.sort(sortedList);
        for (String s :sortedList) {
            System.out.println(s);
        }

 /*
        System.out.println(originalList);
        ArrayList<String> sortedList = originalList;
        Collections.sort(sortedList);
        System.out.println(sortedList);
*/

      Assert.assertTrue(originalList.equals(sortedList));


    }

}
