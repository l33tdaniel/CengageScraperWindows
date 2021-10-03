import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;

public class Webdriver {
    public static void startTab() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        System.out.println("placeholder");
        // locating where the webdriver is
        System.setProperty("webdriver.chrome.driver", "/Users/danielneugent/Desktop/CodingProjects/CengageScraper/includedFiles/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://nglsync.cengage.com/portal/Account/LogOn?ReturnUrl=%2fportal");
        Thread.sleep(3000);

            // This is finding Rockhurst
        WebElement school = driver.findElement(By.id("schoolSearchText"));
        school.sendKeys("ROCKHURST HIGH SCHOOL");     
        Thread.sleep(1000);
        school.sendKeys(Keys.DOWN);
        Thread.sleep(200);
        school.sendKeys(Keys.RETURN);
        Thread.sleep(1000);
            // This is going to enter in our data for our name.
        WebElement username = driver.findElement(By.id("UserName"));
        System.out.println("What is your username?");
        username.sendKeys(in.nextLine());
        WebElement password = driver.findElement(By.id("Password"));
        System.out.println("What is your password?");
        password.sendKeys(in.nextLine());
            
        in.close();
        // don't want the memory leaks..
        password.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement launchClass = driver.findElement(By.id("course-8032155"));
        launchClass.click();
        Thread.sleep(4000);
        // memory leaks..
        driver.close();
    
    }
    /*
    public static void OpeningAssignment() {
        // the purpose of this is to be able to find a Unit header.
        WebElement testingThis = driver.findElement(By.id("topic-heading-1-1258893112"));
    }
*/

}
       // id="topic-heading-1-1258893112
        /*
// test 
        element = driver.find_element :xpath, '//input[@name="q"]'
element.click();
        WebElement launchClass = driver.findElement(By.id("course-8032155"));
        */
// only online kid to not get a 1