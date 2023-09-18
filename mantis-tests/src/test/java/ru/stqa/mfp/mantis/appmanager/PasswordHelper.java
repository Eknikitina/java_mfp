package ru.stqa.mfp.mantis.appmanager;

import org.openqa.selenium.By;

public class PasswordHelper extends HelperBase {

    public PasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseURL") + "/login.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void reset(String whichUser) {
        login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
        wd.get(app.getProperty("web.baseURL") + "/manage_overview_page.php");
        wd.get(app.getProperty("web.baseURL") + "/manage_user_page.php");
        wd.findElement(By.xpath("html/body/table[3]/tbody/tr[4]/td[1]/a")).click();
        wd.findElement(By.cssSelector("input[value='Reset Password']")).click();
    }

    public void change(String confirmationToLink, String whichPassword) {
        wd.get(confirmationToLink);
        type(By.name("password"), app.getProperty("web.defaultPass"));
        type(By.name("password_confirm"), app.getProperty("web.defaultPass"));
        click(By.cssSelector("input[value='Update User']"));
    }
}