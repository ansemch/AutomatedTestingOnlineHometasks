package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class PagePastebinPasteObject {

    private WebDriver driver;

    public PagePastebinPasteObject (WebDriver driver) { this.driver = driver; }

    public void checkPasteInfo (String code, String pasteNameTitle) {
        WebElement searchInput = driver.findElement(By.className("paste_box_line1"));
        if (searchInput.getAttribute("title").equals(pasteNameTitle))
            System.out.println("Заголовок страницы браузера соответствует Paste Name / Title");
        else System.out.println("Заголовок страницы браузера не соответствует Paste Name / Title");
        searchInput = driver.findElement(By.id("paste_code"));
        if (searchInput.getAttribute("value").equals(code)) System.out.println("Код ввода соответствует коду вывода");
        else System.out.println("Код ввода не соответствует коду вывода");
        if (!driver.findElement(By.className("kw2")).getCssValue("color").equals("rgba(0, 0, 0, 1)") &&
                !driver.findElement(By.className("re5")).getCssValue("color").equals("rgba(0, 0, 0, 1)") &&
                !driver.findElement(By.className("st0")).getCssValue("color").equals("rgba(0, 0, 0, 1)"))
            System.out.println("Синтаксис подсвечен для bash");
        else System.out.println("Синтаксис не подсвечен для bash");
    }
}
