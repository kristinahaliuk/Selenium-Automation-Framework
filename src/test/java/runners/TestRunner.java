package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        features = "src/test/resources/features",
        glue = "step_definitions",
        tags = "@t1",
        dryRun = false,
        monochrome = true
)

public class TestRunner {

}
