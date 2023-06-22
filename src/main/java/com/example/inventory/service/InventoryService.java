package com.example.inventory.service;

import java.util.List;

import com.example.inventory.web.api.response.InventoryResponse;

public interface InventoryService {
    List<InventoryResponse> findAll();
}
