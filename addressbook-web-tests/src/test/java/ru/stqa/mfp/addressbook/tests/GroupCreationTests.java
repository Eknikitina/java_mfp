package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.mfp.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("New group5", null, null));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
