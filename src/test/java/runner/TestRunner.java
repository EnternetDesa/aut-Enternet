package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/feature", // Ruta fija al directorio de tus features
        glue = {"definitions", "page"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        },
        tags = "${cucumber.filter.tags}", // Permite usar -Dcucumber.filter.tags en el .bat
        monochrome = true
)
public class TestRunner {
}

