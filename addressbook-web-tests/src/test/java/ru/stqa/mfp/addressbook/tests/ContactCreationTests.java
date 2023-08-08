package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        app.goTo().gotoContactCreation();
        ContactData contact = new ContactData().
                withLastname("Муромский").withName("Иван").withMobile("80009000000").withEmail("email@gmail.com").withGroup("test1");
        app.contact().createC(contact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}