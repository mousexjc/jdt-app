package cn.chinajdt.bussiness.sys.model;

import java.io.Serializable;
import java.util.Date;

public class Sysrole implements Serializable {
    private String sysroleid;

    private String rname;

    private String parentid;

    private String remark;

    private Integer rorder;

    private Integer isdelete;

    private Date createtime;

    public String getSysroleid() {
        return sysroleid;
    }

    public void setSysroleid(String sysroleid) {
        this.sysroleid = sysroleid == null ? null : sysroleid.trim();
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRorder() {
        return rorder;
    }

    public void setRorder(Integer rorder) {
        this.rorder = rorder;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}