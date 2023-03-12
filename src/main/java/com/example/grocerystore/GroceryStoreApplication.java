package com.example.grocerystore;

import com.example.grocerystore.models.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class GroceryStoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(GroceryStoreApplication.class, args);
    }


}
