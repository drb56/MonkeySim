import static org.junit.Assert.*;
import static org.testng.FileAssert.fail;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class PinningTests {

    /**
     * Runs this setup before the actual tests
     *
     * @throws Exception
     */
    @Before
    public void setUp() {

    }

    @Test
    public void getFirstMonkeyTest() {
        Monkey firstMonkey = new Monkey();
        assertEquals(firstMonkey.getId, 1);
    }

}
