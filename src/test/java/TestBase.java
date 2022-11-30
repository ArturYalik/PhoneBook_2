import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;

    @BeforeSuite
    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/");
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        wd.quit();
    }

    public void pause(int time) {
        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void openLoginRegForm() {
        click(By.xpath("//a[@href = '/login']"));
    }

    public void fillLoginRegForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void submitReg() {
        click(By.xpath("//button[2]"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isLogGet() {
        if(isElementPresent(By.xpath("//a[@href='/add']"))){
            return true;
        }
        return false;
    }

    public void logout() {
        click(By.xpath("//button"));
    }

}