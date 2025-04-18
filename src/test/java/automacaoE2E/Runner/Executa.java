package automacaoE2E.Runner;

import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

import automacaoE2E.Drivers.Drivers;
import java.util.Locale;

public class Executa extends Drivers {
    
    ChromeOptions options = new ChromeOptions();

    @BeforeAll
    public static void setupBeforeAll() {
        // Configura o Locale usando o método correto (não mais a string diretamente)
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));
    }

    @Test
    public void setup() {
        try {
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.get("https://desafio.ui.e2etreinamentos.com.br/hb.html");
        } catch (Exception e) {
            throw new UnreachableBrowserException("Não foi possível abrir o navegador");
        }
    }
    
    
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
