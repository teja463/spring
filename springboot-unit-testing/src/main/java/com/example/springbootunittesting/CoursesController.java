package com.example.springbootunittesting;

import com.example.springbootunittesting.items.Item;
import com.example.springbootunittesting.items.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    private final ItemRepository itemRepository;

    public CoursesController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAll(){
        return itemRepository.findAll();
    }
}
