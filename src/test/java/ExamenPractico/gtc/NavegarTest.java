package ExamenPractico.gtc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Objects;

public class NavegarTest {

        private WebDriver driver;

        // Inicializar el WebDriver
        @BeforeClass
        public void setUp() {
            // Configura WebDriverManager para manejar la versión de ChromeDriver
            WebDriverManager.chromedriver().setup();
            // Crea una nueva instancia de ChromeDriver
            driver = new ChromeDriver();
            //Maximizar ventana
            driver.manage().window().maximize();
        }

        // Prueba que abre una página web
        @Test
        public void testOpenWebsite() {
            // Navega a la URL especificada
            driver.get("https://www.selenium.dev/documentation/");

        }

        // Cierra el navegador después de la prueba
        @AfterClass
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }


