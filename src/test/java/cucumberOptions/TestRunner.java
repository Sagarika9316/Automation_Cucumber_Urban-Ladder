package cucumberOptions;

import org.junit.runner.RunWith;

@RunWith(io.cucumber.junit.Cucumber.class)
@io.cucumber.junit.CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions")
public class TestRunner {

}
