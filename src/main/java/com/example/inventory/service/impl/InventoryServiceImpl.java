package com.example.inventory.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.mapper.InventoryTransactionMapper;
import com.example.inventory.service.InventoryService;
import com.example.inventory.web.api.response.InventoryResponse;

@Service
public class InventoryTransactionServiceImpl implements InventoryService {
  private final InventoryTransactionMapper inventoryMapper;

  public InventoryTransactionServiceImpl(InventoryTransactionMapper inventoryMapper) {
    this.inventoryMapper = inventoryMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<InventoryResponse> findAll() {
    return inventoryMapper.findAll();
  }

  @Override
  public InventoryResponse findByItemCode(String itemCode) {
    return inventoryMapper.findByItemCode(itemCode);
  }


}
