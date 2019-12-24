import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Frames_Janelas {

	@Test
	public void Frames() {  //AUTOMACAO validação de texto na pagina
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		
		// Passagem do Page para Frame
		driver.switchTo().frame("frame1");
		// Clicar no button do frame
		driver.findElement(By.id("frameButton")).click(); 
		// Alert do frame
		Alert alert = driver.switchTo().alert();
		// validaçcao
		
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!",msg);
		alert.accept(); 
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}
	
	@Test
	public void Janelas() {
		// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName(("textarea"))).sendKeys("Deu certo");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("e agora ?");
	}
	
	
	
	
}
