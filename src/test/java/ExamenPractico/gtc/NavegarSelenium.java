package ExamenPractico.gtc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class NavegarSelenium {
    public static class CapturaPantalla {

        public static class NavegarTest {

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
            public void testNavegarYCapturarMenu() throws InterruptedException {
                // Navega a la URL especificada
                driver.get("https://www.selenium.dev/documentation/");
                testTomarCapuraPantalla("Documentation_home");

                //Creando WebDriverWait para esperar a que los elementos se puedan clickear.
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                //1. Navegar al enlace de Overview y tomar captura.
                WebElement seleniumOverviewLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Overview")));
                seleniumOverviewLink.click();
                testTomarCapuraPantalla("Overview");
                Thread.sleep(5000);

                //Navegar al enlace de WebDriver y tomar captura.
                WebElement seleniumWebDriverLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("WebDriver")));
                seleniumWebDriverLink.click();
                testTomarCapuraPantalla("WebDriver");
                Thread.sleep(5000);

                // Navegar al enlace de Grid y tomar captura.
                WebElement seleniumGridLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Grid")));
                seleniumGridLink.click();
                testTomarCapuraPantalla("Grid");

                //Navegar al enlace de IDE y tomar captura.
                WebElement seleniumIDELink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("IDE")));
                seleniumIDELink.click();
                testTomarCapuraPantalla("IDE");
                Thread.sleep(5000);

                //Navegar al enlace de Legacy y tomar captura.
                WebElement seleniumLegacyLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Legacy")));
                seleniumLegacyLink.click();
                testTomarCapuraPantalla("Legacy");
                Thread.sleep(5000);

                //Navegar al enlace de About y tomar captura.
                WebElement seleniumAboutLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("About")));
                seleniumAboutLink.click();
                testTomarCapuraPantalla("About");
                Thread.sleep(5000);

            }
            @Test
            public void testTomarCapuraPantalla(String overview) {
                //Tomar captura de pantalla
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destination = new File("src/test/resources/capturaPantalla.png");
                //System.out.println("Captura tomada y gudarda como" + destination.getAbsolutePath());

                try {
                    FileUtils.copyFile(screenshot, destination);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
