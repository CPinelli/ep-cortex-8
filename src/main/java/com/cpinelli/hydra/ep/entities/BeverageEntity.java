package com.cpinelli.hydra.ep.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeverageEntity {

    private String id;

    private String name;

    private Float price;

    private List<IngredientEntity> ingredients;
}
