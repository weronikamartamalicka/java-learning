package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;


public class CrudAppTestSuite {
    private static final String BASE_URL = "https://weronikamartamalicka.github.io/";
    private WebDriver driver;
    Random generator = new Random();

    @BeforeEach
    void initTest() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
    }

    @AfterEach
    void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TITLE_TEXTFIELD = "//form[contains(@action, \"herokuapp.com/v1/tasks\")]/fieldset[1]/input";
        final String XPATH_CONTENT_TEXTFIELD = "//form[contains(@action, \"herokuapp.com/v1/tasks\")]/fieldset[2]/textarea";
        final String XPATH_ADDTASK_BUTTON = "//form[contains(@action, \"herokuapp.com/v1/tasks\")]/fieldset[3]/button";
        final String taskName = "Task number" + generator.nextInt(1000);
        final String taskContent = taskName + "content";

        WebElement taskNameField = driver.findElement(By.xpath(XPATH_TITLE_TEXTFIELD));
        taskNameField.sendKeys(taskName);

        WebElement taskContentField = driver.findElement(By.xpath(XPATH_CONTENT_TEXTFIELD));
        taskContentField.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADDTASK_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        //assertTrue(checkTaskExistsInTrello(taskName));
        deleteCreatedTaskInCrud(taskName);
    }

    private void sendTestTaskToTrello(String taskName) throws  InterruptedException {
        driver.navigate().refresh();

        Thread.sleep(5000);

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectForm = theForm.findElement(By.xpath(".//select[1]"));
                    Select selectBox = new Select(selectForm);
                    selectBox.selectByIndex(1);

                    WebElement button = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    button.click();
                });

        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        boolean result = false;
        final String TRELLO_URL = "https://trello.com/login";

        driver.get(TRELLO_URL);
        WebElement userNameField = driver.findElement(By.id("user"));
        userNameField.sendKeys("weronikamarta.malicka@gmail.com");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("@Lateks69");
        driver.findElement(By.id("login")).click();

        Thread.sleep(4000);

        driver.findElements(By.xpath("//a[@class=\"board-title\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);

        Thread.sleep(4000);

        result = driver.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driver.close();


        return result;
    }

    void deleteCreatedTaskInCrud(String taskName) throws InterruptedException {
        driver.get(BASE_URL);

        Thread.sleep(5000);

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]")).getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement deleteButton = theForm.findElement(By.xpath(".//button[4]"));
                    deleteButton.click();
                });

        Thread.sleep(5000);
    }
}
