package ExamenPractico.gtc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CapturaPantalla {

    public class NavegarTest {

        private WebDriver driver;

        // Inicializar el WebDriver
        @BeforeClass
        public void setUp() {
            // Configura WebDriverManager para manejar la versión de ChromeDriver
            WebDriverManager.chromedriver().setup();

            // Crea una nueva instancia de ChromeDriver
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void testNavegarEnlaces() throws InterruptedException, IOException {
            // Navega a la URL especificada
            driver.get("https://www.selenium.dev/documentation/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File archive = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/capturaPantalla.png" );
            try {
                FileUtils.copyFile(archive, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


