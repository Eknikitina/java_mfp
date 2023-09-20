package ru.stqa.mfp.rest.tests;

import org.testng.annotations.Test;
import ru.stqa.mfp.rest.model.Issue;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {
    @Test
    public void testCreateIssue() throws IOException, URISyntaxException {
        skipIfNotFixed(1);
        Set<Issue> oldIssues = app.rest().getIssues();
        Issue newIssue = new Issue().withSubject("Issue worktest").withDescription("Description of worktest");
        int issueId = app.rest().createIssue(newIssue);
        Set<Issue> newIssues = app.rest().getIssues();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues, oldIssues);
    }
}