package dev.therelentlessdude.starwarsapi.Responses;

import dev.therelentlessdude.starwarsapi.Classes.Person;

import java.util.List;

public class PersonResponse {
    private List<Person> results;

    public List<Person> getResults() {
        return results;
    }

    public void setResults(List<Person> results) {
        this.results = results;
    }
}
