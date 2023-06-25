package com.example.inventory.web.api;

import java.util.List;

import com.example.inventory.entity.InventoryTransaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.service.TransactionService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/transactions")
public class TransactionRestController {
  private final TransactionService transactionService;

  public TransactionRestController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @GetMapping
  public ResponseEntity<List<InventoryTransaction>> findAll(@PathParam("itemCode") String itemCode){
    List<InventoryTransaction> transactions = transactionService.findAll(itemCode);
    return ResponseEntity.status(HttpStatus.CREATED).body(transactions);
  }
}
