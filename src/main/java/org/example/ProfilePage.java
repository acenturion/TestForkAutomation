package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    WebDriver driver;
    By btnMyPersonalInformation = By.xpath("//button[@aria-controls='user-space-user-information']");
    By fieldFirstName = By.name("firstName");
    By fieldLastName = By.name("lastName");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;

        // This checks the robot it is on My profile Page
        waitForElement(Duration.ofSeconds(60), btnMyPersonalInformation);
    }

    public void clickMyPersonalInformationBtn(){
        driver.findElement(btnMyPersonalInformation).click();
    }

    public String getFirstNameField(){
        return driver.findElement(fieldFirstName).getAttribute("value");
    }
    public String getFirstLastNameField(){
        return driver.findElement(fieldLastName).getAttribute("value");
    }

    public void waitForElement(Duration time, By element){
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void goToMyProfile() {
        this.clickMyPersonalInformationBtn();
    }
}
