package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;
    HelperUse user;
    HelperContact con;
    String browser;
    Properties properties;


    public ApplicationManager(String browser) {
        properties = new Properties();
        this.browser = browser;
    }

    public HelperUse getUser() {
        return user;
    }

    public HelperContact getCon() {
        return con;
    }
    public String getEmail(){
        return properties.getProperty("web.email");
    }
    public String getPassword() {
        return properties.getProperty("web.password");
    }

    public void init() throws IOException {

        String target = System.getProperty("target","config");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("load-extension=/C:/Tools/5.3.3_0/");
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Test on FIREFOX");
        } else {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test on CHROME");
        }
        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wd.register(new MyListener());
        wd.navigate().to(properties.getProperty("web.baseURL"));
        user = new HelperUse(wd);
        con = new HelperContact(wd);
    }

    public void tearDown() {
        wd.quit();
    }

}
