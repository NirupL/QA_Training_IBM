@activity1
Feature: Basic Syntax

@SmokeTest
Scenario: Simple Selenium test
	Given the user has opened the TS homepage
	When they click the About Us link
	Then they are redirected to the About Us page
