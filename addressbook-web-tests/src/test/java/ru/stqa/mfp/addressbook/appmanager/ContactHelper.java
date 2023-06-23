package ru.stqa.mfp.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.mfp.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returntoContactPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getName());
    type(By.name("mobile"), contactData.getName());
    type(By.name("email"), contactData.getName());
  }

  public void login() {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void selectContact() {
    click(By.id("4"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void confirmDeletion() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }
}
