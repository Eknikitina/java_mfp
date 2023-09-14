package ru.stqa.mfp.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactPhoneTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            if (app.contact().all().size() == 0) {
                app.contact().create(new ContactData().withLastname("Муромский").withName("Иван").withMiddlename("Иванович").withNickname("Огурчик").withTitle("Title").withCompany("Company").withAddress("Address").withHome("111").
                        withMobile("8800").withWork("8863").withFax("222").withEmail("email").withEmail2("email2").withEmail3("email3").withAddress2("г.Москва").withHomepage("г.Ростов"));
            }
        }
    }
    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        //телефоны
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        // адреса
        assertThat(cleanedAddress(contact.getAddress()), equalTo(cleanedAddress(contactInfoFromEditForm.getAddress())));
        // email
        assertThat(contact.getAllEmail(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Stream.of(contact.getHome(), contact.getMobile(), contact.getWork())
                .filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactData contact) {
        return Stream.of(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleanedEmails)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public static String cleanedAddress(String address) {
        return address.replaceAll("\n", "");
    }

    public static String cleanedEmails(String email) {
        return email.trim();
    }
}
