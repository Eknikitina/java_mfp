package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        app.goTo().gotoContactCreation();
        ContactData contact = new ContactData().
                withLastname("Муромский").withName("Иван").withMobile("80009000000").withEmail("email@gmail.com").withGroup("test1");
        app.contact().createC(contact);
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}