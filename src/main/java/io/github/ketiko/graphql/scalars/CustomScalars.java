package io.github.ketiko.graphql.scalars;

import graphql.schema.GraphQLScalarType;

/**
 *
 */
public class CustomScalars {
  public static final GraphQLScalarType Uuid =
      GraphQLScalarType.newScalar()
          .name("UUID")
          .description("A universally unique identifier compliant UUID Scalar")
          .coercing(new UuidCoercing())
          .build();
}
