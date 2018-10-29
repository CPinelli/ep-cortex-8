package com.cpinelli.hydra.ep.assemblers.beverage;

import com.cpinelli.hydra.ep.assemblers.ingredient.IngredientAssembler;
import com.cpinelli.hydra.ep.controllers.BeverageController;
import com.cpinelli.hydra.ep.entities.BeverageEntity;
import com.cpinelli.hydra.ep.resources.beverage.BeverageDefinition;
import com.cpinelli.hydra.ep.resources.ingredient.Ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeverageDefinitionAssembler extends ResourceAssemblerSupport<BeverageEntity, BeverageDefinition> {

    @Autowired
    private IngredientAssembler ingredientAssembler;

    public BeverageDefinitionAssembler() {
        super(BeverageController.class, BeverageDefinition.class);
    }

    @Override
    public BeverageDefinition toResource(BeverageEntity entity) {

        // this is not required
        return this.instantiateResource(entity);
    }

    @Override
    protected BeverageDefinition instantiateResource(BeverageEntity entity) {
        BeverageDefinition definition = new BeverageDefinition();

        definition.setName(entity.getName());

        List<Ingredient> ingredients = new ArrayList<>();

        entity.getIngredients().forEach(i -> ingredients.add(this.ingredientAssembler.toResource(i)));

        definition.setIngredients(ingredients);

        return definition;
    }
}
