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

## Demo

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
