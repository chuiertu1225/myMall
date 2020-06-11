package com.mall.item.service;


import com.mall.item.mapper.SpecGroupMapper;
import com.mall.item.pojo.SpecGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    public List<SpecGroup> queryGroupByCid(Long cid) {
       SpecGroup specGroup = new SpecGroup();
       specGroup.setCid(cid);
       return this.specGroupMapper.select(specGroup);
    }

    @Transactional
    public void updateGroup(SpecGroup specGroup) {
        this.specGroupMapper.updateByPrimaryKey(specGroup);
    }

    @Transactional
    public void deleteGroup(Long gid) {
        this.specGroupMapper.deleteByPrimaryKey(gid);
    }

    @Transactional
    public void saveGroup(SpecGroup specGroup){
        this.specGroupMapper.insert(specGroup);
    }
}
