package com.example.inventory.web.api;

import com.example.inventory.entity.Item;
import com.example.inventory.service.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemRestController {
    private final ItemService itemService;

    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        if(isDuplicate(item)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        itemService.insert(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    }

}
