package com.example.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.mapper.InventoryMapper;
import com.example.inventory.service.InventoryService;
import com.example.inventory.web.api.response.InventoryResponse;

@Service
public class InventoryServiceImpl implements InventoryService {
  private final InventoryMapper inventoryMapper;

  public InventoryServiceImpl(InventoryMapper inventoryMapper) {
    this.inventoryMapper = inventoryMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<InventoryResponse> findAll() {
    List<InventoryResponse> inventories = inventoryMapper.findAll();
    return inventories;
  }
}
