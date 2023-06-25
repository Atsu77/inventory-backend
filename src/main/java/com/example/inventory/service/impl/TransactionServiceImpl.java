package com.example.inventory.service.impl;

import java.util.List;

import com.example.inventory.entity.InventoryTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.mapper.TransactionMapper;
import com.example.inventory.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
  private final TransactionMapper transactionMapper;

  public TransactionServiceImpl(TransactionMapper transactionMapper) {
    this.transactionMapper = transactionMapper;
  }

  @Override
  @Transactional(readOnly = true)
  public List<InventoryTransaction> findAll(String itemCode) {
    return transactionMapper.findAll(itemCode);
  }

}
