package com.mall.item.mapper;

import com.mall.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category,Long> {
    @Select("SELECT * from tb_category where id in (SELECT category_id FROM `tb_category_brand` WHERE brand_id = #{bid})")
    public List<Category> queryCategoriesByBid(Long bid);
}
