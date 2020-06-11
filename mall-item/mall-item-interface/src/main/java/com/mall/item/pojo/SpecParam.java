package com.mall.item.pojo;

import javax.persistence.*;

@Table(name = "tb_spec_param")
public class SpecParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cid;
    private Long groupId;
    private String name;
    @Column(name = "`numeric`")
    private Boolean numeric;    // 是否为数值类型
    private String unit;        // 参数的单位
    private Boolean generic;    // 是否为通用属性
    private Boolean searching;  // 是否用作过滤
    private String segments;    // 这些数值类型的参数，在搜索时需要按区间划分，这里提前确定好划分区间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNumeric() {
        return numeric;
    }

    public void setNumeric(Boolean numeric) {
        this.numeric = numeric;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getGeneric() {
        return generic;
    }

    public void setGeneric(Boolean generic) {
        this.generic = generic;
    }

    public Boolean getSearching() {
        return searching;
    }

    public void setSearching(Boolean searching) {
        this.searching = searching;
    }

    public String getSegments() {
        return segments;
    }

    public void setSegments(String segments) {
        this.segments = segments;
    }

}