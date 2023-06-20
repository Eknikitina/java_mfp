package ru.stqa.mfp.addressbook;

import org.testng.annotations.*;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletions() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
    logOut();
  }

}