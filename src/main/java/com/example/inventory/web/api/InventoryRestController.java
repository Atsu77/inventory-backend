package com.example.inventory.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.service.InventoryService;
import com.example.inventory.web.api.response.InventoryResponse;

@RestController
@RequestMapping("/api/inventories")
public class InventoryRestController {
  private final InventoryService inventoryService;

  public InventoryRestController(InventoryService inventoryService) {
    this.inventoryService = inventoryService;
  }

  @GetMapping
  public ResponseEntity<List<InventoryResponse>> findAll() {
    List<InventoryResponse> inventories = inventoryService.findAll();
    return ResponseEntity.status(HttpStatus.CREATED).body(inventories);
  }

  @GetMapping({"/{itemCode}"})
  public ResponseEntity<InventoryResponse> findByItemCode(@PathVariable String itemCode) {
    InventoryResponse inventory = inventoryService.findByItemCode(itemCode);
    if(inventory == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(inventory);
  }
}
