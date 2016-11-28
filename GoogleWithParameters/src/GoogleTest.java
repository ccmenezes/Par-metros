import static org.junit.Assert.*;

import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@SuppressWarnings("unused")
@RunWith(Parameterized.class)
public class GoogleTest {
	
		
		WebDriver driver;
		private String parametroDeBusca;
				
		public GoogleTest(String parametroDeBusca){
			this.parametroDeBusca = parametroDeBusca;
		}
		
		@Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", "settings/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.google.com.br/");
		}
		
		@Parameterized.Parameters
		public static Collection entrada(){
			return Arrays.asList(new Object [][]{ {"Selenium"}, {"Selenium IDE"}, {"Selenium WebDriver"}});
		}
		
		@After
		public void tearDown() throws Exception {
			driver.quit();
		}
		
		@Test
		public void test() throws InterruptedException {
			WebElement palavra = driver.findElement(By.className("gsfi"));
			palavra.sendKeys(parametroDeBusca);
			palavra.submit();
			Thread.sleep(3000);
			
			boolean confirmarGetTitle = driver.getTitle().contains(parametroDeBusca);
						
			assertTrue(confirmarGetTitle);
		}

}