package com.cpinelli.hydra.ep.controllers;

import com.cpinelli.hydra.ep.assemblers.beverage.BeverageAssembler;
import com.cpinelli.hydra.ep.assemblers.beverage.BeverageDefinitionAssembler;
import com.cpinelli.hydra.ep.entities.BeverageEntity;
import com.cpinelli.hydra.ep.entities.IngredientEntity;
import com.cpinelli.hydra.ep.resources.beverage.Beverage;
import com.cpinelli.hydra.ep.resources.beverage.BeverageDefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import static de.escalon.hypermedia.spring.AffordanceBuilder.linkTo;
import static de.escalon.hypermedia.spring.AffordanceBuilder.methodOn;

@RestController
@RequestMapping("/beverages")
public class BeverageController {

    private BeverageEntity beverage = new BeverageEntity(
            "e5sfg1",
            "Latte Macchiato",
            5.4f,
            Arrays.asList(
                    new IngredientEntity("61642", "Coffee"),
                    new IngredientEntity("61643", "Milk"),
                    new IngredientEntity("61644", "Sugar")
            )
    );

    @Autowired
    private BeverageAssembler beverageAssembler;

    @Autowired
    private BeverageDefinitionAssembler beverageDefinitionAssembler;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Resource<Beverage> getBeverage(@PathVariable String id) {

        Resource<Beverage> beverageResource = new Resource<>(this.beverageAssembler.toResource(beverage));

        BeverageEntity b = new BeverageEntity();

        beverageResource.add(linkTo(methodOn(BeverageController.class).updateBeverage(id, b))
                                     .and(linkTo(methodOn(BeverageController.class).deleteBeverage(id))
                                                  .and(linkTo(methodOn(BeverageController.class).getBeverage(
                                                          id)))).withRel("_self"));

        beverageResource.add(linkTo(methodOn(BeverageController.class).getPrice(id)).withRel("price"));
        beverageResource.add(linkTo(methodOn(BeverageController.class).getDefinition(id)).withRel("definition"));

        return beverageResource;
    }

    @RequestMapping(value = "/{id}/price")
    public Resource<Float> getPrice(@PathVariable String id) {
        Resource<Float> resource = new Resource<>(this.beverage.getPrice());

        resource.add(linkTo(methodOn(BeverageController.class).getBeverage(id)).withRel("beverage"));
        resource.add(linkTo(methodOn(BeverageController.class).getPrice(id)).withRel("_self"));

        return resource;
    }

    @RequestMapping(value = "/{id}/definition")
    public Resource<BeverageDefinition> getDefinition(@PathVariable String id) {
        Resource<BeverageDefinition> resource = new Resource<>(
                this.beverageDefinitionAssembler.toResource(this.beverage));

        resource.add(linkTo(methodOn(BeverageController.class).getBeverage(id)).withRel("beverage"));
        resource.add(linkTo(methodOn(BeverageController.class).getDefinition(id)).withRel("_self"));

        return resource;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Resource<Beverage> updateBeverage(@PathVariable String id, @RequestBody BeverageEntity beverageEntity) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Resource<Beverage> deleteBeverage(@PathVariable String id) {
        return null;
    }
}
