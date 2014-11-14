package TestCOT.TeacherRole.Dashboard.Reports;

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

public class CollegesStudentAttending {
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
    public void testCollegesStudentAttending() throws Exception {
        driver.get(baseUrl + "/teacher-reports");
        driver.findElement(By.linkText("Colleges Students Attending")).click();
        driver.findElement(By.id("edit-combine")).clear();
        driver.findElement(By.id("edit-combine")).sendKeys("pa");
        driver.findElement(By.id("edit-submit-college-destination")).click();
        driver.findElement(By.id("edit-combine")).clear();
        driver.findElement(By.id("edit-combine")).sendKeys("ama");
        driver.findElement(By.id("edit-submit-college-destination")).click();
        driver.findElement(By.id("edit-combine")).clear();
        driver.findElement(By.id("edit-combine")).sendKeys("sh");
        driver.findElement(By.id("edit-submit-college-destination")).click();
        driver.findElement(By.id("edit-combine")).clear();
        driver.findElement(By.id("edit-combine")).sendKeys("g");
        driver.findElement(By.id("edit-submit-college-destination")).click();
        driver.findElement(By.linkText("Any")).click();
        driver.findElement(By.id("edit-submit-college-destination")).click();
        driver.findElement(By.id("edit-combine")).clear();
        driver.findElement(By.id("edit-combine")).sendKeys("");
        driver.findElement(By.id("edit-submit-college-destination")).click();
        driver.findElement(By.cssSelector("img.image-style-none")).click();
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
