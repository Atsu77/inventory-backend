package com.example.inventory.web.api;

import com.example.inventory.entity.Item;
import com.example.inventory.service.ItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Item>> findAll() {
        List<Item> items = itemService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        if(isDuplicate(item)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        itemService.insert(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Item> findByCode(@PathVariable String code) {
        Item item = itemService.findByCode(code);
        if(item == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }

    private boolean isDuplicate(Item item) {
        return itemService.findAll().stream().anyMatch(i -> i.getCode().equals(item.getCode()));
    }

}
