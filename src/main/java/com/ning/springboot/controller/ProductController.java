package com.ning.springboot.controller;

import com.ning.springboot.entity.Product;
import com.ning.springboot.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired(required = false)
    private ProductMapper productMapper;

    @GetMapping
    public List<Product> index(){
        return productMapper.findAll();
    }

    @PostMapping
    public Integer add(@RequestBody Product product){
        return productMapper.insert(product);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return productMapper.deleteById(id);
    }

    @PutMapping
    public Integer update(@RequestBody Product product){
        return productMapper.update(product);
    }

    // mybatis 方式
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        pageNum = (pageNum - 1) * pageSize;
        List<Product> data = productMapper.selectPage(pageNum,pageSize);
        Integer total = productMapper.selectTotal();
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
