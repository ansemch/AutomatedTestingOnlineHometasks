package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

class MailServicePageObject {

    private static final String HOMEPAGE_URL="https://10minutemail.com";
    private WebDriver driver;

    public MailServicePageObject (WebDriver driver) { this.driver = driver; }

    public MailServicePageObject openPage () {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public String getEmailAddress () {
        String tempEmailAddress = driver.findElement(By.id("mailAddress")).getAttribute("value");
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        return tempEmailAddress;
    }

    public void checkTotalEstimation (String totalEstimatedCost) {
        WebElement searchInput = new WebDriverWait(driver, 61).until(ExpectedConditions.presenceOfElementLocated(By.id("ui-id-1")));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", searchInput);
        searchInput = new WebDriverWait(driver, 15).
                until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")));

        System.out.println(searchInput.getText());

        if (searchInput.getText().split(" ") [1].equals(totalEstimatedCost))
            System.out.println("Total Estimated Monthly Cost совпадает");
    }

}
