/*
 * Static OpenAPI document of Push API resource
 * Push API resources Open API documentation
 *
 * The version of the OpenAPI document: 0.4.3
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.databox.api;

import org.databox.ApiException;
import org.openapitools.client.model.PushData;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
@Disabled
public class DefaultApiTest {

    private final DefaultApi api = new DefaultApi();

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void dataDeleteTest() throws ApiException {
        api.dataDelete();
        // TODO: test validations
    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void dataMetricKeyDeleteTest() throws ApiException {
        String metricKey = null;
        api.dataMetricKeyDelete(metricKey);
        // TODO: test validations
    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void dataPostTest() throws ApiException {
        List<PushData> pushData = null;
        api.dataPost(pushData);
        // TODO: test validations
    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void metrickeysGetTest() throws ApiException {
        api.metrickeysGet();
        // TODO: test validations
    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void metrickeysPostTest() throws ApiException {
        Object body = null;
        api.metrickeysPost(body);
        // TODO: test validations
    }

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void pingGetTest() throws ApiException {
        api.pingGet();
        // TODO: test validations
    }

}
