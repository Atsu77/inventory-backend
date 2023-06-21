package com.example.inventory.mapper;

import com.example.inventory.entity.Item;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ItemMapper {
  @Select("SELECT * FROM items")
  List<Item> findAll();

  @Insert("INSERT INTO items (code, name) VALUES (#{code}, #{name})")
  void insert(Item item);

  @Select("SELECT * FROM items WHERE code = #{code}")
  Item findByCode(String code);
}
