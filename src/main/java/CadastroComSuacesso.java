import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class CadastroComSuacesso {

	
	@Test
	public void CadastrarComSucesso() {  //AUTOMACAO validação de texto na pagina
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\eduardo.matias\\Documents\\DRIVERS\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		// Digita no campo id "elementosForm:nome" que está dentro do formulário id
		// o texto "eduardo"
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Eduardo");
		// Digita no campo id "elementosForm:sobrenome" que está dentro do formulário id
		// o texto "Henrique"
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Henrique");
		// selecionar no campo id "elementosForm:sexo:0" que está dentro do formulário id
        //	RadioButton masculino
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		//  selecionar no campo id "elementosForm:comidaFavorita:2" que está dentro do formulário id
		// checkBox pizza
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		// selecionar no campo id "elementosForm:escolaridade" que está dentro do formulário id 
		// seleciona escolaridade
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		combo.selectByVisibleText("2o grau completo");
	
		// Selecionar no id "elementosForm:esportes"  que esta dentro do formulário de id
    	// Selecionar 3 opcoes
		WebElement element2 = driver.findElement(By.id("elementosForm:esportes"));
		Select combo2 = new Select(element2);
		combo2.selectByVisibleText("Natacao");
		
	    // Clicar no campo id "elementosForm:cadastrar" que esta dentro do formulário de id
		driver.findElement(By.id("elementosForm:cadastrar")).click();
	    
		//Validações  de dados cadastrados.
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		
		Assert.assertEquals("Nome: Eduardo", driver.findElement(By.id("descNome")).getText());
		Assert.assertEquals("Sobrenome: Henrique", driver.findElement(By.id("descSobrenome")).getText());
		Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
		Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
		Assert.assertEquals("Escolaridade: 2graucomp", driver.findElement(By.id("descEscolaridade")).getText());
		Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
	}
	
	
}
