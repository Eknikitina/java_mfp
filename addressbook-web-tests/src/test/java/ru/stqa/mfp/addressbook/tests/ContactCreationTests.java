package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;
import ru.stqa.mfp.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test(enabled = false)
    public void testContactCreation() throws Exception {
        app.getNavigationHelper().goToHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactCreation();
        ContactData contact = new ContactData("Muromskiyi", "Vanya", "80009000000", "email@gmail.com", "test1");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}