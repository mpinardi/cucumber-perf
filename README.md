# cucumber-perf
A performance testing framework for cucumber io.

## What is Cucumber Perf?
Cucumber perf represents a new idea in automated testing development.

### What is Cucumber?
Cucumber itself is a implimentation of Behavior Driven Development (BDD).
Which uses simple natural language scripts to define a software feature.
These executable specifications are written in a language called gherkin.
Example:
```
Feature: Beer
  Scenario: Jeff dinks a beer
  Given: Jeff is of age and has a beer
  And: Jeff opens his beer.
  When: Jeff takes a sip.
  Then: Verify he enjoyed it.
```
These scripts can be used to develop the features themselves but also drive automated tests.

Cucumber Perf provides a level of automation ontop of Cucumber.
Its a implimentation of a new concept (as far as i know) called Concurrent Behavior Driven Testing (CBDT).

### The issue?
So you now have a working functional automation test suite.
But you want to do a performance test. This would require either rewriteing your existing functional tests or copying a bunch of code.
Also you would need to create a performance test harness.

Most likely each team will end up with something that is project specific and doesn't use the existing functional code base.

### The fix
Cucumber perf provides a means to use your existing functional code without writing a single line of code.
It provides the ability to run performance simulations with support for common load testing features:
* Timed Tests
* Multi-Threading
* Thread Count Limits
* Ramp Up/Down
* Data replaceing
* Random Wait
* Reporting
* Junit XML export
* more to come.

It uses a new type of script called Salad.
Salad is a reimplimentation of Cucumber Gherkin with the focus on performance simulations.

```
Plan: Bar visit

Simulation: Jeff drinks 3 beers.
  Group: beer.feature
  Runners: 1
  Count: 3
```
## Plans:
Here is an example plan
```
Plan: test
Simulation: simulation 1
Group test.feature
	#slices
	#these values will replace property "value out"
	|value out|
	|changed value 1|
	|changed value 2|
	#number of threads
	Runners: 2
	#total number of threads to run.
	Count: 2
#a optional random wait mean for before thread runs tests.
#thread will wait between +-50% of this mean
RandomWait: 00:00:02

#Will run all groups for the period below
Simulation Period: simulation 2 period
Group test.feature
	|value out|
	|changed value |
		Threads: 5
		#count is ignored in a simulation period
		Count: 1
#run time
Time: 00:00:30
RampUp: 00:00:10
RampDown: 00:00:10
```

## Getting Started
It takes a lot of planing to impliment Cucumber Perf.

Your functional automation should follow these rules:
* Use a non specific test harness. This should standerdize all your common functions.
* Do not use static variables! Your code must work in a multithreaded world.
* Properly comment your features and scenarios. You want to keep track of what scenarios can be run multithreaded.

### Prerequisites

io.cucumber cucumber-core
```
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-core</artifactId>
    <version>2.3.1</version>
</dependency>
```

### Installing

TBD


## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
