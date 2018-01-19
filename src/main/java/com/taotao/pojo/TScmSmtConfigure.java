package com.taotao.pojo;

import java.util.Date;

public class TScmSmtConfigure {
    private Integer id;

    private String lineType;

    private String lineNumber;

    private Short machineType;

    private String machineName;

    private String acquirePatternPath;

    private String saveLocalPath;

    private String pictureName;

    private Date lastUpdateDate;

    private String lastUpdatedBy;

    private Date createDate;

    private String createdBy;

    private String active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType == null ? null : lineType.trim();
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber == null ? null : lineNumber.trim();
    }

    public Short getMachineType() {
        return machineType;
    }

    public void setMachineType(Short machineType) {
        this.machineType = machineType;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName == null ? null : machineName.trim();
    }

    public String getAcquirePatternPath() {
        return acquirePatternPath;
    }

    public void setAcquirePatternPath(String acquirePatternPath) {
        this.acquirePatternPath = acquirePatternPath == null ? null : acquirePatternPath.trim();
    }

    public String getSaveLocalPath() {
        return saveLocalPath;
    }

    public void setSaveLocalPath(String saveLocalPath) {
        this.saveLocalPath = saveLocalPath == null ? null : saveLocalPath.trim();
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active == null ? null : active.trim();
    }
}