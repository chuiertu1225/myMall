package com.mall.item.mapper;

import com.mall.item.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand>, SelectByIdListMapper<Brand,Long> {

    @Insert("INSERT INTO tb_category_brand(category_id, brand_id) VALUES (#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid,@Param("bid") Long bid);

    @Delete("delete from tb_category_brand where brand_id = #{bid}")
    void deleteByBrandInCategoryAndBrand(Long bid);

    @Select("SELECT b.* from tb_brand b INNER JOIN tb_category_brand cb on b.id=cb.brand_id where cb.category_id=#{cid}")
    List<Brand> selectBrandByCid(Long cid);
}
