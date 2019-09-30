package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

class PageGoogleCloudCalculatorObject {

    private static final String HOMEPAGE_URL="https://cloud.google.com";
    private WebDriver driver;

    public PageGoogleCloudCalculatorObject (WebDriver driver) { this.driver = driver; }

    public PageGoogleCloudCalculatorObject openPage () {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void checkDataForEstimation (String machineClass, String instanceType, String localSSD, String region, String commitmentTerm) {
        WebElement searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[2]/div"));
        if (searchInput.getText().contains(machineClass)) System.out.println ("VM Class совпадает");
        searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[3]/div"));
        if(instanceType.contains(searchInput.getText().split(" ")[2])) System.out.println ("Instace type совпадает");
        searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[5]/div"));
        if (searchInput.getText().contains(localSSD)) System.out.println ("Local SSD совпадает");
        searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[4]/div"));
        if (region.contains(searchInput.getText().split(" ")[1])) System.out.println ("Регион совпадает");
        searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/md-content/md-list/md-list-item[6]/div"));
        if(searchInput.getText().contains(commitmentTerm)) System.out.println ("Commitment term совпадает");
    }

    public void createNewEstimation () {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Google Cloud Platform Pricing Calculator");
        searchInput.submit();
        searchInput = driver.findElement(By.linkText("Google Cloud Platform Pricing Calculator"));
        String newTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        searchInput.sendKeys(newTab);
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        driver.switchTo().window((String)tabs.get(1));
        MailServicePageObject pageMailService = new MailServicePageObject(driver);
        pageMailService = pageMailService.openPage();
        String tempEmailAddress = pageMailService.getEmailAddress();
        driver.switchTo().window((String)tabs.get(0));
        searchInput.click();
        driver.switchTo().frame("idIframe");
        searchInput = driver.findElement(By.id("input_53"));
        searchInput.sendKeys("4");
        searchInput = driver.findElement(By.id("select_option_67"));
        String machineClass = searchInput.getAttribute("value").toLowerCase();
        searchInput = driver.findElement(By.id("select_76"));
        searchInput.click();
        searchInput = driver.findElement(By.id("select_option_217"));
        String instanceType = searchInput.getAttribute("value").toLowerCase();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[1]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput = driver.findElement(By.id("select_348"));
        searchInput.sendKeys("1");
        searchInput = driver.findElement(By.id("select_78"));
        searchInput.click();
        searchInput = driver.findElement(By.id("select_option_171"));
        searchInput.click();
        searchInput = driver.findElement(By.id("select_78"));
        String localSSD = searchInput.getAttribute("aria-label").substring(24,32);
        searchInput = driver.findElement(By.id("select_80"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput = driver.findElement(By.id("select_option_185"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput = driver.findElement(By.id("select_80"));
        String region = searchInput.getAttribute("aria-label");
        searchInput = driver.findElement(By.id("select_85"));
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(searchInput));
        searchInput.click();
        searchInput = driver.findElement(By.id("select_option_83"));
        String commitmentTerm = searchInput.getAttribute("value");
        searchInput.click();
        searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[1]/div[1]/div/md-card/md-card-content/div/div[1]/form/div[13]/button"));
        searchInput.click();
        checkDataForEstimation (machineClass, instanceType, localSSD, region, commitmentTerm);
        searchInput = driver.findElement(By.xpath("/html/body/md-content/md-card/div/md-card-content[2]/md-card/md-card-content/div/div/div/h2"));
        String totalEstimatedCost = searchInput.getText().split(" ") [4];
        searchInput = driver.findElement(By.id("email_quote"));
        searchInput.click();
        searchInput = driver.findElement(By.id("input_396"));
        searchInput.sendKeys(tempEmailAddress);
        searchInput = driver.findElement(By.xpath("/html/body/div[7]/md-dialog/form/md-dialog-actions/button[2]"));
        searchInput.click();
        driver.switchTo().window((String)tabs.get(1));
        pageMailService.checkTotalEstimation (totalEstimatedCost);
    }
}
