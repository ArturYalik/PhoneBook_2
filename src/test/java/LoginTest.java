import manager.TestBase;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    WebDriver wd;
    @Test
    public void loginTestPositive() {

        User data = new User().withEmail("abc@mail.com").withPassword("$Sens1234");
        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitLogin();

        app.getUser().pause(30);
       Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));

    }
    @Test
    public void loginTestNegative(){
        User data = new User().withEmail("abc@mail.com").withPassword("$Sens124");
        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
