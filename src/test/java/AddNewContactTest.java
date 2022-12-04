import manager.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static manager.TestBase.app;

public class AddNewContactTest extends TestBase {
    WebDriver wd;

    @Test
    public void addNewContactTest(){
        String email = "abc@mail.com";
        String password = "$Sens1234";
        app.getUser().openLoginRegForm();
        app.getUser().fillLoginRegForm(email,password);
        app.getUser().submitLogin();

        app.getUser().pause(30);

        app.getUser().click(By.xpath("//a[@href='/add']"));
        app.getUser().pause(30);
        app.getUser().type(By.xpath("//input[1]"),"Artur");
        app.getUser().type(By.xpath("//input[2]"),"Last Name");
        app.getUser().type(By.xpath("//input[3]"),"1234567890");
        app.getUser().type(By.xpath("//input[4]"),"qwerty@gmail.com");
        app.getUser().type(By.xpath("//input[5]"),"Hifa");
        app.getUser().type(By.xpath("//input[6]"),"Homework");

        app.getUser().pause(30);

        app.getUser().click(By.xpath("//button[.='Save']"));

//        app.getUser().pause(30);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h2[.='Artur']")));
    }
}
