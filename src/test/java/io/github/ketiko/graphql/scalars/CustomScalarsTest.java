package io.github.ketiko.graphql.scalars;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public class CustomScalarsTest {

  @Test
  void Uuid() {
    var uuid = CustomScalars.Uuid;
    assertEquals(uuid.getName(), "UUID");
    assertTrue(uuid.getCoercing() instanceof UuidCoercing);
  }
}
