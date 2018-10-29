package com.cpinelli.hydra.ep.controllers;

import com.cpinelli.hydra.ep.assemblers.ingredient.IngredientAssembler;
import com.cpinelli.hydra.ep.entities.IngredientEntity;
import com.cpinelli.hydra.ep.resources.ingredient.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private List<IngredientEntity> entities = Arrays.asList(
            new IngredientEntity("dns4f5s0", "Water"),
            new IngredientEntity("dns4f5s1", "coffee"),
            new IngredientEntity("dns4f5s2", "Milk"),
            new IngredientEntity("dns4f5s3", "Sugar")
    );

    @Autowired
    private IngredientAssembler assembler;

    @RequestMapping(value = "/{beverageId}", method = RequestMethod.GET)
    public Resources<Ingredient> getIngredients(@PathVariable String beverageId) {

        List<Ingredient> ingredients = this.assembler.toResources(this.entities);

        return new Resources<>(ingredients);
    }

    @RequestMapping(value = "/{beverageId}/{ingredientId}", method = RequestMethod.GET)
    public Resource<IngredientEntity> getIngredient(@PathVariable String beverageId,
                                                    @PathVariable String ingredientId) {
        return null;
    }
}
