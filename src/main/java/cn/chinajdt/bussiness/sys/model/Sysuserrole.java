package cn.chinajdt.bussiness.sys.model;

import java.io.Serializable;

public class Sysuserrole implements Serializable {
    private String sysuserroleid;

    private String sysuserid;

    private String sysroleid;

    public String getSysuserroleid() {
        return sysuserroleid;
    }

    public void setSysuserroleid(String sysuserroleid) {
        this.sysuserroleid = sysuserroleid == null ? null : sysuserroleid.trim();
    }

    public String getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(String sysuserid) {
        this.sysuserid = sysuserid == null ? null : sysuserid.trim();
    }

    public String getSysroleid() {
        return sysroleid;
    }

    public void setSysroleid(String sysroleid) {
        this.sysroleid = sysroleid == null ? null : sysroleid.trim();
    }
}