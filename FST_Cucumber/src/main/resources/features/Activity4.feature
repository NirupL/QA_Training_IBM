@activity4
Feature: Login Test

@SmokeTest
Scenario: Testing Login
	Given the user is on the login page
	When the user enters "admin" and "password"
	And clicks the submit button
	Then get the confirmation message and verify it