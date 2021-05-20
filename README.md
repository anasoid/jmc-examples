# Example for [Jmeter as code](https://github.com/anasoid/jmeter-as-code)

An API that give access to full Jmeter feature as code, All designed object in GUI can be written as code.

### Usage example

###### basic script example:

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

###### A basic script example using template:
````java
    TestPlanWrapper testPlan = TestPlanWrapper.builder()
        .addThread(ThreadGroupWrapper.builder()
            .addSampler(new HomePage())
            .build())
        .build();

    ApplicationTest applicationTest = new ApplicationTest(testPlanWrapper);

    applicationTest.run();
    //OR
    applicationTest.toJmx(new File("mytest.jmx"));
    
class HomePage extends
    AbstractJmcTemplate<HTTPSamplerProxyWrapper, HTTPSamplerProxyWrapperBuilder<?, ?>> {

  @Override
  protected void prepareBuilder(HTTPSamplerProxyWrapperBuilder<?, ?> builder) {
    super.prepareBuilder(builder);
    builder.withName("Home")
        .withDomain("https://github.com")
        .withProtocol("https")
        .withPath("/anasoid");
  }

  @Override
  protected JmcWrapperBuilder<?> init() {
    return HTTPSamplerProxyWrapper.builder();
  }
}

            

  
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
./gradlew  --refresh-dependencies  clean build
````

Some tests will be executed and jmx file generated to folder./app/build/jmx