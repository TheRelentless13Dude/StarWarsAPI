package dev.therelentlessdude.starwarsapi;

import dev.therelentlessdude.starwarsapi.model.People;
import dev.therelentlessdude.starwarsapi.repository.PeopleRepository;
import dev.therelentlessdude.starwarsapi.service.PeopleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

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
            System.out.println("<---------- Building People List now.");
            Mono<List<People>> people = service.getPeople();
            System.out.println("People list built, back at Main------>");
            System.out.println("<-------- About to Subscribe to repository and save......");
            //people.subscribe(repository::saveAll);
            people.subscribe(response -> {
                System.out.println("<<<<<<<<<< Subscribed Successfully >>>>>>>>>>");
                System.out.println("<<<<<<<<<< About to save.... >>>>>>>>>>");
                repository.saveAll(response);
                System.out.println("<<<<<<<<<< Saved to db. >>>>>>>>>>");
            });
            System.out.println("Subscribed to repository");
            System.out.println("<<<<<<<"+repository);
        };
    }

}
