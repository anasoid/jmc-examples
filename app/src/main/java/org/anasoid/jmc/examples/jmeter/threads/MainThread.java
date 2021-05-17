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

package org.anasoid.jmc.examples.jmeter.threads;

import org.anasoid.jmc.core.wrapper.JmcWrapperBuilder;
import org.anasoid.jmc.core.wrapper.jmeter.threads.ThreadGroupWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.threads.ThreadGroupWrapper.ThreadGroupWrapperBuilder;
import org.anasoid.jmc.core.wrapper.template.AbstractJmcTemplate;
import org.anasoid.jmc.examples.jmeter.global.config.TestUserConfig;
import org.anasoid.jmc.examples.jmeter.samplers.http.HomePageController;
import org.anasoid.jmc.examples.jmeter.samplers.http.RepositoryPageController;


public class MainThread extends AbstractJmcTemplate<ThreadGroupWrapper> {

  @Override
  protected void prepareBuilder(JmcWrapperBuilder<ThreadGroupWrapper> builder) {
    super.prepareBuilder(builder);
    ThreadGroupWrapperBuilder threadGroupWrapper = (ThreadGroupWrapperBuilder) builder;
    addHomePage(threadGroupWrapper);
    addRepoPage(threadGroupWrapper);
  }

  @Override
  protected JmcWrapperBuilder<ThreadGroupWrapper> init() {
    return (JmcWrapperBuilder<ThreadGroupWrapper>) ThreadGroupWrapper.builder()
        .withName("Main Thread").withLoops(TestUserConfig.EXEC_LOOP_COUNT)
        .withNumThreads(TestUserConfig.EXEC_THREAD_COUNT);
  }

  protected void addHomePage(ThreadGroupWrapperBuilder threadGroupWrapper) {
    threadGroupWrapper.addController(new HomePageController());
  }

  protected void addRepoPage(ThreadGroupWrapperBuilder threadGroupWrapper) {
    threadGroupWrapper.addController(new RepositoryPageController());
  }
}
