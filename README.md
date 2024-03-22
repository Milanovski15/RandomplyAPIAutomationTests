# Description

This project contains automation tests for Randomly API. 
The tests are written in Java using Rest Assured and junit.

# Prerequisites
Java 21

Maven

# How to run tests
command for running all tests: mvn test

command for running specific test class:mvn -Dtest={TestClassName} test

Example: mvn -Dtest=CommentsTest test

# Project goal explanation
The end goal was to test the sign up POST, login POST, post POST, 
comment POST and the comments GET endpoints. The final step where i 
assert the added comment with the e2e flow is in the CommentsTest class.
