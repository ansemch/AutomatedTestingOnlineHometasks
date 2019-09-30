package WebDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class JavaWebDriverPageObjectTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup () { driver = new ChromeDriver(); }

    @Test
    public void createNewPasteTest () {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        new PagePastebinHomeObject(driver).openPage().
                createNewPaste(code, "10 Minutes", "Bash",
                        "how to gain dominance among developers");
    }

    @Test
    public void checkMailServiceTest () {
        new PageGoogleCloudCalculatorObject (driver).openPage().createNewEstimation();
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown () {
        driver.quit();
        driver = null;
    }
}