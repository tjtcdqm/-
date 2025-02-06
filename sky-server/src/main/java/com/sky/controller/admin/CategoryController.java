package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.RectangularShape;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "分类管理接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> getByCategoryType(Integer type){
        log.info("通过类型查询分类，类型为{}",type);

        if(type!=null&&type !=1 &&type!=2) {
            return Result.error("只能为菜品分类和套餐分类");
        }

        List<Category> categories = categoryService.getByCategoryType(type);
        return Result.success(categories);
    }

    @GetMapping("page")
    @ApiOperation("分页查询分类")
    public Result<PageResult> pageQueryCategory(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping
    @ApiOperation("新增分类")
    public Result insertCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("新增分类");
        categoryService.insertCategory(categoryDTO);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("修改分类信息")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO){
        log.info("修改分类信息");
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result enableOrDisableCategory(@PathVariable Integer status,Long id){
        log.info("启用，禁用分类");
        categoryService.enableOrDisableCategory(status,id);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("删除分类")
    public Result deleteCategory(Long id){
        log.info("删除分类");


        categoryService.deleteById(id);
        return Result.success();
    }
}
