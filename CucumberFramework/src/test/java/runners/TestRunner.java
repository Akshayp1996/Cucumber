package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalTests", glue = {
		"stepDefinations" }, monochrome = false, dryRun = false, plugin = { "pretty", "html:target/cucumber.html",
				"json:target/cucumber.json", "junit:target/cucumberReport.xml", })
public class TestRunner {
}
//<<<<<<< HEAD
//jdcbhds
//=======
//Testjenkins
//>>>>>>> 5678a569e75c87c8364ec5ff4d7bf3361cc71883
