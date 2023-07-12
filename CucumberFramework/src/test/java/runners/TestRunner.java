package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalTests/End2End_Tests.feature", glue = {
		"stepDefinations" }, monochrome = false, dryRun = false, plugin = { "pretty", "html:target/cucumber.html",
				"json:target/cucumber.json", "junit:target/cucumberReport.xml", })
public class TestRunner {

}