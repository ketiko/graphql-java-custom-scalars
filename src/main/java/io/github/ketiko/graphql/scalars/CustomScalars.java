package io.github.ketiko.graphql.scalars;

import graphql.schema.GraphQLScalarType;

/** Provides central place for available custom scalars */
public class CustomScalars {

  /**
   * Provides a UUID scalar that accepts string values like `34af64af-2090-4a8d-8e0a-4d01d5551fbb`
   * and produces a `java.util.UUID`.
   *
   * <p>Its {@link graphql.schema.Coercing#serialize(java.lang.Object)} and {@link
   * graphql.schema.Coercing#parseValue(java.lang.Object)} methods accept formatted UUID strings as
   * valid objects.
   *
   * <p>
   *
   * @see java.util.UUID
   */
  public static final GraphQLScalarType Uuid =
      GraphQLScalarType.newScalar()
          .name("UUID")
          .description("A universally unique identifier compliant UUID Scalar")
          .coercing(new UuidCoercing())
          .build();
}
