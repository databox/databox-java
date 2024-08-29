import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.api.DefaultApi;
import org.databox.auth.HttpBasicAuth;
import org.openapitools.client.model.PushData;
import org.openapitools.client.model.PushDataAttribute;

public class PushData {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://push.databox.com");
        defaultClient.addDefaultHeader("Accept", "application/vnd.databox.v2+json");

        HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
        basicAuth.setUsername("<Your_Databox_API_Token>");

        PushData data = new PushData()
                .key("<Metric_name>") // e.g. sales
                .value(123f)
                .date("<Date_in_ISO8601>") // e.g. "2024-08-01T00:00:00Z"
                .unit("<Unit>") // optional - e.g. EUR
                .attributes(List.of(new PushDataAttribute().key("<Dimension_name>").value("<Dimension_value>"))); // optional - e.g. currency & USD

        DefaultApi apiInstance = new DefaultApi(defaultClient);
        try {
            apiInstance.dataPost(List.of(data));
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}