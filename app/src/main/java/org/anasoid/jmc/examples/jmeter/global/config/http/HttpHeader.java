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

package org.anasoid.jmc.examples.jmeter.global.config.http;

import org.anasoid.jmc.core.wrapper.JmcWrapperBuilder;
import org.anasoid.jmc.core.wrapper.jmeter.protocol.http.control.HeaderManagerWrapper;
import org.anasoid.jmc.core.wrapper.jmeter.protocol.http.control.HeaderManagerWrapper.HeaderManagerWrapperBuilder;
import org.anasoid.jmc.core.wrapper.template.AbstractJmcTemplate;

public class HttpHeader extends
    AbstractJmcTemplate<HeaderManagerWrapper, HeaderManagerWrapperBuilder<?, ?>> {


  @Override
  protected void prepareBuilder(HeaderManagerWrapperBuilder<?, ?> builder) {
    super.prepareBuilder(builder);
    builder.userAgentHeader(
        "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:88.0) Gecko/20100101 Firefox/88.0")
        .userAgentHeader("en-US,en;q=0.5")
        .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
        .acceptEncodingHeader("gzip, deflate, br");
  }


  @Override
  protected JmcWrapperBuilder<HeaderManagerWrapper> init() {
    return (JmcWrapperBuilder<HeaderManagerWrapper>) HeaderManagerWrapper.builder();
  }
}
