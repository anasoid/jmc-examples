# Example for [Jmeter as code](https://github.com/anasoid/jmeter-as-code)

An API that give access to full Jmeter feature as code, All designed object in GUI can be written as code.

### Usage example
A basic script example:
````java
    TestPlanWrapper testPlan = TestPlanWrapper.builder()
        .addThread(ThreadGroupWrapper.builder()
            .addSampler(
                HTTPSamplerProxyWrapper.builder()
                    .withName("Home")
                    .withDomain("https://github.com")
                    .withProtocol("https")
                    .withPath("/anasoid")
                    .build())
            .build())
        .build();

            
  ApplicationTest applicationTest = new ApplicationTest(testPlanWrapper);
 
  applicationTest.run();
  //OR
  applicationTest.toJmx(new File("mytest.jmx"));
````

###Build:

####JMETER_HOME:
set JMETER_HOME environment variable to jmeter folder.

In linux
````shell
 export  JMETER_HOME=/..path tojmeter
````
####Execution:

````shell
./gradlew build
````

Some tests will be executed and jmx file generated to folder./app/build/jmx