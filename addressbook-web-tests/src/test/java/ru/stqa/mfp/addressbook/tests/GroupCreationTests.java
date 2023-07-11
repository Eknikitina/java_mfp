package ru.stqa.mfp.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.mfp.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("New group5", null, null));
  }

}
