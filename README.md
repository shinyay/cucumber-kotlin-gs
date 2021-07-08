# Getting Started with Cucumber in Kotlin

Cucumber is a testing tool that supports behavior-driven development (BDD)
Cucumber-JVM is a Java implementation of Cucumber.


## Description
### Dependencies
- io.cucumber
  - `cucumber-java:${cucumberVersion}`
  - `cucumber-junit:${cucumberVersion}`
- org.junit.jupiter
  - `junit-jupiter-api:${junitVersion}`
  - `junit-jupiter-engine:${junitVersion}`

#### Version
```groovy
ext {
    junitVersion = '5.7.2'
    cucumberVersion = '6.10.4'
}
```

### Dependency Configuration
```groovy
configurations {
    cucumberRuntime {
        extendsFrom testImplementation
    }
}
```

### Cucumber task for CLI
```groovy
task cucumberCli() {
    dependsOn assemble, testClasses
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = [
                    '--plugin', 'pretty',
                    '--plugin', 'html:target/cucumber-report.html',
                    '--glue', 'com.google.shinyay',
                    'src/test/resources']
        }
    }
}
```

### Cucumber plugin for Gradle Wrapper task
```groovy
plugins {
    id 'se.thinkcode.cucumber-runner' version '0.0.9'
}
```

### Feature File
- `Feature:`
  - Name for Feature. It might be good to use a name similar to the file name
- `Scenario:`
  - Description for behavior.
- **Steps**
  - `Given`
    - Description for an initial context
  - `When`
    - Description for an event
  - `Then`
    - Description for an expected outcome
  - `And`
  - `But`
```
Feature: Account is credited with amount

  Scenario: Credit amount
    Given account balance is 0.0
    When the account is credited with 10.0
    Then account should have a balance of 10.0
```

## Demo
Gradle
```shell
$ gradle cucumberCli
```

Gradle Wrapper
```shell
$ ./gradlew cucumber
```

### StepDefinition Class Suggestion
Just create the following **Feature file** and then run Cucumber.

```
Feature: Account is credited with amount

  Scenario: Credit amount
    Given account balance is 0.0
    When the account is credited with 10.0
    Then account should have a balance of 10.0
```

Then you'll get the following message:

```shell
You can implement missing steps with the snippets below:

@Given("account balance is {double}")
public void account_balance_is(Double double1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("the account is credited with {double}")
public void the_account_is_credited_with(Double double1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("account should have a balance of {double}")
public void account_should_have_a_balance_of(Double double1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
```

## Features

- feature:1
- feature:2

## Requirement

## Usage

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
