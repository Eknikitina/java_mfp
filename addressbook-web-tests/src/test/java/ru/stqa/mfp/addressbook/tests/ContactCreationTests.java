package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactCreation();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().createContact(new ContactData("Vanya", "Muromskiyi", "80009000000", "email@gmail.com", "test1"));
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }


}