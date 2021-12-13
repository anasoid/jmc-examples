# Example for [Jmeter as code](https://github.com/anasoid/jmeter-as-code)

An API that give access to full Jmeter feature as code, All designed object in GUI can be written as
code.

### Example

In this example we generate and execute JMX file using junit test in different way.

All test will generate test access to home page (https://github.com/anasoid/) and test list of
repositories owned by this user,

### Build:

#### Execution:

````shell
./gradlew  --refresh-dependencies  clean build
````

Some tests will be executed and jmx file generated to folder./app/build/jmx