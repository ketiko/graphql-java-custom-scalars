# graphql-java-custom-scalars

[![CircleCI](https://circleci.com/gh/ketiko/graphql-java-custom-scalars/tree/master.svg?style=svg)](https://circleci.com/gh/ketiko/graphql-java-custom-scalars/tree/master) [![Codacy Badge](https://app.codacy.com/project/badge/Grade/36c34c1774cf47af8bd95bf54651529b)](https://www.codacy.com/manual/ketiko/graphql-java-custom-scalars?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ketiko/graphql-java-custom-scalars&amp;utm_campaign=Badge_Grade) [![Codacy Badge](https://app.codacy.com/project/badge/Coverage/36c34c1774cf47af8bd95bf54651529b)](https://www.codacy.com/manual/ketiko/graphql-java-custom-scalars?utm_source=github.com&utm_medium=referral&utm_content=ketiko/graphql-java-custom-scalars&utm_campaign=Badge_Coverage)

## Custom Graphql Scalars for Java

This adds some custom Graphql scalars not found in the standard https://github.com/graphql-java/graphql-java library.

The https://github.com/graphql-java/graphql-java-extended-scalars project already adds many custom scalars.
However they do not have a UUID scalar yet. There is a PR to add one, https://github.com/graphql-java/graphql-java-extended-scalars/pull/18.

This project add more scalars not found in either of these projects.

### Usage

First, register the scalar as a bean.
```java
  // GraphqlConfig

  @Bean
  public GraphQLScalarType registerUuidScalar() {
    return CustomScalars.Uuid;
  }
```

Second, include the scalar in your graphql schema file.
```graphql
# schema.graphqls

scalar UUID
```