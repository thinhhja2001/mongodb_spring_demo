package com.example.grocerystore.assembler;

import com.example.grocerystore.controllers.GroceryItemController;
import com.example.grocerystore.models.GroceryItem;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GroceryItemAssembler implements RepresentationModelAssembler<GroceryItem, EntityModel<GroceryItem>> {
    @Override
    public EntityModel<GroceryItem> toModel(GroceryItem grocery) {
        EntityModel<GroceryItem> groceryModel = EntityModel.of(grocery,
                linkTo(methodOn(GroceryItemController.class).findOne(grocery.getId())).withSelfRel(),
                linkTo(methodOn(GroceryItemController.class).all()).withRel("groceries"));
        return groceryModel;
    }
}
