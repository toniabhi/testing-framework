package TestCOT.StudentRole.Messages;

/**
 * Created by om on 11/12/2014.
 */
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeeBroadcastMessages {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://collegeontrackdev.prod.acquia-sites.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSeeBroadcastMessages() throws Exception {
        driver.get(baseUrl + "/messages");
        driver.findElement(By.linkText("Broadcast")).click();
        driver.findElement(By.linkText("Broadcast")).click();
        driver.findElement(By.cssSelector("a.use-ajax.ajax-processed")).click();
        driver.findElement(By.cssSelector("span.close-button > img")).click();
        driver.findElement(By.linkText("Remove")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        driver.findElement(By.linkText("Remove")).click();
        driver.findElement(By.xpath("//div[7]/div/a/span")).click();
        driver.findElement(By.linkText("Remove")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
