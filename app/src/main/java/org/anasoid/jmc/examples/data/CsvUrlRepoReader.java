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

package org.anasoid.jmc.examples.data;

import org.anasoid.jmc.core.wrapper.JmcWrapperBuilder;
import org.anasoid.jmc.core.wrapper.jmc.Variable;
import org.anasoid.jmc.core.wrapper.jmeter.config.CSVDataSetWrapper;
import org.anasoid.jmc.core.wrapper.template.AbstractJmcTemplate;

public class CsvUrlRepoReader extends AbstractJmcTemplate<CSVDataSetWrapper> {

  public static final Variable URL = new Variable("repo.url");

  @Override
  protected JmcWrapperBuilder<CSVDataSetWrapper> init() {
    return (JmcWrapperBuilder<CSVDataSetWrapper>) CSVDataSetWrapper.builder()
        .withFilename("data/repositories.csv").addvariable(URL);
  }
}
