import manager.TestBase;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogGet()){
            app.getUser().logout();
        }
    }

    @Test
    public void RegistrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withEmail("name" + i + "@gmail.com").withPassword("1699Sens$");

        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitReg();
        app.getUser().pause(30);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

    @Test
    public void RegistrationWrongEmailTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withEmail("name" + i + "@gmail,com").withPassword("1699Sens$");

        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitReg();
        app.getUser().pause(30);
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));

    }
}
