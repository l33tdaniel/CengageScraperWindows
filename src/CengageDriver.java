import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;

public class CengageDriver {
    private String link;
    private WebDriver driver;

    public CengageDriver(String link) {
        this.link = link;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\D\\Desktop\\Coding\\CengageScraperWindows\\includedFiles\\chromedriver.exe");
        // the following line is what will actually start the driver.
        driver = new ChromeDriver();
        openPage(driver, link);
    }

    public void endThis() throws Exception {
        driver.quit();
    }
    private void openPage(WebDriver driver, String link) {
        driver.get(link);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        enteringRockhurst(driver);
    }
    private void enteringRockhurst(WebDriver driver){
        try {
            WebElement school = driver.findElement(By.id("schoolSearchText"));
            school.sendKeys("ROCKHURST HIGH SCHOOL");     
            Thread.sleep(1000);
            school.sendKeys(Keys.DOWN);
            Thread.sleep(200);
            school.sendKeys(Keys.RETURN);
            Thread.sleep(100);
            fillingCreds(driver);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }
    private void enteringCreds(WebDriver driver) {
        try {
            Scanner in = new Scanner(System.in);
            WebElement username = driver.findElement(By.id("UserName"));
            System.out.println("What is your username?");
            username.sendKeys(in.nextLine());
            WebElement password = driver.findElement(By.id("Password"));
            System.out.println("What is your password?");
            password.sendKeys(in.nextLine());
            Thread.sleep(10);  
            launchCourse(driver);
            password.sendKeys(Keys.ENTER);
        }   catch(InterruptedException e) {
                System.out.println("got interrupted!");
        }
    }
    private void fillingCreds(WebDriver driver) {
        try {
            Thread.sleep(500);
            WebElement username = driver.findElement(By.id("UserName"));
            username.sendKeys("username");
            Thread.sleep(400);
            WebElement password = driver.findElement(By.id("Password"));
            password.sendKeys("password");
            Thread.sleep(10);
            password.sendKeys(Keys.ENTER);
            launchCourse(driver);
            }catch(Exception e) {
                System.out.println(e + " happened, and this should also be deleted regardless");
        }
    }
    private void launchCourse(WebDriver driver) {
        try{
            Thread.sleep(1000);
            WebElement launchClass = driver.findElement(By.id("course-8032155"));
            launchClass.click();
            //enterAssignment(driver);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
   
}



/* 

Going to make a seerate class for the files database and you should also have the
different chrome drivers for each of the chrome versions

*/
// smrt name
