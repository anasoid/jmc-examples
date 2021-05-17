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

package org.anasoid.jmc.examples.jmeter.global.config;

import org.anasoid.jmc.core.wrapper.JmcWrapperBuilder;
import org.anasoid.jmc.core.wrapper.jmc.Variable;
import org.anasoid.jmc.core.wrapper.jmc.functions.JmeterFunctions;
import org.anasoid.jmc.core.wrapper.jmeter.config.ArgumentsWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.config.ArgumentsWrapper.ArgumentsWrapperBuilder;
import org.anasoid.jmc.core.wrapper.template.AbstractJmcTemplate;
import org.anasoid.jmc.examples.jmc.config.Config;

public class TestUserConfig extends AbstractJmcTemplate<ArgumentsWrapper> {

  public static final Variable SERVER_URL = new Variable("repo.url");
  public static final Variable SERVER_PORT = new Variable("repo.port");
  public static final Variable EXEC_THREAD_COUNT = new Variable("thread.count");
  public static final Variable EXEC_LOOP_COUNT = new Variable("loop.count");


  public static final Variable WAIT_RND_DEFAULT = new Variable("wait.rnd.default");

  @Override
  protected void prepareBuilder(JmcWrapperBuilder<ArgumentsWrapper> builder) {
    super.prepareBuilder(builder);
    ArgumentsWrapperBuilder headerManagerBuilder = (ArgumentsWrapperBuilder) builder;
    headerManagerBuilder.addArgument(SERVER_URL,
        JmeterFunctions.property("SERVER_URL", "github.com"))
        .addArgument(SERVER_PORT,
            JmeterFunctions.property("SERVER_PORT", "443"))
        .addArgument(EXEC_THREAD_COUNT,
            JmeterFunctions.property("EXEC_THREAD_COUNT", "2"))
        .addArgument(EXEC_LOOP_COUNT,
            JmeterFunctions.property("EXEC_LOOP_COUNT", "3"))

        .addArgument(WAIT_RND_DEFAULT,
            JmeterFunctions.property("WAIT_RND_DEFAULT", String.valueOf(Config.waitDefault())))

    ;
  }


  @Override
  protected JmcWrapperBuilder<ArgumentsWrapper> init() {

    return (JmcWrapperBuilder<ArgumentsWrapper>) ArgumentsWrapper.builder().withName("Test Config");
  }
}
