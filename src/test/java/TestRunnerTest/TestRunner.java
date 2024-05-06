package TestRunnerTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(

		features = { "src/test/java/features/itemsfetching.feature" }, glue = {
				"StepDefinitionCucumber" }, monochrome = true, dryRun = false

)

public class TestRunner extends AbstractTestNGCucumberTests {
}