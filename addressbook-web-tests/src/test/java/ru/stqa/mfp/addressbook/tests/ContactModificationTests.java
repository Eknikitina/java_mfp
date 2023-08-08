package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;
import ru.stqa.mfp.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactCreation();
            app.getContactHelper().createContact(new ContactData("Muromskiyi", "Vanya", "80009000000", "email@gmail.com", "test1"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Muromskiyi", "Vanya", "80009000000", "email@gmail.com", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
