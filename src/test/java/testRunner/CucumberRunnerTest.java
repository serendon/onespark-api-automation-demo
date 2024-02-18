package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(tags = "", features = "src/test/resources/features/", glue = "steps",
        plugin = {"pretty", "html:target/cucumber.html"})

public class CucumberRunnerTest {
}