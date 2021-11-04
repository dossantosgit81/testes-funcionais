import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {
	
	@Test
	public void deveInteragirComAlertSimples() {
		WebDriver driver  = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Alert Simples", textoAlert);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(textoAlert);
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		WebDriver driver  = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		String textoAlert = alert.getText();
		Assert.assertEquals("Confirm Simples", textoAlert);
		alert.accept();
		textoAlert = alert.getText();
		Assert.assertEquals("Confirmado", textoAlert);
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		 alert = driver.switchTo().alert();
		 textoAlert = alert.getText();
		Assert.assertEquals("Confirm Simples", textoAlert);
		alert.dismiss();
		textoAlert = alert.getText();
		Assert.assertEquals("Negado", textoAlert);
		alert.dismiss();
		
	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
		WebDriver driver  = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
	}
	
}
