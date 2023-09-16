package ru.stqa.mfp.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static jdk.nashorn.internal.objects.NativeJava.type;

public class RegistrationHelper {
    private final ApplicationManager app;
    private WebDriver wd;

    public RegistrationHelper(ApplicationManager app) {
        this.app = app;
        wd = app.getDriver();
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseURL") + "/signup_page.php");
    }
}
