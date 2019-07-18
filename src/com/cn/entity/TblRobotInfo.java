package com.cn.entity;

public class TblRobotInfo {
    private Integer id;

    private String robotno;

    private String number;

    private Integer modeltype;

    private Integer customername;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRobotno() {
        return robotno;
    }

    public void setRobotno(String robotno) {
        this.robotno = robotno;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getModeltype() {
        return modeltype;
    }

    public void setModeltype(Integer modeltype) {
        this.modeltype = modeltype;
    }

    public Integer getCustomername() {
        return customername;
    }

    public void setCustomername(Integer customername) {
        this.customername = customername;
    }
}