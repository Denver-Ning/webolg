package com.ning.springboot.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 代码生成器
 * */
public class CodeGenerator {
    public static void main(String[] args) {
        generate();
    }

    private static void generate(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/java-bili?serverTimezone=GMT%2b8", "root", "11111111")
                .globalConfig(builder -> {
                    builder.author("宁") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //生成完成后不弹出文件夹
                            .outputDir("/Users/zhangshuaining/Documents/code/hewai_project/springboot/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ning.springboot") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/zhangshuaining/Documents/code/hewai_project/springboot/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); // 为实体类添加 lombok 注解
                    builder.mapperBuilder().enableMapperAnnotation().build(); // 为 mapper 接口添加 @Mapper 注解
                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle(); // 为控制器添加 URL 中的连字符
                    builder.addInclude("sys_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "sys_"); // 设置过滤表前缀

                })
                .execute();
    }
}
