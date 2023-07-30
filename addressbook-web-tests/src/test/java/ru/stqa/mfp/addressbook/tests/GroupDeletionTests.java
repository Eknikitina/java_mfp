package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.mfp.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("New group5", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }

}