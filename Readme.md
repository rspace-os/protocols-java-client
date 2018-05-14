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
