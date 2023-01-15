import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class
TestBase {
    public static ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME)
    );
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {
        app.init();
    }

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m){
        logger.info("Start Test: "+ m.getName());
    }
    @AfterMethod(alwaysRun = true)
    public void stopTest(Method m){
        logger.info("Stop Test: "+ m.getName());
    }
    @AfterSuite(alwaysRun = true)
    public void stop() {
        app.tearDown();
    }

//    public void pause(int time) {
//        wd.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
//    }

//    public void click(By locator) {
//        wd.findElement(locator).click();
//    }

//    public void type(By locator, String text) {
//        WebElement element = wd.findElement(locator);
//        element.click();
//        element.clear();
//        element.sendKeys(text);
//    }

//    public void openLoginRegForm() {
//        click(By.xpath("//a[@href = '/login']"));
//    }
//
//    public void fillLoginRegForm(String email, String password) {
//        type(By.xpath("//input[1]"), email);
//        type(By.xpath("//input[2]"), password);
//    }
//
//    public void submitLogin() {
//        click(By.xpath("//button[1]"));
//    }
//
//    public void submitReg() {
//        click(By.xpath("//button[2]"));
//    }

//    public boolean isElementPresent(By locator) {
//        return wd.findElements(locator).size() > 0;
//    }

//    public boolean isLogGet() {
//        return isElementPresent(By.xpath("//a[@href='/add']"));
//    }
//
//    public void logout() {
//        click(By.xpath("//button"));
//    }

}