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

package org.anasoid.jmc.examples.jmc.utils.samplers;

import lombok.NonNull;
import org.anasoid.jmc.core.wrapper.jmc.samplers.HttpMethod;
import org.anasoid.jmc.core.wrapper.template.samplers.http.controller.SimplePageControllerTemplate;

/**
 * My Abstract Page
 */
public abstract class MyAbstractPageController extends
    SimplePageControllerTemplate {


  public MyAbstractPageController(@NonNull String name,
      @NonNull String path) {
    super(name, path);
  }

  public MyAbstractPageController(@NonNull String name, @NonNull String path,
      String domain) {
    super(name, path, domain);
  }

  public MyAbstractPageController(@NonNull String name, @NonNull String path,
      @NonNull HttpMethod method) {
    super(name, path, method);
  }

  public MyAbstractPageController(@NonNull String name, @NonNull String path,
      String domain, @NonNull HttpMethod method) {
    super(name, path, domain, method);
  }
}
