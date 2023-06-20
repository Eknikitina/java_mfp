package ru.stqa.mfp.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("New group5", "test3", "test4"));
    submitGroupCreation();
    returnToGroupPage();
    logOut();
  }

}
