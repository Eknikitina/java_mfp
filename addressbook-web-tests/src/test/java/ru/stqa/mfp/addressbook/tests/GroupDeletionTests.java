package ru.stqa.mfp.addressbook.tests;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroup();
    app.getGroupHelper().returnToGroupPage();
    app.logOut();
  }

}