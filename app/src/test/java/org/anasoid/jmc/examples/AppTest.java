package org.anasoid.jmc.examples;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.anasoid.jmc.core.application.ApplicationTest;
import org.anasoid.jmc.examples.jmc.Interceptors.DebugInterceptor;
import org.anasoid.jmc.examples.jmc.Interceptors.WaitInterceptor;
import org.anasoid.jmc.examples.jmeter.testplan.HelloTestPlan;
import org.junit.jupiter.api.Test;
/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @author : anas
 * Date :   17-May-2021
 */

class AppTest {

  @Test
  void helloTest() throws IOException {

    ApplicationTest applicationTest = new ApplicationTest(new HelloTestPlan().generate());

    String filepath =
        System.getProperties().getProperty("user.dir") + "/build/jmx/" + "helloTest.jmx";
    applicationTest.toJmx(new File(filepath));
  }

  @Test
  void helloTestInterceptors() throws IOException {

    ApplicationTest applicationTest = new ApplicationTest(new HelloTestPlan().generate(),
        Arrays.asList(new WaitInterceptor(), new DebugInterceptor()));

    String filepath =
        System.getProperties().getProperty("user.dir") + "/build/jmx/"
            + "helloTestInterceptors.jmx";
    applicationTest.toJmx(new File(filepath));
  }
}