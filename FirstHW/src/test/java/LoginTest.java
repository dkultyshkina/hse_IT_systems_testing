import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

  /*
  1.Открыть страницу https://www.saucedemo.com/
  2. Оставить поле username пустым
  3. Оставить поле password пустым
  4. Нажать кнопку Login
  5. Проверить, что мы видим сообщение об ошибке с текстом
     Epic sadface: Password is required
   */

  @Test
  public void checkNegativeLoginWithEmptyLogin() {
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://www.saucedemo.com/");

    driver.findElement(By.id("user-name")).sendKeys("");
    driver.findElement(By.id("password")).sendKeys("");
    driver.findElement(By.id("login-button")).click();

    String errorMessage =
        driver.findElement(By.cssSelector("[data-test=error]")).getText();

    Assert.assertEquals(errorMessage, "Epic sadface: Username is required");

    driver.quit();
  }

  /*
  1.Открыть страницу https://www.saucedemo.com/
  2. Ввести в поле username значение standard_user1
  3. Ввести в поле password значение secret_sauce1
  4. Нажать кнопку Login
  5. Проверить, что мы видим сообщение об ошибке с текстом
     Epic sadface: Username and password do not match any user in this service
   */

  @Test
  public void checkNegativeIncorrectLoginAndPassword() {
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://www.saucedemo.com/");

    driver.findElement(By.id("user-name")).sendKeys("standard_user1");
    driver.findElement(By.id("password")).sendKeys("secret_sauce1");
    driver.findElement(By.id("login-button")).click();

    String errorMessage =
        driver.findElement(By.cssSelector("[data-test=error]")).getText();

    Assert.assertEquals(
        errorMessage,
        "Epic sadface: Username and password do not match any user in this service");

    driver.quit();
  }

  /*
  1.Открыть страницу https://www.saucedemo.com/
  2. Ввести в поле username значение standard_user123
  3. Ввести в поле password значение secret_sauce
  4. Нажать кнопку Login
  5. Проверить, что мы видим сообщение об ошибке с текстом
     Epic sadface: Username and password do not match any user in this service
   */

  @Test
  public void checkNegativeIncorrectLogin() {
    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://www.saucedemo.com/");

    driver.findElement(By.id("user-name")).sendKeys("standard_user123");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

    String errorMessage =
        driver.findElement(By.cssSelector("[data-test=error]")).getText();
    System.out.println(errorMessage);
    Assert.assertEquals(
        errorMessage,
        "Epic sadface: Username and password do not match any user in this service");

    driver.quit();
  }
}