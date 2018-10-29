package com.cpinelli.hydra.ep.resources.beverage;

import com.cpinelli.hydra.ep.resources.ingredient.Ingredient;

import de.escalon.hypermedia.hydra.mapping.Term;
import de.escalon.hypermedia.hydra.mapping.Terms;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Terms({
        @Term(define = "hydra", as = "http://www.w3.org/ns/hydra/core#"),
        @Term(define = "id", as = "https://schema.org/identifier")
})
@Relation("definition")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class BeverageDefinition extends ResourceSupport {

    @Getter
    private String name;

    @Getter
    private List<Ingredient> ingredients;
}
