import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class TesteCampoTreinamento {

	@Test
	@Ignore
	public void InputTest() {   //AUTOMACAO PARA INPUT 
		// Caminho do ChromeDriver
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
		WebDriver driver = new ChromeDriver();
		// Diretório onde está apontando o arquivo trenamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		// Digitar no campo com id "elementosForm:nome" que está dentro do formulário de id
		// o texto "Test"
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Test");
		
		// Validando no campo se "Test" foi passado via automacao
		Assert.assertEquals("Test", driver.findElement(By.id("elementosForm:nome")).getAttribute("value")); //validando

		// Fecha Navegador
		driver.quit();
		
	}
	
	@Test
	@Ignore
	public void InputCaixaText() {  //AUTOMACAO PARA CAIXA DE TEXTO
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		
		//Digira no campo com id "elementos:Form:sugestoes" que esta dentro do formulário de is
		// o texto "Test"
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("testando");
		
		// Validando no campo se "testando" foi passado via automacao
		assertEquals("testando", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		// Fecha Navegador
		driver.quit();
	}
	
	@Test
	@Ignore
	public void RadioButton() {  //AUTOMACAO PARA RADIO BUTTON
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		// Selecionar no id "elementosFrom:sexo:0" que esta dentro do formulário de id
		// Selecionar com click
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		// Verificando no RadioButton está selecionado
	    Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		
	    //Fecha Navegador
	    driver.quit();
   	}
	
	@Test
	@Ignore
	public void CheckBox() {  //AUTOMACAO PARA CHECK BOX
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		// Selecionar no nome "elementosForm:comidaFavorita:2"  que esta dentro do formulário de id
		// Selecionar com click Pizza
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		
		// Verificando no CheckButton está selecionado
	    Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
	    //Fecha Navegador
	   driver.quit();
   	}
	
	
	@Test
	@Ignore
	public void ComboBox() {  //AUTOMACAO PARA COMBOBOX
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		// Instancia de element
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		// Instancia de combo
		Select combo = new Select(element);
		
		// Selecionar no combo, onde contem a terceira opção
		// Index começa com zero
		 //     combo.selectByIndex(3);
		 //     combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		
		// Validação de comboBox passado via automacao
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		
		driver.quit();
	}
	
	@Test
	@Ignore
	public void DisponiveisComboBox() {  //AUTOMACAO PARA COMBOBOX  NÃO ADEQUANDO APENAS VERIFICA SE TEM "mestrado" o campo fica não alteração 
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		// Instancia de element
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		
		// Instancia de combo
		Select combo = new Select(element);
		
		// Listagem disponivel no comboBox com validação de quantidade de elementos
		List<WebElement> options = combo.getOptions();
		// Verificação se a quantidade é igual a 8
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		// Validação final
		Assert.assertTrue(encontrou);
	}
	
	@Test
	@Ignore
	public void SelecionarComboBoxEspecificos() {  //AUTOMACAO PARA COMBOBOX  NÃO ADEQUANDO APENAS VERIFICA SE TEM "mestrado" o campo fica não alteração 
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	    // Instancia de element
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		// Instancia de combo
		Select combo = new Select(element);
	    
	   
		// Selecionar no id "elementosForm:esportes"  que esta dentro do formulário de id
    	// Selecionar 3 opcoes
	    combo.selectByVisibleText("Natacao");
	    combo.selectByVisibleText("Corrida");
	    combo.selectByVisibleText("O que eh esporte?");
	
	    
	 // Deselecionar no id "elementosForm:esportes"  que esta dentro do formulário de id
	    combo.deselectByVisibleText("Natacao");
	    
	    
	    List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
	    Assert.assertEquals(2, allSelectedOptions.size());
	    
	    driver.quit();
	}
	
	@Test
	@Ignore
	public void ClickButton() {  //AUTOMACAO PARA Button Click troca de value
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		
		// Clicar no nome "buttonSimple"  que esta dentro do formulário de id
	    // clicl com click Pizza
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		
		// Instancia para validação de troca de value de "clime me!" para "Obrigado!"
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
		driver.quit();
	}
	
	
	@Test
	public void LinkText() {  //AUTOMACAO por link
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
		
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
		// Assert.fail(); // COMANDO PARA FALHA O TESTE
		
	}
	
	@Test
	public void VerificacaoDeTexto() {  //AUTOMACAO validação de texto na pagina
    	// Caminho do ChromeDriver
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\Eduardo\\Documents\\Softwares & Servidores\\WEBDRIVER\\chromedriver.exe");
		// Instancia do driver
    	WebDriver driver = new ChromeDriver();
    	// Diretório onde está apontando o arquivo treinamento de teste via chrome browse
		driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
	
	    // Exibir no console todo conteudo da page
		System.out.println(driver.findElement(By.tagName("body")));
		
		// Valida se na tag "body" existe o value campo de treinamento
	//	Assert.assertTrue(driver.findElement(By.tagName("body"))
	//			.getText().contains("Campo de Treinamento"));
	
		Assert.assertEquals("Campo de Treinamento",driver.findElement(By.tagName("h3")).getText());
		
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",driver.findElement(By.className("span")).getText());
		
		
	driver.quit();
	
	}
	
	
	
	
	
	
	
}
