package com.ning.springboot.mapper;

import com.ning.springboot.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface ProductMapper {
    @Select("select * from product")
    List<Product> findAll();

    @Insert("INSERT INTO product(product_name,product_price) VALUES (#{product_name},#{product_price})")
    int insert(Product product);

    @Delete("delete from product where id=#{id}")
    Integer deleteById(Integer id);

    int update(Product product);


    @Select("SELECT * FROM product LIMIT #{pageNum},#{pageSize}")
    List<Product> selectPage(Integer pageNum, Integer pageSize);

    @Select("select count(*) from product")
    Integer selectTotal();
}
