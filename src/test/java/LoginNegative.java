import manager.NGListener;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(NGListener.class)
public class LoginNegative extends TestBase{
    @Test
    public void loginTestNegativeAlert(){
        User data = new User().withEmail("abc@mail.com").withPassword("$Sens124");
        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitLogin();
        Assert.assertTrue(app.getUser().isErrorMessageInFormat());
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
    @Test
    public void loginTestNegativePassword(){
        User data = new User().withEmail("abc@mail.com").withPassword("qwerty");
        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(data);
        app.getUser().submitLogin();
        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));
    }
}
