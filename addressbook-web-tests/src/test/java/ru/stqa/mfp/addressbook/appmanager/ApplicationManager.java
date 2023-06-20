package ru.stqa.mfp.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.mfp.addressbook.model.GroupData;

import java.time.Duration;

public class ApplicationManager {
  public WebDriver wb;

  public void init() {
    wb = new ChromeDriver();
    wb.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    wb.get("http://localhost/addressbook/addressbook/group.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wb.findElement(By.name("user")).click();
    wb.findElement(By.name("user")).clear();
    wb.findElement(By.name("user")).sendKeys(username);
    wb.findElement(By.name("pass")).click();
    wb.findElement(By.name("pass")).clear();
    wb.findElement(By.name("pass")).sendKeys(password);
    wb.findElement(By.id("LoginForm")).click();
    wb.findElement(By.xpath("//input[@value='Login']")).click();
  }

  public void logOut() {
    wb.findElement(By.linkText("Logout")).click();
  }

  public void returnToGroupPage() {
    wb.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    wb.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    wb.findElement(By.name("group_name")).click();
    wb.findElement(By.name("group_name")).clear();
    wb.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wb.findElement(By.name("group_header")).clear();
    wb.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wb.findElement(By.name("group_footer")).clear();
    wb.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  public void initGroupCreation() {
    wb.findElement(By.name("new")).click();
  }

  public void gotoGroupPage() {
    wb.findElement(By.linkText("groups")).click();
  }

  public void stop() {
    wb.quit();
  }

  public boolean isElementPresent(By by) {
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

  public void deleteSelectedGroup() {
    wb.findElement(By.xpath("//input[5]")).click();
  }

  public void selectGroup() {
    wb.findElement(By.name("selected[]")).click();
  }
}
