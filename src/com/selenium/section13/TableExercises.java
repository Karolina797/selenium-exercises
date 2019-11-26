package com.selenium.section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercises {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/23938/paku23-vs-indu23-1st-semi-final-acc-emerging-teams-asia-cup-2019");

        WebElement table = driver.findElement(By.cssSelector(".cb-col.cb-col-100.cb-ltst-wgt-hdr"));
        int rowcount = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms")).size();
       int count = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).size();
        System.out.println(rowcount);
        System.out.println(count);

        int sum = 0;
       for(int i =0; i<count-2;i++){
           String value = table.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText();
           int valueInteger = Integer.parseInt(value);
           sum += valueInteger;
       }


        String Extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
       int extrasValue = Integer.parseInt(Extras);
       int totalSumValue = sum+extrasValue;
        System.out.println(totalSumValue);
       String actualTotal = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
       int actualTotalValue = Integer.parseInt(actualTotal);

       if(actualTotalValue==totalSumValue){
           System.out.println("Count Matches");
       } else{
           System.out.println("Count fails");
       }



    }

}
