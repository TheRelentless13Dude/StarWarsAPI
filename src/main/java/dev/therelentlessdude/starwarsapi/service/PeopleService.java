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

        //test
//        graphQlClient = HttpGraphQlClient.builder(client2).build();

        //test 2
    System.out.println("************** Attempting to build graphQlClient using testClient now... **************");
        graphQlClient = HttpGraphQlClient.builder(finalResponse).build();
    System.out.println("************** graphQlClient built **************");
        //original
//        graphQlClient = HttpGraphQlClient.builder(client).build();
    }

    public Mono<List<People>> getPeople() {
        //language=GraphQL
        //Request=GET
        String document = """
                query{
                    people{
                        name
                        height
                        mass
                        gender
                        homeworld
                    }
                }
                """;
        System.out.println("<------ Document built, trying to build Mono List now using graphQlClient...");
        Mono<List<People>> people = graphQlClient.document(document).retrieve("people").toEntityList(People.class);
        for (String s : Arrays.asList("People list is: " + people.publish(Mono::log), "Is this right?")) {
            System.out.println(s);
        }

        return people;
    }
}
