package TestCOT.StudentRole.Iplan;

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

public class AddCourseRequest {
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
    public void testAddCourseRequest() throws Exception {
        driver.get(baseUrl + "/student-planner?track=891361");
        driver.findElement(By.linkText("Course Planner")).click();
        driver.findElement(By.linkText("Course Planner")).click();
        driver.findElement(By.linkText("Add Class")).click();
        driver.findElement(By.id("subject-social_science")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("grade-12")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("subject-foreign_languages")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.findElement(By.id("grade-9")).click();
        driver.findElement(By.id("edit-submit")).click();
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
