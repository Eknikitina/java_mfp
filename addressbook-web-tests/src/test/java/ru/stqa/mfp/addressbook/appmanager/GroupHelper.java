package ru.stqa.mfp.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.mfp.addressbook.model.GroupData;

public class GroupHelper {
  public WebDriver wb;

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

  public void deleteSelectedGroup() {
    wb.findElement(By.xpath("//input[5]")).click();
  }

  public void selectGroup() {
    wb.findElement(By.name("selected[]")).click();
  }
}
