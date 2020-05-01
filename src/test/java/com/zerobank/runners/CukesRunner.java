package com.zerobank.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue = "com/zerobank/step_definitions",
        tags = "@statements_documents",
        dryRun = false,
        plugin = "html:target/default-report"
)
public class CukesRunner {
}
