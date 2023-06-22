package com.example.inventory.web.api.response;

public class InventoryResponse {
  private String code;
  private String name;
  private Integer quantity;

  public InventoryResponse(String code, String name, Integer quantity) {
    this.code = code;
    this.name = name;
    this.quantity = quantity;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public Integer getQuantity() {
    return quantity;
  }
}
