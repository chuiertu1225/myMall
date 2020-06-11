package com.mall.item.controller;

import com.mall.item.pojo.SpecGroup;
import com.mall.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupByCid(@PathVariable("cid") Long cid){
        List<SpecGroup> specGroups = this.specificationService.queryGroupByCid(cid);
        if(CollectionUtils.isEmpty(specGroups)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(specGroups);
    }

    @PutMapping("group")
    public ResponseEntity<Void> updateGroup(@RequestBody  SpecGroup specGroup){
        this.specificationService.updateGroup(specGroup);
        return ResponseEntity.ok().build();
    }

    @PostMapping("group")
    public ResponseEntity<Void> saveGroup(@RequestBody  SpecGroup specGroup){
        this.specificationService.saveGroup(specGroup);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("group/{id}")
    public ResponseEntity<Void> deleteGroupByGid(@PathVariable("id") Long gid){
        this.specificationService.deleteGroup(gid);
        return ResponseEntity.ok().build();
    }

}
