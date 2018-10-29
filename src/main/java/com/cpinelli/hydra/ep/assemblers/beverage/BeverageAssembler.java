package com.cpinelli.hydra.ep.assemblers.beverage;

import com.cpinelli.hydra.ep.assemblers.ingredient.IngredientAssembler;
import com.cpinelli.hydra.ep.controllers.BeverageController;
import com.cpinelli.hydra.ep.entities.BeverageEntity;
import com.cpinelli.hydra.ep.resources.beverage.Beverage;
import com.cpinelli.hydra.ep.resources.beverage.BeverageDefinition;
import com.cpinelli.hydra.ep.resources.ingredient.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeverageAssembler extends ResourceAssemblerSupport<BeverageEntity, Beverage> {

    @Autowired
    private IngredientAssembler ingredientAssembler;

    public BeverageAssembler() {
        super(BeverageController.class, Beverage.class);
    }

    @Override
    public Beverage toResource(BeverageEntity entity) {

        Beverage resource = new Beverage();

        resource.setId(entity.getId());

        return resource;
    }

    @Override
    protected Beverage instantiateResource(BeverageEntity entity) {
        Beverage beverage = new Beverage();

        beverage.setId(entity.getId());
        beverage.setPrice(entity.getPrice());

        List<Ingredient> ingredients = new ArrayList<>();

        entity.getIngredients().forEach(i -> ingredients.add(this.ingredientAssembler.toResource(i)));

        beverage.setDefinition(new BeverageDefinition(entity.getName(), ingredients));

        return beverage;
    }
}
