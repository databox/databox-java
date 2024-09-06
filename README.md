# Databox
This package is designed to consume the Databox Push API functionality via a Java client.


## Installation

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>org.databox</groupId>
  <artifactId>databox</artifactId>
  <version>2.5.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
  repositories {
    mavenCentral()     // Needed if the 'databox' jar has been published to maven central.
    mavenLocal()       // Needed if the 'databox' jar has been published to the local maven repo.
  }

  dependencies {
     implementation "org.databox:databox:2.5.1"
  }
```

## Prerequisites
In use the Databox Push API functionality, please refer to [Databox Developers Page](https://developers.databox.com/), specifically the **Quick Guide** section, where you will learn how to create a **Databox Push API token** which is required for pushing your data.

## Example

```java
import org.databox.ApiClient;
import org.databox.ApiException;
import org.databox.Configuration;
import org.databox.api.DefaultApi;
import org.databox.auth.HttpBasicAuth;
import org.openapitools.client.model.PushData;
import org.openapitools.client.model.PushDataAttribute;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://push.databox.com");
    defaultClient.addDefaultHeader("Accept", "application/vnd.databox.v2+json");

    HttpBasicAuth basicAuth = (HttpBasicAuth) defaultClient.getAuthentication("basicAuth");
    basicAuth.setUsername("Your_Databox_API_Token");

    PushData data = new PushData()
            .key("Metric_name") // e.g. sales
            .value(123f)
            .date("Date_in_ISO8601") // e.g. "2024-08-01T00:00:00Z"
            .unit("Unit") // optional - e.g. USD
            .attributes(List.of(new PushDataAttribute().key("Dimension_name").value("Dimension_value"))); // optional - e.g. currency & USD

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      apiInstance.dataPost(List.of(data));
    } catch (ApiException e) {
      e.printStackTrace();
    }
  }
}
```