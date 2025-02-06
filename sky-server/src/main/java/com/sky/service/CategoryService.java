package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO) ;

    List<Category> getByCategoryType(Integer type) ;

    void insertCategory(CategoryDTO categoryDTO);

    void updateCategory(CategoryDTO categoryDTO);

    void enableOrDisableCategory(Integer status,Long id);

    void deleteById(Long id);
}
