package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class FacebookTestingApp {
    public final static String XPATH_COOKIES_SELECT = "//div[@class = \"_9xo5\"]/button[1]";
    public final static String XPATH_NEW_ACCOUNT = "//div[@class = \"_6ltg\"]/a";
    public final static String XPATH_BIRTHDAY_TEXTAREA = "//*[@id=\"day\"]";
    public final static String XPATH_BIRTHMONTH_TEXTAREA = "//*[@id=\"month\"]";
    public final static String XPATH_BIRTHYEAR_TEXTAREA = "//*[@id=\"year\"]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIES_SELECT)).click();
        driver.findElement(By.xpath(XPATH_NEW_ACCOUNT)).click();


        WebElement selectComboBirthDay = driver.findElement(By.xpath(XPATH_BIRTHDAY_TEXTAREA));
        Select selectBirthDay = new Select(selectComboBirthDay);
        selectBirthDay.selectByValue("26");

        WebElement selectComboBirthMonth = driver.findElement(By.xpath(XPATH_BIRTHMONTH_TEXTAREA));
        Select selectBirthMonth = new Select(selectComboBirthMonth);
        selectBirthMonth.selectByValue("8");

        WebElement selectComboBirthYear = driver.findElement(By.xpath(XPATH_BIRTHYEAR_TEXTAREA));
        Select selectBirthYear = new Select(selectComboBirthYear);
        selectBirthYear.selectByValue("1992");
    }
}
