package ru.stqa.mfp.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.mfp.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("New group5", "test3", "test4"));
    app.submitGroupCreation();
    app.returnToGroupPage();
    app.logOut();
  }

}
