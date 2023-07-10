package ru.stqa.mfp.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().goToHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Vanya", "Muromskiyi", "80009000000", "email@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }
}
