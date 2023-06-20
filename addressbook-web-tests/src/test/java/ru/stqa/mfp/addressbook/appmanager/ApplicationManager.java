package ru.stqa.mfp.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

  private final GroupHelper groupHelper = new GroupHelper();

  public void init() {
    groupHelper.wb = new ChromeDriver();
    groupHelper.wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    groupHelper.wb.get("http://localhost/addressbook/addressbook/group.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    groupHelper.wb.findElement(By.name("user")).click();
    groupHelper.wb.findElement(By.name("user")).clear();
    groupHelper.wb.findElement(By.name("user")).sendKeys(username);
    groupHelper.wb.findElement(By.name("pass")).click();
    groupHelper.wb.findElement(By.name("pass")).clear();
    groupHelper.wb.findElement(By.name("pass")).sendKeys(password);
    groupHelper.wb.findElement(By.id("LoginForm")).click();
    groupHelper.wb.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void logOut() {
    groupHelper.wb.findElement(By.linkText("Logout")).click();
  }

  public void gotoGroupPage() {
    groupHelper.wb.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    groupHelper.wb.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      groupHelper.wb.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      groupHelper.wb.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
