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

## Demo
Gradle
```shell
$ gradle cucumberCli
```

Gradle Wrapper
```shell
$ ./gradlew cucumber
```
```shell
Jul 08, 2021 2:31:42 PM cucumber.api.cli.Main run
WARNING: You are using deprecated Main class. Please use io.cucumber.core.cli.Main
......======--> 88% EXECUTING [1s]
┌───────────────────────────────────────────────────────────────────────────────────┐

2 Scenarios (2 passed)
6 Steps (6 passed)
│ Share your Cucumber Report with your team at https://reports.cucumber.io          │
0m0.290s


│ Activate publishing with one of the following:                                    │
│                                                                                   │
│ src/test/resources/cucumber.properties:          cucumber.publish.enabled=true    │
│ src/test/resources/junit-platform.properties:    cucumber.publish.enabled=true    │
│ Environment variable:                            CUCUMBER_PUBLISH_ENABLED=true    │
│ JUnit:                                           @CucumberOptions(publish = true) │
│                                                                                   │
│ More information at https://reports.cucumber.io/docs/cucumber-jvm                 │
│                                                                                   │
│ Disable this message with one of the following:                                   │
│                                                                                   │
│ src/test/resources/cucumber.properties:          cucumber.publish.quiet=true      │
│ src/test/resources/junit-platform.properties:    cucumber.publish.quiet=true      │
└───────────────────────────────────────────────────────────────────────────────────┘

BUILD SUCCESSFUL in 2s
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
