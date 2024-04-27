# Unified_Automation

Unified Automation is a test automation framework that combines Selenium for web UI automation and API automation. This project includes a suite of tests for testing the application's functionality across different layers.

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
Java Development Kit (JDK) - Version 8 or higher
Maven - Build Automation Tool
IDE (Eclipse, IntelliJ IDEA, etc.) - Optional but recommended
Git - Version Control System

Installing
1.Clone the repository to your local machine:
git clone https://github.com/anurag-z/Unified_Automation.git

2.Open the project in your preferred IDE.
3.Install the necessary Maven dependencies:
mvn clean install

Running Tests
To run the tests, execute the following Maven command:
mvn test

This command will execute both Selenium and API automation tests based on the configurations specified.

Git Actions Workflow
The project is configured with GitHub Actions for Continuous Integration and Continuous Deployment (CI/CD). The workflow file can be found in .github/workflows/ci-cd.yml.

The workflow performs the following steps:

Build: Compiles the project and installs dependencies.
Test: Executes the test suite using Maven.
Generate Reports: Generates Extent reports based on test categories (@UITest and @APITest).
