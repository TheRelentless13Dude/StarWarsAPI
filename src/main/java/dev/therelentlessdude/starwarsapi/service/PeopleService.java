package dev.therelentlessdude.starwarsapi.service;

import dev.therelentlessdude.starwarsapi.model.People;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
public class PeopleService {

    private final HttpGraphQlClient graphQlClient;

public PeopleService() {
    WebClient testClient = WebClient.builder().baseUrl("https://swapi.dev/api/people").build();
    String graphqlQuery = "https://swapi.dev/api/people";
    String testClientResponse = (testClient.get().uri(uriBuilder -> uriBuilder.queryParam("query",graphqlQuery).build())
            .retrieve().bodyToMono(String.class).subscribe(response -> {
                System.out.println("WebClient response: "+response);
            })).toString();

    WebClient finalResponse = WebClient.create(testClientResponse);

        graphQlClient = HttpGraphQlClient.builder(finalResponse).build();

    }

    public Mono<List<People>> getPeople() {
        System.out.println("<<<<<<<<<< Inside getPeople in PeopleService now >>>>>>>>>>");
        //language=GraphQL
        //Request=GET
        String document = """
                query{
                    results[
                     {
                        name
                        height
                        mass
                        gender
                        homeworld
                        }
                    ]
                }
                """;
        System.out.println("<------ Document built, trying to build Mono List now using graphQlClient...");
        Mono<List<People>> people = graphQlClient.document(document).retrieve("people").toEntityList(People.class);

        return people;
    }
}
