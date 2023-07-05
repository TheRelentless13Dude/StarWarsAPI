package dev.therelentlessdude.starwarsapi.repository;


import dev.therelentlessdude.starwarsapi.Classes.Person;
import org.springframework.data.repository.ListCrudRepository;

public interface PeopleRepository extends ListCrudRepository<Person, Integer> {
}
