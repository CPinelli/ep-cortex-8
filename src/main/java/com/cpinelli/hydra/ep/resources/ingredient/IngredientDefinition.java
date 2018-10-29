package com.cpinelli.hydra.ep.resources.ingredient;

import de.escalon.hypermedia.hydra.mapping.Term;
import de.escalon.hypermedia.hydra.mapping.Terms;

import org.springframework.hateoas.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Terms({
        @Term(define = "hydra", as = "http://www.w3.org/ns/hydra/core#"),
        @Term(define = "id", as = "https://schema.org/identifier")
})
@Relation("definition")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredientDefinition {

    private String name;
}
