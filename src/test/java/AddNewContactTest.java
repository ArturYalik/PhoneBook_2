import manager.TestBase;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogGet()) {
            app.getUser().pause(30);
        } else {
            User data = new User().withEmail("abc@mail.com").withPassword("$Sens1234");
            app.getUser().openLoginRegForm();
            app.getUser().fillLoginRegForm(data);
            app.getUser().submitLogin();
            app.getUser().pause(30);

        }
    }

    @Test
    public void addNewContactTest() {
        app.getUser().click(By.xpath("//a[@href='/add']"));
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Name" + i;
        String lastmane = "Last Name" + i;
        String phone = "123456789" + i;
        String mail = "ars" + i + "@gmail.com";
        String adress = "Haifa" + i;
        String note = "Note" + i;
        app.getUser().pause(30);
        app.getUser().type(By.xpath("//input[1]"), name);
        app.getUser().type(By.xpath("//input[2]"), lastmane);
        app.getUser().type(By.xpath("//input[3]"), phone);
        app.getUser().type(By.xpath("//input[4]"), mail);
        app.getUser().type(By.xpath("//input[5]"), adress);
        app.getUser().type(By.xpath("//input[6]"), note);
        app.getUser().pause(30);
        app.getUser().click(By.xpath("//button[.='Save']"));
        app.getUser().pause(30);

        Assert.assertTrue(
        app.getUser().getText(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3                                                                                                                                                                                                                  ")).equals(phone));
    }
}
