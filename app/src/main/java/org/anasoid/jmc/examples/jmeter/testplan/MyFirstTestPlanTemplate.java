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

package org.anasoid.jmc.examples.jmeter.testplan;

import org.anasoid.jmc.core.wrapper.JmcWrapperBuilder;
import org.anasoid.jmc.core.wrapper.jmeter.samplers.HTTPSamplerProxyWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.samplers.HTTPSamplerProxyWrapper.HTTPSamplerProxyWrapperBuilder;
import org.anasoid.jmc.core.wrapper.jmeter.testelement.TestPlanWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.threads.ThreadGroupWrapper;
import org.anasoid.jmc.core.wrapper.template.AbstractJmcTemplate;

public class MyFirstTestPlanTemplate {


  protected TestPlanWrapper getTestPlan() {
    TestPlanWrapper testPlan = TestPlanWrapper.builder()
        .addThread(ThreadGroupWrapper.builder()
            .addSampler(new HomePage())
            .build())
        .build();
    return testPlan;

  }

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


}
