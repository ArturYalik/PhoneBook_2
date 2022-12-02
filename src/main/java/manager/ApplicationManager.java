package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;
    HelperUse user;

    public HelperUse getUser() {
        return user;
    }

    public void init() {
        wd = new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/");
        user = new HelperUse(wd);
    }

    public void tearDown() {
        wd.quit();
    }

}
