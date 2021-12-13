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

package org.anasoid.jmc.examples.jmc.Interceptors;

import org.anasoid.jmc.core.application.interceptors.PrepareInterceptor;
import org.anasoid.jmc.core.wrapper.jmeter.samplers.HTTPSamplerProxyWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.testelement.TestElementWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.timers.UniformRandomTimerWrapper;
import org.anasoid.jmc.examples.jmc.config.Tags;
import org.anasoid.jmc.examples.jmeter.global.config.TestUserConfig;

public class WaitInterceptor implements PrepareInterceptor {

  @Override
  public boolean support(TestElementWrapper<?> testElementWrapper) {
    return testElementWrapper.getTags().contains(Tags.WAIT.toString())
        && testElementWrapper instanceof HTTPSamplerProxyWrapper;
  }

  @Override
  public void prepare(TestElementWrapper<?> testPlan, TestElementWrapper<?> testElementWrapper) {
    HTTPSamplerProxyWrapper sampler = (HTTPSamplerProxyWrapper) testElementWrapper;

    sampler.getChildren().add(
        UniformRandomTimerWrapper.builder()
            .withName("Wait default")
            .withDelay(0)
            .withRandom(TestUserConfig.WAIT_RND_DEFAULT)
            .build());
  }
}
