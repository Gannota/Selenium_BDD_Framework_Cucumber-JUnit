package com.company.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources/features",
        glue = "com/company/step_defs",
        dryRun = false,
        tags = "@us01",
        //monochrome = true,
        publish = true //generating a report with public link

)
public class CukesRunner {}