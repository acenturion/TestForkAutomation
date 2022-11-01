import org.example.HomePage;
import org.example.ProfilePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Testing {
    WebDriver driver;
    HomePage homePage;
    ProfilePage profilePage;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get("https://www.thefork.com/");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test_login_user() {
        homePage = new HomePage(driver);
        homePage.login("alejandroo_mc@hotmail.com", "Qwerty1!");

        profilePage = new ProfilePage(driver);
        profilePage.goToMyProfile();
        String resultLastname = profilePage.getFirstNameField();
        String resultFirstname = profilePage.getFirstLastNameField();

        Assertions.assertEquals("Tester", resultLastname);
        Assertions.assertEquals("Testerfield", resultFirstname);

    }
}
