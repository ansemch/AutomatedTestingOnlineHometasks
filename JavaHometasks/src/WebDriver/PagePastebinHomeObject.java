package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class PagePastebinHomeObject {

    private static final String HOMEPAGE_URL="https://pastebin.com";
    private WebDriver driver;

    public PagePastebinHomeObject (WebDriver driver) { this.driver = driver; }

    public PagePastebinHomeObject openPage () {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void createNewPaste (String code, String pasteEspiration, String syntaxHighlighting,
                                                   String pasteNameTitle) {
        WebElement searchInput = driver.findElement(By.id("paste_code"));
        searchInput.sendKeys (code);
        searchInput = driver.findElement(By.name("paste_name"));
        searchInput.sendKeys (pasteNameTitle);
        WebElement searchSelect = driver.findElement (By.name("paste_expire_date"));
        searchSelect.sendKeys(pasteEspiration);
        searchSelect = driver.findElement (By.name("paste_format"));
        searchSelect.sendKeys(syntaxHighlighting);
        WebElement searchButton = driver.findElement(By.id("submit"));
        searchButton.click();
        new PagePastebinPasteObject(driver).
                checkPasteInfo(code, "how to gain dominance among developers");;
    }
}
