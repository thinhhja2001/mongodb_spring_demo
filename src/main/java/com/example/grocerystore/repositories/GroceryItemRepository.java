package com.example.grocerystore.repositories;

import com.example.grocerystore.models.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface GroceryItemRepository extends MongoRepository<GroceryItem, String> {
}
