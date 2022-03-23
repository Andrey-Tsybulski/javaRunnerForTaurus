package selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class JunitBaseTest {

    @BeforeClass
    public static void beforeSuite() {
        System.out.println("beforeSuite");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterSuite");
    }

    @Test
    public void startTest() throws MalformedURLException {
//      ChromeOptions chromeOptions = new ChromeOptions();
//      chromeOptions.addArguments("start-maximized");
//
//        System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/Downloads/chromedriver_win32/chromedriver.exe");
//        WebDriver driver = new ChromeDriver(chromeOptions);

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        capabilities.setCapability(ChromeOptions.CAPABILITY, options);


        WebDriver driver = new RemoteWebDriver(
                URI.create("http://your-url/wd/hub").toURL(), capabilities);

        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        try {
            driver.get("https://fifa.new-dev.smartexclusives.com/");
            Thread.sleep(20000);

            driver.get("https://fifa.new-dev.smartexclusives.com/auctions");
            Thread.sleep(20000);

            driver.get("https://fifa.new-dev.smartexclusives.com/drops");
            Thread.sleep(20000);

            driver.get("https://fifa.new-dev.smartexclusives.com/marketplace");
            Thread.sleep(20000);

//            driver.findElement(By.id("deskHeaderAuctionBtn")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("deskHeaderDropsBtn")).click();
//            Thread.sleep(5000);
//
//            driver.findElement(By.id("deskHeaderMarketplaceBtn")).click();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
