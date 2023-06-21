package com.example.inventory.service.impl;

import com.example.inventory.entity.Item;

import com.example.inventory.mapper.ItemMapper;
import com.example.inventory.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    public final ItemMapper itemMapper;

    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    @Override
    public Item insert(Item item) {
        itemMapper.insert(item);
        return item;
    }

    @Override
    public Item findByCode(String code) {
        return itemMapper.findByCode(code);
    }
}
