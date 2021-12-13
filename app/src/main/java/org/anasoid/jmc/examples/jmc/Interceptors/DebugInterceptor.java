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

import java.util.List;
import org.anasoid.jmc.core.application.interceptors.PrepareInterceptor;
import org.anasoid.jmc.core.wrapper.jmeter.control.GenericControllerWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.samplers.DebugSamplerWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.testelement.TestElementWrapper;
import org.anasoid.jmc.examples.jmc.config.Config;
import org.anasoid.jmc.examples.jmc.config.Tags;

public class DebugInterceptor implements PrepareInterceptor {

  @Override
  public boolean support(TestElementWrapper<?> testElementWrapper) {
    return testElementWrapper instanceof GenericControllerWrapper &&
        Config.isDebug();
  }

  @Override
  public void prepare(TestElementWrapper<?> testPlan, TestElementWrapper<?> testElementWrapper) {
    GenericControllerWrapper controller = (GenericControllerWrapper) testElementWrapper;

    List<TestElementWrapper> children = controller.getChildren();

    for (int i = 0; i < children.size(); i++) {
      TestElementWrapper child = children.get(i);
      if (child.getTags().contains(Tags.DEBUG.toString())) {
        boolean add = true;
        if (i + 1 < children.size()) {
          TestElementWrapper nextChild = children.get(i + i);
          if (nextChild instanceof DebugSamplerWrapper) {
            add = false;
          }
        }
        if (add) {
          children.add(i + 1, DebugSamplerWrapper.builder().build());
        }
      }
    }
  }
}
