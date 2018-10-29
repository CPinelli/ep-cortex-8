package com.cpinelli.hydra.ep.assemblers.ingredient;

import com.cpinelli.hydra.ep.controllers.IngredientController;
import com.cpinelli.hydra.ep.entities.IngredientEntity;
import com.cpinelli.hydra.ep.resources.ingredient.Ingredient;
import com.cpinelli.hydra.ep.resources.ingredient.IngredientDefinition;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

@Service
public class IngredientAssembler extends ResourceAssemblerSupport<IngredientEntity, Ingredient> {

    public IngredientAssembler() {
        super(IngredientController.class, Ingredient.class);
    }

    @Override
    public Ingredient toResource(IngredientEntity entity) {
        entity.setName(null);
        return createResourceWithId(entity.getId(), entity);
    }

    @Override
    protected Ingredient instantiateResource(IngredientEntity entity) {
        Ingredient ingredient = new Ingredient();

        ingredient.setId(entity.getId());

        ingredient.setDefinition(new IngredientDefinition(entity.getName()));

        return ingredient;
    }
}
