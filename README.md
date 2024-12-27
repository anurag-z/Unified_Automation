# Unified_Automation with support of parallel Execution

Unified Automation is a test automation framework that combines Selenium for web UI automation and API automation. This project includes a suite of tests for testing the application's functionality across different layers.

## 1.TestNG Parallel Test Execution

Creation of XML File at runtime based on MVN cmd Argument and Thread count

## 2.UI Testing and API Testing

Supports UI Testing and API testing based on Tags and Grouping at Testcase Level and Support Parallel Execution.

## 3.Extent Report integration For UI and API Testing

This Framework will create extent report and to make it Thread safe we have used ThreadLocal for managing Parallel execution.

![Extent](https://github.com/user-attachments/assets/e95dc66d-1207-4db6-adcb-401d53c2401c)

## 4.Integration of GitAction workflow and Parallel Execution in Cloud 

To Execute our testcase we have created a yml file and we have used pre-defined git action to execute our scripts.
Generate Extent Reports and log will attached as Artifact to Build. As shown below:

![Gitactinos](https://github.com/user-attachments/assets/598d5b62-0b28-4fea-8cef-4f58dc2086b4)

## 5.Docker Integration 

Create a custom Image and Load the image in an container by passing the runtime cmd for execution

## Steps to setup and Work with Framework
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
