package me.cyj.lab2;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.csvreader.CsvReader;

@RunWith(Parameterized.class)
public class WebDriverTest {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String id = null;
  private String email = null;

  public WebDriverTest(String id, String email){
      this.id= id;
      this.email = email;
  }
  
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe");
    driver = new FirefoxDriver();
    driver.get("http://www.ncfxy.com/");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Parameters
  public static Collection<Object[]> getData() throws IOException{
      Object[][] obj = new Object[109][];
      CsvReader r = new CsvReader("C:/Users/chen/Desktop/测试第二次上机/info.csv",',',Charset.forName("GBK"));
      int count = 0;
      while(r.readRecord()){
          obj[count] = new Object[]{r.get(0), r.get(1)};
          count++;
      }
      return Arrays.asList(obj);
  }
  
  @Test
  public void testCase() throws Exception {
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys(this.id);
    driver.findElement(By.id("pwd")).clear();
    driver.findElement(By.id("pwd")).sendKeys(this.id.substring(4));
    driver.findElement(By.id("submit")).click();
    assertEquals(this.email, driver.findElement(By.xpath("//tbody[@id='table-main']/tr/td[2]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.close();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

//  private boolean isElementPresent(By by) {
//    try {
//      driver.findElement(by);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
}
