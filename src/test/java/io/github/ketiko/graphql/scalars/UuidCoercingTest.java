package io.github.ketiko.graphql.scalars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import graphql.language.StringValue;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class UuidCoercingTest {
    private final UuidCoercing coercing = new UuidCoercing();

    @Test
    public void serialize_whenObjectIsUuidString_returnsStringValue() {
      Object input = UUID.randomUUID().toString();
      String output = coercing.serialize(input);
      assertEquals(output, input);
    }

    @Test
    public void serialize_whenObjectIsNotValidUuidString_throwsError() {
    Object input = "random string";
      assertThrows(
        CoercingSerializeException.class,
        () -> {
          coercing.serialize(input);
        });
    }

    @Test
    public void serialize_whenObjectIsUuid_returnsStringValue() {
      Object input = UUID.randomUUID();
      String output = coercing.serialize(input);
      assertEquals(output, input.toString());
    }

    @Test
    public void serialize_whenInvalidObject_throwsError() {
      Object input = 123;
      assertThrows(
        CoercingSerializeException.class,
        () -> {
          coercing.serialize(input);
        });
    }

    @Test
    public void parseValue_whenObjectIsUuidString_returnsUuidValue() {
      Object input = UUID.randomUUID();
      UUID output = coercing.parseValue(input.toString());
      assertEquals(output, input);
    }

    @Test
    public void parseValue_whenObjectIsNotValidUuidString_throwsError() {
    Object input = "random string";
      assertThrows(
        CoercingParseValueException.class,
        () -> {
          coercing.parseValue(input);
        });
    }

    @Test
    public void parseValue_whenObjectIsUuid_returnsUuidValue() {
      Object input = UUID.randomUUID();
      UUID output = coercing.parseValue(input);
      assertEquals(output, input);
    }

    @Test
    public void parseValue_whenInvalidObject_throwsError() {
      Object input = 456;
      assertThrows(
        CoercingParseValueException.class,
        () -> {
          coercing.parseValue(input);
        });
    }

    @Test
    public void parseLiteral_whenNotStringValueType_throwsError() {
      Object input = "random string";
      assertThrows(
        CoercingParseLiteralException.class,
        () -> {
          coercing.parseLiteral(input);
        });
    }

    @Test
    public void parseLiteral_whenValidUuidAsStringValueType_returnsUuidValue() {
      UUID uuid = UUID.randomUUID();
      StringValue input = new StringValue(uuid.toString());
      UUID output = coercing.parseLiteral(input);
      assertEquals(output, uuid);
    }

    @Test
    public void parseLiteral_whenNonValidUuidAsStringValueType_throwsError() {
      StringValue input = new StringValue("random string");
      assertThrows(
        CoercingParseLiteralException.class,
        () -> {
          coercing.parseLiteral(input);
        });
    }
}
