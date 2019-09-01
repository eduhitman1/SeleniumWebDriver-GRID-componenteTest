import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteAlert {

	@Test
	@Ignore
	public void AlertSimple() {  //AUTOMACAO validação de texto na pagina
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		// Clicar no button Alert 
	     driver.findElement(By.id("alert")).click();
	     // Interação com javascript validação de mensagem
	    Alert  alert = driver.switchTo().alert();
		
	    String texto = alert.getText();
	    
	    Assert.assertEquals("Alert Simples", alert.getText());
		alert.accept();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto); 
	}
	
	
	@Test
	@Ignore
	public void AlertConfirm() {  //AUTOMACAO validação de texto na pagina
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
	    driver.findElement(By.id("confirm")).click();
	    Alert alert = driver.switchTo().alert();
	    Assert.assertEquals("Confirm Simples", alert.getText());
	    alert.accept();
	    Assert.assertEquals("Confirmado", alert.getText());
	    alert.accept();	
	    
	    driver.findElement(By.id("confirm")).click();
	    alert = driver.switchTo().alert();
	    Assert.assertEquals("Confirm Simples", alert.getText());
	    alert.dismiss();
	    Assert.assertEquals("Negado", alert.getText());
	    alert.dismiss();
	}
	
	@Test
	@Ignore
	public void AlertPrompt() {  //AUTOMACAO validação de texto na pagina
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		driver.findElement(By.id("prompt")).click();
	    Alert alert = driver.switchTo().alert();
	    Assert.assertEquals("Digite um numero", alert.getText());
	    alert.sendKeys("12");
	    alert.accept();
	    alert.sendKeys("12");
	    alert.accept();
	    alert.sendKeys("12");
	    alert.accept();
	}
	
	
		
	
}
