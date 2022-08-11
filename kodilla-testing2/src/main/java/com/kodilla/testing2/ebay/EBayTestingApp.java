package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    private final static String XPATH_SEARCH_FIELD = "//*[@id=\"gh-ac\"]";
    private final static String NAME = "_nkw";


    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.ebay.com/");

        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        //WebElement element = driver.findElement(By.xpath(XPATH_SEARCH_FIELD));
        WebElement element = driver.findElement((By.name(NAME)));
        element.sendKeys("Laptop");
        element.submit();


    }
}
