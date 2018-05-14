## ProtocolIO Java library

This is a library of Java classes representing the Protocols.io API version 3 data objects.

### Usage

From a JSON representation of a protocol:

```java
  String json = getProtocolsIO_v3Json();// get this from API calls
  ObjectMapper mapper = new ObjectMapper();
  Protocol protocol = mapper.readValue(json, Protocol.class);

```

See [TestP_io.java JUnit Test](src/test/java/com/researchspace/protocolsio/TestP_io.java)
 for additional usage examples.

### Dependencies

- Lombok - used for POJO classes
- Jackson - used for marshalling/unmarshalling annotations
- Apache Commons IO/Lang - utilities.

### Building

Standard Maven commands will build, test and package this library as a jar file, e.g.
    
    mvn clean package
    
If you want to use this library as a dependency in your own project, then consider using [Jitpack](https://jitpack.io/) to build and host an online Maven repo containing this library.
