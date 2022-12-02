package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUse extends HelperBase {



    public HelperUse(WebDriver wd) {
        super(wd);
    }
    public void openLoginRegForm() {
        click(By.xpath("//a[@href = '/login']"));
    }

    public void fillLoginRegForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void submitReg() {
        click(By.xpath("//button[2]"));
    }

    public boolean isLogGet() {
        return isElementPresent(By.xpath("//a[@href='/add']"));
    }

    public void logout() {
        click(By.xpath("//button"));
    }
}
