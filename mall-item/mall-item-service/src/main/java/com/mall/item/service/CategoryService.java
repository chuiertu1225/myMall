package com.mall.item.service;

import com.mall.item.mapper.CategoryMapper;
import com.mall.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    /**
     * 根据父节点查询子节点
     * @param pid
     * @return
     */
    public List<Category> queryCategoriesByPid(Long pid) {
        Category record = new Category();
        record.setParentId(pid);
        return this.categoryMapper.select(record);
    }

    public List<Category> queryCategoriesByBid(Long bid) {
        return this.categoryMapper.queryCategoriesByBid(bid);
    }
}
