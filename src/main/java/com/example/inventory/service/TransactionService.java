package com.example.inventory.service;

import java.util.List;

import com.example.inventory.entity.InventoryTransaction;

public interface TransactionService {
   List<InventoryTransaction> findAll(String itemCode);
}
