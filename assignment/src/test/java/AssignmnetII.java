import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class AssignmnetII {
    Keywords key=new Keywords();
   // Script for URL Navigation
    @Test
    public void urlNavigation() throws Exception{
        PropReader singleton = PropReader.getInstance();
        key.openBrowser();
        key.driver.navigate().to(singleton.prop.getProperty("MHurl"));
        String actualTitle = key.driver.getTitle();
        Assert.assertEquals(singleton.prop.getProperty("title"),actualTitle,"Title is not Matching");
        System.out.println(actualTitle);
        }

    // Script for Mouse Hover
    @Test (priority = 1)
    public void mouseHover() throws Exception{
        PropReader singleton = PropReader.getInstance();
        key.openBrowser();
        key.driver.navigate().to(singleton.prop.getProperty("MHurl"));
        key.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = key.driver.findElement(By.linkText("Media"));
        Actions action = new Actions(key.driver);
        action.moveToElement(element).build().perform();
        key.driver.findElement(By.linkText("News Hub")).click();
    }

    // Script for Drag And Drop
    @Test (priority = 2)
    public void dragAndDrop() throws Exception{
        PropReader singleton = PropReader.getInstance();
        key.openBrowser();
        key.driver.navigate().to(singleton.prop.getProperty("url"));
        key.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement From = key.driver.findElement(By.xpath(singleton.prop.getProperty("drag")));
        WebElement To = key.driver.findElement(By.xpath(singleton.prop.getProperty("drop")));
        Actions action = new Actions(key.driver);
        action.dragAndDrop(From, To).build().perform();
    }


    // Script for Frame Handling
    @Test (priority=3)
    public void frameHandle() throws Exception{
        PropReader singleton = PropReader.getInstance();
        key.openBrowser();
        key.driver.navigate().to(singleton.prop.getProperty("furl"));
        key.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<WebElement> frameCount = key.driver.findElements(By.tagName("iframe"));
        System.out.println("Total Number Of Frames   :"+ frameCount.size());
        key.driver.switchTo().frame(1);
        int size = key.driver.findElements(By.tagName("iframe")).size();
        System.out.println(size);

    }

    // Script for Page scroll using Key Press
    @Test (priority=4)
    public void pageScrollUsingKey() throws Exception{
        PropReader singleton = PropReader.getInstance();
        key.openBrowser();
        key.driver.navigate().to(singleton.prop.getProperty("scroll"));
        key.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Actions action = new Actions(key.driver);
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_UP).build().perform();
    }


    // Script for Page scroll using Javascript executer
    @Test (priority=5)
    public void pageScrollUsingJsExecutor() throws Exception{
        PropReader singleton = PropReader.getInstance();
        key.openBrowser();
        key.driver.navigate().to(singleton.prop.getProperty("scroll"));
        key.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor)key.driver;
        // Scroll only 250 px vertical
        // js.executeScript("window.scrollBy(0,250)", "");
        // Scroll full Page vertical
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
    }

    // To Close Browser window
    @AfterMethod
    public void close(){
        key.driver.close();
    }

}
