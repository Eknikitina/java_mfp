package ru.stqa.mfp.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;
import ru.stqa.mfp.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.goTo().gotoContactCreation();
        ContactData contact = new ContactData().
                withLastname("Муромский").withName("Иван").withMiddlename("Иванович").withNickname("Огурчик").withTitle("Title").withCompany("Company").withAddress("Address").withHome("111").
                withMobile("8800").withWork("8863").withFax("222").withEmail("email").withEmail2("email2").withEmail3("email3").withGroup("group1").withAddress("г.Москва").withHomepage("г.Ростов");
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt(ContactData::getId).max().getAsInt()))));
    }
    @Test
    public void testBadContactCreation() throws Exception {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        app.goTo().gotoContactCreation();
        ContactData contact = new ContactData().
                withLastname("Муромский'").withName("Иван'").withMobile(null).withEmail("email@gmail.com").withGroup("group1");
        app.contact().create(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }
}