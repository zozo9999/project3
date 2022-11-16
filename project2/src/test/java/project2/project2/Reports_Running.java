package project2.project2;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/Features", glue= {"StepDefinitions"},
monochrome = true,

plugin = {"pretty", "junit:target/junit/report3.xml",
		"html:target/html/HtmlReports3",
		"json:target/JSONReports/report3.json"},
tags="@Sorting_HL"
		)

public class Reports_Running {

	public Reports_Running() {
		// TODO Auto-generated constructor stub
	}

}
