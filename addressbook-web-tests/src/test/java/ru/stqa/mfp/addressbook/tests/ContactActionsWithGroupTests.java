package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.ContactData;
import ru.stqa.mfp.addressbook.model.Contacts;
import ru.stqa.mfp.addressbook.model.GroupData;
import ru.stqa.mfp.addressbook.model.Groups;

import java.io.File;
import java.util.stream.Collectors;

public class ContactActionsWithGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        File photo = new File("src/test/resources/avatar.png");
        if (app.db().contacts().size() == 0) {
            app.goTo().gotoContactCreation();
            app.contact().create(new ContactData().
                    withLastname("Muromskii").
                    withName("Ivan").
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
                    withHomepage("").
                    withPhoto(photo));
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testContactAddToGroup() {
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        ContactData contactForAdd = before.iterator().next();
        int contactId = contactForAdd.getId();
        int groupId = groups.iterator().next().getId();

        // если контакт в группе (удаление)
        if (isGroupContainsContact(groupId, contactForAdd)) {
            app.goTo().homePage();
            app.contact().removeFromGroup(contactId, groupId);
        }

        app.goTo().homePage();
        app.contact().addToGroup(contactId, groupId);

        Contacts after = app.db().contacts();

        Assert.assertTrue(isGroupContainsContact(groupId, getMovedContact(contactId, after)));
    }

    @Test
    public void testContactRemoveFromGroup() {
        Groups groups = app.db().groups();
        Contacts before = app.db().contacts();
        ContactData contactForRemove = before.iterator().next();
        int contactId = contactForRemove.getId();
        int groupId = groups.iterator().next().getId();

        // если контакта нет в группе (добавление)
        if (!isGroupContainsContact(groupId, contactForRemove)) {
            app.goTo().homePage();
            app.contact().addToGroup(contactId, groupId);
        }

        app.goTo().homePage();
        app.contact().removeFromGroup(contactId, groupId);

        Contacts after = app.db().contacts();

        Assert.assertFalse(isGroupContainsContact(groupId, getMovedContact(contactId, after)));
    }

    private static boolean isGroupContainsContact(int groupId, ContactData contact) {
        return contact.getGroups().stream()
                .map((g) -> new GroupData().withId(g.getId())).collect(Collectors.toSet())
                .contains(new GroupData().withId(groupId));
    }

    private static ContactData getMovedContact(int contactId, Contacts contacts) {
        return contacts.stream().filter(c -> c.getId() == contactId)
                .collect(Collectors.toSet()).iterator().next();
    }
}