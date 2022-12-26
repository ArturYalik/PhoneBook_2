package manager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperContact extends HelperBase {

    Logger logger = LoggerFactory.getLogger(HelperContact.class);

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillContactForm(User data) {
        type(By.xpath("//input[1]"), data.getName());
        type(By.xpath("//input[2]"), data.getLastname());
        type(By.xpath("//input[3]"), data.getPhone());
        type(By.xpath("//input[4]"), data.getEmail());
        type(By.xpath("//input[5]"), data.getAdress());
        type(By.xpath("//input[6]"), data.getNote());
        pause(3000);
    }

    public void susseccAddContactForm() {
        click(By.xpath("//button[.='Save']"));
        pause(3000);
    }

    public int removeOneContact() {
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
        logger.info("The deleted number is " + phone);
        pause(3000);
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[normalize-space()='Remove']"));
        pause(3000);
        int countAfter = countOfContacts();
        logger.info("Number of contacts After is " + countAfter);
        return countBefore - countAfter;

    }

    public int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        int countBefore = countOfContacts();
        logger.info("Number of contacts before is " + countBefore);
        pause(3000);
        for (int i = 0;i > countBefore;i++){
//            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
//            logger.info("The deleted number is " + phone);
            pause(3000);
            click(By.cssSelector(".contact-item_card__2SOIM"));
            pause(3000);
            click(By.xpath("//button[normalize-space()='Remove']"));
            pause(3000);
        }
    }
}
