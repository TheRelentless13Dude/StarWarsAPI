package dev.therelentlessdude.starwarsapi.Configurations;

import dev.therelentlessdude.starwarsapi.resolvers.PersonResolver;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class GraphQLConfig {

    private final PersonResolver personResolved;

    @Autowired
    public GraphQLConfig(PersonResolver personResolved) {
        this.personResolved= personResolved;
    }

    @Bean
    public GraphQL graphQL() {
        SchemaParser parser = new SchemaParser();
        SchemaGenerator generator = new SchemaGenerator();
        TypeDefinitionRegistry registry = new TypeDefinitionRegistry();
        registry.merge(parser.parse("../resources/schema.graphqls"));

        RuntimeWiring runTime = buildRuntime();

        GraphQLSchema schema = generator.makeExecutableSchema(registry, runTime);

        return GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntime() {
        return RuntimeWiring.newRuntimeWiring().type("Query", builder ->
                builder.dataFetcher("people", env -> personResolved.getPeople()))
                .build();
    }
}
