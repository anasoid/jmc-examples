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

package org.anasoid.jmc.examples.jmeter.samplers.http;

import org.anasoid.jmc.core.dsl.assertions.ResponseAssertionDsl;
import org.anasoid.jmc.core.wrapper.jmeter.samplers.HTTPSamplerProxyWrapper.HTTPSamplerProxyWrapperBuilder;
import org.anasoid.jmc.examples.jmc.config.Tags;
import org.anasoid.jmc.examples.jmc.utils.samplers.MyAbstractPageController;

public class HomePageController extends MyAbstractPageController {

  @Override
  protected void prepareSamplerBuilder(HTTPSamplerProxyWrapperBuilder<?, ?> builder) {
    super.prepareSamplerBuilder(builder);
    builder.addAssertion(ResponseAssertionDsl.httpCodeOK("Assertion 200")).addTags(Tags.WAIT.name());
  }

  public HomePageController() {
    super("Home Page", "/anasoid");
  }


}
