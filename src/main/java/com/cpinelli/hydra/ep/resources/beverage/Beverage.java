package com.cpinelli.hydra.ep.resources.beverage;

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
        @Term(define = "id", as = "https://schema.org/identifier")
})
@Vocab("https://schema.org/Menu")
@Relation("beverage")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beverage extends ResourceSupport {

    private String id;

    @Getter
    private Float price;

    @Getter
    private BeverageDefinition definition;
}
