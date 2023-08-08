package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;
import java.util.HashSet;
import java.util.Set;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().gotoContactCreation();
            app.contact().createC(new ContactData().withLastname("Муромский").withName("Иван").withMobile("80009000000").withEmail("email@gmail.com").withGroup("test1"));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).withLastname("Муромский").withName("Иван").withMobile("80009000000").withEmail("email@gmail.com").withGroup("test1");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }


}
