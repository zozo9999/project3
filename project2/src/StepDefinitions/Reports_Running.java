
import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features", glue= {"StepDefinitions"},
monochrome = true,

plugin = {"pretty", "junit:target/junit/report.xml",
		"html:target/html/HtmlReports",
		"json:target/JSONReports/report.json"},
tags="@Sorting_HL"
		)

public class Reports_Running {

	public Reports_Running() {
		// TODO Auto-generated constructor stub
	}

}
