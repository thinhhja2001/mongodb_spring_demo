package com.example.grocerystore.controllers;

import com.example.grocerystore.assembler.GroceryItemAssembler;
import com.example.grocerystore.exceptions.GroceryNotFoundException;
import com.example.grocerystore.models.GroceryItem;
import com.example.grocerystore.repositories.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1")
public class GroceryItemController {
    private final GroceryItemRepository groceryRepo;
    @Autowired
    private GroceryItemAssembler assembler;

    public GroceryItemController(GroceryItemRepository groceryRepo) {
        this.groceryRepo = groceryRepo;
    }

    @GetMapping("/groceries")
    public CollectionModel<EntityModel<GroceryItem>> all() {
        List<EntityModel<GroceryItem>> groceries = groceryRepo.findAll().stream()
                .map(groceryItem -> assembler.toModel(groceryItem)).toList();
        return CollectionModel.of(groceries, linkTo(methodOn(GroceryItemController.class).all()).withSelfRel());
    }

    @PostMapping("/groceries")
    public EntityModel<GroceryItem> newGrocery(@RequestBody GroceryItem newGrocery) {
        groceryRepo.save(newGrocery);
        return assembler.toModel(newGrocery);
    }

    @GetMapping("/groceries/{id}")
    public EntityModel<GroceryItem> findOne(@PathVariable String id) {
        GroceryItem groceryItem = groceryRepo.findById(id)
                .orElseThrow(() -> new GroceryNotFoundException(id));
        return assembler.toModel(groceryItem);
    }
}
