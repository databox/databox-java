# Databox Java SDK

[![Build Status](https://travis-ci.org/databox/databox-java.png?branch=master)](https://travis-ci.org/databox/databox-java)

The Java SDK for interacting with the Databox Push API.

## Features

* Built on top of a solid and extensively tested framework [Apache HttpComponents](http://hc.apache.org/)
* Uses Java library to convert JSON to Java objects and vice-versa [google-gson](https://code.google.com/p/google-gson)
* Tested and well-documented

## Requirements

* Java >= 1.5 or later,
* Maven >= 3.0.3 (optional but highly recomended)

## Maven supported

Add a maven repository to your pom file:
```xml
<repository>
	<id>umajeric-public-repo</id>
	<name>Umajeric Releases</name>
	<releases>
		<enabled>true</enabled>
	</releases>
	<snapshots>
		<enabled>false</enabled>
	</snapshots>
	<url>https://raw.github.com/umajeric/maven-public-repo/releases</url>
</repository>
```

Then add a dependency for Databox Custom DataSource artefact (see [here](https://github.com/umajeric/maven-public-repo/tree/releases/com/databox/custom-datasource-sdk) to find the latest version):
```xml
<dependency>
	<groupId>com.databox</groupId>
	<artifactId>java-push-sdk</artifactId>
	<version>LATEST</version>
</dependency>
```

## Basic usage of the Databox's `custom-datasource-sdk` client

Most basic sample:

```java
	DataSink<DataboxDataSource> sink = new DataboxSink();
	
	String accessToken = "hd32o1ga8sf7sad0fu9sdufs8440442kj2";
	DataboxDataSource dataSource = new DataboxDataSource(accessToken);

	DefaultDataProvider dataProvider = new DefaultDataProvider();
	dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(234D).withAttribute("no_of_items", 12).build());
	dataProvider.addKPI(new KPI.Builder().setKey("new_signups").setValue(234D).build());
	dataSource.addDataProvider(dataProvider);
	
	sink.push(dataSource);
```

One more advanced example (XSLDailyDataProvider implements DataProvider interface) that reads data from [Excel file](https://github.com/umajeric/databox-java-sdk/blob/master/sample/src/main/resources/cycling.xlsx):

```java
	DataboxSink sink = new DataboxSink();
	List<DataboxDataSource> dataSources = new ArrayList<DataboxDataSource>();
	
	String accessToken = "hd32o1ga8sf7sad0fu9sdufs8440442kj2";
	DataboxDataSource dataSource = new DataboxDataSource(accessToken);
	
	XSLDailyDataProvider xlsxDataProvider = new XSLDailyDataProvider("cycling.xlsx");
	dataSource.addDataProvider(xlsxDataProvider);
	/* You can implement your own data provider that implements DataProvider interface */
	// dataSource.addDataProvider(new MyCustomDataProviderImpl());
	dataSources.add(dataSource);

	/* For each data source we add a separate connection to the sink (each uses a different API Key and URL postfix) */
	// dataSource2 = new DataboxDataSource("5r4w91ga8sf7sad0fu9sdufs844044");
	/* We can use the same data provider for different connections */
	// dataSource2.addDataProvider(xlsxDataProvider);
	// dataSources.add(dataSource2);

	for (DataSource ds : dataSources) {
		sink.push(ds);
	}

```

Snippet from excel file:

|Date	|Total Time	|Moving Time	|Distance	|Distance Unit	|Average Speed	|Max Speed	|Speed Unit|
| -------:| ------:| ------:| ------:|:------ | ------:| ------:|:------|
|7/6/13		| 56	| 56	| 27.00	| km	| 28.93	| 34.00	| km/h |
|7/7/13		| 34	| 34	| 13	| km	| 22.94	| 30	| km/h |
|7/8/13		| 56	| 56	| 23	| km	| 24.54	| 38	| km/h |
|7/9/13		| 63	| 63	| 28	| km	| 26.67	| 35	| km/h |
|7/10/13	| 22	| 22	| 9	| km	| 24.55	| 35	| km/h |



More examples can be found here [Example project](https://github.com/umajeric/databox-java-sdk/tree/master/sample)

## Documentation

See [wiki page](https://github.com/umajeric/databox-java-sdk/wiki) for additional documentation. 

## License

Databox `databox-java` is licensed under the Apache License, Version 2.0 - see the [LICENSE](http://www.apache.org/licenses/LICENSE-2.0) file for details

### Contributors & Credits

- [Uros Majeric](http://github.com/umajeric) 

