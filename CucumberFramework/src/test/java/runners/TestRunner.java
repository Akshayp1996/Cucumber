package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalTests", glue = {
		"stepDefinations" }, tags = "@Test1", monochrome = false, dryRun = false, plugin = { "pretty",
				"html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cucumberReport.xml", })
public class TestRunner {
}
