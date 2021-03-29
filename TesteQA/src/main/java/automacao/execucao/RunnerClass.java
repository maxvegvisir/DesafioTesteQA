package automacao.execucao;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = "automacao",
		monochrome = true, 
		dryRun = false, 
		tags = { "@BuscarPreçoNaKabum" }
		)
public class RunnerClass {

}
