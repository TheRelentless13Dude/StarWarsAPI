package dev.therelentlessdude.starwarsapi;

import dev.therelentlessdude.starwarsapi.Classes.Person;
import dev.therelentlessdude.starwarsapi.repository.PeopleRepository;
import dev.therelentlessdude.starwarsapi.resolvers.PersonResolver;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PersonResolver resolver, PeopleRepository repository) {
        return args -> {
            Mono<List<Person>> peopleResult = resolver.getPeople();
            peopleResult.subscribe(repository::saveAll);
        };
    }

}
