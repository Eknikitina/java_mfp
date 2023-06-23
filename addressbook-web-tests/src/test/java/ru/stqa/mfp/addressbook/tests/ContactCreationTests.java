package ru.stqa.mfp.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Vanya", "Muromskiyi", "80009000000", "email@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returntoContactPage();
    app.logOut();
  }


}