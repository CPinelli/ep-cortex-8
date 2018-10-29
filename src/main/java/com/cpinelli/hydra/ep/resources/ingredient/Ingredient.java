package com.cpinelli.hydra.ep.resources.ingredient;

import de.escalon.hypermedia.hydra.mapping.Term;
import de.escalon.hypermedia.hydra.mapping.Terms;
import de.escalon.hypermedia.hydra.mapping.Vocab;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Terms({
        @Term(define = "hydra", as = "http://www.w3.org/ns/hydra/core#"),
        @Term(define = "id", as = "https://schema.org/identifier"),
        @Term(define = "name", as = "https://schema.org/name")
})
@Vocab("https://schema.org/recipeIngredient")
@Relation("ingredient")
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient extends ResourceSupport {

    @Setter
    private String id;

    @Getter
    @Setter
    private IngredientDefinition definition;
}