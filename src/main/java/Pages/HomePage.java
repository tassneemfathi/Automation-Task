package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);  // Correct use of super
    }

    By createAccountBtn = By.cssSelector("a[href='https://magento.softwaretestingboard.com/customer/account/create/']");
    By addToCartButtons = By.xpath("//span[text()='Add to Cart']");

    public void goToCreateAccountPage() {
        driver.findElement(createAccountBtn).click();
    }

    public void addFirstTwoHotSellersToCart() {
        var buttons = driver.findElements(addToCartButtons);
        buttons.get(0).click();
        buttons.get(1).click();
    }
}
