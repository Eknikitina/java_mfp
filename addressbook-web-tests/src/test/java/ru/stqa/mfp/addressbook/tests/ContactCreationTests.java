package ru.stqa.mfp.addressbook.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;

import java.time.Duration;

import static org.testng.Assert.fail;

public class ContactCreationTests {
  private WebDriver wb;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    wb = new ChromeDriver();
    wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wb.get("http://localhost/addressbook/addressbook/index.php");
    login();
  }

  @Test
  public void testContactCreation() throws Exception {
    gotoContactCreation();
    fillContactForm(new ContactData("Vanya", "Muromskiyi", "80009000000", "email@gmail.com"));
    submitContactCreation();
    returntoConcacyPage();
  }

  private void logout() {
    wb.findElement(By.linkText("Logout")).click();
  }

  private void returntoConcacyPage() {
    wb.findElement(By.linkText("home page")).click();
    wb.get("http://localhost/addressbook/addressbook/index.php");
  }

  private void submitContactCreation() {
    wb.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm(ContactData contactData) {
    wb.findElement(By.name("firstname")).click();
    wb.findElement(By.name("firstname")).clear();
    wb.findElement(By.name("firstname")).sendKeys(contactData.getName());
    wb.findElement(By.name("lastname")).click();
    wb.findElement(By.name("lastname")).clear();
    wb.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
    wb.findElement(By.name("mobile")).click();
    wb.findElement(By.name("mobile")).clear();
    wb.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
    wb.findElement(By.name("email")).click();
    wb.findElement(By.name("email")).clear();
    wb.findElement(By.name("email")).sendKeys(contactData.getEmail());
  }

  private void gotoContactCreation() {
    wb.findElement(By.linkText("add new")).click();
    wb.get("http://localhost/addressbook/addressbook/edit.php");
  }

  private void login() {
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys("admin");
    wb.findElement(By.name("pass")).click();
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys("secret");
    wb.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    logout();
    wb.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  }