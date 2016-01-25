# Databox Java SDK

[![Build Status][ci-master-image]][ci-master]
[![Download][download-image]][download]

The Java SDK for interacting with the [Databox](https://databox.com) Push API v 2.0.

## Installation

For [Gradle](http://gradle.org/) users. Add this to your `gradle.build`:

```gradle
repositories {
  jcenter()
  maven { url "http://dl.bintray.com/databox/databox" }
}

dependencies {
  ...
  compile 'com.databox:databox-java:2.0'
  ...
}
```

For [Maven](http://maven.org/) users. Get your [settings.xml at Bintray](https://bintray.com/databox/databox/databox-sdk/view).

## Requirements

* Java >= 1.7 or later,
* Maven >= 3.0.3 OR Gradle 2.x

## Usage

```java
String TOKEN = "your_token_goes_here";
Databox databox = new Databox(TOKEN);
try {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
	databox.send("kitchen_light", 341d, sdf.parse("2015-12-25 00:00:00"));
} catch (Exception e) {
	System.err.println(e.getLocalizedMessage());
}
```

### Sending multiple metrics at once

```java
String TOKEN = "your_token_goes_here";
Databox databox = new Databox(TOKEN);
try {
	List<Databox.KPI> kpis = new ArrayList<Databox.KPI>();
	kpis.add(new Databox.KPI().setKey("my_first_key").setValue(1201.41));
	kpis.add(new Databox.KPI().setKey("my_second_key").setValue(8249));
	databox.push(kpis);
} catch (Exception e) {
	logger.error(e.getLocalizedMessage(), e);
}
```

## License

`databox-sdk` is licensed under the [MIT License](LICENSE).

## Authors

- [Uros Majeric](http://github.com/umajeric)
- [Oto Brglez](http://github.com/otobrglez)

[ci-master]: https://travis-ci.org/databox/databox-java
[ci-master-image]: https://travis-ci.org/databox/databox-java.svg?branch=master
[download]: https://bintray.com/databox/databox/databox-sdk/_latestVersion
[download-image]: https://api.bintray.com/packages/databox/databox/databox-sdk/images/download.svg
