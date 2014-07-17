package com.mybatis.model;

public class Aaa {
    private Integer id;

    private String featureType;

    private String columnName;

    private Short condType;

    private String dataType;

    private Integer onlineDuration;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Short getCondType() {
        return condType;
    }

    public void setCondType(Short condType) {
        this.condType = condType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getOnlineDuration() {
        return onlineDuration;
    }

    public void setOnlineDuration(Integer onlineDuration) {
        this.onlineDuration = onlineDuration;
    }
}