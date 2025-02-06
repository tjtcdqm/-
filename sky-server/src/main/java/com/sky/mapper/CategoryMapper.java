package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /*
    根据分类查询
     */
    Page<Category> getCategories(Category category);

    @Insert("insert into category (id,type,name,sort,status,create_time,update_time,create_user,update_user)"+
            "values " +
            "(#{id},#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void insertCategory(Category category);

    void update(Category category);

    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);
}
