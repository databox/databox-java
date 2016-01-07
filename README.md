# Databox Java SDK 2.0 [![Build Status](https://travis-ci.org/umajeric/databox-java-sdk.png?branch=master)](https://travis-ci.org/umajeric/databox-java-sdk)

The Java SDK for interacting with the Databox Push API v 2.0.

## Requirements

* Java >= 1.5 or later,
* Maven >= 3.0.3 OR Gradle 2.x

## Basic usage of the Databox's `databox-sdk` client

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
## License

`databox-sdk` is licensed under the Apache License, Version 2.0 - see the [LICENSE](http://www.apache.org/licenses/LICENSE-2.0) file for details

## Credits

### Contributors


- [Uros Majeric](http://github.com/umajeric)
