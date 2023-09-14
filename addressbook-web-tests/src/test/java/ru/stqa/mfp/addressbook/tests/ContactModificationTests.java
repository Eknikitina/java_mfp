package ru.stqa.mfp.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;
import ru.stqa.mfp.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        File photo = new File("src/test/resources/avatar.png");
        if (app.db().contacts().size() == 0) {
                if (app.contact().all().size() == 0) {
                    app.goTo().gotoContactCreation();
                    app.contact().create(new ContactData().withLastname("Муромский").withName("Иван").withMobile("").withEmail("email@gmail.com").withPhoto(photo));
                }
            }
        }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).
                withLastname("Муромский").
                withName("Иван").
                withMobile("").
                withEmail("email@gmail.com").
                withMiddlename("").
                withEmail("").
                withHome("").
                withWork("").
                withNickname("").
                withTitle("").
                withCompany("").
                withAddress("").
                withFax("").
                withEmail2("").
                withEmail3("").
                withHomepage("");
        app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
        verifyContactListInUI();


    }


}
