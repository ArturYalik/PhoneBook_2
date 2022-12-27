import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getUser().isLogGet()) {
            app.getUser().pause(3000);
        } else {
            User data = new User().withEmail("abc@mail.com").withPassword("$Sens1234");
            app.getUser().openLoginRegForm();
            app.getUser().fillLoginRegForm(data);
            app.getUser().submitLogin();
            app.getUser().pause(3000);

        }
    }

    @Test(invocationCount = 1)
    public void addNewContactTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User data = new User().withName( "Name" + i)
                .withLastname("Last Name" + i)
                .withPhone("123456789" + i)
                .withEmail("ars" + i + "@gmail.com")
                .withAdress("Haifa" + i)
                .withNote("Note" + i);
        app.getCon().openAddContactForm();
        app.getCon().fillContactForm(data);
        app.getCon().susseccAddContactForm();
        Assert.assertTrue(
        app.getUser().getText(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(data.getPhone()));
    }
}
