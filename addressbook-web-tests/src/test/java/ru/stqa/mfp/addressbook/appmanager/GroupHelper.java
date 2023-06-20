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
    wd.findElement(By.name("group_name")).click();
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  private void type(By locator, String text) {
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  private void type(GroupData groupData, By locator) {

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
