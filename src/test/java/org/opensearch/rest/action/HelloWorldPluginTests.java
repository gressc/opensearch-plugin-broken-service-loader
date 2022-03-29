/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.rest.action;

import org.opensearch.test.OpenSearchTestCase;

import static org.hamcrest.Matchers.equalTo;

import java.util.ServiceLoader;

public class HelloWorldPluginTests extends OpenSearchTestCase {
    public void testBuildHelloWorldResponse() {
        String name = "What's in a name?";
        HelloWorldService service = new HelloWorldServiceImpl();
        assertThat(service.buildResponse(name).content().utf8ToString(),
                equalTo("Hi " + name + "! Your plugin is installed and working:)"));
    }

    public void testBuildHelloWorldResponseWithServiceLoader() {
        String name = "What's in a name?";
        ServiceLoader<HelloWorldService> loader = ServiceLoader.load(HelloWorldService.class);

        HelloWorldService service = loader.iterator().next();
        assertNotNull(service);
        assertThat(service.buildResponse(name).content().utf8ToString(),
                equalTo("Hi " + name + "! Your plugin is installed and working:)"));
    }
}