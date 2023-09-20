package ru.stqa.mfp.github;

import com.google.common.collect.ImmutableMap;
import com.jcabi.github.*;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.IdentityHashMap;

public class GitHubTests {
    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("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");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("Eknikitina", "java_mfp")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}
