package dev.therelentlessdude.starwarsapi.repository;

import dev.therelentlessdude.starwarsapi.model.People;
import org.springframework.data.repository.ListCrudRepository;

public interface PeopleRepository extends ListCrudRepository<People, Integer> {
}
