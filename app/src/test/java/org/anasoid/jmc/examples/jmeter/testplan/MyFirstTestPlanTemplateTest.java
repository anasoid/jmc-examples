package org.anasoid.jmc.examples.jmeter.testplan;

import java.io.File;
import java.io.IOException;
import org.anasoid.jmc.core.application.ApplicationTest;
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
 * Date :   20-May-2021
 */

class MyFirstTestPlanTemplateTest {

  @Test
  void firstTest() throws IOException {

    ApplicationTest applicationTest = new ApplicationTest(
        new MyFirstTestPlanTemplate().getTestPlan());

    String filepath =
        System.getProperties().getProperty("user.dir") + "/build/jmx/" + "firstTestTemplate.jmx";
    applicationTest.toJmx(new File(filepath));
    applicationTest.run();
  }
}