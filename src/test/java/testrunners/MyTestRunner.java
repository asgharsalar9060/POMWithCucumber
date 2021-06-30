package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/features" }, 
		glue = { "stepdefinitions", "apphooks" }, 
		plugin = {
				"pretty", "html:test-outout", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/"

}, 
		monochrome = true,
		strict = true,
		dryRun = false

)

public class MyTestRunner {

}
