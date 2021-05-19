import org.openqa.selenium.chrome.ChromeDriver;

public class Keywords

{
     ChromeDriver driver;
    public void openBrowser() throws Exception
    {
        PropReader singleton = PropReader.getInstance();
        System.setProperty(singleton.prop.getProperty("driver"), singleton.prop.getProperty("driverPath"));
        driver = new ChromeDriver();
    }


}