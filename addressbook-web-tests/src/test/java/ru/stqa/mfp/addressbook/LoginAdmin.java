package ru.stqa.mfp.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginAdmin {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    wd.get("https://test-gidapp.k8s-dev.gid.team/auth/realms/gid/protocol/openid-connect/auth?client_id=admin&redirect_uri=https%3A%2F%2Fadmin-test-gidapp.k8s-dev.gid.team%2Fapp%2Fnews&state=22ab3046-c108-47aa-bb62-0e55f9959ab5&response_mode=fragment&response_type=code&scope=openid&nonce=046fe4e3-c913-4174-82b8-7761b1e94373");
    wd.findElement(By.id("social-GID")).click();
    wd.get("https://preprod.gid-auth.ru/cas/login?gid_client=3ki7kLBAattRXCxyNcsEWafgITM6yas07Arikkjr&login_challenge=063b246a67ce4d8891cfdc0552f74fa2");
    wd.get("https://preprod.gid-auth.ru/cas/login/welcome?gid_client=3ki7kLBAattRXCxyNcsEWafgITM6yas07Arikkjr&login_challenge=063b246a67ce4d8891cfdc0552f74fa2");
    wd.findElement(By.id("23")).click();
    wd.findElement(By.id("23")).clear();
    wd.findElement(By.id("23")).sendKeys("+7 900 100 10 90");
    wd.findElement(By.xpath("//button[@type='submit']")).click();
    wd.get("https://preprod.gid-auth.ru/cas/login?gid_client=3ki7kLBAattRXCxyNcsEWafgITM6yas07Arikkjr&login_challenge=063b246a67ce4d8891cfdc0552f74fa2");
    wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    // Ожидание прохождения капчи
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div/input")).click();
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div/input")).clear();
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div/input")).sendKeys("7");
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[2]/input")).clear();
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[2]/input")).sendKeys("6");
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[3]/input")).clear();
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[3]/input")).sendKeys("4");
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[4]/input")).clear();
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[4]/input")).sendKeys("8");
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[5]/input")).clear();
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[5]/input")).sendKeys("1");
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[6]/input")).clear();
    wd.findElement(By.xpath("//div[@id='app']/div/div/div/div/form/div[2]/div/div[6]/input")).sendKeys("9");
    wd.get("https://preprod.gid-auth.ru/consent?consent_challenge=39a8bad6a156439487ec5898f2738963&gid_client=3ki7kLBAattRXCxyNcsEWafgITM6yas07Arikkjr");
    wd.get("https://admin-test-gidapp.k8s-dev.gid.team/app/news#state=22ab3046-c108-47aa-bb62-0e55f9959ab5&session_state=ec150da1-f4ed-44c7-a594-16ba5d059aeb&code=2a84e4e8-d69d-46ba-8528-599e1b9ba037.ec150da1-f4ed-44c7-a594-16ba5d059aeb.1b13d1db-715d-4ce4-bafd-ff0c47a30c29");
    wd.get("https://admin-test-gidapp.k8s-dev.gid.team/app/news");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}