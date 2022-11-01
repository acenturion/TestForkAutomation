package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    By btnLogin = By.xpath("//button[@data-testid='user-space']");
    By btnAcceptCookies = By.id("_evidon-accept-button");
    By btnContinueEmail = By.xpath("//button[@data-testid='checkout-submit-email']");
    By btnContinuePassword = By.xpath("//button[@data-testid='submit-password']");
    By inputUsername = By.name("email");
    By inputPassword = By.name("password");

    public HomePage(WebDriver driver) {
        this.driver = driver;

        //wait for human robot [-.~]
        this.waitForElement(Duration.ofSeconds(60), btnAcceptCookies);
    }

    public void clickAcceptCookies() {
        driver.findElement(btnAcceptCookies).click();
    }

    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }

    public void clickContinueVerifyEmail() {
        driver.findElement(btnContinueEmail).click();
    }

    public void clickContinueVerifyPassword() {
        driver.findElement(btnContinuePassword).click();
    }

    public void setUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }


    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void waitForElement(Duration time, By element){
        new WebDriverWait(driver, time)
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    public void login(String username, String password) {
        this.clickAcceptCookies();
        this.clickLogin();
        this.setUsername(username);
        this.clickContinueVerifyEmail();
        this.waitForElement(Duration.ofSeconds(60), inputPassword);
        this.setPassword(password);
        this.clickContinueVerifyPassword();
    }
}
