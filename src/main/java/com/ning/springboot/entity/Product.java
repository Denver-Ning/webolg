package com.ning.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigInteger;

@Data
public class Product {
    private String product_name;
//    @JsonIgnore 不展示给前端
    private BigInteger product_price;

    private Integer id;
}
