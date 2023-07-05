package dev.therelentlessdude.starwarsapi.model;

import org.springframework.data.annotation.Id;

public record People(
        @Id
        Integer id,
        String name,
        String height,
        String mass,
        String gender,
        String homeworld
) {

}
