package com.example.inventory.mapper;

import com.example.inventory.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ItemMapper {
  @Select("SELECT * FROM items")
  List<Item> findAll();
}
