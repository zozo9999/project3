@featureTest
Feature: Check sorting is working.
	#tag name above feature will run all tags in the below.	
	#tag names = or, and, , or and, and not,
	
	Background:
	Given validate brwoser
	When browser is triggared
	Then check if brwoser is started
	
	@Login
	Scenario: Login in
    Given Log in "standard_user"
    When Click log in button
    Then Vertify if login in
			
	@Sorting_AZ
  Scenario Outline: User sorts A to Z
    Given Login <username>, Sorting tab is seen.
    And Showing the list when a user clicks the tab
    When click "A to Z" is clicked.
    Then Vertify_A_to_Z

#Examples:
 #|Sort  			|
 #|A to Z			|
 #|Z to A			|
 #|low to high	|
 #|high to low	|
 #
#| Jung | Shin | email@email.com |
# data driving testign
# DataTable data
# List<List<String>> obj = daa.raw
# get(0).get(0)
# get(0).get(1)
# get(0).get(2) 

#"" means regular exression and can reduce duplicate .
  #@Sorting_ZA
  #Scenario: User sorts Z to A
 #		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When click "Z to A" is clicked.
#		Then Products are sorted from "Sauce Labs Backpack" and <fname>, <lname>, <zip>.

#	@Sorting_LH
  #Scenario: Price low to high
#		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When click "low to high" is clicked.
#		Then Products are sorted from "low to high" and <fname>, <lname>, <zip>.

#	@Sorting_HL
  #Scenario Outline: Price high to low
#		Given Login <username>, Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When click "high to low" is clicked.
  #	Then Products are sorted from "high to low" and <fname>, <lname>, <zip>.
 	Examples:
	|username 								|fname |lname |zip |
	|standard_user 						|fname1|lname1|zip1|
#	|locked_out_user					|fname2|lname2|zip1|
  #|problem_user							|fname3|lname3|zip1|
  #|performance_glitch_user	|fname4|lname4|zip1|
  
 # The Scenario Outline keyword can be used to run the same Scenario multiple times, with different combinations of values.
  #<Username> <password>
 #Examples:
 #|Sort  			|
 #|A to Z			|
 #|Z to A			|
 #|low to high	|
 #|high to low	|
 
 #Examples:
 #|Username |password|
 #|user1    |pass1   |
 #|user2    |pass2   |
 #|user3    |pass3   |
 #|user4    |pass4   |

	#tag names = or, and, , or and, and not, 
#	@Sorting_AZ
  #Scenario: User sorts A to Z
    #Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting A to Z is clicked.
    #Then Products are sorted from A to Z.

  #@Sorting_ZA
  #Scenario: User sorts Z to A
 #		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting Z to A is clicked.
#		Then Products are sorted from Z to A.

#	@Sorting_LH
  #Scenario: Price low to high
#		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting low to high is clicked.
#		Then Products are sorted from low to high
 
#	@Sorting_HL
  #Scenario: Price high to low
#		Given Sorting tab is seen.
    #And Showing the list when a user clicks the tab
    #When Click Sorting high to low is clicked.
  #	Then Products are sorted from high to low
	

