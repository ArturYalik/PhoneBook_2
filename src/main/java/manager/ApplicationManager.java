package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;
    HelperUse user;

    HelperContact con;

    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public HelperUse getUser() {
        return user;
    }

    public HelperContact getCon() {
        return con;
    }

    public void init() {
        if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Test on FIREFOX");
        }else{
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test on CHROME");
        }
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.register(new MyListener());
        wd.navigate().to("https://telranedu.web.app/");
        user = new HelperUse(wd);
        con = new HelperContact(wd);
    }

    public void tearDown() {
        wd.quit();
    }

}
