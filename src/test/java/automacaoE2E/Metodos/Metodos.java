package automacaoE2E.Metodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automacaoE2E.Drivers.Drivers;

public class Metodos extends Drivers {

	/**
	 * Escreve num elemento atravez de um By capturado
	 * @param locator //captura através de um .findElement
	 * @param texto //escreve através de um .sendKeys
	 * @author Levis
	 */
	public void escrever(By locator, String texto) {
		try {
			driver.findElement(locator).sendKeys(texto);
		} catch (Exception e) {
			throw new NotFoundException("Não foi possivel encontrar o Elemento: " + locator);
		}
	}
	public void apagar(By locator) {
		try {
			driver.findElement(locator).clear();
		} catch (Exception e) {
			throw new NotFoundException("Não foi possivel encontrar o Elemento: " + locator);
		}
	}

	public void clicar(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			throw new NotFoundException("Não foi possivel encontrar o Elemento: " + locator);
		}

	}
	public void validarUrl(String urlEsperada) {
		try {
			String urlCapturada = driver.getCurrentUrl();
			assertEquals(urlCapturada, urlEsperada);
		} catch (Exception e) {
			throw new NotFoundException("Não foi possivel localizar a URL" + urlEsperada);
		}
	}
	public void capturarScreenshot() {
		String diretorio = "./automacaoE2E/src/test/java/Screenshots";
		String caminho = diretorio + "screenshot_" + System.currentTimeMillis() + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(caminho));
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Screenshot salva em: " + caminho);
	}
	public void validarAlert(String msgEsperada) {
		try {
			String msgCapturada = driver.switchTo().alert().getText();
			assertEquals(msgEsperada, msgCapturada);
		} catch (Exception e) {
			throw new NoAlertPresentException("Não foi possivel localizar o alert");
		}
	}
	public void aceitarAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			throw new NoAlertPresentException("Não foi possivel localizar o alert");
		}
	}
	public void validarTexto(By locator, String textoEsperado) {
		try {
			String textoCapturado = driver.findElement(locator).getText();
			assertEquals(textoCapturado, textoEsperado);
		} catch (Exception e) {
			throw new NoSuchElementException("Não foi possivel encontrar o Elemento" + locator);
		}
	}
	public void accAllAlerts() {
		while (true) {
	        try {
	            Alert alert = driver.switchTo().alert();
	            alert.accept();
	        } catch (NoAlertPresentException e) {
	            break;
	        }
	    }
	}
	public void esperarElementoSerVisivel(By elemento, int tempoDeEspera) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempoDeEspera));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
	}
}
