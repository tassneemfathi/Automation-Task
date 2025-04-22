package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import Pages.HomePage;

import java.time.Duration;
import java.util.UUID;

public class magentoTest {
    WebDriver driver;
    HomePage homePage;
    CreateAccountPage createAccountPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void testMagentoFlow() {
        homePage = new HomePage(driver);
        homePage.goToCreateAccountPage();

        createAccountPage = new CreateAccountPage(driver);
        String email = "tassneemfathi+" + UUID.randomUUID().toString().substring(0, 5) + "@gmail.com";
        createAccountPage.registerNewUser("Tassneem", "Fathi", email, "Test1234");

        driver.get("https://magento.softwaretestingboard.com/");
        homePage.addFirstTwoHotSellersToCart();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
