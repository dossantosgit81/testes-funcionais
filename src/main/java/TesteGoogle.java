import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

	@Test
	public void teste() {
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().setSize(new Dimension(800, 765));
		driver.get("http://google.com");
		Assert.assertEquals("Yahoo", driver.getTitle());
		driver.quit();
	}
	
}
