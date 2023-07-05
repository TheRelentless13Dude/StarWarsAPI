package dev.therelentlessdude.starwarsapi;

import dev.therelentlessdude.starwarsapi.model.People;
import dev.therelentlessdude.starwarsapi.repository.PeopleRepository;
import dev.therelentlessdude.starwarsapi.service.PeopleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpInputMessage;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PeopleService service, PeopleRepository repository) {
        return args -> {

            Mono<List<People>> peopleResult = service.getPeople();
            URI uriForSub = new URI(peopleResult.toString());
            URL testURL = new URL("https://swapi.dev/api/people");
            System.out.println(testURL.getProtocol());
            System.out.println("uri For Subscribing is: "+uriForSub.getScheme());
            peopleResult.subscribe(repository::saveAll);

        };
    }

}
