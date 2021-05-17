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
 * Date :   11-May-2021
 */

package org.anasoid.jmc.examples.global.config.http;

import org.anasoid.jmc.core.wrapper.JmcWrapperBuilder;
import org.anasoid.jmc.core.wrapper.jmeter.protocol.http.config.HttpDefaultsWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.protocol.http.config.HttpDefaultsWrapper.HttpDefaultsWrapperBuilder;
import org.anasoid.jmc.core.wrapper.template.AbstractJmcTemplate;
import org.anasoid.jmc.examples.global.config.TestConfig;

public class HttpDefaults extends AbstractJmcTemplate<HttpDefaultsWrapper> {

  @Override
  protected void prepareBuilder(JmcWrapperBuilder<HttpDefaultsWrapper> builder) {
    super.prepareBuilder(builder);
    HttpDefaultsWrapperBuilder httpDefaultsWrapper = (HttpDefaultsWrapperBuilder) builder;
    httpDefaultsWrapper.withProtocol("https").withPort(TestConfig.SERVER_PORT.getValue())
        .withDomain(TestConfig.SERVER_URL.getValue());
  }

  @Override
  protected JmcWrapperBuilder<HttpDefaultsWrapper> init() {
    return (JmcWrapperBuilder<HttpDefaultsWrapper>) HttpDefaultsWrapper.builder()
        ;
  }
}
