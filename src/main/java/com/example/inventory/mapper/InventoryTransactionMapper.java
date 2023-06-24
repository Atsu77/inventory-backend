package com.example.inventory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.inventory.web.api.response.InventoryResponse;

@Mapper
public interface InventoryTransactionMapper {

  @Select("SELECT i.code, i.name, COALESCE(SUM(it.quantity), 0) AS quantity " +
        "FROM items i " +
        "LEFT JOIN inventory_transactions it ON i.code = it.item_code " +
        "GROUP BY i.code, i.name")
  List<InventoryResponse> findAll();



  @Select("SELECT i.code, i.name, COALESCE(SUM(it.quantity), 0) AS quantity " +
        "FROM items i " +
        "LEFT JOIN inventory_transactions it ON i.code = it.item_code " +
        "WHERE i.code = #{itemCode} " +
        "GROUP BY i.code, i.name")
  InventoryResponse findByItemCode(String itemCode);
}
