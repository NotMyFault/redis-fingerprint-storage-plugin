/*
 * The MIT License
 *
 * Copyright (c) 2020, Jenkins project contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package io.jenkins.plugins.redis;

import io.jenkins.plugins.casc.misc.ConfiguredWithCode;
import io.jenkins.plugins.casc.misc.JenkinsConfiguredWithCodeRule;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfigurationAsCodeCompatibilityTest {

    @Rule
    public JenkinsConfiguredWithCodeRule jenkinsConfiguredWithCodeRule = new JenkinsConfiguredWithCodeRule();

    @Test
    @ConfiguredWithCode("casc.yml")
    public void shouldSupportConfigurationAsCode() {
        assertThat(GlobalRedisConfiguration.get().getHost(), is("test"));
        assertThat(GlobalRedisConfiguration.get().getPort(), is(3333));
        assertThat(GlobalRedisConfiguration.get().getSsl(), is(true));
        assertThat(GlobalRedisConfiguration.get().getDatabase(), is(3));
        assertThat(GlobalRedisConfiguration.get().getConnectionTimeout(), is(3));
        assertThat(GlobalRedisConfiguration.get().getSocketTimeout(), is(3));
    }

}