package ru.stqa.mfp.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.mfp.addressbook.model.GroupData;

public class GroupHelper {

  private WebDriver wd;

  public GroupHelper(WebDriver wd) {
  this.wd = wd;
  }

  public void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupData groupData) {
    type(groupData, By.name("group_name"));
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  private void type(GroupData groupData, By locator) {
    wd.findElement(locator).click();
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(groupData.getName());
  }

  public void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  public void deleteSelectedGroup() {
    wd.findElement(By.xpath("//input[5]")).click();
  }

  public void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
