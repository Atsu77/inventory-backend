package com.example.inventory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.inventory.entity.InventoryTransaction;

@Mapper
public interface TransactionMapper {
    @Results({
    @Result(column="date_time", property="dateTime"),
    @Result(column="id", property="id"),
    @Result(column="item_code", property="item",
      one=@One(select="com.example.inventory.mapper.ItemMapper.findByCode")),
    @Result(column="quantity", property="quantity"),
    @Result(column="type", property="type"),
    @Result(column="description", property="description"),
  })
  @Select("SELECT date_time, id, item_code, quantity, type, description FROM inventory_transactions WHERE item_code = #{itemCode}")
  List<InventoryTransaction> findAll(String itemCode);
}