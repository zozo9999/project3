package project2.project2;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Run_Hooks {

	public Run_Hooks() {
		// TODO Auto-generated constructor stub
	}

	@Before("@Sorting_AZ")
	public void bf() {
		System.out.println("cucumber hook before");
	}
	
	@After("@Sorting_AZ")
	public void af() {
		System.out.println("Cucumber book after");	
	}
	
}
