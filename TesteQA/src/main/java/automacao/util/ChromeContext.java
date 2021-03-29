package automacao.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(JUnit4.class)
public class ChromeContext {

	private static WebDriver driver;
	private static String url = "http://www.google.com.br";
	private static JavascriptExecutor executorJS;
	private Map<Integer, String> progrmasParaMatar = new HashMap<Integer, String>();

	public static WebDriver getDriver() {
		return driver;
	}

	@SuppressWarnings("deprecation")
	@Before
	public void startWebDriver() {
		stopProcess();
		System.getProperties().list(System.out);

		if (System.getProperty("webdriver.chrome.driver") == null) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		}

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("browserName", "chrome");

		ChromeContext.driver = new ChromeDriver(capabilities);

		setExecutorJS((JavascriptExecutor) ChromeContext.driver);

		ChromeContext.driver.manage().window().maximize();

		ChromeContext.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@After
	public void stopWebDriver() {
		driver.close();
		driver.quit();
		stopProcess();
	}

	protected void inputURL(String url) {
		if (url.equals(null)) {
			driver.get(ChromeContext.url);
		} else {
			driver.get(url);
		}
	}

	public Map<Integer, String> getProgramasParaMatar() {
		return progrmasParaMatar;
	}

	public void setProgramasParaMatar(Map<Integer, String> progrmasParaMatar) {
		this.progrmasParaMatar.clear();
		this.progrmasParaMatar = progrmasParaMatar;
	}

	public boolean matarProgramas(ArrayList<String> lista) {
		try {

			Map<Integer, String> programas = new HashMap<Integer, String>();

			Iterator<String> iterator = lista.iterator();
			int count = 0;

			while (iterator.hasNext()) {
				programas.put(count, iterator.next());
				count++;
			}
			setProgramasParaMatar(programas);
			stopProcess();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean matarPrograma(String programaSemExe) {
		try {
			killProcessCmd("chromedriver");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private void stopProcess() {
		Iterator<Entry<Integer, String>> iterator = this.progrmasParaMatar.entrySet().iterator();

		while (iterator.hasNext()) {
			String nomePrograma = iterator.next().getValue();
			killProcessCmd(nomePrograma);
		}
	}

	private void killProcessCmd(String nomeSemPontoExe) {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM " + nomeSemPontoExe + ".exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JavascriptExecutor getExecutorJS() {
		return executorJS;
	}

	public static void setExecutorJS(JavascriptExecutor executorJS) {
		ChromeContext.executorJS = executorJS;
	}

}