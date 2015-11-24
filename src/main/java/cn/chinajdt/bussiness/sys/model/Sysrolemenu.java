package cn.chinajdt.bussiness.sys.model;

import java.io.Serializable;

public class Sysrolemenu implements Serializable {
    private String sysrolemenuid;

    private String sysroleid;

    private String sysmenuid;

    private String sysmenucodeid ;

    public String getSysrolemenuid() {
        return sysrolemenuid;
    }

    public void setSysrolemenuid(String sysrolemenuid) {
        this.sysrolemenuid = sysrolemenuid == null ? null : sysrolemenuid.trim();
    }

    public String getSysroleid() {
        return sysroleid;
    }

    public void setSysroleid(String sysroleid) {
        this.sysroleid = sysroleid == null ? null : sysroleid.trim();
    }

    public String getSysmenuid() {
        return sysmenuid;
    }

    public void setSysmenuid(String sysmenuid) {
        this.sysmenuid = sysmenuid == null ? null : sysmenuid.trim();
    }

    public String getSysmenucodeid() {
        return sysmenucodeid;
    }

    public void setSysmenucodeid(String sysmenucodeid) {
        this.sysmenucodeid = sysmenucodeid;
    }
}