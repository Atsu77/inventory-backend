package com.example.inventory.service;

import com.example.inventory.entity.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item insert(Item item);

    Item findByCode(String code);
}
