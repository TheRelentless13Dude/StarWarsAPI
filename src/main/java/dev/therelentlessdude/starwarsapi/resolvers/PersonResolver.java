package dev.therelentlessdude.starwarsapi.resolvers;

import dev.therelentlessdude.starwarsapi.Classes.Person;
import dev.therelentlessdude.starwarsapi.Responses.PersonResponse;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Service
public class PersonResolver {
    private final WebClient webClient;

    public PersonResolver(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<List<Person>> getPeople() {
        return webClient.get()
                .uri("/people")
                .retrieve()
                .bodyToMono(PersonResponse.class)
                .map(PersonResponse::getResults)
                .flatMapMany(Flux::fromIterable)
                .collectList();
    }
}
