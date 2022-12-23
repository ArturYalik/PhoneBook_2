package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    EventFiringWebDriver wd;
    HelperUse user;

    public HelperUse getUser() {
        return user;
    }

    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.register(new MyListener());
        wd.navigate().to("https://telranedu.web.app/");
        user = new HelperUse(wd);
    }

    public void tearDown() {
        wd.quit();
    }

}
