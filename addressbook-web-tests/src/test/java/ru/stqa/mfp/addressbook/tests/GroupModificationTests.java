package ru.stqa.mfp.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.mfp.addressbook.model.GroupData;
import java.util.HashSet;
import java.util.Set;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("group1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set <GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().
                withId(modifiedGroup.getId()).withName("group1").withHeader("group2").withFooter("group3");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
