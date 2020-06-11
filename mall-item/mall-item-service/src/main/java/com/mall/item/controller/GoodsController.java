package com.mall.item.controller;

import com.mall.common.pojo.PageResult;
import com.mall.item.bo.SpuBo;
import com.mall.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuBodyByPage(
            @RequestParam(value = "key",required = false) String key,
            @RequestParam(value = "saleable",required = false) Boolean saleable,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "rows",defaultValue = "5") Integer rows
    ){
        PageResult<SpuBo> result = this.goodsService.querySpuBodyByPage(key,saleable,page,rows);
        if(CollectionUtils.isEmpty(result.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }
}
